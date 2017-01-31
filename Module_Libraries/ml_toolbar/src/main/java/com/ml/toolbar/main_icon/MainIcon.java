package com.ml.toolbar.main_icon;

import android.app.Activity;
import android.os.Bundle;

/**
 * <p> Interface MainIcon </p>
 * Interface to encapsulate MainIcon functions
 *
 * @author jcaceres
 * @version 1.0.0
 */
public interface MainIcon {

    /**
     * The constant MAIN_ACTION_MENU.
     */
    int MAIN_ACTION_MENU = 1;

    /**
     * The constant MAIN_ACTION_BACK.
     */
    int MAIN_ACTION_BACK = 2;

    /**
     * The constant MAIN_ACTION_ACCEPT.
     */
    int MAIN_ACTION_ACCEPT = 3;

    /**
     * The constant MAIN_ACTION_CANCEL.
     */
    int MAIN_ACTION_CANCEL = 4;

    /**
     * Create.
     *
     * @param activity  the activity
     * @param toolbarId the toolbar id
     */
    void create(Activity activity, final int toolbarId);

    /**
     * Load state.
     *
     * @param savedInstanceState the saved instance state
     */
    void loadState(Bundle savedInstanceState);

    /**
     * Save state.
     *
     * @param savedInstanceState the saved instance state
     */
    void saveState(Bundle savedInstanceState);

    /**
     * Sets color.
     *
     * @param isVisible the is visible
     * @param color     the color
     */
    void setColor(boolean isVisible, int color);

    /**
     * Animate state.
     *
     * @param action the action
     */
    void animateState(int action);

    /**
     * On slide.
     *
     * @param isOpen the is open
     * @param offset the offset
     */
    void onSlide(boolean isOpen, float offset);

    /**
     * Sets state.
     *
     * @param action the action
     */
    void setState(int action);
}
