package com.ml.menu.items;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p> Interface MenuGenericItem </p>
 * Used to generalize menu items
 *
 * @author jcaceres
 * @version 1.0.0
 */
public interface MenuGenericItem {

    /**
     * Gets id.
     *
     * @return the id
     */
    int getId();

    /**
     * Gets label.
     *
     * @return the label
     */
    int getLabel();

    /**
     * Gets view.
     *
     * @param lineView         the line view
     * @param parentView       the parent view
     * @param inflater         the inflater
     * @param actualIdSelected the actual id selected
     * @return the view
     */
    View getView(View lineView, ViewGroup parentView, LayoutInflater inflater, int actualIdSelected);

    /**
     * Gets type.
     *
     * @return the type
     */
    int getType();

    /**
     * Gets layout.
     *
     * @return the layout
     */
    int getLayout();

    /**
     * Gets color.
     *
     * @return the color
     */
    int getColor();

    /**
     * Gets press color.
     *
     * @return the press color
     */
    int getPressColor();

    /**
     * Gets icon.
     *
     * @return the icon
     */
    int getIcon();

    /**
     * Gets press icon.
     *
     * @return the press icon
     */
    int getPressIcon();
}
