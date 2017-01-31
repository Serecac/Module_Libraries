package com.ml.utils.utils;

/**
 * <p> Class Utils_Version </p>
 * Utils about Version
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Utils_Version {

    public static int versionCodeFromVersionName(String versionString){
        return Integer.parseInt(versionString.replace(".","00"));
    }

    public static String versionStringFromVersionCode(int versionCode){
        return (versionCode + "").replace("00",".");
    }
}
