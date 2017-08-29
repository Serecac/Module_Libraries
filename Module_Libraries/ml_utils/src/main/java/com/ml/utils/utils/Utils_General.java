package com.ml.utils.utils;

import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Utils_General {

    public static void setHtml(String html, TextView textView) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
            textView.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        else
            textView.setText(Html.fromHtml(html));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void setUnderlineHtml(String html, TextView textView) {

        SpannableString content = new SpannableString(html);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
            content = new SpannableString(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));

        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void setUnderlineText(String text, TextView textView) {

        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
    }

    public static <C> List<C> asList(SparseArray<C> sparseArray) {
        if (sparseArray == null) return null;
        List<C> arrayList = new ArrayList<C>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++)
            arrayList.add(sparseArray.valueAt(i));
        return arrayList;
    }

}
