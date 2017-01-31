package com.ml.logs;

import android.os.Build;
import android.os.Looper;
import android.util.Log;

import com.ml.utils.utils.Utils_String;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import static com.ml.logs.LogWritterGenericException.LOGWRITTER_EXCEPTION_NOTCREATED;

/**
 * <p> Class LogcatWritter </p>
 * Class to write custom logs for debugging.
 *
 * <i> JCN - Refactor functions, unified calls in a single function </i>
 *
 * @author Javier Cáceres
 * @version 1.0.1
 */
public class LogcatWritter {

    private final int SEPARATOR_LINE_LENTGH = 90;
    private final int MAX_STACKTRACE = 10;
    private final String lineNormal = "║ %s";

    /**
     * The constant TYPE_LOG_DEBUG.
     */
    public static final int TYPE_LOG_DEBUG = 1;
    /**
     * The constant TYPE_LOG_VERBOSE.
     */
    public static final int TYPE_LOG_VERBOSE = 2;
    /**
     * The constant TYPE_LOG_INFO.
     */
    public static final int TYPE_LOG_INFO = 3;
    /**
     * The constant TYPE_LOG_ERROR.
     */
    public static final int TYPE_LOG_ERROR = 4;
    /**
     * The constant TYPE_LOG_WARNING.
     */
    public static final int TYPE_LOG_WARNING = 5;

    /**
     * The constant LOG_LEVEL_NONE.
     */
    public static final int LOG_LEVEL_NONE = 1;
    /**
     * The constant LOG_LEVEL_DEBUG.
     */
    public static final int LOG_LEVEL_DEBUG = 2;
    /**
     * The constant LOG_LEVEL_FULL.
     */
    public static final int LOG_LEVEL_FULL = 3;

    private String defaultLogTag = "LogcatWritter";
    private int logLevel = LOG_LEVEL_FULL;
    private static LogcatWritter instance = null;

    /**
     * Instantiates a new Logcat writter.
     *
     * @param defaultLogTag the default log tag
     * @param logLevel      the log level
     */
    public LogcatWritter(String defaultLogTag, int logLevel) {

        this.logLevel = logLevel;
        this.defaultLogTag = defaultLogTag;
    }

    /**
     * Instantiates a new Logcat writter.
     *
     * @param logLevel the log level
     */
    public LogcatWritter(int logLevel) {

        this.logLevel = logLevel;
    }

    /**
     * Init.
     *
     * @param defaultLogTag the default log tag
     * @param logLevel      the log level
     */
    public static void init(String defaultLogTag, int logLevel){
        instance = new LogcatWritter(defaultLogTag, logLevel);
    }

    /**
     * Init.
     *
     * @param logLevel the log level
     */
    public static void init(int logLevel){
        instance = new LogcatWritter(logLevel);
    }

    /**
     * Get instance logcat writter.
     *
     * @return the logcat writter
     */
    public static LogcatWritter getInstance(){

        if (instance == null)
            throw new LogWritterGenericException(LOGWRITTER_EXCEPTION_NOTCREATED);

        return instance;
    }

    /*=======================================================*/
    /*=======================  DEBUG  =======================*/
    /*=======================================================*/
    /**
     * Debug.
     *
     * @param builder the builder
     */
    public void debug(LogInfo.Builder builder){
        debug(defaultLogTag,builder.create());
    }

    /**
     * Debug.
     *
     * @param logInfo the log info
     */
    public void debug(LogInfo logInfo){
        debug(defaultLogTag,logInfo);
    }

    /**
     * Debug.
     *
     * @param tag     the tag
     * @param builder the builder
     */
    public void debug(String tag, LogInfo.Builder builder){
        debug(tag,builder.create());
    }

    /**
     * Debug.
     *
     * @param tag     the tag
     * @param logInfo the log info
     */
    public void debug(String tag, LogInfo logInfo){

        writeFullLog(tag,logInfo,TYPE_LOG_DEBUG);
    }

    /*=======================================================*/
    /*=======================  ERROR  =======================*/
    /*=======================================================*/
    /**
     * Error.
     *
     * @param builder the builder
     */

    public void error(LogInfo.Builder builder){
        error(defaultLogTag,builder.create());
    }

    /**
     * Error.
     *
     * @param logInfo the log info
     */
    public void error(LogInfo logInfo){
        error(defaultLogTag,logInfo);
    }

    /**
     * Error.
     *
     * @param tag     the tag
     * @param builder the builder
     */
    public void error(String tag, LogInfo.Builder builder){
        error(tag,builder.create());
    }

