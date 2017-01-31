package com.ml.architecture.mvp.module.invoker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <p> Class PriorityRunnableFutureDecorated </p>
 *
 * @version 1.0.0
 */
public class PriorityRunnableFutureDecorated<T> implements RunnableFuture<T> {

    private RunnableFuture<T> undecoratedFuture;
    private int priority;

    /**
     * Instantiates a new PriorityRunnableFutureDecorated.
     *
     * @param undecoratedFuture the undecorated future
     * @param priority          the priority
     */
    public PriorityRunnableFutureDecorated(RunnableFuture<T> undecoratedFuture, int priority) {
        this.undecoratedFuture = undecoratedFuture;
        this.priority = priority;
    }

    @Override
    public void run() {
        undecoratedFuture.run();
    }

    @Override
    public boolean cancel(boolean b) {
        return undecoratedFuture.cancel(b);
    }

    @Override
    public boolean isCancelled() {
        return undecoratedFuture.isCancelled();
    }

    @Override
    public boolean isDone() {
        return undecoratedFuture.isDone();
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        return undecoratedFuture.get();
    }

    @Override
    public T get(long l, TimeUnit timeUnit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return undecoratedFuture.get();
    }

    /**
     * Gets priority.
     *
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }
}
