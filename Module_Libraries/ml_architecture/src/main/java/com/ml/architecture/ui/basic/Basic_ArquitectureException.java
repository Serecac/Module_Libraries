package com.ml.architecture.ui.basic;

/**
 * <p> Class Basic_ArquitectureException </p>
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Basic_ArquitectureException extends RuntimeException {

    /**
     * The constant BASIC_EXCEPTION_FAILLAYOUT, message for exception.
     */
    final public static String BASIC_EXCEPTION_FAILLAYOUT = "Activity layout not found";
    /**
     * The constant BASIC_EXCEPTION_BADARGUMENTS, message for exception.
     */
    final public static String BASIC_EXCEPTION_BADARGUMENTS = "Bad arguments for fragment";
    /**
     * The constant BASIC_EXCEPTION_CHANGEFRAGMENT, message for exception.
     */
    final public static String BASIC_EXCEPTION_CHANGEFRAGMENT = "Error while changing fragments";

    /**
     * Instantiates a new Basic_ArquitectureException.
     *
     * @param message the message
     */
    public Basic_ArquitectureException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Basic_ArquitectureException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public Basic_ArquitectureException(String message, Throwable cause) {
        super(message, cause);
    }
}
