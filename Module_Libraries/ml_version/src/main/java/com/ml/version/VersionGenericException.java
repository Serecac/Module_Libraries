package com.ml.version;

/**
 * <p> Class VersionGenericException </p>
 * Exception to control that instance was created.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see VersionManager#getInstance()
 */
public class VersionGenericException extends RuntimeException {

    /**
     * The constant VERSION_EXCEPTION_NOTCREATED, message for the exception.
     */
    final public static String VERSION_EXCEPTION_NOTCREATED = "VersionManager instance not created";

    /**
     * Instantiates a new VersionGenericException.
     *
     * @param message the message
     */
    public VersionGenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new VersionGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public VersionGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
