package com.ml.version;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.ml.logs.LogInfo;
import com.ml.logs.LogcatWritter;
import com.ml.preference.PreferenceManager;
import com.ml.utils.utils.Utils_Dialog;

import static com.ml.version.VersionBadConfigException.VERSION_EXCEPTION_BADCONFIG;
import static com.ml.version.VersionConfig.INT_DEFUALT;
import static com.ml.version.VersionConfig.STRING_DEFAULT;
import static com.ml.version.VersionConfig.TYPE_DIALOG;
import static com.ml.version.VersionConfig.TYPE_FORCEDIALOG;
import static com.ml.version.VersionConfig.TYPE_NOTIFICATION;
import static com.ml.version.VersionConfig.TYPE_TOAST;
import static com.ml.version.VersionGenericException.VERSION_EXCEPTION_NOTCREATED;

/**
 * <p> Class VersionManager </p>
 * Control updates and blocks by version
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class VersionManager {

    private final String PREFERENCE_ATTEMPTS_ASKUPDATE = "version_attempts_askupdate";
    private final int NOTIFICATION_ID = 123;

    private static VersionManager instance = null;
    private VersionConfig config;

    private UpdateDialog updateDialog = null;
    private ForceUpdateDialog forceUpdateDialog = null;

    /**
     * Instantiates a new VersionManager.
     *
     * @param config the config
     */
    public VersionManager(VersionConfig config) {
        this.config = config;
    }

    /**
     * Init.
     *
     * @param config the config
     * @throws VersionBadConfigException the VERSION bad config exception
     */
    public static void init(VersionConfig config) throws VersionBadConfigException {

        if (checkConfig(config))
            instance = new VersionManager(config);
        else
            throw new VersionBadConfigException(VERSION_EXCEPTION_BADCONFIG);
    }

    /**
     * Get instance VersionManager.
     *
     * @return the VersionManager
     */
    public static VersionManager getInstance() {

        if (instance == null)
            throw new VersionGenericException(VERSION_EXCEPTION_NOTCREATED);

        return instance;
    }

    /**
     * Verify that the installed version matches with specific version
     *
     * @param preferenceManager the preference manager
     * @param logcatWritter     the logcat writter
     * @param context           the context
     * @param version           the version
     * @param typeUpdate        the type update
     */
    public void checkVersion(PreferenceManager preferenceManager, LogcatWritter logcatWritter, Context context, int version, int typeUpdate) {

        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (pInfo.versionCode < version) {

                int attempts = preferenceManager.getInt(PREFERENCE_ATTEMPTS_ASKUPDATE);
                if (attempts == -1) { //First attempt and no preferenceManager save
                    attempts = this.config.getAttempToAskForUpdate();
                }

                attempts--;
                if (attempts == 0 || typeUpdate == TYPE_FORCEDIALOG) {
                    showNeedUpdating(context, logcatWritter, typeUpdate);
                    attempts = this.config.getAttempToAskForUpdate(); //Restart attemps
                }

                preferenceManager.setInt(PREFERENCE_ATTEMPTS_ASKUPDATE, attempts); //Save new value
            }

        } catch (PackageManager.NameNotFoundException exce) {
            logcatWritter.error(new LogInfo.Builder()
                    .addMessage("Error while getting version code")
                    .addThrowable(exce));
        }
    }

    /**
     * Verify that the installed version matches with online version.
     *
     * @param preferenceManager the preference manager
     * @param logcatWritter     the logcat writter
     * @param context           the context
     * @param typeUpdate        the type update
     */
    public void checkWithOnlineVersion(final PreferenceManager preferenceManager, final LogcatWritter logcatWritter, final Context context, final int typeUpdate){

        VersionOnlineListener listener = new VersionOnlineListener() {
            @Override
            public void onOnlineVersionReady(String versionName, int versionCode) {
                try {
                    PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    if (pInfo.versionCode < versionCode) {

                        int attempts = preferenceManager.getInt(PREFERENCE_ATTEMPTS_ASKUPDATE);
                        if (attempts == -1) { //First attempt and no preferenceManager save
                            attempts = config.getAttempToAskForUpdate();
                        }

                        attempts--;
                        if (attempts == 0 || typeUpdate == TYPE_FORCEDIALOG) {
                            showNeedUpdating(context, logcatWritter, typeUpdate);
                            attempts = config.getAttempToAskForUpdate(); //Restart attemps
                        }

                        preferenceManager.setInt(PREFERENCE_ATTEMPTS_ASKUPDATE, attempts); //Save new value
                    }

                } catch (PackageManager.NameNotFoundException exce) {
                    logcatWritter.error(new LogInfo.Builder()
                            .addMessage("Error while getting version code")
                            .addThrowable(exce));
                }
            }
        };

        new GetVersionAsyncTask(listener).execute(context.getPackageName());
    }

    private void showNeedUpdating(Context context, LogcatWritter logcatWritter, int typeUpdate) {

        switch (typeUpdate) {
            case TYPE_NOTIFICATION:
                showNotification(context);
                break;
            case TYPE_TOAST:
                Utils_Dialog.centerCustomiczeToastMessage(config.getDialogTextColor(), config.getDialogMainColor(), config.getTextUpdate(), context, Utils_Dialog.DURATION_LONG);
                break;
            case TYPE_DIALOG:
                showUpdateDialog(logcatWritter, context);
                break;
            case TYPE_FORCEDIALOG:
                showForceUpdateDialog(logcatWritter, context);
                break;
        }
    }

    private void showNotification(Context context) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), config.getIconLargeUpdate()));
        mBuilder.setSmallIcon(config.getIconSmallUpdate());
        mBuilder.setContentTitle(context.getString(R.string.title_notification));
        mBuilder.setContentText(config.getTextUpdate());
        mBuilder.setContentIntent(PendingIntent.getActivity(context, 0, intentMarket(context), 0));
        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

    private void showUpdateDialog(final LogcatWritter logcatWritter, final Context context) {

        if (updateDialog == null) {
            updateDialog = new UpdateDialog(context, config);

            updateDialog.setOnUpdateListener(new UpdateDialog.OnUpdateListener() {
                @Override
                public void onUpdate(Dialog dialog) {
                    dialog.dismiss();
                    updateDialog = null;
                    launchMarket(logcatWritter, context);
                }
            });

            updateDialog.show();
        }
    }

    private void showForceUpdateDialog(final LogcatWritter logcatWritter, final Context context) {

        if (forceUpdateDialog == null || !forceUpdateDialog.isShowing()) {
            forceUpdateDialog = new ForceUpdateDialog(context, config);

            forceUpdateDialog.setOnUpdateListener(new ForceUpdateDialog.OnUpdateListener() {
                @Override
                public void onUpdate(Dialog dialog) {
                    dialog.dismiss();
                    updateDialog = null;
                    launchMarket(logcatWritter, context);
                }
            });

            forceUpdateDialog.show();
        }
    }

    private static boolean checkConfig(VersionConfig config) {

        if (config.getParentHeight() == INT_DEFUALT || config.getParentWidth() == INT_DEFUALT)
            return false;

        if (config.getAttempToAskForUpdate() == INT_DEFUALT || config.getIconLargeUpdate() == INT_DEFUALT)
            return false;

        if (config.getTextUpdate().equals(STRING_DEFAULT) || config.getIconSmallUpdate() == INT_DEFUALT)
            return false;

        //noinspection RedundantIfStatement
        if (config.getDialogMainColor() == INT_DEFUALT ||
                config.getDialogSecondColor() == INT_DEFUALT ||
                config.getDialogTextColor() == INT_DEFUALT)
            return false;

        return true;
    }

    private Intent intentMarket(Context context) {

        String appPackageName = context.getPackageName();
        Intent marketIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName));
        marketIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET | Intent.FLAG_ACTIVITY_MULTIPLE_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        return marketIntent;
    }

    private void launchMarket(LogcatWritter logcatWritter, Context context) {
        try {
            context.startActivity(intentMarket(context));
        } catch (ActivityNotFoundException exce) {
            logcatWritter.error(new LogInfo.Builder()
                    .addMessage("App not found on market")
                    .addStackTraceDeep(3)
                    .addThrowable(exce));
        }
    }
}
