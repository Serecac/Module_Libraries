package com.ml.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <p> TextView_OpenSans_Bold </p>
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class TextView_OpenSans_Bold extends TextView {

    /**
     * Instantiates a new TextView_OpenSans_Bold.
     *
     * @param context the context
     */
    public TextView_OpenSans_Bold(Context context) {
        super(context);
        setTypeFace(context);
    }

    /**
     * Instantiates a new Text view open sans bold.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public TextView_OpenSans_Bold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    /**
     * Instantiates a new Text view open sans bold.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public TextView_OpenSans_Bold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }

    private void setTypeFace(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/OpenSans-Bold.ttf"));
    }
}