    /**
     * Error.
     *
     * @param tag     the tag
     * @param logInfo the log info
     */
    public void error(String tag, LogInfo logInfo){

        writeFullLog(tag,logInfo,TYPE_LOG_ERROR);
    }

    /*=========================================================*/
    /*=======================  WARNING  =======================*/
    /*=========================================================*/
    /**
     * Warning.
     *
     * @param builder the builder
     */
    public void warning(LogInfo.Builder builder){
        warning(defaultLogTag,builder.create());
    }

    /**
     * Warning.
     *
     * @param logInfo the log info
     */
    public void warning(LogInfo logInfo){
        warning(defaultLogTag,logInfo);
    }

    /**
     * Warning.
     *
     * @param tag     the tag
     * @param builder the builder
     */
    public void warning(String tag, LogInfo.Builder builder){
        warning(tag,builder.create());
    }

    /**
     * Warning.
     *
     * @param tag     the tag
     * @param logInfo the log info
     */
    public void warning(String tag, LogInfo logInfo){

        writeFullLog(tag,logInfo,TYPE_LOG_WARNING);
    }

    /*======================================================*/
    /*=======================  INFO  =======================*/
    /*======================================================*/
    /**
     * Info.
     *
     * @param builder the builder
     */
    public void info(LogInfo.Builder builder){
        info(defaultLogTag,builder.create());
    }

    /**
     * Info.
     *
     * @param logInfo the log info
     */
    public void info(LogInfo logInfo){
        info(defaultLogTag,logInfo);
    }

    /**
     * Info.
     *
     * @param tag     the tag
     * @param builder the builder
     */
    public void info(String tag, LogInfo.Builder builder){
        info(tag,builder.create());
    }

    /**
     * Info.
     *
     * @param tag     the tag
     * @param logInfo the log info
     */
    public void info(String tag, LogInfo logInfo){

        writeFullLog(tag,logInfo,TYPE_LOG_INFO);
    }

    /**
     * Verbose.
     *
     * @param builder the builder
     */
/*=========================================================*/
    /*=======================  VERBOSE  =======================*/
    /*=========================================================*/
    public void verbose(LogInfo.Builder builder){
        verbose(defaultLogTag,builder.create());
    }

    /**
     * Verbose.
     *
     * @param logInfo the log info
     */
    public void verbose(LogInfo logInfo){
        verbose(defaultLogTag,logInfo);
    }

    /**
     * Verbose.
     *
     * @param tag     the tag
     * @param builder the builder
     */
    public void verbose(String tag, LogInfo.Builder builder){
        verbose(tag,builder.create());
    }

    /**
     * Verbose.
     *
     * @param tag     the tag
     * @param logInfo the log info
     */
    public void verbose(String tag, LogInfo logInfo){
        writeFullLog(tag,logInfo,TYPE_LOG_VERBOSE);
    }

    /*==========================================================*/
    /*=======================  WRITTERS  =======================*/
    /*==========================================================*/
    private void writeFullLog(String tag, LogInfo logInfo, int logType){
        boolean firstLine = !logInfo.isShowThreadHeader();

        writeHeaderThread(tag,logType,logInfo.isShowThreadHeader());

        if (!logInfo.getMessage().equals("")){
            writeBodyMessage(tag,logInfo.getMessage(),logType, firstLine);
            firstLine = false;
        }

        if (logInfo.getThrowable() != null) {
            writeBodyThrowble(tag, logInfo.getThrowable(), logInfo.getStackTraceDeep(), logType, firstLine);
            firstLine = false;
        }

        if (!logInfo.getJson().equals("")){
            writeBodyJson(tag, logInfo.getJson(), logType, firstLine);
            firstLine = false;
        }

        if (!logInfo.getXml().equals("")){
            writeBodyXml(tag, logInfo.getXml(), logType, firstLine);
        }

        writeFinishLog(tag, logType);
    }

    private void writeLineLog(String tag, String message, int logType){

        if (logLevel == LOG_LEVEL_NONE)
            return;

        if (logLevel == LOG_LEVEL_DEBUG){
            if (logType == TYPE_LOG_DEBUG)
                Log.d(tag,message);
            return;
        }

        switch (logType){
            case TYPE_LOG_DEBUG:
                Log.d(tag,message);
                break;
            case TYPE_LOG_WARNING:
                Log.w(tag,message);
                break;
            case TYPE_LOG_ERROR:
                Log.e(tag,message);
                break;
            case TYPE_LOG_VERBOSE:
                Log.v(tag,message);
                break;
            default:
                Log.i(tag,message);
                break;
        }
    }

