package com.ml.architecture.mvp.usecase;

/**
 * <p> Inteface UseCaseResult </p>
 * Result sucess info for usecase execution
 *
 * @param <T> the type parameter
 * @author Javier Cáceres
 * @version 1.0.0
 */
public interface UseCaseResult<T> {

    /**
     * On result.
     *
     * @param result the result
     */
    void onResult(T result);
}
