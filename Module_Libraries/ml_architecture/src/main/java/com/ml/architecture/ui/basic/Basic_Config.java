package com.ml.architecture.ui.basic;

/**
 * <p> Class Basic_Config </p>
 * Configuration for Basic_Activity
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Basic_Config {

    private int activityLayout = -1;
    private int fragmentLayoutId = -1;
    private String fragmentTag = "";
    private int firstFragmentId = -1;

    /**
     * Instantiates a new Basic_Config.
     */
    public Basic_Config() {
    }

    /**
     * Instantiates a new Basic_Config.
     *
     * @param activityLayout   the activity layout
     * @param fragmentLayoutId the fragment layout id
     * @param fragmentTag      the fragment tag
     * @param firstFragmentId  the first fragment id
     */
    public Basic_Config(int activityLayout, int fragmentLayoutId, String fragmentTag, int firstFragmentId) {
        this.activityLayout = activityLayout;
        this.fragmentLayoutId = fragmentLayoutId;
        this.fragmentTag = fragmentTag;
        this.firstFragmentId = firstFragmentId;
    }

    /**
     * Gets activity layout.
     *
     * @return the activity layout
     */
    public int getActivityLayout() {
        return activityLayout;
    }

    /**
     * Sets activity layout.
     *
     * @param activityLayout the activity layout
     */
    public void setActivityLayout(int activityLayout) {
        this.activityLayout = activityLayout;
    }

    /**
     * Gets fragment layout id.
     *
     * @return the fragment layout id
     */
    public int getFragmentLayoutId() {
        return fragmentLayoutId;
    }

    /**
     * Sets fragment layout id.
     *
     * @param fragmentLayoutId the fragment layout id
     */
    public void setFragmentLayoutId(int fragmentLayoutId) {
        this.fragmentLayoutId = fragmentLayoutId;
    }

    /**
     * Gets fragment tag.
     *
     * @return the fragment tag
     */
    public String getFragmentTag() {
        return fragmentTag;
    }

    /**
     * Sets fragment tag.
     *
     * @param fragmentTag the fragment tag
     */
    public void setFragmentTag(String fragmentTag) {
        this.fragmentTag = fragmentTag;
    }

    /**
     * Gets first fragment id.
     *
     * @return the first fragment id
     */
    public int getFirstFragmentId() {
        return firstFragmentId;
    }

    /**
     * Sets first fragment id.
     *
     * @param firstFragmentId the first fragment id
     */
    public void setFirstFragmentId(int firstFragmentId) {
        this.firstFragmentId = firstFragmentId;
    }
}
