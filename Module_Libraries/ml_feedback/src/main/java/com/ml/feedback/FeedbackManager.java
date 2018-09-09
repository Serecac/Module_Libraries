package com.ml.feedback;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import com.ml.logs.LogInfo;
import com.ml.logs.LogcatWritter;
import com.ml.preference.PreferenceManager;
import com.ml.utils.utils.Utils_Dialog;

import static com.ml.feedback.FeedbackBadConfigException.FEEDBACK_EXCEPTION_BADCONFIG;
import static com.ml.feedback.FeedbackConfig.INT_DEFAULT;
import static com.ml.feedback.FeedbackGenericException.FEEDBACK_EXCEPTION_NOTCREATED;

public class FeedbackManager {

    private static FeedbackManager instance = null;
    private final String PREFERENCE_ATTEMPTS_OPENAPP = "feedback_attempts_openapp";
    private final int MIN_ACCEPTABLE_STARS = 4;
    private FeedbackConfig config;
    private Context context;
    private AskRateDialog askRateDialog = null;
    private BadRateDialog badRateDialog = null;
    private SimpleRateDialog simpleRateDialog = null;

    private OnNegativeRateReceive onNegativeRateReceive;
    private OnRateReceive onRateReceive;

    public FeedbackManager(FeedbackConfig config, Context context) {
        this.config = config;
        this.context = context;
        this.onNegativeRateReceive = new OnNegativeRateReceive() {
            @Override
            public void onNegativeRateReceive(String string, int stars) {

            }
        };
        this.onRateReceive = new OnRateReceive() {
            @Override
            public void onRateReceive(int stars) {

            }
        };
    }

    public static void init(FeedbackConfig config, Context context) throws FeedbackBadConfigException {

        if (checkConfig(config))
            instance = new FeedbackManager(config, context);
        else
            throw new FeedbackBadConfigException(FEEDBACK_EXCEPTION_BADCONFIG);
    }

    public static FeedbackManager getInstance() {

        if (instance == null)
            throw new FeedbackGenericException(FEEDBACK_EXCEPTION_NOTCREATED);

        return instance;
    }

    public void attemptRate(PreferenceManager preferenceManager, LogcatWritter logcatWritter, Activity activity) {
        attemptRate(preferenceManager, logcatWritter, activity, true);
    }

    public void attemptRate(PreferenceManager preferenceManager, LogcatWritter logcatWritter, Activity activity, boolean showStars) {

        int attempts = preferenceManager.getInt(PREFERENCE_ATTEMPTS_OPENAPP);
        if (attempts == -1) { //First attempt and no preferenceManager save
            attempts = this.config.getAttemptToRate();
        }

        if (attempts == 0) //Already show rate dialog
            return;

        attempts--;
        if (attempts == 0) {
            if (showStars)
                askRate(activity, logcatWritter);
            else
                simpleRate(activity, logcatWritter);
        }

        preferenceManager.setInt(PREFERENCE_ATTEMPTS_OPENAPP, attempts); //Save new value
    }

