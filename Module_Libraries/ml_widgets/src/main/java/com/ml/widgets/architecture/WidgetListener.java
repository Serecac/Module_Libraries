package com.ml.widgets.architecture;


import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;

/**
 * Created by jcaceres on 20/06/2016.
 */
public interface WidgetListener {

    void onClickWidget(Widget widget);

    void onClickWidgetItem(WidgetItem widgetItem);
}
