package com.ml.architecture.ui.toolbarmenu.childs;

import android.content.Context;

/**
 * <p> Interface ToolbarMenu_ChildGenerator </p>
 * Helps to generate ToolbarMenu_Childs array
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public interface ToolBarMenu_ChildGenerator {

    /**
     * Generate ToolbarMenu_Childs array.
     *
     * @param context the context
     * @return the tool bar menu childs
     */
    ToolBarMenu_Childs generate(Context context);
}
