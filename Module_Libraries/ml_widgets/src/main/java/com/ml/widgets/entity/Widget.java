package com.ml.widgets.entity;

import java.util.List;

/**
 * Created by jcace on 05/10/2016.
 */

public class Widget {

    int type;
    List<WidgetItem> items;
    String navUrl;

    public Widget() {
    }

    public Widget(int type, List<WidgetItem> items, String url) {
        this.type = type;
        this.items = items;
        this.navUrl = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<WidgetItem> getItems() {
        return items;
    }

    public void setItems(List<WidgetItem> items) {
        this.items = items;
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl;
    }
}
