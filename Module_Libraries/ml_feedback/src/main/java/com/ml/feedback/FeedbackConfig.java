package com.ml.feedback;

/**
 * <p> Class FeedbackConfig </p>
 * Configuratin used in FeedbackManager.
 * @see FeedbackManager
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class FeedbackConfig {

    /**
     * The constant INT_DEFUALT, for control default values.
     */
    public static final int INT_DEFUALT = 0;

    private int dialogMainColor;
    private int dialogSecondColor;
    private int dialogTextColor;

    private int parentHeight;
    private int parentWidth;

    private int attemptToRate;

    /**
     * Instantiates a new Feedback config.
     */
    public FeedbackConfig() {
        this.dialogMainColor = INT_DEFUALT;
        this.dialogSecondColor = INT_DEFUALT;
        this.dialogTextColor = INT_DEFUALT;
        this.parentHeight = INT_DEFUALT;
        this.parentWidth = INT_DEFUALT;
        this.attemptToRate = INT_DEFUALT;
    }

    /**
     * Instantiates a new Feedback config.
     *
     * @param dialogMainColor   the dialog main color
     * @param dialogSecondColor the dialog second color
     * @param dialogTextColor   the dialog text color
     * @param parentHeight      the parent height
     * @param parentWidth       the parent width
     * @param attemptToRate     the attempt to rate
     */
    public FeedbackConfig(int dialogMainColor, int dialogSecondColor, int dialogTextColor, int parentHeight, int parentWidth, int attemptToRate) {
        this.dialogMainColor = dialogMainColor;
        this.dialogSecondColor = dialogSecondColor;
        this.dialogTextColor = dialogTextColor;
        this.parentHeight = parentHeight;
        this.parentWidth = parentWidth;
        this.attemptToRate = attemptToRate;
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
     * Gets attempt to rate.
     *
     * @return the attempt to rate
     */
    public int getAttemptToRate() {
        return attemptToRate;
    }

    /**
     * Sets attempt to rate.
     *
     * @param attemptToRate the attempt to rate
     */
    public void setAttemptToRate(int attemptToRate) {
        this.attemptToRate = attemptToRate;
    }
}
