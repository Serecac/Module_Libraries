package com.ml.widgets.widget.title;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ml.utils.utils.Utils_Dimen;
import com.ml.widgets.R;
import com.ml.widgets.architecture.WidgetListener;
import com.ml.widgets.architecture.WidgetView;
import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetUtils;

import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_INT;
import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_STRING;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_COLOR;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_GRAVITY;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_GRAVITY_SEPARATOR;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_HEIGHT;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_IMAGE;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_NUM_SEPARATOR;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_PATH;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_SIZE;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_STYLE;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_TEXT;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_TYPE;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_INDEX_TYPEFACE;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_SIZE_IMAGE_MAX_VALUES_INT;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_SIZE_IMAGE_MAX_VALUES_STRING;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_SIZE_SEPARATOR_VALUES_INT;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_SIZE_TEXT_VALUES_INT;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_SIZE_TEXT_VALUES_STRING;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_GRAVITY_END;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_GRAVITY_START;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_STYLE_BOLD;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_STYLE_BOLDITALIC;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_STYLE_ITALIC;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_STYLE_STRIKETHROUGH;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_TYPE_IMAGE;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_TYPE_SEPARATOR;
import static com.ml.widgets.widget.title.WidgetTitle_Constants.WIDGET_TITLE_VALUE_TYPE_TEXT;


/**
 * Created by jcace on 05/10/2016.
 */

public class WidgetTitle implements WidgetView {

    private int heightWinner = WIDGET_TITLE_VALUE_GRAVITY_START;
    private float actualBigHeight = 0;

