package com.ml.toolbar;

/**
 * <p> Class ToolbarInfo </p>
 * Stores all information about toolbar style
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class ToolbarInfo {

    private int imageSecondIcon;
    private boolean isSecondIcon;
    private int imageFirstIcon;
    private boolean isFirstIcon;
    private boolean isMainIcon;
    private int actionMainIcon;
    private int colorMainIcon;
    private String title;

    /**
     * Instantiates a new ToolbarInfo.
     *
     * @param imageSecondIcon the image second icon
     * @param isSecondIcon    the is second icon
     * @param imageFirstIcon  the image first icon
     * @param isFirstIcon     the is first icon
     * @param isMainIcon      the is main icon
     * @param actionMainIcon  the action main icon
     * @param colorMainIcon   the color main icon
     * @param title           the title
     */
    public ToolbarInfo(int imageSecondIcon, boolean isSecondIcon, int imageFirstIcon, boolean isFirstIcon, boolean isMainIcon, int actionMainIcon, int colorMainIcon, String title) {
        this.imageSecondIcon = imageSecondIcon;
        this.isSecondIcon = isSecondIcon;
        this.imageFirstIcon = imageFirstIcon;
        this.isFirstIcon = isFirstIcon;
        this.isMainIcon = isMainIcon;
        this.actionMainIcon = actionMainIcon;
        this.colorMainIcon = colorMainIcon;
        this.title = title;
    }

    /**
     * Gets image second icon.
     *
     * @return the image second icon
     */
    public int getImageSecondIcon() {
        return imageSecondIcon;
    }

    /**
     * Sets image second icon.
     *
     * @param imageSecondIcon the image second icon
     */
    public void setImageSecondIcon(int imageSecondIcon) {
        this.imageSecondIcon = imageSecondIcon;
    }

    /**
     * Is second icon boolean.
     *
     * @return the boolean
     */
    public boolean isSecondIcon() {
        return isSecondIcon;
    }

    /**
     * Sets second icon.
     *
     * @param secondIcon the second icon
     */
    public void setSecondIcon(boolean secondIcon) {
        isSecondIcon = secondIcon;
    }

    /**
     * Gets image first icon.
     *
     * @return the image first icon
     */
    public int getImageFirstIcon() {
        return imageFirstIcon;
    }

    /**
     * Sets image first icon.
     *
     * @param imageFirstIcon the image first icon
     */
    public void setImageFirstIcon(int imageFirstIcon) {
        this.imageFirstIcon = imageFirstIcon;
    }

    /**
     * Is first icon boolean.
     *
     * @return the boolean
     */
    public boolean isFirstIcon() {
        return isFirstIcon;
    }

    /**
     * Sets first icon.
     *
     * @param firstIcon the first icon
     */
    public void setFirstIcon(boolean firstIcon) {
        isFirstIcon = firstIcon;
    }

    /**
     * Is main icon boolean.
     *
     * @return the boolean
     */
    public boolean isMainIcon() {
        return isMainIcon;
    }

    /**
     * Sets main icon.
     *
     * @param mainIcon the main icon
     */
    public void setMainIcon(boolean mainIcon) {
        isMainIcon = mainIcon;
    }

    /**
     * Gets action main icon.
     *
     * @return the action main icon
     */
    public int getActionMainIcon() {
        return actionMainIcon;
    }

    /**
     * Sets action main icon.
     *
     * @param actionMainIcon the action main icon
     */
    public void setActionMainIcon(int actionMainIcon) {
        this.actionMainIcon = actionMainIcon;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets color main icon.
     *
     * @return the color main icon
     */
    public int getColorMainIcon() {
        return colorMainIcon;
    }

    /**
     * Sets color main icon.
     *
     * @param colorMainIcon the color main icon
     */
    public void setColorMainIcon(int colorMainIcon) {
        this.colorMainIcon = colorMainIcon;
    }
}
