package com.ml.feedback;

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
import static com.ml.feedback.FeedbackConfig.INT_DEFUALT;
import static com.ml.feedback.FeedbackGenericException.FEEDBACK_EXCEPTION_NOTCREATED;

/**
 * <p> Class FeedbackManager </p>
 * Manage information from users to developers
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class FeedbackManager {

    private static FeedbackManager instance = null;
    private final String PREFERENCE_ATTEMPTS_OPENAPP = "feedback_attempts_openapp";
    private final int MIN_ACCEPTABLE_STARS = 4;
    private FeedbackConfig config;
    private Context context;
    private AskRateDialog askRateDialog = null;
    private BadRateDialog badRateDialog = null;

    private OnNegativeRateReceive onNegativeRateReceive;

    /**
     * Instantiates a new Feedback manager.
     *
     * @param config  the config
     * @param context the context
     */
    public FeedbackManager(FeedbackConfig config, Context context){
        this.config = config;
        this.context = context;
        this.onNegativeRateReceive = new OnNegativeRateReceive() {
            @Override
            public void onNegativeRateReceive(String string, int stars) {

            }
        };
    }

    /**
     * Init.
     *
     * @param config  the config
     * @param context the context
     * @throws FeedbackBadConfigException the feedback bad config exception
     */
    public static void init(FeedbackConfig config, Context context) throws FeedbackBadConfigException {

        if (checkConfig(config))
            instance = new FeedbackManager(config,context);
        else
            throw new FeedbackBadConfigException(FEEDBACK_EXCEPTION_BADCONFIG);
    }

    /**
     * Get instance feedback manager.
     *
     * @return the feedback manager
     */
    public static FeedbackManager getInstance(){

        if (instance == null)
            throw new FeedbackGenericException(FEEDBACK_EXCEPTION_NOTCREATED);

        return instance;
    }

    /**
     * Attempt rate.
     *
     * @param preferenceManager    the preferenceManager
     * @param logcatWritter the logcat writter
     * @param context       the context
     */
    public void attemptRate(PreferenceManager preferenceManager, LogcatWritter logcatWritter, Context context){

        int attempts = preferenceManager.getInt(PREFERENCE_ATTEMPTS_OPENAPP);
        if (attempts == -1) { //First attempt and no preferenceManager save
            attempts = this.config.getAttemptToRate();
        }

        if (attempts == 0) //Already show rate dialog
            return;

        attempts--;
        if (attempts == 0)
            askRate(context,logcatWritter);

        preferenceManager.setInt(PREFERENCE_ATTEMPTS_OPENAPP,attempts); //Save new value
    }

    private void askRate(final Context context, final LogcatWritter logcatWritter) {

        if (askRateDialog == null) {
            askRateDialog = new AskRateDialog(context, config);

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
                    if (countStars >= MIN_ACCEPTABLE_STARS)
                        launchMarket(logcatWritter);
                    else
                        badRate(context, countStars);
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

    private void badRate(final Context context, final int starts) {

        if (badRateDialog == null){
            badRateDialog = new BadRateDialog(context, config);

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
                    Utils_Dialog.centerCustomiczeToastMessage(config.getDialogTextColor(),config.getDialogMainColor(),context.getString(R.string.feedback_thanks),context, Utils_Dialog.DURATION_LONG);
                    onNegativeRateReceive.onNegativeRateReceive(comment, starts);
                    dialog.dismiss();
                    badRateDialog = null;
                }
            });

            badRateDialog.show();
        }
    }

    private static boolean checkConfig(FeedbackConfig config){

        if (config.getParentHeight() == INT_DEFUALT || config.getParentWidth()  == INT_DEFUALT)
            return false;

        if (config.getAttemptToRate() == INT_DEFUALT)
            return false;

        //noinspection RedundantIfStatement
        if (config.getDialogMainColor() == INT_DEFUALT ||
                config.getDialogSecondColor() == INT_DEFUALT ||
                config.getDialogTextColor() == INT_DEFUALT)
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

    /**
     * Set on negative rate receive lister.
     *
     * @param onNegativeRateReceiveLister the on negative rate receive lister
     */
    public void setOnNegativeRateReceiveLister(OnNegativeRateReceive onNegativeRateReceiveLister){
        this.onNegativeRateReceive = onNegativeRateReceiveLister;
    }

    /**
     * The interface On negative rate receive.
     */
    public interface OnNegativeRateReceive{
        /**
         * On negative rate receive.
         *
         * @param string the string
         */
        void onNegativeRateReceive(String string, int stars);
    }
}
