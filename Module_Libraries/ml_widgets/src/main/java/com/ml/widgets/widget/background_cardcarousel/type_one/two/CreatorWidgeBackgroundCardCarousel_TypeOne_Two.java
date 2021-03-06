package com.ml.widgets.widget.background_cardcarousel.type_one.two;

import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetUtils;

import java.util.ArrayList;
import java.util.List;

import static com.ml.widgets.general.WidgetConstants.*;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.*;

/**
 * Created by jcace on 06/10/2016.
 */

public class CreatorWidgeBackgroundCardCarousel_TypeOne_Two {

    private static CreatorWidgeBackgroundCardCarousel_TypeOne_Two instance = null;
    private Widget tempWidget = null;

    private int numItemsTitle = 0;

    public CreatorWidgeBackgroundCardCarousel_TypeOne_Two() {

    }

    public static CreatorWidgeBackgroundCardCarousel_TypeOne_Two getInstance(){
        if (instance == null)
            instance = new CreatorWidgeBackgroundCardCarousel_TypeOne_Two();
        return instance;
    }

    public CreatorWidgeBackgroundCardCarousel_TypeOne_Two prepareWidget(String url) {

        tempWidget = new Widget();
        tempWidget.setNavUrl(url);
        tempWidget.setItems(new ArrayList<WidgetItem>());
        tempWidget.setType(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TWO);
        numItemsTitle = 0;
        return this;
    }

    public CreatorWidgeBackgroundCardCarousel_TypeOne_Two addWidgetItemCard(int image, String title, String subtitle, String price, String lastPrice, String path, String url){

        if (tempWidget != null) {
            WidgetItem item = new WidgetItem();

            List<Integer> valuesInt = new ArrayList<>();
            
            List<String> valuesString = new ArrayList<>();
            valuesString.add(title);
            valuesString.add(subtitle);
            valuesString.add(price);
            valuesString.add(lastPrice);

            if (image != WIDGET_GENERAL_DEFAULT_INT)
                valuesInt.add(image);
            else if (!path.equals(WIDGET_GENERAL_DEFAULT_STRING))
                valuesString.add(path);

            item.setNavUrl(url);
            item.setValuesInt(valuesInt);
            item.setValuesString(valuesString);
            tempWidget.getItems().add(item);
        }
        return this;
    }

    public CreatorWidgeBackgroundCardCarousel_TypeOne_Two addWidgetItemText(int textsize, int color, int gravity, int style, String text, String typeface){

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
            numItemsTitle++;
        }
        return this;
    }

    public CreatorWidgeBackgroundCardCarousel_TypeOne_Two addWidgetItemImage(int height, int gravity, int resource, String path){

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
            numItemsTitle++;
        }
        return this;
    }

    public CreatorWidgeBackgroundCardCarousel_TypeOne_Two addWidgetItemSeparator(int gravity, int numSeparator){

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
            numItemsTitle++;
        }
        return this;
    }

    public CreatorWidgeBackgroundCardCarousel_TypeOne_Two addWidgetItemConfig(int resource, String path, boolean isOffset){

        if (tempWidget != null) {
            WidgetItem item = new WidgetItem();

            List<Integer> valuesInt = new ArrayList<>();
            List<String> valuesString = new ArrayList<>();

            valuesInt.add(numItemsTitle);
            valuesInt.add(WidgetUtils.getIntFromBoolean(isOffset));

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

    public Widget createWidget(){

        Widget returnWidget = tempWidget;
        tempWidget = null;
        return returnWidget;
    }
}
