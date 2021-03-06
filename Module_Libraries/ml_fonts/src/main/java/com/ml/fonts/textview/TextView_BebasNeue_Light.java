package com.ml.fonts.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextView_BebasNeue_Light extends TextView {

    public TextView_BebasNeue_Light(Context context) {
        super(context);
        setTypeFace(context);
    }

    public TextView_BebasNeue_Light(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    public TextView_BebasNeue_Light(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }

    private void setTypeFace(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/BebasNeue-Light.ttf"));
    }
}
