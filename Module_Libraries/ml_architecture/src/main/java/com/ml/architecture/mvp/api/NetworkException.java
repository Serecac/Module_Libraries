package com.ml.architecture.mvp.api;


/**
 * <p> Class NetworkException </p>
 * Exception to control api calls status
 *
 * @version 1.0.0
 */
public class NetworkException extends RuntimeException {

    /**
     * The constant NETWORK_EXCEPTION, message for the exception.
     */
    final public static String NETWORK_EXCEPTION = "Error ";

    /**
     * Instantiates a new NetworkException.
     *
     * @param message the message
     */
    public NetworkException(String message) {
        super(message);
    }

    /**
     * Instantiates a new NetworkException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NetworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
