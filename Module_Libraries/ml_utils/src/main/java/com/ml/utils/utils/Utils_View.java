package com.ml.utils.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * <p> Class Utils_View </p>
 * Utils about Views
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Utils_View {

    /**
     * Send view to back, z axis.
     *
     * @param child the child
     */
    public static void sendViewToBack(final View child) {
        final ViewGroup parent = (ViewGroup) child.getParent();
        if (null != parent) {
            parent.removeView(child);
            parent.addView(child, 0);
        }
    }

    /**
     * Send view to , z axis.
     *
     * @param child the child
     */
    public static void sendViewToFront(final View child) {
        final ViewGroup parent = (ViewGroup) child.getParent();
        if (null != parent) {
            parent.removeView(child);
            parent.addView(child);
        }
    }
}
