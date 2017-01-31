package com.ml.logs;

/**
 * <p> Class LogWritterGenericException </p>
 * Exception to control that instance was created.
 * @see LogcatWritter#getInstance()
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class LogWritterGenericException extends RuntimeException {

    /**
     * The constant LOGWRITTER_EXCEPTION_NOTCREATED, message for the exception.
     */
    final public static String LOGWRITTER_EXCEPTION_NOTCREATED = "LogcatWritter instance not created";

    /**
     * Instantiates a new LogcatWritter generic exception.
     *
     * @param message the message
     */
    public LogWritterGenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new LogcatWritter generic exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public LogWritterGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