    @Override
    public void inject(Context context, ViewGroup father, final WidgetListener listener, final Widget widget) {

        if (widget == null) {
            return;
        }

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_title, null);
        if (view != null) {

            RelativeLayout mainLayout = (RelativeLayout) view.findViewById(R.id.widget_title_layout);
            if (mainLayout != null) {
                mainLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClickWidget(widget);
                    }
                });

                LinearLayout startLayout = (LinearLayout) view.findViewById(R.id.widget_title_layout_start);
                LinearLayout endLayout = (LinearLayout) view.findViewById(R.id.widget_title_layout_end);

                if (startLayout != null && endLayout != null) {

                    for (WidgetItem widgetItem : widget.getItems()) {
                        if (widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_TYPE) == WIDGET_TITLE_VALUE_TYPE_TEXT) {
                            createItemText(widgetItem,context,startLayout,endLayout);
                        } else if (widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_TYPE) == WIDGET_TITLE_VALUE_TYPE_IMAGE) {
                            createItemImage(widgetItem,context,startLayout,endLayout);
                        } else if (widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_TYPE) == WIDGET_TITLE_VALUE_TYPE_SEPARATOR) {
                            createItemSeparator(widgetItem,context,startLayout,endLayout);
                        }
                    }

                    RelativeLayout.LayoutParams params;
                    if (heightWinner == WIDGET_TITLE_VALUE_GRAVITY_START) {
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

            if (father != null) {
                father.addView(view);
            }
        }
    }

    @Override
    public void refresh() {

    }

    private void createItemText(WidgetItem widgetItem, Context context, LinearLayout startLayout, LinearLayout endLayout){

        if (widgetItem.getValuesInt().size() == WIDGET_TITLE_SIZE_TEXT_VALUES_INT && widgetItem.getValuesString().size() == WIDGET_TITLE_SIZE_TEXT_VALUES_STRING){

            float textsize = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_SIZE);
            int color = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_COLOR);
            int style = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_STYLE);
            int gravity = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_GRAVITY);

            TextView textView = new TextView(context);
            textView.setText(widgetItem.getValuesString().get(WIDGET_TITLE_INDEX_TEXT));

            if (textsize == WIDGET_GENERAL_DEFAULT_INT)
                textsize = context.getResources().getDimension(R.dimen.default_widget_title_textsize);

            if (color == WIDGET_GENERAL_DEFAULT_INT)
                color = context.getResources().getColor(R.color.black);

            textView.setTextColor(color);
            textView.setTextSize(Utils_Dimen.pixelsToSp(context,textsize));

            if (textsize > actualBigHeight){
                actualBigHeight = textsize;
                heightWinner = gravity;
            }

            if (style == WIDGET_TITLE_VALUE_STYLE_BOLD)
                textView.setTypeface(null, Typeface.BOLD);
            else if (style == WIDGET_TITLE_VALUE_STYLE_ITALIC)
                textView.setTypeface(null, Typeface.ITALIC);
            else if (style == WIDGET_TITLE_VALUE_STYLE_BOLDITALIC)
                textView.setTypeface(null, Typeface.BOLD_ITALIC);
            else if (style == WIDGET_TITLE_VALUE_STYLE_STRIKETHROUGH)
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            else
                textView.setTypeface(null, Typeface.NORMAL);

            textView.setId(WidgetUtils.generateViewId());

            if (widgetItem.getValuesString().get(WIDGET_TITLE_INDEX_TYPEFACE) != null && !widgetItem.getValuesString().get(WIDGET_TITLE_INDEX_TYPEFACE).equals(WIDGET_GENERAL_DEFAULT_STRING))
                textView.setTypeface(Typeface.createFromAsset(context.getAssets(),widgetItem.getValuesString().get(WIDGET_TITLE_INDEX_TYPEFACE)));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 0, 0);
            textView.setLayoutParams(params);
            if (gravity == WIDGET_TITLE_VALUE_GRAVITY_END)
                endLayout.addView(textView);
            else if (gravity == WIDGET_TITLE_VALUE_GRAVITY_START)
                startLayout.addView(textView);
        }
    }

    private void createItemImage(WidgetItem widgetItem, Context context, LinearLayout startLayout, LinearLayout endLayout){

        if (widgetItem.getValuesInt().size() == WIDGET_TITLE_SIZE_IMAGE_MAX_VALUES_INT || widgetItem.getValuesString().size() == WIDGET_TITLE_SIZE_IMAGE_MAX_VALUES_STRING){

            int height = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_HEIGHT);
            int gravity = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_GRAVITY);

            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setId(WidgetUtils.generateViewId());

            if (widgetItem.getValuesInt().size() == WIDGET_TITLE_SIZE_IMAGE_MAX_VALUES_INT)
                WidgetUtils.loadImage(widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_IMAGE),imageView,context);
            else if (widgetItem.getValuesString().size() == WIDGET_TITLE_SIZE_IMAGE_MAX_VALUES_STRING)
                WidgetUtils.loadImage(widgetItem.getValuesString().get(WIDGET_TITLE_INDEX_PATH),imageView,context);

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

            if (gravity == WIDGET_TITLE_VALUE_GRAVITY_END)
                endLayout.addView(imageView);
            else if (gravity == WIDGET_TITLE_VALUE_GRAVITY_START)
                startLayout.addView(imageView);
        }
    }

    private void createItemSeparator(WidgetItem widgetItem, Context context, LinearLayout startLayout, LinearLayout endLayout){

        if (widgetItem.getValuesInt().size() == WIDGET_TITLE_SIZE_SEPARATOR_VALUES_INT){

            float textsize = context.getResources().getDimension(R.dimen.default_widget_title_textsize);
            int color = context.getResources().getColor(R.color.black);
            int gravity = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_GRAVITY_SEPARATOR);
            int numSeparator = widgetItem.getValuesInt().get(WIDGET_TITLE_INDEX_NUM_SEPARATOR);

            TextView textView = new TextView(context);
            textView.setText(WidgetUtils.stringOfSize(numSeparator,' '));
            textView.setTextColor(color);
            textView.setTextSize(WidgetUtils.pixelsToSp(context,textsize));
            textView.setId(WidgetUtils.generateViewId());

            if (textsize > actualBigHeight){
                actualBigHeight = textsize;
                heightWinner = gravity;
            }

            if (gravity == WIDGET_TITLE_VALUE_GRAVITY_END)
                endLayout.addView(textView);
            else if (gravity == WIDGET_TITLE_VALUE_GRAVITY_START)
                startLayout.addView(textView);
        }
    }
}
