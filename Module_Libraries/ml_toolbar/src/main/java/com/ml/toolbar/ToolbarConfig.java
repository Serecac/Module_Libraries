package com.ml.toolbar;

public class ToolbarConfig {

    private int toolbarId = -1;
    private int toolbatTitleId = -1;
    private int toolbarFirsButtonId = -1;
    private int toolbarSecondButtonId = -1;
    private boolean isAnimated = false;
    private boolean hasMainIcon = true;

    public ToolbarConfig() {
    }

    public ToolbarConfig(int toolbarLayout, int toolbatTitleId, int toolbarFirsButtonId, int toolbarSecondButtonId, boolean isAnimated, boolean hasMainIcon) {
        this.toolbarId = toolbarLayout;
        this.toolbatTitleId = toolbatTitleId;
        this.toolbarFirsButtonId = toolbarFirsButtonId;
        this.toolbarSecondButtonId = toolbarSecondButtonId;
        this.isAnimated = isAnimated;
        this.hasMainIcon = hasMainIcon;
    }

    public int getToolbarId() {
        return toolbarId;
    }

    public void setToolbarId(int toolbarId) {
        this.toolbarId = toolbarId;
    }

    public int getToolbatTitleId() {
        return toolbatTitleId;
    }

    public void setToolbatTitleId(int toolbatTitleId) {
        this.toolbatTitleId = toolbatTitleId;
    }

    public int getToolbarFirsButtonId() {
        return toolbarFirsButtonId;
    }

    public void setToolbarFirsButtonId(int toolbarFirsButtonId) {
        this.toolbarFirsButtonId = toolbarFirsButtonId;
    }

    public int getToolbarSecondButtonId() {
        return toolbarSecondButtonId;
    }

    public void setToolbarSecondButtonId(int toolbarSecondButtonId) {
        this.toolbarSecondButtonId = toolbarSecondButtonId;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public boolean hasMainIcon() {
        return hasMainIcon;
    }

    public void setHasMainIcon(boolean hasMainIcon) {
        this.hasMainIcon = hasMainIcon;
    }
}
