package com.ml.architecture.ui.toolbarmenu.childs;

import android.util.SparseArray;

import com.ml.toolbar.ToolbarInfo;

/**
 * <p> Class ToolbarMenu_Childs </p>
 * Manage childs info for ToolbarMenu arquitecture
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class ToolbarMenu_Childs {

    private SparseArray<ToolbarMenu_Fragment> fragments = null;
    private SparseArray<ToolbarInfo> toolbars = null;

    /**
     * Instantiates a new ToolbarMenu_Childs.
     */
    public ToolbarMenu_Childs() {

        fragments = new SparseArray<>();
        toolbars = new SparseArray<>();
    }

    /**
     * Add one fragment.
     *
     * @param newFragment the new fragment
     */
    public void addOneFragment(ToolbarMenu_Fragment newFragment) {
        if (fragments != null) {
            fragments.put(newFragment.getFragmentId(), newFragment);
        }
    }

    /**
     * Add fragment tool bar menu childs.
     *
     * @param newFragment the new fragment
     * @return the tool bar menu childs
     */
    public ToolbarMenu_Childs addFragment(ToolbarMenu_Fragment newFragment) {
        if (fragments != null) {
            fragments.put(newFragment.getFragmentId(), newFragment);
        }
        return this;
    }

    /**
     * Add one toolbar.
     *
     * @param fragmentId the fragment id
     * @param newToolbar the new toolbar
     */
    public void addOneToolbar(int fragmentId, ToolbarInfo newToolbar) {
        if (toolbars != null) {
            toolbars.put(fragmentId, newToolbar);
        }
    }

    /**
     * Add toolbar tool bar menu childs.
     *
     * @param fragmentId the fragment id
     * @param newToolbar the new toolbar
     * @return the tool bar menu childs
     */
    public ToolbarMenu_Childs addToolbar(int fragmentId, ToolbarInfo newToolbar) {
        if (toolbars != null) {
            toolbars.put(fragmentId, newToolbar);
        }
        return this;
    }

    /**
     * Add one child.
     *
     * @param newFragment the new fragment
     * @param newToolbar  the new toolbar
     */
    public void addOneChild(ToolbarMenu_Fragment newFragment, ToolbarInfo newToolbar) {
        if (fragments != null) {
            fragments.put(newFragment.getFragmentId(), newFragment);
        }
        if (toolbars != null) {
            toolbars.put(newFragment.getFragmentId(), newToolbar);
        }
    }

    /**
     * Add child tool bar menu childs.
     *
     * @param newFragment the new fragment
     * @param newToolbar  the new toolbar
     * @return the tool bar menu childs
     */
    public ToolbarMenu_Childs addChild(ToolbarMenu_Fragment newFragment, ToolbarInfo newToolbar) {
        if (fragments != null) {
            fragments.put(newFragment.getFragmentId(), newFragment);
        }
        if (toolbars != null) {
            toolbars.put(newFragment.getFragmentId(), newToolbar);
        }
        return this;
    }

    /**
     * Gets one fragment.
     *
     * @param fragmentId the fragment id
     * @return the one fragment
     */
    public ToolbarMenu_Fragment getOneFragment(int fragmentId) {
        if (fragments == null || fragments.indexOfKey(fragmentId) < 0) {
            return null;
        }
        return fragments.get(fragmentId);
    }

    /**
     * Gets one toolbar.
     *
     * @param toolbarId the toolbar id
     * @return the one toolbar
     */
    public ToolbarInfo getOneToolbar(int toolbarId) {
        if (toolbars == null || toolbars.indexOfKey(toolbarId) < 0) {
            return null;
        }
        return toolbars.get(toolbarId);
    }

    /**
     * Gets all fragments.
     *
     * @return the all fragments
     */
    public SparseArray<ToolbarMenu_Fragment> getAllFragments() {
        return fragments;
    }

    /**
     * Gets all toolbar.
     *
     * @return the all toolbar
     */
    public SparseArray<ToolbarInfo> getAllToolbar() {
        return toolbars;
    }
}
