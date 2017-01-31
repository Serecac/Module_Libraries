package com.ml.toolbar;

/**
 * <p> Class ToolbarConfig </p>
 * Stores all information about toolbar views
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class ToolbarConfig {

    private int toolbarId = -1;
    private int toolbatTitleId = -1;
    private int toolbarFirsButtonId = -1;
    private int toolbarSecondButtonId = -1;
    private boolean isAnimated = false;

    /**
     * Instantiates a new ToolbarConfig.
     */
    public ToolbarConfig() {
    }

    /**
     * Instantiates a new ToolbarConfig.
     *
     * @param toolbarLayout         the toolbar layout
     * @param toolbatTitleId        the toolbat title id
     * @param toolbarFirsButtonId   the toolbar firs button id
     * @param toolbarSecondButtonId the toolbar second button id
     * @param isAnimated            the is animated
     */
    public ToolbarConfig(int toolbarLayout, int toolbatTitleId, int toolbarFirsButtonId, int toolbarSecondButtonId, boolean isAnimated) {
        this.toolbarId = toolbarLayout;
        this.toolbatTitleId = toolbatTitleId;
        this.toolbarFirsButtonId = toolbarFirsButtonId;
        this.toolbarSecondButtonId = toolbarSecondButtonId;
        this.isAnimated = isAnimated;
    }

    /**
     * Gets toolbar layout.
     *
     * @return the toolbar layout
     */
    public int getToolbarId() {
        return toolbarId;
    }

    /**
     * Sets toolbar layout.
     *
     * @param toolbarId the toolbar layout
     */
    public void setToolbarId(int toolbarId) {
        this.toolbarId = toolbarId;
    }

    /**
     * Gets toolbat title id.
     *
     * @return the toolbat title id
     */
    public int getToolbatTitleId() {
        return toolbatTitleId;
    }

    /**
     * Sets toolbat title id.
     *
     * @param toolbatTitleId the toolbat title id
     */
    public void setToolbatTitleId(int toolbatTitleId) {
        this.toolbatTitleId = toolbatTitleId;
    }

    /**
     * Gets toolbar firs button id.
     *
     * @return the toolbar firs button id
     */
    public int getToolbarFirsButtonId() {
        return toolbarFirsButtonId;
    }

    /**
     * Sets toolbar firs button id.
     *
     * @param toolbarFirsButtonId the toolbar firs button id
     */
    public void setToolbarFirsButtonId(int toolbarFirsButtonId) {
        this.toolbarFirsButtonId = toolbarFirsButtonId;
    }

    /**
     * Gets toolbar second button id.
     *
     * @return the toolbar second button id
     */
    public int getToolbarSecondButtonId() {
        return toolbarSecondButtonId;
    }

    /**
     * Sets toolbar second button id.
     *
     * @param toolbarSecondButtonId the toolbar second button id
     */
    public void setToolbarSecondButtonId(int toolbarSecondButtonId) {
        this.toolbarSecondButtonId = toolbarSecondButtonId;
    }

    /**
     * Is animated boolean.
     *
     * @return the boolean
     */
    public boolean isAnimated() {
        return isAnimated;
    }

    /**
     * Sets animated.
     *
     * @param animated the animated
     */
    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }
}
