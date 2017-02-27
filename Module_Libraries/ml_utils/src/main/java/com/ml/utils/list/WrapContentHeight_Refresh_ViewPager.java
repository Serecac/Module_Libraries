package com.ml.utils.list;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jcaceres on 17/06/2016.
 */
public class WrapContentHeight_Refresh_ViewPager extends ViewPager {

    private View mCurrentView;

    public WrapContentHeight_Refresh_ViewPager(Context context) {
        super(context);
    }

    public WrapContentHeight_Refresh_ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mCurrentView == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int height = 0;
        mCurrentView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        int h = mCurrentView.getMeasuredHeight();
        if (h > height) height = h;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void measureCurrentView(View currentView) {
        mCurrentView = currentView;
        requestLayout();
    }

    public int measureFragment(View view) {
        if (view == null)
            return 0;

        view.measure(0, 0);
        return view.getMeasuredHeight();
    }
}