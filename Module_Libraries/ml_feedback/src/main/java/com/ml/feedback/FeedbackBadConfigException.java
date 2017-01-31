package com.ml.feedback;

/**
 * <p> Class FeedbackBadConfigException </p>
 * Exception to control that config is ok.
 * @see FeedbackConfig
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class FeedbackBadConfigException extends Exception {

    /**
     * The constant FEEDBACK_EXCEPTION_BADCONFIG, message for the exception.
     */
    final public static String FEEDBACK_EXCEPTION_BADCONFIG = "FeedConfig incomplete";

    /**
     * Instantiates a new FeedbackGenericException.
     *
     * @param message the message
     */
    public FeedbackBadConfigException(String message) {
        super(message);
    }

    /**
     * Instantiates a new FeedbackGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public FeedbackBadConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}
