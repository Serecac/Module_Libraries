package com.ml.toolbar;

/**
 * <p> Interface ToolbarListener </p>
 * Interface for setting listener for toolbar events
 *
 * @author jcaceres
 * @version 1.0.0
 */
public interface ToolbarListener {

    /**
     * On main icon click.
     *
     * @param action the action
     */
    void onMainIconClick(int action);

    /**
     * On first icon click.
     */
    void onFirstIconClick();

    /**
     * On second icon click.
     */
    void onSecondIconClick();
}
