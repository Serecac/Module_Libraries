package com.ml.comunication;

/**
 * <p> Class ComunicatorGenericException </p>
 * Exception to control that instance was created.
 * @see ComunicatorManager#getInstance()
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class ComunicatorGenericException extends RuntimeException {

    /**
     * The constant COMUNICATOR_EXCEPTION_NOTCREATED, message for the exception.
     */
    final public static String COMUNICATOR_EXCEPTION_NOTCREATED = "ComunicatorManager instance not created";

    /**
     * Instantiates a new ComunicatorGenericException.
     *
     * @param message the message
     */
    public ComunicatorGenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new ComunicatorGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ComunicatorGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
