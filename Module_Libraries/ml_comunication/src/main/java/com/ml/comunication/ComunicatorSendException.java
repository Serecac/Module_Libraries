package com.ml.comunication;

/**
 * <p> Class ComunicatorSendException </p>
 * Exception to control that message was sent.
 * @see ComunicatorManager#sendMessage(int, Message)
 * @see ComunicatorManager#sendMessageToAll(Message)
 * @see ComunicatorManager#sendMessageToChannel(int, Message)
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class ComunicatorSendException extends Exception {

    /**
     * The constant COMUNICATOR_EXCEPTION_FAILSEND_COMUNICATOR, message for the exception.
     */
    final public static String COMUNICATOR_EXCEPTION_FAILSEND_COMUNICATOR = "Message can't be send, comunnicator not found";
    /**
     * The constant COMUNICATOR_EXCEPTION_FAILSEND_CHANNEL, message for the exception.
     */
    final public static String COMUNICATOR_EXCEPTION_FAILSEND_CHANNEL = "Send can't be send, channel not found";

    /**
     * Instantiates a new ComunicatorSendException.
     *
     * @param message the message
     */
    public ComunicatorSendException(String message) {
        super(message);
    }

    /**
     * Instantiates a new ComunicatorSendException.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ComunicatorSendException(String message, Throwable cause) {
        super(message, cause);
    }
}
