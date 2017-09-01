package com.ml.utils.list;

import android.content.Context;
import android.util.DisplayMetrics;

public class ColumnManager {

    private final int MIN_SPACING = 15;

    private int pixelsWidth, remaining;
    private DisplayMetrics displayMetrics;

    public ColumnManager(Context context, int widthDimenResource) {

        this.pixelsWidth = context.getResources().getDimensionPixelSize(widthDimenResource);
        this.displayMetrics = context.getResources().getDisplayMetrics();
    }

    public int calculateNoOfColumns() {
        int numberOfColumns = displayMetrics.widthPixels / pixelsWidth;
        remaining = displayMetrics.widthPixels - (numberOfColumns * pixelsWidth);
        if (remaining / (2 * numberOfColumns) < MIN_SPACING) {
            numberOfColumns--;
            remaining = displayMetrics.widthPixels - (numberOfColumns * pixelsWidth);
        }
        return numberOfColumns;
    }

    public int calculateSpacing() {
        int numberOfColumns = calculateNoOfColumns();
        return remaining / (2 * numberOfColumns);
    }
}
