package com.ml.feedback;

/**
 * <p> Class FeedbackGenericException </p>
 * Exception to control that instance was created.
 * @see FeedbackManager#getInstance()
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class FeedbackGenericException extends RuntimeException {

    /**
     * The constant FEEDBACK_EXCEPTION_NOTCREATED, message for the exception.
     */
    final public static String FEEDBACK_EXCEPTION_NOTCREATED = "FeedbackManager instance not created";

    /**
     * Instantiates a new FeedbackGenericException.
     *
     * @param message the message
     */
    public FeedbackGenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new FeedbackGenericException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public FeedbackGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
