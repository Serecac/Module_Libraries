package com.ml.architecture.mvp.module.invoker;


import com.ml.architecture.mvp.usecase.UseCaseError;
import com.ml.architecture.mvp.usecase.UseCaseExecution;
import com.ml.architecture.mvp.usecase.UseCaseResponse;
import com.ml.architecture.mvp.usecase.UseCaseResult;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <p> Class UseCaseExecutionFutureTask </p>
 *
 * @param <T> the type parameter
 * @version 1.0.0
 */
public class UseCaseExecutionFutureTask<T> extends FutureTask<T> implements PriorityUseCase {

    private final UseCaseExecution<T> useCaseExecution;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final String description;

    /**
     * Instantiates a new UseCaseExecutionFutureTask.
     *
     * @param useCaseExecution         the use case execution
     * @param uncaughtExceptionHandler the uncaught exception handler
     */
    public UseCaseExecutionFutureTask(UseCaseExecution<T> useCaseExecution,
                                      Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        super((Callable<T>) useCaseExecution.getUseCase());
        this.useCaseExecution = useCaseExecution;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        this.description = useCaseExecution.getUseCase().getClass().toString();
    }

    @Override
    protected void done() {
        super.done();
        try {
            handleResponse((UseCaseResponse<T>) get());
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        Throwable causeException = e.getCause();
        unhandledException(causeException != null ? causeException : e);
    }

    private void handleResponse(UseCaseResponse<T> response) {
        if (response.hasError()) {
            handleError(response.getError());
        } else {
            handleResult(response.getResult());
        }
    }

    private void handleResult(T result) {
        useCaseExecution.getUseCaseResult().onResult(result);
    }

    private void handleError(UseCaseError error) {
        UseCaseResult errorResult =
                useCaseExecution.getUseCaseErrorResult(error.getClass());
        if (errorResult != null) {
            errorResult.onResult(error);
        } else {
            unhandledException(new RuntimeException("Unhandled handleError action: " + error.getClass().toString()));
        }
    }

    private void unhandledException(Throwable cause) {
        UnhandledUseCaseException e =
                new UnhandledUseCaseException(description, cause.getClass().getName());
        e.initCause(cause);
        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), e);
    }

    public int getPriority() {
        return useCaseExecution.getPriority();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
