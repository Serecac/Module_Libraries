package com.ml.menu.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * <p> Class MenuAdapter </p>
 * Simple adapter that calls items to print their views
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class MenuAdapter extends ArrayAdapter<MenuGenericItem> {

    private LayoutInflater inflater;
    private final int NUM_TYPE = 2;
    private MenuGenericItem[] list = null;
    private int actualSelectedState = -1;

    /**
     * Instantiates a new MenuAdapter.
     *
     * @param context             the context
     * @param textViewResourceId  the text view resource id
     * @param list                the list
     * @param actualSelectedState the actual selected state
     */
    public MenuAdapter(Context context, int textViewResourceId, MenuGenericItem[] list, int actualSelectedState) {
        super(context, textViewResourceId, list);
        inflater = LayoutInflater.from(context);
        this.list = list;
        this.actualSelectedState = actualSelectedState;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.length;
        } else {
            return 0;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(convertView, parent, inflater, actualSelectedState);
    }

    @Override
    public int getViewTypeCount() {
        return NUM_TYPE;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    /**
     * Update selected item.
     *
     * @param actualSelectedState the actual selected state
     */
    public void updateSelectedItem(int actualSelectedState){
        this.actualSelectedState = actualSelectedState;
    }
}
