package com.ml.preference;

/**
 * <p> Class PreferenceGenericException </p>
 * Exception to force control of the case of error when parsing json preference to object.
 * @see PreferenceManager#getJSON(String, Class)
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class PreferenceJsonParseException extends Exception {

    /**
     * The constant PREFERENCE_EXCEPTION_JSON, message for the exception.
     */
    final public static String PREFERENCE_EXCEPTION_JSON = "JSON preference can't cast to %s";

    /**
     * Instantiates a new PreferenceManager json parse exception.
     *
     * @param message the message
     */
    public PreferenceJsonParseException(String message) {
        super(message);
    }

    /**
     * Instantiates a new PreferenceManager json pase exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public PreferenceJsonParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
