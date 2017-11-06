package com.ml.utils.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <p> Class Utils_Dialog </p>
 * Utils about dialogs
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Utils_Dialog {

    public static final int DURATION_SHORT = 0;
    public static final int DURATION_LONG = 1;

    /**
     * Show toast applying gravity center to message text
     *
     * @param message the message
     * @param context the context
     */
    public static void centerToastMessage(String message, Context context, int duration){
        Toast toast = Toast.makeText(context, message, duration == DURATION_LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }

    /**
     * Show toast applying gravity center to message text
     *
     * @param colorText       the color text
     * @param colorBackground the color background
     * @param message         the message
     * @param context         the context
     */
    public static void centerCustomiczeToastMessage(int colorText, int colorBackground, String message, Context context, int duration){
        Toast toast = Toast.makeText(context, "  " + message.replace("\n","  \n  ") + "  ", duration == DURATION_LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundColor(colorBackground);
        TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
        if (text != null) {
            text.setGravity(Gravity.CENTER);
            text.setTextColor(colorText);
            text.setBackgroundColor(colorBackground);
        }
        toast.show();
    }
}
