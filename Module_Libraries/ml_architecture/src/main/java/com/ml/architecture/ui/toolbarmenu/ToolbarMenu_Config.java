package com.ml.architecture.ui.toolbarmenu;

import com.ml.menu.MenuConfig;
import com.ml.toolbar.ToolbarConfig;

/**
 * <p> Class ToolbarMenu_Config </p>
 * Configuration for ToolbarMenu_Activity
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class ToolbarMenu_Config {

    private int activityLayout = -1;
    private MenuConfig menuConfig = null;
    private ToolbarConfig toolbarConfig = null;
    private int fragmentLayoutId = -1;
    private String fragmentTag = "";
    private int firstFragmentId = -1;
    private boolean wantMenu = false;
    private boolean wantToolbar = false;

    /**
     * Instantiates a new ToolbarMenu_Config.
     */
    public ToolbarMenu_Config() {
    }

    /**
     * Instantiates a new ToolbarMenu_Config.
     *
     * @param activityLayout   the activity layout
     * @param menuConfig       the menu config
     * @param toolbarConfig    the toolbar config
     * @param fragmentLayoutId the fragment layout id
     * @param fragmentTag      the fragment tag
     * @param firstFragmentId  the first fragment id
     * @param wantMenu         the want menu
     * @param wantToolbar      the want toolbar
     */
    public ToolbarMenu_Config(int activityLayout, MenuConfig menuConfig, ToolbarConfig toolbarConfig, int fragmentLayoutId, String fragmentTag, int firstFragmentId, boolean wantMenu, boolean wantToolbar) {
        this.activityLayout = activityLayout;
        this.menuConfig = menuConfig;
        this.toolbarConfig = toolbarConfig;
        this.fragmentLayoutId = fragmentLayoutId;
        this.fragmentTag = fragmentTag;
        this.firstFragmentId = firstFragmentId;
        this.wantMenu = wantMenu;
        this.wantToolbar = wantToolbar;
    }

    /**
     * Gets activity layout.
     *
     * @return the activity layout
     */
    public int getActivityLayout() {
        return activityLayout;
    }

    /**
     * Sets activity layout.
     *
     * @param activityLayout the activity layout
     */
    public void setActivityLayout(int activityLayout) {
        this.activityLayout = activityLayout;
    }

    /**
     * Gets menu config.
     *
     * @return the menu config
     */
    public MenuConfig getMenuConfig() {
        return menuConfig;
    }

    /**
     * Sets menu config.
     *
     * @param menuConfig the menu config
     */
    public void setMenuConfig(MenuConfig menuConfig) {
        this.menuConfig = menuConfig;
    }

    /**
     * Gets toolbar config.
     *
     * @return the toolbar config
     */
    public ToolbarConfig getToolbarConfig() {
        return toolbarConfig;
    }

    /**
     * Sets toolbar config.
     *
     * @param toolbarConfig the toolbar config
     */
    public void setToolbarConfig(ToolbarConfig toolbarConfig) {
        this.toolbarConfig = toolbarConfig;
    }

    /**
     * Gets fragment layout id.
     *
     * @return the fragment layout id
     */
    public int getFragmentLayoutId() {
        return fragmentLayoutId;
    }

    /**
     * Sets fragment layout id.
     *
     * @param fragmentLayoutId the fragment layout id
     */
    public void setFragmentLayoutId(int fragmentLayoutId) {
        this.fragmentLayoutId = fragmentLayoutId;
    }

    /**
     * Gets fragment tag.
     *
     * @return the fragment tag
     */
    public String getFragmentTag() {
        return fragmentTag;
    }

    /**
     * Sets fragment tag.
     *
     * @param fragmentTag the fragment tag
     */
    public void setFragmentTag(String fragmentTag) {
        this.fragmentTag = fragmentTag;
    }

    /**
     * Gets first fragment id.
     *
     * @return the first fragment id
     */
    public int getFirstFragmentId() {
        return firstFragmentId;
    }

    /**
     * Sets first fragment id.
     *
     * @param firstFragmentId the first fragment id
     */
    public void setFirstFragmentId(int firstFragmentId) {
        this.firstFragmentId = firstFragmentId;
    }

    /**
     * Is want menu boolean.
     *
     * @return the boolean
     */
    public boolean isWantMenu() {
        return wantMenu;
    }

    /**
     * Sets want menu.
     *
     * @param wantMenu the want menu
     */
    public void setWantMenu(boolean wantMenu) {
        this.wantMenu = wantMenu;
    }

    /**
     * Is want toolbar boolean.
     *
     * @return the boolean
     */
    public boolean isWantToolbar() {
        return wantToolbar;
    }

    /**
     * Sets want toolbar.
     *
     * @param wantToolbar the want toolbar
     */
    public void setWantToolbar(boolean wantToolbar) {
        this.wantToolbar = wantToolbar;
    }
}
