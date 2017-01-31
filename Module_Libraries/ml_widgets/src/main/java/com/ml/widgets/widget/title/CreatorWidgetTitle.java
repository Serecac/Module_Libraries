package com.ml.widgets.widget.title;

import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetConstants;

import java.util.ArrayList;
import java.util.List;

import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_INT;
import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_STRING;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_TYPE_IMAGE;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_TYPE_SEPARATOR;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_TYPE_TEXT;

/**
 * Created by jcace on 06/10/2016.
 */

public class CreatorWidgetTitle {

    private static CreatorWidgetTitle instance = null;
    private Widget tempWidget = null;

    public CreatorWidgetTitle() {

    }

    public static CreatorWidgetTitle getInstance(){
        if (instance == null)
            instance = new CreatorWidgetTitle();
        return instance;
    }

    public CreatorWidgetTitle prepareWidget(String url) {

        tempWidget = new Widget();
        tempWidget.setNavUrl(url);
        tempWidget.setItems(new ArrayList<WidgetItem>());
        tempWidget.setType(WidgetConstants.WIDGET_TITLE);
        return this;
    }

    public CreatorWidgetTitle addWidgetItemText(int textsize, int color, int gravity, int style, String text, String typeface){

        if (tempWidget != null) {
            WidgetItem item = new WidgetItem();

            List<Integer> valuesInt = new ArrayList<>();
            valuesInt.add(WIDGET_TITLE_VALUE_TYPE_TEXT);
            valuesInt.add(style);
            valuesInt.add(gravity);
            valuesInt.add(textsize);
            valuesInt.add(color);

            List<String> valuesString = new ArrayList<>();
            valuesString.add(text);
            valuesString.add(typeface);

            item.setNavUrl(WIDGET_GENERAL_DEFAULT_STRING);
            item.setValuesInt(valuesInt);
            item.setValuesString(valuesString);
            tempWidget.getItems().add(item);
        }
        return this;
    }

    public CreatorWidgetTitle addWidgetItemImage(int height, int gravity, int resource, String path){

        if (tempWidget != null) {
            WidgetItem item = new WidgetItem();

            List<Integer> valuesInt = new ArrayList<>();
            valuesInt.add(WIDGET_TITLE_VALUE_TYPE_IMAGE);
            valuesInt.add(height);
            valuesInt.add(gravity);

            List<String> valuesString = new ArrayList<>();

            if (resource != WIDGET_GENERAL_DEFAULT_INT)
                valuesInt.add(resource);
            else if (!path.equals(WIDGET_GENERAL_DEFAULT_STRING))
                valuesString.add(path);

            item.setNavUrl(WIDGET_GENERAL_DEFAULT_STRING);
            item.setValuesInt(valuesInt);
            item.setValuesString(valuesString);
            tempWidget.getItems().add(item);
        }
        return this;
    }

    public CreatorWidgetTitle addWidgetItemSeparator(int gravity, int numSeparator){
        if (tempWidget != null) {
            WidgetItem item = new WidgetItem();

            List<Integer> valuesInt = new ArrayList<>();
            valuesInt.add(WIDGET_TITLE_VALUE_TYPE_SEPARATOR);
            valuesInt.add(gravity);
            valuesInt.add(numSeparator);

            List<String> valuesString = new ArrayList<>();

            item.setNavUrl(WIDGET_GENERAL_DEFAULT_STRING);
            item.setValuesInt(valuesInt);
            item.setValuesString(valuesString);
            tempWidget.getItems().add(item);
        }
        return this;
    }

    public Widget createWidget(){

        Widget returnWidget = tempWidget;
        tempWidget = null;
        return returnWidget;
    }
}
