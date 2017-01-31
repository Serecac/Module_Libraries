package com.ml.menu.items.block_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ml.menu.R;
import com.ml.menu.items.MenuGenericItem;

/**
 * <p> Class BlockList_MenuItem </p>
 * Normal item for blocklist type.
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class BlockList_MenuItem implements MenuGenericItem {

    /**
     * The constant ITEM_TYPE.
     */
    public static final int ITEM_TYPE = 1;

    private int id;
    private int label;
    private int color;
    private int pressColor;
    private int icon;
    private int pressIcon;

    /**
     * Instantiates a new BlockList_MenuItem.
     *
     * @param id         the id
     * @param label      the label
     * @param color      the color
     * @param pressColor the press color
     * @param icon       the icon
     * @param pressIcon  the press icon
     */
    public BlockList_MenuItem(int id, int label, int color, int pressColor, int icon, int pressIcon) {
        this.id = id;
        this.label = label;
        this.color = color;
        this.icon = icon;
        this.pressColor = pressColor;
        this.pressIcon = pressIcon;
    }

    @Override
    public int getType() {
        return ITEM_TYPE;
    }

    @Override
    public int getLayout() {
        return R.layout.blocklist_menuitem;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets label.
     *
     * @param label the label
     */
    public void setLabel(int label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(int color) {
        this.color = color;
    }

    public int getPressColor() {
        return pressColor;
    }

    /**
     * Sets press color.
     *
     * @param pressColor the press color
     */
    public void setPressColor(int pressColor) {
        this.pressColor = pressColor;
    }

    public int getIcon() {
        return icon;
    }

    /**
     * Sets icon.
     *
     * @param icon the icon
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getPressIcon() {
        return pressIcon;
    }

    /**
     * Sets press icon.
     *
     * @param pressIcon the press icon
     */
    public void setPressIcon(int pressIcon) {
        this.pressIcon = pressIcon;
    }

    @Override
    public int getLabel() {
        return label;
    }

    /**
     * Gets view.
     *
     * @param lineView   the line view
     * @param parentView the parent view
     * @param inflater   the inflater
     * @return the view
     */
    @Override
    public View getView(View lineView, ViewGroup parentView, LayoutInflater inflater, int actualIdSelected) {

        BlockList_MenuItem menuItem = this;
        BlockList_MenuBuilder.MenuItemHolder itemHolder = null;

        if (lineView == null) {

            lineView = inflater.inflate(R.layout.blocklist_menuitem, parentView, false);

            itemHolder = new BlockList_MenuBuilder.MenuItemHolder();
            itemHolder.labelView = (TextView) lineView.findViewById(R.id.menu_item_label);
            itemHolder.layoutLine = (LinearLayout) lineView.findViewById(R.id.menu_item_layoutLine);
            itemHolder.viewIcon = (ImageView) lineView.findViewById(R.id.menu_item_icon);

            lineView.setTag(itemHolder);
        }

        if (itemHolder == null) {
            itemHolder = (BlockList_MenuBuilder.MenuItemHolder) lineView.getTag();
        }

        itemHolder.labelView.setText(menuItem.getLabel());

        if (actualIdSelected == id) {
            itemHolder = (BlockList_MenuBuilder.MenuItemHolder) lineView.getTag();
            if (pressIcon != -1)
                itemHolder.viewIcon.setImageResource(pressIcon);
            itemHolder.labelView.setTextColor(pressColor);
        } else {
            if (icon != -1)
                itemHolder.viewIcon.setImageResource(icon);
            itemHolder.labelView.setTextColor(color);
        }

        return lineView;
    }
}
