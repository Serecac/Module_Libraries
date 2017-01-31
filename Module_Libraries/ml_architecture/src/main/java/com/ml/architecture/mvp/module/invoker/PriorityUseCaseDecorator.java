package com.ml.architecture.mvp.module.invoker;

import com.ml.architecture.mvp.usecase.UseCaseExecution;

import java.util.concurrent.Callable;

/**
 * <p> Class PriorityUseCaseDecorator </p>
 *
 * @param <T> the type parameter
 * @version 1.0.0
 */
public class PriorityUseCaseDecorator<T> implements Callable<T>, PriorityUseCase {

    private UseCaseExecution<T> execution;

    /**
     * Instantiates a new PriorityUseCaseDecorator.
     *
     * @param execution the execution
     */
    public PriorityUseCaseDecorator(UseCaseExecution<T> execution) {
        this.execution = execution;
    }

    @Override
    public T call() throws Exception {
        return (T) execution.getUseCase().call();
    }

    @Override
    public int getPriority() {
        return execution.getPriority();
    }

    @Override
    public String getDescription() {
        return execution.getClass().toString();
    }
}