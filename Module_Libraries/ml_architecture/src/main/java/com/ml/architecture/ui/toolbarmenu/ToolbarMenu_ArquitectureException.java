package com.ml.architecture.ui.toolbarmenu;

/**
 * <p> Class ToolbarMenu_ArquitectureException </p>
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class ToolbarMenu_ArquitectureException extends RuntimeException {

    /**
     * The constant TOOLBARMENU_EXCEPTION_FAILLAYOUT, message for exception.
     */
    final public static String TOOLBARMENU_EXCEPTION_FAILLAYOUT = "Activity layout not found";
    /**
     * The constant TOOLBARMENU_EXCEPTION_BADARGUMENTS, message for exception.
     */
    final public static String TOOLBARMENU_EXCEPTION_BADARGUMENTS = "Bad arguments for fragment";
    /**
     * The constant TOOLBARMENU_EXCEPTION_CHANGEFRAGMENT, message for exception.
     */
    final public static String TOOLBARMENU_EXCEPTION_CHANGEFRAGMENT = "Error while changing fragments";

    /**
     * Instantiates a new ToolbarMenu_ArquitectureException.
     *
     * @param message the message
     */
    public ToolbarMenu_ArquitectureException(String message) {
        super(message);
    }

    /**
     * Instantiates a new ToolbarMenu_ArquitectureException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ToolbarMenu_ArquitectureException(String message, Throwable cause) {
        super(message, cause);
    }
}
