package com.ml.architecture.ui.basic.childs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ml.architecture.ui.basic.Basic_ArquitectureException;

import static com.ml.architecture.ui.basic.Basic_ArquitectureException.BASIC_EXCEPTION_BADARGUMENTS;


/**
 * <p> Class Basic_Fragment </p>
 * Custom fragment for Basic arquitecture
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public abstract class Basic_Fragment extends Fragment {

    /**
     * The constant KEY_BASEFRAGMENT_ID.
     */
    public static final String KEY_BASEFRAGMENT_ID = "basefragment_id";
    /**
     * The constant KEY_BASEFRAGMENT_PARENTID.
     */
    public static final String KEY_BASEFRAGMENT_PARENTID = "basefragment_parentId";
    /**
     * The constant KEY_BASEFRAGMENT_FRAGMENTNAME.
     */
    public static final String KEY_BASEFRAGMENT_FRAGMENTNAME = "basefragment_name";

    private int fragmentId = -1;
    private int parentId = -1;
    private String fragmentName = "";

    /**
     * The Root view.
     */
    protected View rootView;
    /**
     * The Father activity.
     */
    protected Context fatherActivity;

    /**
     * Instantiates a new Basic_Fragment.
     */
    public Basic_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return createCustomView(inflater, container, savedInstanceState, null);
    }

    /**
     * Create custom view view.
     *
     * @param inflater           the inflater
     * @param container          the container
     * @param savedInstanceState the saved instance state
     * @param childView          the child view
     * @return the view
     */
    protected View createCustomView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View childView) {

        rootView = childView;
        fatherActivity = getActivity();

        return childView;  //Returns only what the child will pass
    }

    /**
     * Apply arguments.
     */
    public void applyArguments() {
        try {
            Bundle arguments = this.getArguments();
            fragmentId = arguments.getInt(KEY_BASEFRAGMENT_ID, 0);
            parentId = arguments.getInt(KEY_BASEFRAGMENT_PARENTID, 0);
            fragmentName = arguments.getString(KEY_BASEFRAGMENT_FRAGMENTNAME, "");
        } catch (Exception exce) {
            throw new Basic_ArquitectureException(BASIC_EXCEPTION_BADARGUMENTS,exce);
        }
    }


    /**
     * Gets fragment id.
     *
     * @return the fragment id
     */
    public int getFragmentId() {
        return fragmentId;
    }

    /**
     * Sets fragment id.
     *
     * @param fragmentId the fragment id
     */
    public void setFragmentId(int fragmentId) {
        this.fragmentId = fragmentId;
    }

    /**
     * Gets parent id.
     *
     * @return the parent id
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * Sets parent id.
     *
     * @param parentId the parent id
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * Gets fragment name.
     *
     * @return the fragment name
     */
    public String getFragmentName() {
        return fragmentName;
    }

    /**
     * Sets fragment name.
     *
     * @param fragmentName the fragment name
     */
    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }

    /**
     * On refresh.
     */
    public abstract void onRefresh();

    /**
     * Destroy view.
     */
    protected void destroyView(){
        rootView = null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeDependencyInjector();
    }

    /**
     * Initialize dependency injector.
     */
    protected abstract void initializeDependencyInjector();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        removeDependencyInjector();
    }

    /**
     * Remove dependency injector.
     */
    protected abstract void removeDependencyInjector();
}
