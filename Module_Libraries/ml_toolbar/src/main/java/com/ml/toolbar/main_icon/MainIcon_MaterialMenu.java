package com.ml.toolbar.main_icon;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.extras.toolbar.MaterialMenuIconToolbar;

/**
 * <p> Class MainIcon_MaterialMenu </p>
 * Implements MainIcon with external library
 * @see MainIcon
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class MainIcon_MaterialMenu implements MainIcon {

    private MaterialMenuIconToolbar materialMenu;

    /**
     * Create.
     *
     * @param activity  the activity
     * @param toolbarId the toolbar id
     */
    @Override
    public void create(Activity activity, final int toolbarId) {

        materialMenu = new MaterialMenuIconToolbar(activity, Color.WHITE, MaterialMenuDrawable.Stroke.THIN) {
            @Override
            public int getToolbarViewId() {
                return toolbarId;
            }
        };
    }

    /**
     * Load state.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    public void loadState(Bundle savedInstanceState) {
        if (materialMenu != null) {
            materialMenu.syncState(savedInstanceState);
        }
    }

    /**
     * Save state.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    public void saveState(Bundle savedInstanceState) {
        if (materialMenu != null) {
            materialMenu.onSaveInstanceState(savedInstanceState);
        }
    }

    /**
     * Sets color.
     *
     * @param isVisible the is visible
     * @param color     the color
     */
    @Override
    public void setColor(boolean isVisible, int color) {

        if (materialMenu != null) {
            if (!isVisible) {
                materialMenu.setColor(Color.TRANSPARENT);
            } else {
                materialMenu.setColor(color);
            }
        }
    }

    /**
     * Animate state.
     *
     * @param action the action
     */
    @Override
    public void animateState(int action) {

        if (materialMenu != null) {
            MaterialMenuDrawable.IconState newState = null;
            switch (action) {
                case MainIcon.MAIN_ACTION_MENU:
                    newState = MaterialMenuDrawable.IconState.BURGER;
                    break;
                case MainIcon.MAIN_ACTION_ACCEPT:
                    newState = MaterialMenuDrawable.IconState.CHECK;
                    break;
                case MainIcon.MAIN_ACTION_BACK:
                    newState = MaterialMenuDrawable.IconState.ARROW;
                    break;
                case MainIcon.MAIN_ACTION_CANCEL:
                    newState = MaterialMenuDrawable.IconState.X;
                    break;
            }

            if (newState != null) {
                materialMenu.animateState(newState);
            }
        }
    }

    /**
     * On slide.
     *
     * @param isOpen the is open
     * @param offset the offset
     */
    @Override
    public void onSlide(boolean isOpen, float offset) {

        if (materialMenu != null) {
            materialMenu.setTransformationOffset(
                    MaterialMenuDrawable.AnimationState.BURGER_ARROW,
                    isOpen ? 2 - offset : offset
            );
        }
    }

    /**
     * Sets state.
     *
     * @param action the action
     */
    @Override
    public void setState(int action) {

        if (materialMenu != null) {
            MaterialMenuDrawable.IconState newState = null;
            switch (action) {
                case MainIcon.MAIN_ACTION_MENU:
                    newState = MaterialMenuDrawable.IconState.BURGER;
                    break;
                case MainIcon.MAIN_ACTION_ACCEPT:
                    newState = MaterialMenuDrawable.IconState.CHECK;
                    break;
                case MainIcon.MAIN_ACTION_BACK:
                    newState = MaterialMenuDrawable.IconState.ARROW;
                    break;
                case MainIcon.MAIN_ACTION_CANCEL:
                    newState = MaterialMenuDrawable.IconState.X;
                    break;
            }

            if (newState != null) {
                materialMenu.setState(newState);
            }
        }
    }
}
