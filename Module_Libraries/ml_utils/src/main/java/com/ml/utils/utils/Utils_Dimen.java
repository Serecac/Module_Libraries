package com.ml.utils.utils;

import android.content.Context;

import java.util.Arrays;

/**
 * <p> Class Utils_Dimen </p>
 * Utils about dimensions
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Utils_Dimen {

    /**
     * Get SP value from float value
     *
     * @param context the context
     * @param px      the px
     * @return the float
     */
    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }

    /**
     * Get DP value from float value
     *
     * @param context the context
     * @param px      the px
     * @return the float
     */
    public static float pixelsToDp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().densityDpi;
        return px/scaledDensity;
    }
}
