package com.ml.utils.utils;

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

/**
 * <p> Class Utils_Image </p>
 * Utils about images and loaders
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Utils_Image {

    /**
     * Load image from URL as resource.
     *
     * @param url     the url
     * @param view    the view
     * @param context the context
     */
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

    /**
     * Load image from app as resource.
     *
     * @param resource the resource
     * @param view     the view
     * @param context  the context
     */
    public static void loadImage(int resource, ImageView view, Context context) {

        if (view != null && resource != -1) {
            Glide.with(context).load(resource).into(view);
            Glide.get(context).clearMemory();
        }
    }

    /**
     * Load image from URL as background.
     *
     * @param url     the url
     * @param view    the view
     * @param context the context
     */
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


    /**
     * Load image from app as background.
     *
     * @param resource the resource
     * @param view     the view
     * @param context  the context
     */
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
}
