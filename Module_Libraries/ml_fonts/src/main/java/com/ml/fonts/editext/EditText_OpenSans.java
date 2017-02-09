package com.ml.fonts.editext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * <p> EditText_OpenSans </p>
 *
 * @author Javier Cáceres
 * @version 1.1.0
 */
public class EditText_OpenSans extends EditText {

    /**
     * Instantiates a new EditText_OpenSans.
     *
     * @param context the context
     */
    public EditText_OpenSans(Context context) {
        super(context);
        setTypeFace(context);
    }

    /**
     * Instantiates a new EditText_OpenSans.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public EditText_OpenSans(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    /**
     * Instantiates a new EditText_OpenSans.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public EditText_OpenSans(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }

    private void setTypeFace(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/OpenSans-Regular.ttf"));
    }
}
