package com.ml.widgets.entity;

import java.util.List;

/**
 * Created by jcace on 05/10/2016.
 */

public class WidgetItem {

    List<Integer> valuesInt;
    List<String> valuesString;
    String navUrl;

    public WidgetItem() {
    }

    public WidgetItem(List<Integer> valuesInt, List<String> valuesString, String navUrl) {
        this.valuesInt = valuesInt;
        this.valuesString = valuesString;
        this.navUrl = navUrl;
    }

    public List<Integer> getValuesInt() {
        return valuesInt;
    }

    public void setValuesInt(List<Integer> valuesInt) {
        this.valuesInt = valuesInt;
    }

    public List<String> getValuesString() {
        return valuesString;
    }

    public void setValuesString(List<String> valuesString) {
        this.valuesString = valuesString;
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl;
    }
}
