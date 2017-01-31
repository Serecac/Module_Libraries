package com.ml.menu.items.block_list;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ml.menu.R;
import com.ml.menu.items.MenuBuilder;
import com.ml.menu.items.MenuGenericItem;

/**
 * <p> Class BlockList_MenuBuilder </p>
 * MenuItem builder for blocklist type items
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class BlockList_MenuBuilder implements MenuBuilder {

    /**
     * Instantiates a new Block list menu builder.
     */
    public BlockList_MenuBuilder() {
        if (mMenu != null) {
            mMenu.clear();
        }
    }

    /**
     * Add section block list menu builder.
     *
     * @param id         the id
     * @param label      the label
     * @param color      the color
     * @param pressColor the press color
     * @param icon       the icon
     * @param pressIcon  the press icon
     * @return the block list menu builder
     */
    public BlockList_MenuBuilder addSection(int id, int label, int color, int pressColor, int icon, int pressIcon) {
        mMenu.add(new BlockList_MenuSection(id, label, color, pressColor, icon, pressIcon));
        return this;
    }

    /**
     * Add item block list menu builder.
     *
     * @param id         the id
     * @param label      the label
     * @param color      the color
     * @param pressColor the press color
     * @param icon       the icon
     * @param pressIcon  the press icon
     * @return the block list menu builder
     */
    public BlockList_MenuBuilder addItem(int id, int label, int color, int pressColor, int icon, int pressIcon) {
        mMenu.add(new BlockList_MenuItem(id, label, color, pressColor, icon, pressIcon));
        return this;
    }

    @Override
    public MenuGenericItem[] build() {
        return mMenu.toArray(new MenuGenericItem[mMenu.size()]);
    }

    /**
     * <p> Class MenuItemHolder </p>
     */
    public static class MenuItemHolder {
        /**
         * The Label view.
         */
        public TextView labelView;
        /**
         * The Layout line.
         */
        public LinearLayout layoutLine;
        /**
         * The View icon.
         */
        public ImageView viewIcon;
    }
}
