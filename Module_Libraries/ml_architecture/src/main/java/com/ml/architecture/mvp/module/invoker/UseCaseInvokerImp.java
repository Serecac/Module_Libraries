package com.ml.architecture.mvp.module.invoker;


import com.ml.architecture.mvp.usecase.UseCaseExecution;
import com.ml.architecture.mvp.usecase.UseCaseInvoker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * <p> Class UseCaseInvokerImp </p>
 *
 * @version 1.0.0
 */
public class UseCaseInvokerImp implements UseCaseInvoker {

    private ExecutorService executor;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    /**
     * Instantiates a new UseCaseInvokerImp.
     *
     * @param executor                 the executor
     * @param uncaughtExceptionHandler the uncaught exception handler
     */
    public UseCaseInvokerImp(ExecutorService executor,
                             Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.executor = executor;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    /**
     * Execute futureTask.
     *
     * @param <T>       the type parameter
     * @param execution the execution
     * @return the future
     */
    @Override
    public <T> Future<T> execute(UseCaseExecution<T> execution) {
        if (execution.getUseCaseResult() != null) {
            return (Future<T>) executor.submit(
                    new UseCaseExecutionFutureTask<>(execution, uncaughtExceptionHandler));
        } else {
            return executor.submit(new PriorityUseCaseDecorator<>(execution));
        }
    }
}