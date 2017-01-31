package com.ml.architecture.mvp.module.invoker;

import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * <p> Class UseCaseOutputThreadFactory </p>
 *
 * @version 1.0.0
 */
public class UseCaseOutputThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(@NonNull Runnable r) {
        return new Thread(r, "InteractorInvoker" + r.toString());
    }
}
