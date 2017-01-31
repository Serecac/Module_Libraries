package com.ml.widgets.general;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jcace on 05/10/2016.
 */

public class WidgetUtils {

    public static boolean getBooleanFromInt(int value){
        return value == 1;
    }

    public static int getIntFromBoolean(boolean value){
        return value ? 1 : 0;
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    public static void loadImage(String url, final ImageView view, Context context) {

        if (view != null && url != null && !url.equals("")) {

            Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .dontAnimate()
                    .thumbnail(0.1f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {

                            if (bitmap != null) {
                                view.setImageBitmap(bitmap);

                            }
                        }
                    });
        }
    }

    public static void loadImage(int resource, ImageView view, Context context) {

        if (view != null && resource != -1) {
            Glide.with(context).load(resource).into(view);
            Glide.get(context).clearMemory();
        }
    }

    public static void loadBackground(String url, final ViewGroup view, Context context) {

        if (view != null && url != null && !url.equals("")) {

            Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .dontAnimate()
                    .thumbnail(0.1f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {

                            if (bitmap != null) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                    view.setBackground(new BitmapDrawable(bitmap));
                                }
                            }
                        }
                    });
        }
    }


    public static void loadBackground(int resource, final ViewGroup view, Context context) {

        if (view != null && resource != -1) {
            Glide.with(context)
                    .load(resource)
                    .asBitmap()
                    .dontAnimate()
                    .thumbnail(0.1f)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {

                            if (bitmap != null) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                    view.setBackground(new BitmapDrawable(bitmap));
                                }
                            }
                        }
                    });
        }
    }

    public static String stringOfSize(int size, char ch)
    {
        final char[] array = new char[size];
        Arrays.fill(array, ch);
        return new String(array);
    }

    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }

    public static float pixelsToDp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().densityDpi;
        return px/scaledDensity;
    }
}
