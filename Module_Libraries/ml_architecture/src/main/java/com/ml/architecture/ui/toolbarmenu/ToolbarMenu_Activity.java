package com.ml.architecture.ui.toolbarmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ml.architecture.ui.toolbarmenu.childs.ToolBarMenu_Childs;
import com.ml.menu.MenuListener;
import com.ml.menu.MenuManager;
import com.ml.menu.items.MenuGenericItem;
import com.ml.toolbar.ToolbarInfo;
import com.ml.toolbar.ToolbarListener;
import com.ml.toolbar.ToolbarManager;
import com.ml.toolbar.main_icon.MainIcon;

import static com.ml.architecture.ui.toolbarmenu.ToolbarMenu_ArquitectureException.TOOLBARMENU_EXCEPTION_CHANGEFRAGMENT;
import static com.ml.architecture.ui.toolbarmenu.ToolbarMenu_ArquitectureException.TOOLBARMENU_EXCEPTION_FAILLAYOUT;

public abstract class ToolbarMenu_Activity extends AppCompatActivity {

    private ToolbarMenu_Config config;
    protected ToolBarMenu_Childs childs = null;
    protected int actualFragmentId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        config = getConfiguration();

        try {
            setContentView(config.getActivityLayout());
        } catch (Exception exce) {
            throw new ToolbarMenu_ArquitectureException(TOOLBARMENU_EXCEPTION_FAILLAYOUT,exce);
        }

        createChilds();

        if (config.isWantMenu())
            MenuManager.init(this,findViewById(android.R.id.content),config.getMenuConfig(),getMenuItems(),menuListener);

        if (config.isWantToolbar()) {
            ToolbarManager.init(this, findViewById(android.R.id.content), config.getToolbarConfig(), toolbarListener);
        }

        if (childs != null && childs.getOneFragment(config.getFirstFragmentId()) != null)
            changeFragment(config.getFirstFragmentId(), false, 0, 0);
    }

    public void changeFragment(int fragmentId, boolean anim, int iniAnimID, int outAnimID) {

        try {
            Fragment fragment = childs.getOneFragment(fragmentId);
            ToolbarInfo toolbar = childs.getOneToolbar(fragmentId);

            if (fragment == null) {
                return;
            }

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (anim) {
                ft.setCustomAnimations(iniAnimID, outAnimID);
            }
            ft.replace(config.getFragmentLayoutId(), fragment, config.getFragmentTag()).commit();

            actualFragmentId = fragmentId;
            if (config.isWantToolbar())
                ToolbarManager.getInstance().changeToolbar(toolbar);

        } catch (Exception exce) {
            throw new ToolbarMenu_ArquitectureException(TOOLBARMENU_EXCEPTION_CHANGEFRAGMENT,exce);
        }
    }

    public void changeFragment(int fragmentId, boolean anim, int iniAnimID, int outAnimID, boolean saveParent) {

        if (actualFragmentId != fragmentId) {
            try {
                Fragment fragment = childs.getOneFragment(fragmentId);
                ToolbarInfo toolbar = childs.getOneToolbar(fragmentId);

                if (fragment == null) {
                    return;
                }

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (anim) {
                    ft.setCustomAnimations(iniAnimID, outAnimID);
                }
                ft.replace(config.getFragmentLayoutId(), fragment, config.getFragmentTag()).commit();

                actualFragmentId = fragmentId;
                if (config.isWantToolbar())
                    ToolbarManager.getInstance().changeToolbar(toolbar);

                if (saveParent)
                    childs.getOneFragment(fragmentId).setParentId(actualFragmentId);

            } catch (Exception exce) {
                throw new ToolbarMenu_ArquitectureException(TOOLBARMENU_EXCEPTION_CHANGEFRAGMENT, exce);
            }

        } else {
            childs.getOneFragment(actualFragmentId).onRefresh();
        }
    }


    protected void blockMenu(boolean mustBlock){
        MenuManager.getInstance().blockMenu(mustBlock);
    }

    protected void openMenu(){
        MenuManager.getInstance().openMenu();
    }

    protected void closeMenu(){
        MenuManager.getInstance().closeMenu();
    }

    private MenuListener menuListener = new MenuListener() {
        @Override
        public void onMenuItemClick(int itemId) {
            onMenuItemSelected(itemId);
        }

        @Override
        public void onMenuSlide(boolean isMenuOpened, float slideOffset) {
            if (config.isWantToolbar())
                ToolbarManager.getInstance().setMainIconSlide(isMenuOpened,slideOffset);
        }

        @Override
        public void onStateChanged(boolean isMenuOpened) {
            if (config.isWantToolbar()){
                if (isMenuOpened) {
                    ToolbarManager.getInstance().setMainIconState(MainIcon.MAIN_ACTION_BACK);
                } else {
                    ToolbarManager.getInstance().setSaveActionIconState();
                }
            }
        }
    };

    private ToolbarListener toolbarListener = new ToolbarListener() {
        @Override
        public void onMainIconClick(int action) {
            MenuManager menuManager = MenuManager.getInstance();
            if (action == MainIcon.MAIN_ACTION_MENU && config.isWantMenu()) {
                if (menuManager.isMenuOpen()) {
                    menuManager.closeMenu();
                } else {
                    menuManager.openMenu();
                }
            } else {
                if (menuManager.isMenuOpen())
                    menuManager.closeMenu();
                else
                    onClickMainBottom(action);
            }
        }

        @Override
        public void onFirstIconClick() {
            onClickFirstButton();
        }

        @Override
        public void onSecondIconClick() {
            onClickSecondButton();
        }
    };

    protected abstract ToolbarMenu_Config getConfiguration();

    protected abstract MenuGenericItem[] getMenuItems();

    protected abstract void onMenuItemSelected(int id);

    protected abstract void createChilds();

    protected abstract void onClickMainBottom(int action);

    protected abstract void onClickFirstButton();

    protected abstract void onClickSecondButton();

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (config.isWantToolbar())
            ToolbarManager.getInstance().loadStateMainIcon(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (config.isWantToolbar())
            ToolbarManager.getInstance().saveStateMainIcon(savedInstanceState);
    }
}
