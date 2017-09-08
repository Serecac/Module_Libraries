package com.ml.feedback;

import android.graphics.Typeface;

public class FeedbackConfig {

    public static final int INT_DEFAULT = 0;

    private int dialogMainColor;
    private int dialogSecondColor;
    private int dialogTextColor;

    private int parentHeight;
    private int parentWidth;

    private int attemptToRate;

    private boolean hasTypeface;
    private Typeface typeface;

    public FeedbackConfig() {
        this.dialogMainColor = INT_DEFAULT;
        this.dialogSecondColor = INT_DEFAULT;
        this.dialogTextColor = INT_DEFAULT;
        this.parentHeight = INT_DEFAULT;
        this.parentWidth = INT_DEFAULT;
        this.attemptToRate = INT_DEFAULT;
        this.hasTypeface = false;
        this.typeface = null;
    }

    public FeedbackConfig(int dialogMainColor, int dialogSecondColor, int dialogTextColor, int parentHeight, int parentWidth, int attemptToRate, boolean hasTypeface, Typeface typeface) {
        this.dialogMainColor = dialogMainColor;
        this.dialogSecondColor = dialogSecondColor;
        this.dialogTextColor = dialogTextColor;
        this.parentHeight = parentHeight;
        this.parentWidth = parentWidth;
        this.attemptToRate = attemptToRate;
        this.hasTypeface = hasTypeface;
        this.typeface = typeface;
    }

    public int getDialogTextColor() {
        return dialogTextColor;
    }

    public void setDialogTextColor(int dialogTextColor) {
        this.dialogTextColor = dialogTextColor;
    }

    public int getDialogSecondColor() {
        return dialogSecondColor;
    }

    public void setDialogSecondColor(int dialogSecondColor) {
        this.dialogSecondColor = dialogSecondColor;
    }

    public int getDialogMainColor() {
        return dialogMainColor;
    }

    public void setDialogMainColor(int dialogMainColor) {
        this.dialogMainColor = dialogMainColor;
    }

    public int getParentHeight() {
        return parentHeight;
    }

    public void setParentHeight(int parentHeight) {
        this.parentHeight = parentHeight;
    }

    public int getParentWidth() {
        return parentWidth;
    }

    public void setParentWidth(int parentWidth) {
        this.parentWidth = parentWidth;
    }

    public int getAttemptToRate() {
        return attemptToRate;
    }

    public void setAttemptToRate(int attemptToRate) {
        this.attemptToRate = attemptToRate;
    }

    public boolean isHasTypeface() {
        return hasTypeface;
    }

    public void setHasTypeface(boolean hasTypeface) {
        this.hasTypeface = hasTypeface;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }
}
