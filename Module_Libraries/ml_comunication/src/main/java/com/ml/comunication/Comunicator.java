package com.ml.comunication;


/**
 * <p> Inteface Comunicator </p>
 * Set up any class as comunicator to receive messages.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public interface Comunicator {

    void receiveMessage(Message message);
    boolean isBlocked();
}
