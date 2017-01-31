package com.ml.widgets.widget.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ml.widgets.R;
import com.ml.widgets.architecture.WidgetListener;
import com.ml.widgets.architecture.WidgetView;
import com.ml.widgets.entity.Widget;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetUtils;

import static com.ml.widgets.general.WidgetConstants.WIDGET_GENERAL_DEFAULT_INT;
import static com.ml.widgets.widget.banner.WidgetBanner_Constants.WIDGET_BANNER_INDEX_HEIGHT;
import static com.ml.widgets.widget.banner.WidgetBanner_Constants.WIDGET_BANNER_INDEX_IMAGE;
import static com.ml.widgets.widget.banner.WidgetBanner_Constants.WIDGET_BANNER_INDEX_MARGIN;
import static com.ml.widgets.widget.banner.WidgetBanner_Constants.WIDGET_BANNER_INDEX_PATH;
import static com.ml.widgets.widget.banner.WidgetBanner_Constants.WIDGET_BANNER_SIZE_IMAGE_MAX_VALUES_INT;
import static com.ml.widgets.widget.banner.WidgetBanner_Constants.WIDGET_BANNER_SIZE_IMAGE_MAX_VALUES_STRING;

/**
 * Created by jcace on 10/10/2016.
 */

public class WidgetBanner implements WidgetView {

    @Override
    public void inject(Context context, ViewGroup father, final WidgetListener listener, final Widget widget) {

        if (widget == null) {
            return;
        }

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_banner, null);
        if (view != null) {

            LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.widget_banner_layout);
            if (mainLayout != null) {
                mainLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClickWidget(widget);
                    }
                });
            }

            if ( widget.getItems() != null &&  widget.getItems().size() > 0) {
                WidgetItem itemConfig = widget.getItems().get(0);

                ImageView bannerImage = (ImageView) view.findViewById(R.id.widget_banner_image);
                if (bannerImage != null) {
                    if (itemConfig.getValuesInt() != null && itemConfig.getValuesInt().size() > 0){
                        if (itemConfig.getValuesInt().get(WIDGET_BANNER_INDEX_HEIGHT) != WIDGET_GENERAL_DEFAULT_INT){
                            bannerImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, itemConfig.getValuesInt().get(WIDGET_BANNER_INDEX_HEIGHT));
                            bannerImage.setLayoutParams(params);
                        }
                    } else {
                        bannerImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }

                    if (itemConfig.getValuesInt().get(WIDGET_BANNER_INDEX_MARGIN) != WIDGET_GENERAL_DEFAULT_INT){
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) bannerImage.getLayoutParams();
                        int margin = itemConfig.getValuesInt().get(WIDGET_BANNER_INDEX_MARGIN);
                        params.setMargins(margin,margin,margin,margin);
                        bannerImage.setLayoutParams(params);
                    }

                    if (itemConfig.getValuesInt().size() == WIDGET_BANNER_SIZE_IMAGE_MAX_VALUES_INT)
                        WidgetUtils.loadImage(itemConfig.getValuesInt().get(WIDGET_BANNER_INDEX_IMAGE),bannerImage,context);
                    else if (itemConfig.getValuesString().size() == WIDGET_BANNER_SIZE_IMAGE_MAX_VALUES_STRING)
                        WidgetUtils.loadImage(itemConfig.getValuesString().get(WIDGET_BANNER_INDEX_PATH),bannerImage,context);
                }
            }
        }

        if (father != null) {
            father.addView(view);
        }
    }

    @Override
    public void refresh() {
    }
}
