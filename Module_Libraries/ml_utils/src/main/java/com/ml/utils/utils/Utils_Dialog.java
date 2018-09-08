package com.ml.utils.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ml.utils.R;

@SuppressWarnings("unused")
public class Utils_Dialog {

    public static final int DURATION_SHORT = 0;
    public static final int DURATION_LONG = 1;

    public static void centerToastMessage(String message, Context context, int duration) {
        Toast toast = Toast.makeText(context, message, duration == DURATION_LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if (v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }

    public static void centerCustomizeToastMessage(int colorText, int colorBackground, String message, Context context, int duration) {
        Toast toast = Toast.makeText(context, "  " + message.replace("\n", "  \n  ") + "  ", duration == DURATION_LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
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

    public static void customSimpleToast(int colorText, int colorBackground, int resourceBackground, String message, Activity activity, int duration) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_simple_toast, (ViewGroup) activity.findViewById(R.id.custom_simple_toast_layout));
        TextView text = (TextView) layout.findViewById(R.id.custom_simple_toast_text);
        text.setGravity(Gravity.CENTER);
        text.setText(message);
        text.setTextColor(colorText);
        if (resourceBackground == -1)
            layout.setBackgroundColor(colorBackground);
        else
            layout.setBackgroundResource(resourceBackground);

        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.BOTTOM, 0, 100);
        toast.setDuration(duration == DURATION_LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
