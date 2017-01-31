package com.ml.comunication;

/**
 * <p> Inteface Message </p>
 * Used to send information.
 *
 * @param <T> the type parameter
 */
public interface Message<T>  {

    /**
     * Gets message info.
     *
     * @return the message info
     */
    T getMessageInfo();
}
