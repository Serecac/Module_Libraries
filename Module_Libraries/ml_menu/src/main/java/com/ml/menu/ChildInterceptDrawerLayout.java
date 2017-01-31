package com.ml.menu;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * <p> Class ChildInterceptDrawerLayout </p>
 * Extended DrawerLayout to intercept the events and redirect them to a especific child
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class ChildInterceptDrawerLayout extends DrawerLayout {

    private int mInterceptTouchEventChildId;

    /**
     * Sets id from child that intercept events.
     *
     * @param id the id
     */
    public void setInterceptTouchEventChildId(int id) {
        this.mInterceptTouchEventChildId = id;
    }

    /**
     * Instantiates a new ChildInterceptDrawerLayout.
     *
     * @param context the context
     */
    public ChildInterceptDrawerLayout(Context context) {
        super(context);
    }

    /**
     * Instantiates a new ChildInterceptDrawerLayout.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public ChildInterceptDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if (mInterceptTouchEventChildId > 0) {
            View scroll = findViewById(mInterceptTouchEventChildId);
            if (scroll != null) {
                Rect rect = new Rect();
                scroll.getHitRect(rect);
                if (rect.contains((int) ev.getX(), (int) ev.getY())) {
                    return false;
                }
            }
        }
        return super.onInterceptTouchEvent(ev);

    }
}
