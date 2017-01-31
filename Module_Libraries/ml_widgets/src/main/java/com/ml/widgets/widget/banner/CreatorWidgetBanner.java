package com.ml.widgets.widget.banner;


import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetConstants;

import java.util.ArrayList;
import java.util.List;

import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_INT;
import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_STRING;

/**
 * Created by jcace on 06/10/2016.
 */

public class CreatorWidgetBanner {

    private static CreatorWidgetBanner instance = null;

    public CreatorWidgetBanner() {

    }

    public static CreatorWidgetBanner getInstance(){
        if (instance == null)
            instance = new CreatorWidgetBanner();

        return instance;
    }

    public Widget createWidget(int height, int margin, int image, String path, String url) {

        Widget returnWidget = new Widget();

        List<Integer> valuesInt = new ArrayList<>();
        valuesInt.add(height);
        valuesInt.add(margin);

        List<String> valuesString = new ArrayList<>();

        if (image != WIDGET_GENERAL_DEFAULT_INT)
            valuesInt.add(image);
        else if (!path.equals(WIDGET_GENERAL_DEFAULT_STRING))
            valuesString.add(path);

        List<WidgetItem> items = new ArrayList<>();
        items.add(new WidgetItem(valuesInt,valuesString,""));

        returnWidget.setNavUrl(url);
        returnWidget.setItems(items);
        returnWidget.setType(WidgetConstants.WIDGET_BANNER);
        return returnWidget;
    }

}
