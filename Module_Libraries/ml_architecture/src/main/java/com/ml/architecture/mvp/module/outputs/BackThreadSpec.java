package com.ml.architecture.mvp.module.outputs;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

/**
 * <p> Class BackThreadSpec </p>
 *
 * @version 1.0.0
 */
public class BackThreadSpec implements ThreadSpec {

    @Override
    public void execute(Runnable action) {
        new Thread(action).start();
    }
}
