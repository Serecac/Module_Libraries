package com.ml.architecture.ui.basic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;

import com.ml.architecture.ui.basic.childs.Basic_Fragment;

import java.util.ArrayList;

import static com.ml.architecture.ui.basic.Basic_ArquitectureException.BASIC_EXCEPTION_CHANGEFRAGMENT;
import static com.ml.architecture.ui.basic.Basic_ArquitectureException.BASIC_EXCEPTION_FAILLAYOUT;

/**
 * <p> Class Basic_Activity </p>
 * Custom activity for Basic arquitecture
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public abstract class Basic_Activity extends AppCompatActivity {

    private Basic_Config config;

    /**
     * The Childs.
     */
    protected SparseArray<Basic_Fragment> childs = null;
    /**
     * The Actual fragment id.
     */
    protected int actualFragmentId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        config = getConfiguration();

        try {
            setContentView(config.getActivityLayout());
        } catch (Exception exce) {
            throw new Basic_ArquitectureException(BASIC_EXCEPTION_FAILLAYOUT,exce);
        }

        createChilds();

        if (childs != null && childs.get(config.getFirstFragmentId()) != null)
            changeFragment(config.getFirstFragmentId(), false, 0, 0);
    }

    /**
     * Change fragment.
     *
     * @param fragmentId the fragment id
     * @param anim       the anim
     * @param iniAnimID  the ini anim id
     * @param outAnimID  the out anim id
     */
    public void changeFragment(int fragmentId, boolean anim, int iniAnimID, int outAnimID) {

        try {
            Fragment fragment = childs.get(fragmentId);

            if (fragment == null) {
                return;
            }

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (anim) {
                ft.setCustomAnimations(iniAnimID, outAnimID);
            }

            ft.replace(config.getFragmentLayoutId(), fragment, config.getFragmentTag());
            ft.commitAllowingStateLoss();

            actualFragmentId = fragmentId;

        } catch (Exception exce) {
            throw new Basic_ArquitectureException(BASIC_EXCEPTION_CHANGEFRAGMENT,exce);
        }
    }

    /**
     * Create childs.
     */
    protected abstract void createChilds();

    /**
     * Gets configuration.
     *
     * @return the configuration
     */
    protected abstract Basic_Config getConfiguration();
}
