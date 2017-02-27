package com.ml.utils.list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jcaceres on 04/07/2016.
 */
public class RefreshHeight_PagerAdapter extends FragmentPagerAdapter {

    /**
     * The M current position.
     */
    private int mCurrentPosition = -1;

    /**
     * List of viewpager fragments
     */
    private ArrayList<Fragment> fragments;

    /**
     * Instantiates a new Main tab pager adapter.
     *
     * @param fm        the fragmentManager
     * @param fragments list of viewpager fragments
     */
    public RefreshHeight_PagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    /**
     * Sets primary item.
     *
     * @param container the container
     * @param position  the position
     * @param object    the object
     */
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (position != mCurrentPosition) {
            Fragment fragment = (Fragment) object;
            WrapContentHeight_Refresh_ViewPager pager = (WrapContentHeight_Refresh_ViewPager) container;
            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }
    }

    /**
     * Gets item.
     *
     * @param position the position
     * @return the item
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * Gets item position.
     *
     * @param object the object
     * @return the item position
     */
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