    private void askRate(final Activity activity, final LogcatWritter logcatWritter) {

        if (askRateDialog == null) {
            askRateDialog = new AskRateDialog(activity, config);

            askRateDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    PreferenceManager.getInstance().delete(PREFERENCE_ATTEMPTS_OPENAPP);
                    askRateDialog = null;
                }
            });

            askRateDialog.setOnNoRateListener(new AskRateDialog.OnNoRateListener() {
                @Override
                public void onNoRate(Dialog dialog) {
                    dialog.dismiss();
                    askRateDialog = null;
                }
            });

            askRateDialog.setOnRateListener(new AskRateDialog.OnRateListener() {
                @Override
                public void onRate(Dialog dialog, int countStars) {

                    onRateReceive.onRateReceive(countStars);
                    if (countStars >= MIN_ACCEPTABLE_STARS)
                        launchMarket(logcatWritter);
                    else
                        badRate(activity, countStars);
                    dialog.dismiss();
                    askRateDialog = null;
                }
            });

            askRateDialog.setOnRemindLaterListener(new AskRateDialog.OnRemindLaterListener() {
                @Override
                public void onRemindLater(Dialog dialog) {
                    PreferenceManager.getInstance().delete(PREFERENCE_ATTEMPTS_OPENAPP);
                    dialog.dismiss();
                    askRateDialog = null;
                }
            });

            askRateDialog.show();
        }
    }

    private void simpleRate(final Context context, final LogcatWritter logcatWritter) {

        if (simpleRateDialog == null) {
            simpleRateDialog = new SimpleRateDialog(context, config);

            simpleRateDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    PreferenceManager.getInstance().delete(PREFERENCE_ATTEMPTS_OPENAPP);
                    askRateDialog = null;
                }
            });

            simpleRateDialog.setListener(new SimpleRateDialog.Listener() {
                @Override
                public void onRate(Dialog dialog) {
                    onRateReceive.onRateReceive(-1);
                    launchMarket(logcatWritter);
                    dialog.dismiss();
                    simpleRateDialog = null;
                }

                @Override
                public void onNoRate(Dialog dialog) {
                    dialog.dismiss();
                    simpleRateDialog = null;
                }

                @Override
                public void onRemindLater(Dialog dialog) {
                    PreferenceManager.getInstance().delete(PREFERENCE_ATTEMPTS_OPENAPP);
                    dialog.dismiss();
                    simpleRateDialog = null;
                }
            });

            simpleRateDialog.show();
        }
    }

    private void badRate(final Activity activity, final int starts) {

        if (badRateDialog == null) {
            badRateDialog = new BadRateDialog(activity, config);

            badRateDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    badRateDialog = null;
                }
            });

            badRateDialog.setOnNoCommentListener(new BadRateDialog.OnNoComment() {
                @Override
                public void onNoComment(Dialog dialog) {
                    dialog.dismiss();
                    badRateDialog = null;
                }
            });

            badRateDialog.setOnSendCommentListener(new BadRateDialog.OnSendComment() {
                @Override
                public void onSendComment(Dialog dialog, String comment) {
                    Utils_Dialog.customSimpleToast(config.getDialogTextColor(), config.getDialogMainColor(), -1, activity.getString(R.string.feedback_thanks), activity, Utils_Dialog.DURATION_LONG);
                    onNegativeRateReceive.onNegativeRateReceive(comment, starts);
                    dialog.dismiss();
                    badRateDialog = null;
                }
            });

            badRateDialog.show();
        }
    }

    private static boolean checkConfig(FeedbackConfig config) {

        if (config.getParentHeight() == INT_DEFAULT || config.getParentWidth() == INT_DEFAULT)
            return false;

        if (config.getAttemptToRate() == INT_DEFAULT)
            return false;

        //noinspection RedundantIfStatement
        if (config.getDialogMainColor() == INT_DEFAULT ||
                config.getDialogSecondColor() == INT_DEFAULT ||
                config.getDialogTextColor() == INT_DEFAULT)
            return false;

        return true;
    }

    private void launchMarket(LogcatWritter logcatWritter) {
        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        myAppLinkToMarket.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException exce) {
            logcatWritter.error(new LogInfo.Builder()
                    .addMessage("App not found on market")
                    .addStackTraceDeep(3)
                    .addThrowable(exce));
        }
    }

    public void setOnNegativeRateReceiveLister(OnNegativeRateReceive onNegativeRateReceive) {
        this.onNegativeRateReceive = onNegativeRateReceive;
    }

    public void setOnRateReceiveLister(OnRateReceive onRateReceive) {
        this.onRateReceive = onRateReceive;
    }

    public interface OnNegativeRateReceive {

        void onNegativeRateReceive(String string, int stars);
    }

    public interface OnRateReceive {

        void onRateReceive(int stars);
    }
}
