package com.ml.widgets.widget.cardcarousel.type_one.one;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.ml.widgets.R;
import com.ml.widgets.adapter.cardcarousel.type_one.one.Adapter_CardCarousel_TypeOne_One;
import com.ml.widgets.architecture.WidgetListener;
import com.ml.widgets.architecture.WidgetView;
import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetHorizontalSpaceItemDecoration;
import com.ml.widgets.general.WidgetRecyclerItemClickListener;

import java.util.List;

import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Metrics.ADAPTER_TYPEONE_ONE_WIDTH_SEPARATOR;


/**
 * Created by jcace on 07/10/2016.
 */

public class WidgetCardCarousel_TypeOne_One implements WidgetView {

    List<WidgetItem> items;

    @Override
    public void inject(Context context, ViewGroup father, final WidgetListener listener, Widget widget) {

        if (widget == null || widget.getItems() == null) {
            return;
        }

        items = widget.getItems();
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_cardcarousel, null);
        if (view != null) {

            RecyclerView list = (RecyclerView) view.findViewById(R.id.widget_cardcarousel_list);
            if (list != null){
                LinearLayoutManager layoutManager = new LinearLayoutManager(context.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                layoutManager.setAutoMeasureEnabled(true);
                list.setLayoutManager(layoutManager);

                list.setHasFixedSize(false);
                list.setNestedScrollingEnabled(false);

                if (widget.getItems().size() < 2) {
                    list.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    list.setHorizontalScrollBarEnabled(false);
                }

                list.addOnItemTouchListener(new WidgetRecyclerItemClickListener(context, new WidgetRecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        if(items != null && items.size() > position)
                            listener.onClickWidgetItem(items.get(position));
                    }
                }));

                WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                Display display = wm.getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;

                list.addItemDecoration(new WidgetHorizontalSpaceItemDecoration((int) (width * ADAPTER_TYPEONE_ONE_WIDTH_SEPARATOR)));
                list.setAdapter(new Adapter_CardCarousel_TypeOne_One(widget.getItems(), context, width, false));
            }

            if (father != null) {
                father.addView(view);
            }
        }
    }

    @Override
    public void refresh() {

    }
}
