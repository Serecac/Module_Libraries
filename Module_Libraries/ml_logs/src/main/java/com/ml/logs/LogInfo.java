package com.ml.logs;

import com.google.gson.Gson;

/**
 * <p> Class LogInfo </p>
 * Base class for print logs on logcat.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see LogcatWritter
 */
public class LogInfo {

    private String message;
    private Throwable throwable;
    private int stackTraceDeep;
    private String json;
    private String xml;
    private boolean showThreadHeader;

    /**
     * Instantiates a new LogInfo.
     */
    public LogInfo() {
        message = "";
        throwable = null;
        stackTraceDeep = -1;
        json = "";
        xml = "";
        showThreadHeader = true;
    }

    /**
     * Instantiates a new Log info.
     *
     * @param message          the message
     * @param throwable        the throwable
     * @param stackTraceDeep    the stackTraceDeep for the throwable
     * @param json             the json n string format
     * @param xml              the xml in string format
     * @param showThreadHeader if header must be shown
     */
    public LogInfo(String message, Throwable throwable, int stackTraceDeep, String json, String xml, boolean showThreadHeader) {
        this.message = message;
        this.throwable = throwable;
        this.stackTraceDeep = stackTraceDeep;
        this.json = json;
        this.xml = xml;
        this.showThreadHeader = showThreadHeader;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets throwable.
     *
     * @return the throwable
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * Sets throwable.
     *
     * @param throwable the throwable
     */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    /**
     * Gets stackTraceDeep.
     *
     * @return the stackTraceDeep
     */
    public int getStackTraceDeep() {
        return stackTraceDeep;
    }

    /**
     * Sets stackTraceDeep
     *
     * @param stackTraceDeep the stackTraceDeep
     */
    public void setStackTraceDeep(int stackTraceDeep) {
        this.stackTraceDeep = stackTraceDeep;
    }

    /**
     * Gets json.
     *
     * @return the json
     */
    public String getJson() {
        return json;
    }

    /**
     * Sets json.
     *
     * @param json the json
     */
    public void setJson(String json) {
        this.json = json;
    }

    /**
     * Gets xml.
     *
     * @return the xml
     */
    public String getXml() {
        return xml;
    }

    /**
     * Sets xml.
     *
     * @param xml the xml
     */
    public void setXml(String xml) {
        this.xml = xml;
    }

    /**
     * if header must be shown.
     *
     * @return the boolean
     */
    public boolean isShowThreadHeader() {
        return showThreadHeader;
    }

    /**
     * Sets if header must be shown.
     *
     * @param showThreadHeader if header must be shown
     */
    public void setShowThreadHeader(boolean showThreadHeader) {
        this.showThreadHeader = showThreadHeader;
    }

    /**
     * The type Builder.
     */
    public static class Builder {

        private LogInfo log;

        /**
         * Instantiates a new Builder.
         */
        public Builder(){
            log = new LogInfo();
        }

        /**
         * Add message builder.
         *
         * @param message the message
         * @return the builder
         */
        public Builder addMessage(String message){
            log.setMessage(message);
            return this;
        }

        /**
         * Add throwable builder.
         *
         * @param throwable the throwable
         * @return the builder
         */
        public Builder addThrowable(Throwable throwable){
            log.setThrowable(throwable);
            return this;
        }

        /**
         * Add stack trace deep builder.
         *
         * @param stackTraceDeep the stack trace deep
         * @return the builder
         */
        public Builder addStackTraceDeep(int stackTraceDeep){
            log.setStackTraceDeep(stackTraceDeep);
            return this;
        }

        /**
         * Add json object builder.
         *
         * @param jsonObject the json object
         * @return the builder
         */
        public Builder addJsonObject(Object jsonObject){
            Gson gson = new Gson();
            log.setJson(gson.toJson(jsonObject));
            return this;
        }

        /**
         * Add json string builder.
         *
         * @param jsonString the json string
         * @return the builder
         */
        public Builder addJsonString(String jsonString){
            log.setJson(jsonString);
            return this;
        }

        /**
         * Add xml string builder.
         *
         * @param xmlString the xml string
         * @return the builder
         */
        public Builder addXmlString(String xmlString){
            log.setXml(xmlString);
            return this;
        }

        /**
         * Add if header must be shown.
         *
         * @param showThreadHeader if header must be shown
         * @return the builder
         */
        public Builder addShowThreadHeader(boolean showThreadHeader){
            log.setShowThreadHeader(showThreadHeader);
            return this;
        }

        /**
         * Create logInfo.
         *
         * @return the log info
         * @see LogInfo
         */
        public LogInfo create(){
            return log;
        }
    }
}
