package com.ml.fonts.editext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * <p> EditText_OpenSans </p>
 *
 * @author Javier Cáceres
 * @version 1.1.0
 */
public class EditText_OpenSans_BoldItalic extends EditText {

    /**
     * Instantiates a new EditText_OpenSans_BoldItalic.
     *
     * @param context the context
     */
    public EditText_OpenSans_BoldItalic(Context context) {
        super(context);
        setTypeFace(context);
    }

    /**
     * Instantiates a new EditText_OpenSans_BoldItalic.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public EditText_OpenSans_BoldItalic(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    /**
     * Instantiates a new EditText_OpenSans_BoldItalic.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public EditText_OpenSans_BoldItalic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }

    private void setTypeFace(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/OpenSans-BoldItalic.ttf"));
    }
}