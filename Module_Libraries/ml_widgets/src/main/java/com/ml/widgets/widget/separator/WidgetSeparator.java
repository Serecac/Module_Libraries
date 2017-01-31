package com.ml.widgets.widget.separator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ml.widgets.R;
import com.ml.widgets.architecture.WidgetListener;
import com.ml.widgets.architecture.WidgetView;
import com.ml.widgets.entity.Widget;


/**
 * Created by jcace on 05/10/2016.
 */
public class WidgetSeparator implements WidgetView {

    private Widget widget = null;

    @Override
    public void inject(Context context, ViewGroup father, WidgetListener listener, Widget widget) {

        if (widget == null) {
            return;
        }

        this.widget = widget;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_separator, null);
        if (view != null) {

            LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.widget_separator_layout);
            if (mainLayout != null && widget.getItems().size() > 0 && widget.getItems().get(0).getValuesInt() != null && widget.getItems().get(0).getValuesInt().size() > 0)
                mainLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,widget.getItems().get(0).getValuesInt().get(0)));

            if (father != null) {
                father.addView(view);
            }
        }
    }

    @Override
    public void refresh() {

    }
}
