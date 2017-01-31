package com.ml.comunication;

import android.util.SparseArray;

/**
 * <p> Class Channel </p>
 * Group of Comunicator to send joint messages
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see Comunicator
 */
public class Channel {

    private SparseArray<Comunicator> subcribeComunicators;

    /**
     * Instantiates a new Channel.
     */
    public Channel() {
        subcribeComunicators = new SparseArray<>();
    }

    /**
     * Gets subcribe comunicators.
     *
     * @return the subcribe comunicators
     */
    public SparseArray<Comunicator> getSubcribeComunicators() {
        return subcribeComunicators;
    }

    /**
     * Sets subcribe comunicators.
     *
     * @param subcribeComunicators the subcribe comunicators
     */
    public void setSubcribeComunicators(SparseArray<Comunicator> subcribeComunicators) {
        this.subcribeComunicators = subcribeComunicators;
    }

    /**
     * Add comunicator.
     *
     * @param id          the id
     * @param comunicator the comunicator
     */
    public void addComunicator(int id, Comunicator comunicator){
        if (subcribeComunicators != null){
            subcribeComunicators.put(id,comunicator);
        }
    }

    /**
     * Delete comunicator.
     *
     * @param id the id
     */
    public void deleteComunicator(int id){
        if (subcribeComunicators != null && subcribeComunicators.indexOfKey(id) > 0){
            subcribeComunicators.remove(id);
        }
    }

    /**
     * Send message to all.
     *
     * @param message the message
     */
    public void sendMessageToAll(Message message){
        if (subcribeComunicators != null){
            for(int i = 0; i < subcribeComunicators.size(); i++) {
                int key = subcribeComunicators.keyAt(i);
                Comunicator comunicator = subcribeComunicators.get(key);
                if (!comunicator.isBlocked())
                    comunicator.receiveMessage(message);
            }
        }
    }
}
