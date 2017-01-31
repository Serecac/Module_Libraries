package com.ml.widgets.adapter.cardcarousel.type_one.fix_three;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ml.widgets.R;
import com.ml.widgets.entity.WidgetItem;
import com.ml.widgets.general.WidgetUtils;

import java.util.List;

import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_INDEX_EXTRA_ONE;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_INDEX_EXTRA_TWO;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_INDEX_IMAGE;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_INDEX_PATH;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_INDEX_SUBTITLE;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_INDEX_TITLE;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_SIZE_MAX_VALUES_INT;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Constans.ADAPTER_TYPEONE_CARD_SIZE_MAX_VALUES_STRING;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Metrics.ADAPTER_TYPEONE_FIX_THREE_WIDTH_CARD;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Metrics.ADAPTER_TYPEONE_PERCENTAGE_IMAGE;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Metrics.ADAPTER_TYPEONE_PERCENTAGE_TEXT;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Metrics.ADAPTER_TYPEONE_TEXTSIZE_BIG;
import static com.ml.widgets.adapter.cardcarousel.type_one.Adapter_CardCarousel_TypeOne_Metrics.ADAPTER_TYPEONE_TEXTSIZE_NORMAL;

/**
 * Created by jcaceres on 07/10/2016.
 */
public class Adapter_CardCarousel_TypeOne_FixThree extends RecyclerView.Adapter<Adapter_CardCarousel_TypeOne_FixThree.ViewHolder> {

    private List<WidgetItem> info;
    private Context context;
    private int widthScreen;
    private boolean isOffset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mainLayout;
        public ImageView image;
        public TextView textTitle;
        public TextView textSubtitle;
        public TextView textExtraInfo_one;
        public TextView textExtraInfo_two;

        public ViewHolder(View itemView, LinearLayout mainLayout, ImageView image, TextView textTitle, TextView textSubtitle, TextView textExtraInfo_one, TextView textExtraInfo_two) {
            super(itemView);
            this.mainLayout = mainLayout;
            this.image = image;
            this.textTitle = textTitle;
            this.textSubtitle = textSubtitle;
            this.textExtraInfo_one = textExtraInfo_one;
            this.textExtraInfo_two = textExtraInfo_two;
        }
    }

    public Adapter_CardCarousel_TypeOne_FixThree(List<WidgetItem> info, Context context, int widthScreen, boolean isOffset) {
        this.info = info.subList(0,3); //Just first 3 elements
        this.context = context;
        this.widthScreen = widthScreen;
        this.isOffset = isOffset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_typeone_item, parent, false);

        int widthMainLayout = (int)(widthScreen * ADAPTER_TYPEONE_FIX_THREE_WIDTH_CARD);
        //Card height is 70% of total height of the card, each Text layout height is 10%
        int heightTextLayout = (int)(((widthMainLayout / ADAPTER_TYPEONE_PERCENTAGE_IMAGE) * ADAPTER_TYPEONE_PERCENTAGE_TEXT));
        float textsizeBig = WidgetUtils.pixelsToSp(context, heightTextLayout * ADAPTER_TYPEONE_TEXTSIZE_BIG);
        float textsizeNormal = WidgetUtils.pixelsToSp(context, heightTextLayout * ADAPTER_TYPEONE_TEXTSIZE_NORMAL);

        LinearLayout layout = (LinearLayout) mainView.findViewById(R.id.widget_typeone_layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthMainLayout, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);

        ImageView image = (ImageView) mainView.findViewById(R.id.widget_typeone_image);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, widthMainLayout);
        image.setLayoutParams(params);

        LinearLayout layoutTitle = (LinearLayout) mainView.findViewById(R.id.widget_typeone_layoutTitle);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightTextLayout);
        layoutTitle.setLayoutParams(params);

        LinearLayout layoutSubtitle = (LinearLayout) mainView.findViewById(R.id.widget_typeone_layoutSubtitle);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightTextLayout);
        layoutSubtitle.setLayoutParams(params);

        LinearLayout layoutExtraInfo = (LinearLayout) mainView.findViewById(R.id.widget_typeone_layoutExtraInfo);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightTextLayout);
        layoutExtraInfo.setLayoutParams(params);

        TextView textTitle = (TextView) mainView.findViewById(R.id.widget_typeone_textTitle);
        textTitle.setTextSize(textsizeBig);

        TextView textSubtitle = (TextView) mainView.findViewById(R.id.widget_typeone_textSubtitle);
        textSubtitle.setTextSize(textsizeNormal);

        TextView textExtraInfo_one = (TextView) mainView.findViewById(R.id.widget_typeone_textExtraInfo_one);
        textExtraInfo_one.setTextSize(textsizeBig);

        TextView textExtraInfo_two = (TextView) mainView.findViewById(R.id.widget_typeone_textExtraInfo_two);
        textExtraInfo_two.setTextSize(textsizeNormal);
        textExtraInfo_two.setPaintFlags(textExtraInfo_two.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        return new ViewHolder(mainView, layout, image, textTitle, textSubtitle, textExtraInfo_one, textExtraInfo_two);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int correctPosition = holder.getAdapterPosition();
        if (isOffset){
            if (correctPosition == 0){
                if (holder.mainLayout != null) {
                    holder.mainLayout.setVisibility(View.INVISIBLE);
                }
                return;
            } else {
                correctPosition--;
                if (holder.mainLayout != null) {
                    holder.mainLayout.setVisibility(View.VISIBLE);
                }
            }
        }

        WidgetItem item = info.get(correctPosition);
        if (item != null){
            if (holder.image != null) {
                if (item.getValuesInt() != null && item.getValuesInt().size() == ADAPTER_TYPEONE_CARD_SIZE_MAX_VALUES_INT)
                    WidgetUtils.loadImage(item.getValuesInt().get(ADAPTER_TYPEONE_CARD_INDEX_IMAGE), holder.image, context);
                else if (item.getValuesString() != null && item.getValuesString().size() == ADAPTER_TYPEONE_CARD_SIZE_MAX_VALUES_STRING)
                    WidgetUtils.loadImage(item.getValuesString().get(ADAPTER_TYPEONE_CARD_INDEX_PATH), holder.image, context);
            }

            if (holder.textTitle != null){
                holder.textTitle.setText(item.getValuesString().get(ADAPTER_TYPEONE_CARD_INDEX_TITLE));
            }

            if (holder.textSubtitle != null){
                holder.textSubtitle.setText(item.getValuesString().get(ADAPTER_TYPEONE_CARD_INDEX_SUBTITLE));
            }

            if (holder.textExtraInfo_one != null){
                holder.textExtraInfo_one.setText(item.getValuesString().get(ADAPTER_TYPEONE_CARD_INDEX_EXTRA_ONE));
            }

            if (holder.textExtraInfo_two != null){
                holder.textExtraInfo_two.setText(item.getValuesString().get(ADAPTER_TYPEONE_CARD_INDEX_EXTRA_TWO));
            }
        }
    }

    @Override
    public int getItemCount() {

        if (isOffset)
            return info.size() +1 ;
        return info.size();
    }
}
