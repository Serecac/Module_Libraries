package com.ml.widgets.widget.separator;

import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcace on 06/10/2016.
 */

public class CreatorWidgetSeparator {

    private static CreatorWidgetSeparator instance = null;

    public CreatorWidgetSeparator() {

    }

    public static CreatorWidgetSeparator getInstance(){
        if (instance == null)
            instance = new CreatorWidgetSeparator();

        return instance;
    }

    public Widget createWidget(int height) {

        Widget returnWidget = new Widget();

        List<Integer> valuesInt = new ArrayList<>();
        valuesInt.add(height);

        List<WidgetItem> items = new ArrayList<>();
        items.add(new WidgetItem(valuesInt,null,""));

        returnWidget.setItems(items);
        returnWidget.setType(WidgetConstants.WIDGET_SEPARATOR);
        return returnWidget;
    }

}
