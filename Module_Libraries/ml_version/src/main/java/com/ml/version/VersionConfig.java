package com.ml.version;

/**
 * <p> Class VersionConfig </p>
 * Configuratin used in VersionManager.
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see VersionManager
 */
public class VersionConfig {

    /**
     * The constant INT_DEFUALT, for control default values.
     */
    public static final int INT_DEFUALT = 0;
    /**
     * The constant STRING_DEFAULT.
     */
    public static final String STRING_DEFAULT = "";

    /**
     * The constant TYPE_NOTIFICATION.
     */
    public static final int TYPE_NOTIFICATION = 1;
    /**
     * The constant TYPE_TOAST.
     */
    public static final int TYPE_TOAST = 2;
    /**
     * The constant TYPE_DIALOG.
     */
    public static final int TYPE_DIALOG = 3;
    /**
     * The constant TYPE_FORCEDIALOG.
     */
    public static final int TYPE_FORCEDIALOG = 4;

    private int dialogMainColor;
    private int dialogSecondColor;
    private int dialogTextColor;

    private int parentHeight;
    private int parentWidth;

    private int attempToAskForUpdate;

    private String textUpdate;
    private int iconSmallUpdate;
    private int iconLargeUpdate;

    /**
     * Instantiates a new Version config.
     */
    public VersionConfig() {
        this.dialogMainColor = INT_DEFUALT;
        this.dialogSecondColor = INT_DEFUALT;
        this.dialogTextColor = INT_DEFUALT;
        this.parentHeight = INT_DEFUALT;
        this.parentWidth = INT_DEFUALT;
        this.attempToAskForUpdate = INT_DEFUALT;
        this.textUpdate = STRING_DEFAULT;
        this.iconSmallUpdate = INT_DEFUALT;
        this.iconLargeUpdate = INT_DEFUALT;
    }

    /**
     * Instantiates a new Version config.
     *
     * @param dialogMainColor      the dialog main color
     * @param dialogSecondColor    the dialog second color
     * @param dialogTextColor      the dialog text color
     * @param parentHeight         the parent height
     * @param parentWidth          the parent width
     * @param attempToAskForUpdate the attemp to ask for update
     * @param textUpdate           the text update
     * @param iconSmallUpdate      the icon update
     * @param iconLargeUpdate      the icon large update
     */
    public VersionConfig(int dialogMainColor, int dialogSecondColor, int dialogTextColor, int parentHeight, int parentWidth, int attempToAskForUpdate, String textUpdate, int iconSmallUpdate, int iconLargeUpdate) {
        this.dialogMainColor = dialogMainColor;
        this.dialogSecondColor = dialogSecondColor;
        this.dialogTextColor = dialogTextColor;
        this.parentHeight = parentHeight;
        this.parentWidth = parentWidth;
        this.attempToAskForUpdate = attempToAskForUpdate;
        this.textUpdate = textUpdate;
        this.iconSmallUpdate = iconSmallUpdate;
        this.iconLargeUpdate = iconLargeUpdate;
    }

    /**
     * Gets dialog text color.
     *
     * @return the dialog text color
     */
    public int getDialogTextColor() {
        return dialogTextColor;
    }

    /**
     * Sets dialog text color.
     *
     * @param dialogTextColor the dialog text color
     */
    public void setDialogTextColor(int dialogTextColor) {
        this.dialogTextColor = dialogTextColor;
    }

    /**
     * Gets dialog second color.
     *
     * @return the dialog second color
     */
    public int getDialogSecondColor() {
        return dialogSecondColor;
    }

    /**
     * Sets dialog second color.
     *
     * @param dialogSecondColor the dialog second color
     */
    public void setDialogSecondColor(int dialogSecondColor) {
        this.dialogSecondColor = dialogSecondColor;
    }

    /**
     * Gets dialog main color.
     *
     * @return the dialog main color
     */
    public int getDialogMainColor() {
        return dialogMainColor;
    }

    /**
     * Sets dialog main color.
     *
     * @param dialogMainColor the dialog main color
     */
    public void setDialogMainColor(int dialogMainColor) {
        this.dialogMainColor = dialogMainColor;
    }

    /**
     * Gets parent height.
     *
     * @return the parent height
     */
    public int getParentHeight() {
        return parentHeight;
    }

    /**
     * Sets parent height.
     *
     * @param parentHeight the parent height
     */
    public void setParentHeight(int parentHeight) {
        this.parentHeight = parentHeight;
    }

    /**
     * Gets parent width.
     *
     * @return the parent width
     */
    public int getParentWidth() {
        return parentWidth;
    }

    /**
     * Sets parent width.
     *
     * @param parentWidth the parent width
     */
    public void setParentWidth(int parentWidth) {
        this.parentWidth = parentWidth;
    }

    /**
     * Gets attemp to ask for update.
     *
     * @return the attemp to ask for update
     */
    public int getAttempToAskForUpdate() {
        return attempToAskForUpdate;
    }

    /**
     * Sets attemp to ask for update.
     *
     * @param attempToAskForUpdate the attemp to ask for update
     */
    public void setAttempToAskForUpdate(int attempToAskForUpdate) {
        this.attempToAskForUpdate = attempToAskForUpdate;
    }

    /**
     * Gets text update.
     *
     * @return the text update
     */
    public String getTextUpdate() {
        return textUpdate;
    }

    /**
     * Sets text update.
     *
     * @param textUpdate the text update
     */
    public void setTextUpdate(String textUpdate) {
        this.textUpdate = textUpdate;
    }

    /**
     * Gets icon update.
     *
     * @return the icon update
     */
    public int getIconSmallUpdate() {
        return iconSmallUpdate;
    }

    /**
     * Sets icon update.
     *
     * @param iconSmallUpdate the icon update
     */
    public void setIconSmallUpdate(int iconSmallUpdate) {
        this.iconSmallUpdate = iconSmallUpdate;
    }

    /**
     * Gets icon large update.
     *
     * @return the icon large update
     */
    public int getIconLargeUpdate() {
        return iconLargeUpdate;
    }

    /**
     * Sets icon large update.
     *
     * @param iconLargeUpdate the icon large update
     */
    public void setIconLargeUpdate(int iconLargeUpdate) {
        this.iconLargeUpdate = iconLargeUpdate;
    }
}
