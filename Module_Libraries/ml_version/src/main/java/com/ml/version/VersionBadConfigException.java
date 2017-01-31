package com.ml.version;

/**
 * <p> Class VersionBadConfigException </p>
 * Exception to control that config is ok.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see VersionConfig
 */
public class VersionBadConfigException extends Exception {

    /**
     * The constant VERSION_EXCEPTION_BADCONFIG, message for the exception.
     */
    final public static String VERSION_EXCEPTION_BADCONFIG = "VersionConfig incomplete";

    /**
     * Instantiates a new VersionGenericException.
     *
     * @param message the message
     */
    public VersionBadConfigException(String message) {
        super(message);
    }

    /**
     * Instantiates a new VersionGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public VersionBadConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}
