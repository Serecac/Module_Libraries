package com.ml.architecture.mvp.module.outputs;


import me.panavtec.threaddecoratedview.views.ThreadSpec;

/**
 * <p> Class BackThreadSpec </p>
 *
 * @version 1.0.0
 */
public class SameThreadSpec implements ThreadSpec {

    @Override
    public void execute(Runnable action) {
        action.run();
    }
}
