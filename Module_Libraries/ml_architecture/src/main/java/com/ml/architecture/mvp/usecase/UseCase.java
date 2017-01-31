package com.ml.architecture.mvp.usecase;

import java.util.concurrent.Callable;

/**
 * <p> Interface UseCase </p>
 * Used to define all internal actions to unique user action
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public interface UseCase<T extends UseCaseResponse> extends Callable<T> {
    @Override T call() throws Exception;
}
