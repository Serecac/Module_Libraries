package com.ml.fonts.editext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditText_BebasNeue extends EditText {

    public EditText_BebasNeue(Context context) {
        super(context);
        setTypeFace(context);
    }

    public EditText_BebasNeue(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    public EditText_BebasNeue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }

    private void setTypeFace(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/BebasNeue-Regular.ttf"));
    }
}
