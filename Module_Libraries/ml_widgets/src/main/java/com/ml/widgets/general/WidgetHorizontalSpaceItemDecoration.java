package com.ml.widgets.general;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jcaceres on 13/07/2016.
 */
public class WidgetHorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int mHorizontalSpaceHeight;

    public WidgetHorizontalSpaceItemDecoration(int mHorizontalSpaceHeight) {
        this.mHorizontalSpaceHeight = mHorizontalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (parent.getAdapter().getItemCount() > 1) {

            if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1 && parent.getChildAdapterPosition(view) != 0) {
                outRect.left = mHorizontalSpaceHeight;
            } else if (parent.getChildAdapterPosition(view) == 0) {
                outRect.left = mHorizontalSpaceHeight;
            } else {
                outRect.left = mHorizontalSpaceHeight;
                outRect.right = mHorizontalSpaceHeight;
            }

        } else {

            outRect.left = mHorizontalSpaceHeight;
            outRect.right = mHorizontalSpaceHeight;
        }
    }
}

