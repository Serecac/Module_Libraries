package com.ml.architecture.mvp.module.invoker;

/**
 * <p> Class UnhandledUseCaseException </p>
 *
 * @version 1.0.0
 */
public class UnhandledUseCaseException extends RuntimeException {
    /**
     * Instantiates a new UnhandledUseCaseException.
     *
     * @param useCaseName        the use case name
     * @param initiatorException the initiator exception
     */
    public UnhandledUseCaseException(String useCaseName, String initiatorException) {
        super(String.format("Your use case %s does not handle the exception: %s", useCaseName,
                            initiatorException));
    }
}
