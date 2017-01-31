package com.ml.architecture.mvp.module.outputs;

import android.os.Handler;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

/**
 * <p> Class BackThreadSpec </p>
 *
 * @version 1.0.0
 */
public class MainThreadSpec implements ThreadSpec {

    /**
     * The Handler.
     */
    Handler handler = new Handler();

    @Override
    public void execute(Runnable action) {
        handler.post(action);
    }
}
