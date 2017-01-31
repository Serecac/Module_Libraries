package com.ml.toolbar;

/**
 * <p> Class ToolbarGenericException </p>
 * Exception to control that instance was created.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see ToolbarManager#getInstance()
 */
public class ToolbarGenericException extends RuntimeException {

    /**
     * The constant TOOLBAR_EXCEPTION_NOTCREATED, message for the exception.
     */
    final public static String TOOLBAR_EXCEPTION_NOTCREATED = "ToolbarManager instance not created";

    /**
     * Instantiates a new ToolbarGenericException.
     *
     * @param message the message
     */
    public ToolbarGenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new ToolbarGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ToolbarGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
