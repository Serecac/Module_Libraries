package com.ml.menu;

/**
 * <p> Interface MenuListener </p>
 * Interface for setting listener for menu events
 *
 * @author jcaceres
 * @version 1.0.0
 */
public interface MenuListener {

    /**
     * On menu item click.
     *
     * @param itemId the item id
     */
    void onMenuItemClick(int itemId);

    void onMenuSlide(boolean isMenuOpened, float slideOffset);

    void onStateChanged(boolean isMenuOpened);
}
