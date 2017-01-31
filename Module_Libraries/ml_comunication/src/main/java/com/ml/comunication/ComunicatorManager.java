package com.ml.comunication;

import android.util.SparseArray;

import java.util.List;

import static com.ml.comunication.ComunicatorGenericException.COMUNICATOR_EXCEPTION_NOTCREATED;
import static com.ml.comunication.ComunicatorSendException.COMUNICATOR_EXCEPTION_FAILSEND_CHANNEL;
import static com.ml.comunication.ComunicatorSendException.COMUNICATOR_EXCEPTION_FAILSEND_COMUNICATOR;

/**
 * The type Comunicator manager.
 */
public class ComunicatorManager {

    private SparseArray<Channel> channels;
    private SparseArray<Comunicator> comunicators;
    private static ComunicatorManager instance = null;

    /**
     * Instantiates a new Comunicator manager.
     */
    public ComunicatorManager(){
        channels = new SparseArray<>();
        comunicators = new SparseArray<>();
    }

    /**
     * Init.
     */
    public static void init(){
        instance = new ComunicatorManager();
    }

    /**
     * Get instance comunicator manager.
     *
     * @return the comunicator manager
     */
    public static ComunicatorManager getInstance(){

        if (instance == null)
            throw new ComunicatorGenericException(COMUNICATOR_EXCEPTION_NOTCREATED);

        return instance;
    }

    /*=========================================================*/
    /*=======================  CHANNEL  =======================*/
    /*=========================================================*/
    /**
     * Create channel.
     * @see Channel
     *
     * @param channelId the channel id
     */
    public void createChannel(int channelId){
        if (channels != null){
            channels.put(channelId,new Channel());
        }
    }

    /**
     * Delete channel.
     * @see Channel
     *
     * @param channelId the channel id
     */
    public void deleteChannel(int channelId){
        if (channels != null && channels.indexOfKey(channelId) >= 0){
            channels.remove(channelId);
        }
    }

    /**
     * Suscribe Comunicator to channel.
     * @see Comunicator
     * @see Channel
     *
     * @param channelId     the channel id
     * @param comunicatorId the comunicator id
     * @param comunicator   the comunicator
     */
    public void suscribeToChannel(int channelId, int comunicatorId, Comunicator comunicator){
        if (channels != null && channels.indexOfKey(channelId) >= 0){
            channels.get(channelId).addComunicator(comunicatorId,comunicator);
            comunicators.put(comunicatorId,comunicator);
        }
    }

    /**
     * Comunicator leave a channel.
     * @see Comunicator
     * @see Channel
     *
     * @param channelId     the channel id
     * @param comunicatorId the comunicator id
     */
    public void leaveAChannel(int channelId, int comunicatorId){
        if (channels != null && channels.indexOfKey(channelId) >= 0){
            channels.get(channelId).deleteComunicator(comunicatorId);
        }
    }

    /*======================================================*/
    /*=======================  SEND  =======================*/
    /*======================================================*/
    /**
     * Send message to one Comunicator.
     * @see Comunicator
     *
     * @param comunicatorId the comunicator id
     * @param message       the message
     * @throws ComunicatorSendException the comunicator send exception
     */
    public void sendMessage(int comunicatorId, Message message) throws ComunicatorSendException {
        if (comunicators != null && comunicators.indexOfKey(comunicatorId) >= 0){
            if (!comunicators.get(comunicatorId).isBlocked())
                comunicators.get(comunicatorId).receiveMessage(message);
        } else {
            throw new ComunicatorSendException(COMUNICATOR_EXCEPTION_FAILSEND_COMUNICATOR);
        }
    }

    /**
     * Send message to all Comunicator in a Channel.
     * @see Comunicator
     * @see Channel
     *
     * @param channelId the channel id
     * @param message   the message
     * @throws ComunicatorSendException the comunicator send exception
     */
    public void sendMessageToChannel(int channelId, Message message) throws ComunicatorSendException {
        if (channels != null && channels.indexOfKey(channelId) >= 0){
            channels.get(channelId).sendMessageToAll(message);
        } else {
            throw new ComunicatorSendException(COMUNICATOR_EXCEPTION_FAILSEND_CHANNEL);
        }
    }

    /**
     * Send message to all Comunicators.
     * @see Comunicator
     *
     * @param message the message
     * @throws ComunicatorSendException the comunicator send exception
     */
    public void sendMessageToAll(Message message) throws ComunicatorSendException {
        if (comunicators != null){
            for(int i = 0; i < comunicators.size(); i++) {
                int key = comunicators.keyAt(i);
                Comunicator comunicator = comunicators.get(key);
                if (!comunicator.isBlocked())
                    comunicator.receiveMessage(message);
            }
        } else {
            throw new ComunicatorSendException(COMUNICATOR_EXCEPTION_FAILSEND_CHANNEL);
        }
    }

    /*==============================================================*/
    /*=======================  COMUNICATOR   =======================*/
    /*==============================================================*/
    /**
     * Add Comunicator to main Channel.
     * @see Comunicator
     *
     * @param comunicatorId the comunicator id
     * @param comunicator   the comunicator
     */
    public void addComunicator(int comunicatorId, Comunicator comunicator){
        if (comunicator != null){
            comunicators.put(comunicatorId,comunicator);
        }
    }

    /**
     * Delete Comunicator from main Channel.
     * @see Comunicator
     *
     * @param comunicatorId the comunicator id
     */
    public void deleteComunicator(int comunicatorId){
        if (comunicators != null && comunicators.indexOfKey(comunicatorId) >= 0){
            comunicators.remove(comunicatorId);
        }

        //Also delete comunicator from all channels
        if (channels != null){
            for(int i = 0; i < channels.size(); i++) {
                int key = channels.keyAt(i);
                Channel channel = channels.get(key);
                channel.deleteComunicator(comunicatorId);
            }
        }
    }
}
