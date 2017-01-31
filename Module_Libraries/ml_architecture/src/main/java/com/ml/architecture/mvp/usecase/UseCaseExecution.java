package com.ml.architecture.mvp.usecase;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> Class UseCaseExecution </p>
 * Control usecase lifecycle
 *
 * @param <T> the type parameter
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class UseCaseExecution<T> {

    private UseCaseResult<T> useCaseResult;
    private final Map<Class<? extends UseCaseError>, UseCaseResult<? extends UseCaseError>> errors = new HashMap<>(0);
    private final UseCase<UseCaseResponse<T>> useCase;
    private int priority;

    /**
     * Instantiates a new usecase execution.
     *
     * @param useCase the usecase
     */
    public UseCaseExecution(UseCase<UseCaseResponse<T>> useCase) {
        this.useCase = useCase;
    }

    /**
     * Result usecase execution.
     *
     * @param useCaseResult the usecase result
     * @return the usecase execution
     */
    public UseCaseExecution<T> result(UseCaseResult<T> useCaseResult) {
        this.useCaseResult = useCaseResult;
        return this;
    }

    /**
     * Error usecase execution.
     *
     * @param errorClass   the error class
     * @param useCaseError the usecase error
     * @return the usecase execution
     */
    public UseCaseExecution<T> error(Class<? extends UseCaseError> errorClass, UseCaseResult<? extends UseCaseError> useCaseError) {
        this.errors.put(errorClass, useCaseError);
        return this;
    }

    /**
     * Priority usecase execution.
     *
     * @param priority the priority
     * @return the usecase execution
     */
    public UseCaseExecution<T> priority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Gets usecase.
     *
     * @return the usecase
     */
    public UseCase<UseCaseResponse<T>> getUseCase() {
        return useCase;
    }

    /**
     * Gets usecase error result.
     *
     * @param errorClass the error class
     * @return the usecase error result
     */
    public UseCaseResult<? extends UseCaseError> getUseCaseErrorResult(Class<? extends UseCaseError> errorClass) {
        return errors.get(errorClass);
    }

    /**
     * Gets usecase result.
     *
     * @return the usecase result
     */
    public UseCaseResult<T> getUseCaseResult() {
        return useCaseResult;
    }

    /**
     * Execute.
     *
     * @param useCaseInvoker the usecase invoker
     */
    public void execute(UseCaseInvoker useCaseInvoker) {
        useCaseInvoker.execute(this);
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
