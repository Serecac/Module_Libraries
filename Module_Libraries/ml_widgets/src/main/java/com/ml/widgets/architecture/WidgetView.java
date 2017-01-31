package com.ml.widgets.architecture;

import android.content.Context;
import android.view.ViewGroup;

import com.ml.widgets.entity.Widget;


/**
 * Created by jcaceres on 20/06/2016.
 */
public interface WidgetView {

    void inject(Context context, ViewGroup father, WidgetListener listener, Widget widget);

    void refresh();
}
