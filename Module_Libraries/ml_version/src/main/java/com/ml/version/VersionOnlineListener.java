package com.ml.version;

/**
 * <p> Inteface VersionOnlineListener </p>
 * Notify when online version values are ready to use
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public interface VersionOnlineListener {

    /**
     * On online version ready.
     *
     * @param versionName the version name
     * @param versionCode the version code
     */
    void onOnlineVersionReady(String versionName, int versionCode);
}
