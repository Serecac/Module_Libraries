package com.ml.pemission;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

public abstract class PermissionDeniedDialog extends Dialog {

    private Listener listener;

    public PermissionDeniedDialog(@NonNull Context context) {
        super(context);
        setCancelable(false);
    }
    public void onOk(){
        if (listener != null)
            listener.onOk();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener{
        void onOk();
    }
}
