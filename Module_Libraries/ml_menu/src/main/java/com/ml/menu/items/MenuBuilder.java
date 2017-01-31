package com.ml.menu.items;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Interface MenuBuilder </p>
 * Used to generalize builders
 *
 * @author jcaceres
 * @version 1.0.0
 */
public interface MenuBuilder {

    /**
     * The constant mMenu, used as temp array.
     */
    List<MenuGenericItem> mMenu = new ArrayList<>();

    /**
     * Build MenuGenericItem array.
     *
     * @return the MenuGenericItem array
     */
    MenuGenericItem[] build();
}