    private void writeHeaderThread(String tag, int logType, boolean hideThreadHeader){
        if (!hideThreadHeader)
            return;
        writeLineLog(tag,getLineFirstSeparator(),logType);
        writeLineLog(tag,String.format(lineNormal, getThreadName()),logType);
    }

    private void writeBodyMessage(String tag, String message, int logType, boolean firstLine){

        if (firstLine)
            writeLineLog(tag,getLineFirstSeparator(),logType);
        else
            writeLineLog(tag,getLineMidSeparator(),logType);
        writeLineLog(tag,String.format(lineNormal, "Message: " + message),logType);
    }

    private void writeBodyThrowble(String tag, Throwable throwable, int stackTraceDeep, int logType, boolean firstLine){

        int maxStackTrace = MAX_STACKTRACE;
        if (throwable.getStackTrace().length < maxStackTrace)
            maxStackTrace = throwable.getStackTrace().length;

        if (stackTraceDeep != -1 && stackTraceDeep < MAX_STACKTRACE)
            maxStackTrace = stackTraceDeep;

        if (firstLine)
            writeLineLog(tag,getLineFirstSeparator(),logType);
        else
            writeLineLog(tag,getLineMidSeparator(),logType);
        writeLineLog(tag,String.format(lineNormal, "Cause: " + throwable.toString()),logType);
        writeLineLog(tag,String.format(lineNormal, "Throwable: " + throwable.getStackTrace()[0].toString()),logType);
        for (int i=1; i<maxStackTrace; i++)
            writeLineLog(tag,String.format(lineNormal, "\t\t" + throwable.getStackTrace()[i].toString()),logType);
    }

    private void writeBodyJson(String tag, String json, int logType, boolean firstLine){

        if (firstLine)
            writeLineLog(tag,getLineFirstSeparator(),logType);
        else
            writeLineLog(tag,getLineMidSeparator(),logType);
        Object jsonObject = getJsonObjFromStr(json);
        if (jsonObject != null) {
            try {
                if (jsonObject instanceof JSONObject) {
                    writeLineLog(tag, String.format(lineNormal,((JSONObject) jsonObject).toString(2).replace("\n","\n║ ")),logType);
                } else if (jsonObject instanceof JSONArray) {
                    writeLineLog(tag, String.format(lineNormal,((JSONArray) jsonObject).toString(2).replace("\n","\n║ ")),logType);
                } else {
                    writeLineLog(tag,json,logType);
                }
            } catch (JSONException e) {
                writeLineLog(tag,json,logType);
            }
        } else {
            writeLineLog(tag,json,logType);
        }
    }

    private void writeBodyXml(String tag, String xml, int logType, boolean firstLine){

        if (firstLine)
            writeLineLog(tag,getLineFirstSeparator(),logType);
        else
            writeLineLog(tag,getLineMidSeparator(),logType);
        try {
            Source xmlInput = new StreamSource(new StringReader(xml));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            writeLineLog(tag, String.format(lineNormal,xmlOutput.getWriter().toString().replaceFirst(">", ">\n").replace("\n","\n║ ")), logType);
        } catch (TransformerException e) {
            writeLineLog(tag,String.format(lineNormal, "Error parsing xml: Invalid xml"), logType);
        }
    }

    private void writeFinishLog(String tag, int logType) {
        writeLineLog(tag, getLineLastSeparator(), logType);
        writeLineLog(tag, " ", logType);
    }

    /*=======================================================*/
    /*=======================  UTILS  =======================*/
    /*=======================================================*/
    private String getThreadName(){
        return "Thread: " + Looper.myLooper().getThread().getName();
    }

    private String getLineFirstSeparator(){
        String returnLine = "╔";
        return returnLine + Utils_String.stringFromCloningChar(SEPARATOR_LINE_LENTGH,'═');
    }

    private String getLineLastSeparator(){
        String returnLine = "╚";
        return returnLine + Utils_String.stringFromCloningChar(SEPARATOR_LINE_LENTGH,'═');
    }

    private String getLineMidSeparator(){
        String returnLine = "╟";
        return returnLine + Utils_String.stringFromCloningChar(SEPARATOR_LINE_LENTGH,'─');
    }

    private static Object getJsonObjFromStr(Object test) {
        Object objectJson = null;
        try {
            objectJson = new JSONObject(test.toString());
        } catch (JSONException ex) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    objectJson = new JSONArray(test);
                }
            } catch (JSONException ex1) {
                return null;
            }
        }
        return objectJson;
    }
}
