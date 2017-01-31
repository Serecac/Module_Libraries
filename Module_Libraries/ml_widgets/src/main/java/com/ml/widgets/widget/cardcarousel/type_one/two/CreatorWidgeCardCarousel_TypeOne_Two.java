package com.ml.widgets.widget.cardcarousel.type_one.two;

import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;

import java.util.ArrayList;
import java.util.List;

import static com.ml.widgets.general.WidgetConstants.WIDGET_CARDCAROUSEL_TYPEONE_TWO;
import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_INT;
import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_STRING;

/**
 * Created by jcace on 06/10/2016.
 */

public class CreatorWidgeCardCarousel_TypeOne_Two {

    private static CreatorWidgeCardCarousel_TypeOne_Two instance = null;
    private Widget tempWidget = null;

    public CreatorWidgeCardCarousel_TypeOne_Two() {

    }

    public static CreatorWidgeCardCarousel_TypeOne_Two getInstance(){
        if (instance == null)
            instance = new CreatorWidgeCardCarousel_TypeOne_Two();
        return instance;
    }

    public CreatorWidgeCardCarousel_TypeOne_Two prepareWidget(String url) {

        tempWidget = new Widget();
        tempWidget.setNavUrl(url);
        tempWidget.setItems(new ArrayList<WidgetItem>());
        tempWidget.setType(WIDGET_CARDCAROUSEL_TYPEONE_TWO);
        return this;
    }

    public CreatorWidgeCardCarousel_TypeOne_Two addWidgetItemResource(int image, String title, String subtitle, String price, String lastPrice,  String path, String url){

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

    public Widget createWidget(){

        Widget returnWidget = tempWidget;
        tempWidget = null;
        return returnWidget;
    }
}
