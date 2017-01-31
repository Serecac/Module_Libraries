package com.ml.widgets.widget.background_cardcarousel.type_one.two;


import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ml.widgets.R;
import com.ml.widgets.adapter.cardcarousel.type_one.two.Adapter_CardCarousel_TypeOne_Two;
import com.ml.widgets.architecture.WidgetListener;
import com.ml.widgets.architecture.WidgetView;
import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetHorizontalSpaceItemDecoration;
import com.ml.widgets.general.WidgetRecyclerItemClickListener;
import com.ml.widgets.general.WidgetUtils;

import java.util.List;

import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Metrics.ADAPTER_TYPEONE_TWO_WIDTH_SEPARATOR;
import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_INT;
import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_STRING;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_OFFSET;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_PATH;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_RESOURCE;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_TITLECOUNT;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_SIZE_MAX_VALUES_INT;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_SIZE_MAX_VALUES_STRING;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_COLOR;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_GRAVITY;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_GRAVITY_SEPARATOR;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_HEIGHT;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_IMAGE;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_NUM_SEPARATOR;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_PATH;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_SIZE;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_STYLE;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TEXT;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPE;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPEFACE;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_IMAGE_MAX_VALUES_INT;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_IMAGE_MAX_VALUES_STRING;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_SEPARATOR_VALUES_INT;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_TEXT_VALUES_INT;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_TEXT_VALUES_STRING;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_END;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_START;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_BOLD;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_BOLDITALIC;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_ITALIC;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_STRIKETHROUGH;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_TYPE_IMAGE;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_TYPE_SEPARATOR;
import static com.ml.widgets.widget.background_cardcarousel.type_one.WidgetBackgroundCardCarousel_TypeOne_Constants.WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_TYPE_TEXT;

/**
 * Created by jcace on 07/10/2016.
 */

public class WidgetBackgroundCardCarousel_TypeOne_Two implements WidgetView {

    private List<WidgetItem> items;
    private int heightWinner = WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_START;
    private float actualBigHeight = 0;

