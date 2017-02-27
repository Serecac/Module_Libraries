package com.ml.utils.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by jcaceres on 17/06/2016.
 */
public class WrapContentHeight_Refresh_NoSlide_ViewPager extends WrapContentHeight_Refresh_ViewPager {

    public WrapContentHeight_Refresh_NoSlide_ViewPager(Context context) {
        super(context);
    }

    public WrapContentHeight_Refresh_NoSlide_ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }
}