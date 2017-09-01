package com.ml.pemission;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.ml.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class PermissionRequester {

    public final static int REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    public final static int REQUEST_READ_EXTERNAL_STORAGE = 2;
    public final static int REQUEST_WRITE_SETTINGS = 3;
    public final static String PREFERENCE_DENIED_PERMISSIONS = "preference_denied_permissions";

    private int requestPending = -1;
    private PermissionDeniedDialog permissionDeniedDialog;
    private PermissionRequestListener listener;
    private Activity activity;
    private PreferenceManager preferenceManager;

    public PermissionRequester(Activity activity, PreferenceManager preferenceManager) {
        this.activity = activity;
        this.preferenceManager = preferenceManager;
    }

    public void requestPermision(int request, PermissionDeniedDialog permissionDeniedDialog, PermissionRequestListener listener) {

        this.listener = listener;
        this.requestPending = request;
        this.permissionDeniedDialog = permissionDeniedDialog;

        String manifestRequest = getManifestRequest(request);
        if (!manifestRequest.equals("")) {
            int permissionCheck = ContextCompat.checkSelfPermission(activity, manifestRequest);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{manifestRequest}, request);
            } else {
                if (listener != null)
                    listener.onPermisionOk();
            }
        } else
            listener.onPermisionError();
    }

    public void checkResultPermision(final int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {

        if (requestCode == requestPending) {
            if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED))
                listener.onPermisionOk();
            else {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    if (!activity.shouldShowRequestPermissionRationale(getManifestRequest(requestCode))) {
                        listener.onPermisionKo();
                        if (preferenceManager != null) {
                            String deniedPermission = preferenceManager.getString(PREFERENCE_DENIED_PERMISSIONS);
                            if (!deniedPermission.contains(getManifestRequest(requestCode))) {
                                if (deniedPermission.equals(""))
                                    deniedPermission = getManifestRequest(requestCode);
                                else
                                    deniedPermission += ";" + getManifestRequest(requestCode);
                                preferenceManager.setString(PREFERENCE_DENIED_PERMISSIONS, deniedPermission);
                            }
                        }
                    } else {
                        if (permissionDeniedDialog != null && !permissionDeniedDialog.isShowing()) {
                            permissionDeniedDialog.setListener(new PermissionDeniedDialog.Listener() {
                                @Override
                                public void onOk() {
                                    requestPermision(requestCode, permissionDeniedDialog, listener);
                                }
                            });
                            permissionDeniedDialog.show();
                        } else
                            listener.onPermisionKo();
                    }
                }
            }
        }
    }

    public List<String> getPermissionDenied() {

        List<String> returnPermissions = new ArrayList<>();
        if (preferenceManager != null) {
            String deniedPermission = preferenceManager.getString(PREFERENCE_DENIED_PERMISSIONS);
            if (!deniedPermission.equals("")) {
                String[] deniedPermissionsArray = deniedPermission.split(";");
                for (int i = 0; i < deniedPermissionsArray.length; i++){
                    if (ContextCompat.checkSelfPermission(activity, deniedPermissionsArray[i]) != PackageManager.PERMISSION_GRANTED)
                        returnPermissions.add(deniedPermissionsArray[i]);
                }
            }
        }

        String newDeniePermissionPreference = "";
        for (String permission: returnPermissions)
            if (newDeniePermissionPreference.equals(""))
                newDeniePermissionPreference = permission;
            else
                newDeniePermissionPreference += ";" + permission;
        preferenceManager.setString(PREFERENCE_DENIED_PERMISSIONS, newDeniePermissionPreference);

        return returnPermissions;
    }

    private String getManifestRequest(int request) {

        switch (request) {
            case REQUEST_WRITE_EXTERNAL_STORAGE:
                return Manifest.permission.WRITE_EXTERNAL_STORAGE;
            case REQUEST_READ_EXTERNAL_STORAGE:
                return Manifest.permission.READ_EXTERNAL_STORAGE;
            case REQUEST_WRITE_SETTINGS:
                return Manifest.permission.WRITE_SETTINGS;
            default:
                return "";
        }
    }
}