    @Override
    public void inject(Context context, ViewGroup father, final WidgetListener listener, final Widget widget) {

        if (widget == null || widget.getItems() == null) {
            return;
        }

        /********************* CONFIG AREA *********************/
        WidgetItem configItem = widget.getItems().get(widget.getItems().size()-1); //Last item is configitem
        int numItemsTitle = configItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_TITLECOUNT);
        boolean isOffset = WidgetUtils.getBooleanFromInt(configItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_OFFSET));

        final List<WidgetItem> titleItems, cardItems;

        if (widget.getItems().size() > numItemsTitle && numItemsTitle > 0) {
            titleItems = widget.getItems().subList(0, numItemsTitle);


            cardItems = widget.getItems().subList(numItemsTitle, widget.getItems().size() - 1); //Last item is configitem
        } else if (widget.getItems().size() > 1){
            titleItems = null;
            cardItems = widget.getItems().subList(numItemsTitle, widget.getItems().size() - 1); //Last item is configitem
        } else {
            titleItems = null;
            cardItems = null;
        }

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_cardcarousel_background, null);
        if (view != null && cardItems != null && cardItems.size() > 0 ) {

            /********************* BACKGROUND AREA *********************/
            LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.widget_background_cardcarousel_layout);
            if (mainLayout != null) {

                if (configItem.getValuesInt().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_SIZE_MAX_VALUES_INT)
                    WidgetUtils.loadBackground(configItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_RESOURCE),mainLayout,context);
                else if (configItem.getValuesString().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_SIZE_MAX_VALUES_STRING)
                    WidgetUtils.loadBackground(configItem.getValuesString().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_CONFIG_INDEX_PATH),mainLayout,context);

                mainLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClickWidget(widget);
                    }
                });
            }
            /********************* TITLE AREA *********************/
            if (titleItems != null && titleItems.size() > 0){
                RelativeLayout mainTitleLayout = (RelativeLayout) view.findViewById(R.id.widget_background_cardcarousel_title_layout);
                if (mainTitleLayout != null) {
                    mainTitleLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listener.onClickWidget(widget);
                        }
                    });

                    LinearLayout startLayout = (LinearLayout) view.findViewById(R.id.widget_background_cardcarousel_title_layout_start);
                    LinearLayout endLayout = (LinearLayout) view.findViewById(R.id.widget_background_cardcarousel_title_layout_end);

                    if (startLayout != null && endLayout != null) {

                        for (WidgetItem widgetItem : titleItems) {
                            if (widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPE) == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_TYPE_TEXT) {
                                createItemText(widgetItem,context,startLayout,endLayout);
                            } else if (widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPE) == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_TYPE_IMAGE) {
                                createItemImage(widgetItem,context,startLayout,endLayout);
                            } else if (widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPE) == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_TYPE_SEPARATOR) {
                                createItemSeparator(widgetItem,context,startLayout,endLayout);
                            }
                        }

                        RelativeLayout.LayoutParams params;
                        if (heightWinner == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_START) {
                            params = (RelativeLayout.LayoutParams) endLayout.getLayoutParams();
                            params.addRule(RelativeLayout.ALIGN_BOTTOM,startLayout.getId());
                            endLayout.setLayoutParams(params);
                        } else {
                            params = (RelativeLayout.LayoutParams) startLayout.getLayoutParams();
                            params.addRule(RelativeLayout.ALIGN_BOTTOM,endLayout.getId());
                            startLayout.setLayoutParams(params);
                        }
                    }
                }
            } else {
                //Quit separator between tittle and cards
                view.findViewById(R.id.widget_background_cardcarousel_separator).setVisibility(View.GONE);
            }

            /********************* CARD AREA *********************/
            RecyclerView list = (RecyclerView) view.findViewById(R.id.widget_background_cardcarousel_list);
            if (list != null && cardItems != null){
                LinearLayoutManager layoutManager = new LinearLayoutManager(context.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                layoutManager.setAutoMeasureEnabled(true);
                list.setLayoutManager(layoutManager);

                list.setHasFixedSize(false);
                list.setNestedScrollingEnabled(false);

                if (cardItems.size() < 3) {
                    list.setOverScrollMode(View.OVER_SCROLL_NEVER);
                    list.setHorizontalScrollBarEnabled(false);
                }

                list.addOnItemTouchListener(new WidgetRecyclerItemClickListener(context, new WidgetRecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        if(cardItems != null && cardItems.size() > position)
                            listener.onClickWidgetItem(cardItems.get(position));
                    }
                }));

                WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                Display display = wm.getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;

                list.addItemDecoration(new WidgetHorizontalSpaceItemDecoration((int) (width * ADAPTER_TYPEONE_TWO_WIDTH_SEPARATOR)));
                list.setAdapter(new Adapter_CardCarousel_TypeOne_Two(cardItems, context, width, isOffset));

            } else {
                //Quit separator between tittle and cards
                view.findViewById(R.id.widget_background_cardcarousel_separator).setVisibility(View.GONE);
            }

            if (father != null) {
                father.addView(view);
            }
        }
    }

    @Override
    public void refresh() {

    }

    private void createItemText(WidgetItem widgetItem, Context context, LinearLayout startLayout, LinearLayout endLayout){

        if (widgetItem.getValuesInt().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_TEXT_VALUES_INT && widgetItem.getValuesString().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_TEXT_VALUES_STRING){

            float textsize = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_SIZE);
            int color = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_COLOR);
            int style = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_STYLE);
            int gravity = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_GRAVITY);

            TextView textView = new TextView(context);
            textView.setText(widgetItem.getValuesString().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TEXT));

            if (textsize == WIDGET_GENERAL_DEFAULT_INT)
                textsize = context.getResources().getDimension(R.dimen.default_widget_title_textsize);

            if (color == WIDGET_GENERAL_DEFAULT_INT)
                color = context.getResources().getColor(R.color.black);

            textView.setTextColor(color);
            textView.setTextSize(WidgetUtils.pixelsToSp(context,textsize));

            if (textsize > actualBigHeight){
                actualBigHeight = textsize;
                heightWinner = gravity;
            }

            if (style == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_BOLD)
                textView.setTypeface(null, Typeface.BOLD);
            else if (style == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_ITALIC)
                textView.setTypeface(null, Typeface.ITALIC);
            else if (style == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_BOLDITALIC)
                textView.setTypeface(null, Typeface.BOLD_ITALIC);
            else if (style == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_STYLE_STRIKETHROUGH)
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            else
                textView.setTypeface(null, Typeface.NORMAL);

            textView.setId(WidgetUtils.generateViewId());

            if (widgetItem.getValuesString().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPEFACE) != null && !widgetItem.getValuesString().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPEFACE).equals(WIDGET_GENERAL_DEFAULT_STRING))
                textView.setTypeface(Typeface.createFromAsset(context.getAssets(),widgetItem.getValuesString().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_TYPEFACE)));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 0, 0);
            textView.setLayoutParams(params);
            if (gravity == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_END)
                endLayout.addView(textView);
            else if (gravity == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_START)
                startLayout.addView(textView);
        }
    }

    private void createItemImage(WidgetItem widgetItem, Context context, LinearLayout startLayout, LinearLayout endLayout){

        if (widgetItem.getValuesInt().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_IMAGE_MAX_VALUES_INT || widgetItem.getValuesString().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_IMAGE_MAX_VALUES_STRING){

            int height = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_HEIGHT);
            int gravity = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_GRAVITY);

            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setId(WidgetUtils.generateViewId());

            if (widgetItem.getValuesInt().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_IMAGE_MAX_VALUES_INT)
                WidgetUtils.loadImage(widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_IMAGE),imageView,context);
            else if (widgetItem.getValuesString().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_IMAGE_MAX_VALUES_STRING)
                WidgetUtils.loadImage(widgetItem.getValuesString().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_PATH),imageView,context);

            if (height == WIDGET_GENERAL_DEFAULT_INT)
                height = (int) context.getResources().getDimension(R.dimen.default_widget_title_imagesize);

            if (height > actualBigHeight){
                actualBigHeight = height;
                heightWinner = gravity;
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 0, 0);
            params.height = height;
            imageView.setLayoutParams(params);

            if (gravity == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_END)
                endLayout.addView(imageView);
            else if (gravity == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_START)
                startLayout.addView(imageView);
        }
    }

    private void createItemSeparator(WidgetItem widgetItem, Context context, LinearLayout startLayout, LinearLayout endLayout){

        if (widgetItem.getValuesInt().size() == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_SIZE_SEPARATOR_VALUES_INT){

            float textsize = context.getResources().getDimension(R.dimen.default_widget_title_textsize);
            int color = context.getResources().getColor(R.color.black);
            int gravity = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_GRAVITY_SEPARATOR);
            int numSeparator = widgetItem.getValuesInt().get(WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_INDEX_NUM_SEPARATOR);

            TextView textView = new TextView(context);
            textView.setText(WidgetUtils.stringOfSize(numSeparator,' '));
            textView.setTextColor(color);
            textView.setTextSize(WidgetUtils.pixelsToSp(context,textsize));
            textView.setId(WidgetUtils.generateViewId());

            if (textsize > actualBigHeight){
                actualBigHeight = textsize;
                heightWinner = gravity;
            }

            if (gravity == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_END)
                endLayout.addView(textView);
            else if (gravity == WIDGET_BACKGROUND_CARDCAROUSEL_TYPEONE_TITLE_VALUE_GRAVITY_START)
                startLayout.addView(textView);
        }
    }
}