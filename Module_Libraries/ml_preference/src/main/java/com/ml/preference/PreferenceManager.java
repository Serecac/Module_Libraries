package com.ml.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import static com.ml.preference.PreferenceGenericException.PREFERENCE_EXCEPTION_NOTCREATED;
import static com.ml.preference.PreferenceJsonParseException.PREFERENCE_EXCEPTION_JSON;

/**
 * <p> Class PreferenceManager </p>
 * Class to manage the parameters that are saved in the cell cache.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class PreferenceManager {

    private static PreferenceManager instance = null;
    private SharedPreferences preferences;

    /**
     * Instantiates a new PreferenceManager.
     *
     * @param context        the context
     * @param preferenceName the cache name
     */
    public PreferenceManager(Context context, String preferenceName) {
        this.preferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }


    /**
     * Init preference instance.
     *
     * @param context        the context
     * @param preferenceName the cache name
     */
    public static void init(Context context, String preferenceName){
        instance = new PreferenceManager(context,preferenceName);
    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws PreferenceGenericException throws when the instance was not created
     */
    public static PreferenceManager getInstance() throws PreferenceGenericException {

        if (instance == null)
            throw new PreferenceGenericException(PREFERENCE_EXCEPTION_NOTCREATED);

        return instance;
    }

    /**
     * Set string.
     *
     * @param tag  the tag
     * @param data the data
     */
    public void setString(String tag, String data){
        preferences.edit().putString(tag,data).apply();
    }

    /**
     * Set float.
     *
     * @param tag  the tag
     * @param data the data
     */
    public void setFloat(String tag, float data){
        preferences.edit().putFloat(tag,data).apply();
    }

    /**
     * Set boolean.
     *
     * @param tag  the tag
     * @param data the data
     */
    public void setBoolean(String tag, boolean data){
        preferences.edit().putBoolean(tag,data).apply();
    }

    /**
     * Set long.
     *
     * @param tag  the tag
     * @param data the data
     */
    public void setLong(String tag, long data){
        preferences.edit().putLong(tag,data).apply();
    }

    /**
     * Set int.
     *
     * @param tag  the tag
     * @param data the data
     */
    public void setInt(String tag, int data){
        preferences.edit().putInt(tag,data).apply();
    }

    /**
     * Set json.
     *
     * @param tag  the tag
     * @param data the data
     */
    public void setJSON(String tag, Object data){ Gson gson = new Gson();
        preferences.edit().putString(tag,gson.toJson(data)).apply();
    }

    /**
     * Get string preference.
     *
     * @param tag the tag
     * @return value associated with tag or default value
     */
    public String getString(String tag){
        return preferences.getString(tag,"");
    }

    /**
     * Get float preference.
     *
     * @param tag the tag
     * @return value associated with tag or default value
     */
    public float getFloat(String tag){
        return preferences.getFloat(tag,0);
    }

    /**
     * Get boolean preference.
     *
     * @param tag the tag
     * @return value associated with tag or default value
     */
    public boolean getBoolean(String tag){
        return preferences.getBoolean(tag,false);
    }

    /**
     * Get int preference.
     *
     * @param tag the tag
     * @return value associated with tag or default value
     */
    public int getInt(String tag){
        return preferences.getInt(tag,-1);
    }

    /**
     * Get long preference.
     *
     * @param tag the tag
     * @return value associated with tag or default value
     */
    public long getLong(String tag){
        return preferences.getLong(tag,0);
    }

    /**
     * Gets objetc from json preference.
     *
     * @param tag      the tag
     * @param classOfT the class type for parsing json preference
     * @return value associated with tag or default value
     * @throws PreferenceJsonParseException when object can't be parsed
     */
    public <T> T getJSON(String tag, Class<T> classOfT) throws PreferenceJsonParseException {

        if (!preferences.getString(tag, "").equals("")) {
            Gson gson = new Gson();
            try {
                return gson.fromJson(preferences.getString(tag, ""), classOfT);
            } catch (JsonSyntaxException exp){
                throw new PreferenceJsonParseException(String.format(PREFERENCE_EXCEPTION_JSON,classOfT.getName()));
            }
        }
        return null;
    }

    /**
     * Delete preference
     *
     * @param tag the preference tag that we want to remove
     */
    public void delete(String tag){
        preferences.edit().remove(tag).apply();
    }
}