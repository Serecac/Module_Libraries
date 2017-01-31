package com.ml.widgets.architecture;

import android.content.Context;
import android.view.ViewGroup;


import com.ml.widgets.entity.Widget;
import com.ml.widgets.general.WidgetConstants;
import com.ml.widgets.widget.background_cardcarousel.type_one.fix_three.WidgetBackgroundCardCarousel_TypeOne_FixThree;
import com.ml.widgets.widget.background_cardcarousel.type_one.one.WidgetBackgroundCardCarousel_TypeOne_One;
import com.ml.widgets.widget.background_cardcarousel.type_one.three.WidgetBackgroundCardCarousel_TypeOne_Three;
import com.ml.widgets.widget.background_cardcarousel.type_one.two.WidgetBackgroundCardCarousel_TypeOne_Two;
import com.ml.widgets.widget.banner.WidgetBanner;
import com.ml.widgets.widget.cardcarousel.type_one.fix_three.WidgetCardCarousel_TypeOne_FixThree;
import com.ml.widgets.widget.cardcarousel.type_one.one.WidgetCardCarousel_TypeOne_One;
import com.ml.widgets.widget.cardcarousel.type_one.three.WidgetCardCarousel_TypeOne_Three;
import com.ml.widgets.widget.cardcarousel.type_one.two.WidgetCardCarousel_TypeOne_Two;
import com.ml.widgets.widget.separator.WidgetSeparator;
import com.ml.widgets.widget.title.WidgetTitle;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jcaceres on 20/06/2016.
 */
public class WidgetInjector {

    private List<Widget> widgets = null;
    private Context context = null;
    private WidgetListener listener = null;
    private static WidgetInjector instance = null;

    public WidgetInjector() {

    }

    public static WidgetInjector getInstance(){
        if (instance == null)
            instance = new WidgetInjector();

        return instance;
    }

    public void prepare(List<Widget> widgets, Context context, WidgetListener listener) {
        this.widgets = widgets;
        this.context = context;
        this.listener = listener;
    }

    public List<WidgetView> inject(ViewGroup father) {

        WidgetView widget;
        List<WidgetView> widgetList = new ArrayList<>();

        if (widgets != null && context != null && father != null && widgets.size() > 0) {
            for (Widget info : widgets) {
                widget = null;
                switch (info.getType()) {
                    case WidgetConstants.WIDGET_SEPARATOR:
                        widget = new WidgetSeparator();
                        break;
                    case WidgetConstants.WIDGET_TITLE:
                        widget = new WidgetTitle();
                        break;
                    case WidgetConstants.WIDGET_CARDCAROUSEL_TYPEONE_TWO:
                        widget = new WidgetCardCarousel_TypeOne_Two();
                        break;
                    case WidgetConstants.WIDGET_CARDCAROUSEL_TYPEONE_ONE:
                        widget = new WidgetCardCarousel_TypeOne_One();
                        break;
                    case WidgetConstants.WIDGET_CARDCAROUSEL_TYPEONE_THREE:
                        widget = new WidgetCardCarousel_TypeOne_Three();
                        break;
                    case WidgetConstants.WIDGET_BANNER:
                        widget = new WidgetBanner();
                        break;
                    case WidgetConstants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TWO:
                        widget = new WidgetBackgroundCardCarousel_TypeOne_Two();
                        break;
                    case WidgetConstants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_THREE:
                        widget = new WidgetBackgroundCardCarousel_TypeOne_Three();
                        break;
                    case WidgetConstants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_ONE:
                        widget = new WidgetBackgroundCardCarousel_TypeOne_One();
                        break;
                    case WidgetConstants.WIDGET_CARDCAROUSEL_TYPEONE_FIXTHREE:
                        widget = new WidgetCardCarousel_TypeOne_FixThree();
                        break;
                    case WidgetConstants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_FIXTHREE:
                        widget = new WidgetBackgroundCardCarousel_TypeOne_FixThree();
                        break;
                }

                if (widget != null) {
                    widget.inject(context, father, listener, info);
                    widgetList.add(widget);
                }
            }
        }

        widgets = null;
        listener = null;
        return widgetList;
    }
}
