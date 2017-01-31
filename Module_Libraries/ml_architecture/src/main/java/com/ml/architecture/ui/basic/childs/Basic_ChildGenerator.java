package com.ml.architecture.ui.basic.childs;

import android.content.Context;
import android.util.SparseArray;

/**
 * <p> Interface Basic_ChildGenerator </p>
 * Helps to generate Basic_Fragment array
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public interface Basic_ChildGenerator {

    /**
     * Generate Basic_Fragment array.
     *
     * @param context the context
     * @return the array list
     */
    SparseArray<Basic_Fragment> generate(Context context);
}
