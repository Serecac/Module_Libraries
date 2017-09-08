package com.ml.version;

import android.graphics.Typeface;

public class VersionConfig {

    public static final int INT_DEFUALT = 0;
    public static final String STRING_DEFAULT = "";
    public static final int TYPE_NOTIFICATION = 1;
    public static final int TYPE_TOAST = 2;
    public static final int TYPE_DIALOG = 3;
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

    private boolean hasTypeface;
    private Typeface typeface;

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
        this.hasTypeface = false;
        this.typeface = null;
    }

    public VersionConfig(int dialogMainColor, int dialogSecondColor, int dialogTextColor, int parentHeight, int parentWidth, int attempToAskForUpdate, String textUpdate, int iconSmallUpdate, int iconLargeUpdate, boolean hasTypeface, Typeface typeface) {
        this.dialogMainColor = dialogMainColor;
        this.dialogSecondColor = dialogSecondColor;
        this.dialogTextColor = dialogTextColor;
        this.parentHeight = parentHeight;
        this.parentWidth = parentWidth;
        this.attempToAskForUpdate = attempToAskForUpdate;
        this.textUpdate = textUpdate;
        this.iconSmallUpdate = iconSmallUpdate;
        this.iconLargeUpdate = iconLargeUpdate;
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

    public int getAttempToAskForUpdate() {
        return attempToAskForUpdate;
    }

    public void setAttempToAskForUpdate(int attempToAskForUpdate) {
        this.attempToAskForUpdate = attempToAskForUpdate;
    }

    public String getTextUpdate() {
        return textUpdate;
    }

    public void setTextUpdate(String textUpdate) {
        this.textUpdate = textUpdate;
    }

    public int getIconSmallUpdate() {
        return iconSmallUpdate;
    }

    public void setIconSmallUpdate(int iconSmallUpdate) {
        this.iconSmallUpdate = iconSmallUpdate;
    }

    public int getIconLargeUpdate() {
        return iconLargeUpdate;
    }

    public void setIconLargeUpdate(int iconLargeUpdate) {
        this.iconLargeUpdate = iconLargeUpdate;
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
