package com.ml.architecture.mvp.usecase;

import java.util.concurrent.Future;

/**
 * <p> Interface UseCaseResponse </p>
 * Execute usecase
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public interface UseCaseInvoker {

    /**
     * Execute usecase.
     *
     * @param <T>     the type parameter
     * @param useCase the use case
     * @return the future
     */
    <T> Future<T> execute(UseCaseExecution<T> useCase);
}
