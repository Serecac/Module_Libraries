package com.ml.architecture.mvp.module.invoker;

import android.util.Log;

/**
 * <p> Class LogExceptionHandler </p>
 *
 * @version 1.0.0
 */
public class LogExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "LogExceptionHandler";

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e(TAG, "Unhandled Interactor Exception", ex);
    }
}
