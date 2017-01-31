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
 * <p> Class BlockList_MenuSection </p>
 * Secttion item for blocklist type.
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class BlockList_MenuSection implements MenuGenericItem {

    /**
     * The constant SECTION_TYPE.
     */
    public static final int SECTION_TYPE = 0;
    private int id;
    private int label;
    private int color;
    private int pressColor;
    private int icon;
    private int pressIcon;

    /**
     * Instantiates a new Block list menu section.
     *
     * @param id         the id
     * @param label      the label
     * @param color      the color
     * @param pressColor the press color
     * @param icon       the icon
     * @param pressIcon  the press icon
     */
    public BlockList_MenuSection(int id, int label, int color, int pressColor, int icon, int pressIcon) {
        this.id = id;
        this.label = label;
        this.color = color;
        this.icon = icon;
        this.pressColor = pressColor;
        this.pressIcon = pressIcon;
    }

    @Override
    public int getType() {
        return SECTION_TYPE;
    }

    @Override
    public int getLayout() {
        return R.layout.blocklist_menusection;
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

    @Override
    public View getView(View lineView, ViewGroup parentView, LayoutInflater inflater, int actualIdSelected) {

        BlockList_MenuSection menuItem = this;
        BlockList_MenuBuilder.MenuItemHolder sectionHolder = null;

        if (lineView == null) {
            lineView = inflater.inflate(R.layout.blocklist_menusection, parentView, false);

            sectionHolder = new BlockList_MenuBuilder.MenuItemHolder();
            sectionHolder.labelView = (TextView) lineView.findViewById(R.id.menu_section_label);
            sectionHolder.layoutLine = (LinearLayout) lineView.findViewById(R.id.menu_section_layoutLine);
            sectionHolder.viewIcon = (ImageView) lineView.findViewById(R.id.menu_section_icon);

            lineView.setTag(sectionHolder);
        }

        if (sectionHolder == null) {
            sectionHolder = (BlockList_MenuBuilder.MenuItemHolder) lineView.getTag();
        }

        sectionHolder.labelView.setText(menuItem.getLabel());

        if (actualIdSelected == id) {
            if (pressIcon != -1)
                sectionHolder.viewIcon.setImageResource(pressIcon);
            sectionHolder.labelView.setTextColor(pressColor);
        } else {
            if (icon != -1)
                sectionHolder.viewIcon.setImageResource(icon);
            sectionHolder.labelView.setTextColor(color);
        }

        return lineView;
    }
}
