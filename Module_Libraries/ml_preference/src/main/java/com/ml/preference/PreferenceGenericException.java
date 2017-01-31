package com.ml.preference;

/**
 * <p> Class PreferenceGenericException </p>
 * Exception to control that instance was created.
 * @see PreferenceManager#getInstance()
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class PreferenceGenericException extends RuntimeException {

    /**
     * The constant PREFERENCE_EXCEPTION_NOTCREATED, message for the exception.
     */
    final public static String PREFERENCE_EXCEPTION_NOTCREATED = "PreferenceManager instance not created";

    /**
     * Instantiates a new PreferenceManager generic exception.
     *
     * @param message the message
     */
    public PreferenceGenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new PreferenceManager generic exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public PreferenceGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
