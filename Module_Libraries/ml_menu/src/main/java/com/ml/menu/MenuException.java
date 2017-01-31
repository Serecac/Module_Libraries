package com.ml.menu;

/**
 * <p> Class MenuException </p>
 * Exception to control menu fails.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class MenuException extends RuntimeException {

    /**
     * The constant MENU_EXCEPTION_BLOCKMENU, message for the exception.
     */
    final public static String MENU_EXCEPTION_BLOCKMENU = "Failed trying block menu";

    /**
     * Instantiates a new MenuGenericException.
     *
     * @param message the message
     */
    public MenuException(String message) {
        super(message);
    }

    /**
     * Instantiates a new MenuGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }
}
