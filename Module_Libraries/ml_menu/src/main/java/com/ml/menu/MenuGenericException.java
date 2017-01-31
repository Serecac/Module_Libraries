package com.ml.menu;

/**
 * <p> Class MenuGenericException </p>
 * Exception to control that instance was created.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see MenuManager#getInstance()
 */
public class MenuGenericException extends RuntimeException {

    /**
     * The constant MENU_EXCEPTION_NOTCREATED, message for the exception.
     */
    final public static String MENU_EXCEPTION_NOTCREATED = "MenuManager instance not created";

    /**
     * Instantiates a new MenuGenericException.
     *
     * @param message the message
     */
    public MenuGenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new MenuGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public MenuGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
