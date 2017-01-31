package com.ml.menu;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ml.menu.items.MenuAdapter;
import com.ml.menu.items.MenuGenericItem;
import com.ml.utils.utils.Utils_View;

import static com.ml.menu.MenuException.MENU_EXCEPTION_BLOCKMENU;
import static com.ml.menu.MenuGenericException.MENU_EXCEPTION_NOTCREATED;

/**
 * <p> Class MenuManager </p>
 * Controls print, events, state of horizontal menu
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class MenuManager {

    private static MenuManager instance = null;

    private View parentView;
    private MenuConfig menuConfig;
    private MenuGenericItem[] menuItems;
    private Context context;
    private MenuListener menuListener;

    private boolean isMenuOpened = false;
    private int idSelectItem = -1;

    private View shadowView;
    private ChildInterceptDrawerLayout menuDrawerLayout;
    private ListView menuListView;

    private MenuAdapter menuAdapter;

    /**
     * Instantiates a new MenuManager.
     *
     * @param context      the context
     * @param parentView   the parent view
     * @param menuConfig   the menu config
     * @param menuItems    the menu items
     * @param menuListener the menu listener
     */
    public MenuManager(Context context, View parentView, MenuConfig menuConfig, MenuGenericItem[] menuItems, MenuListener menuListener){
        this.parentView = parentView;
        this.menuConfig = menuConfig;
        this.menuItems = menuItems;
        this.context = context;
        this.menuListener = menuListener;

        prepareMenu();
    }

    /**
     * Init.
     *
     * @param context      the context
     * @param parentView   the parent view
     * @param menuConfig   the menu config
     * @param menuItems    the menu items
     * @param menuListener the menu listener
     */
    public static void init(Context context, View parentView, MenuConfig menuConfig, MenuGenericItem[] menuItems, MenuListener menuListener){
        instance = new MenuManager(context,parentView, menuConfig, menuItems, menuListener);

    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws MenuGenericException the menu generic exception
     */
    public static MenuManager getInstance() throws MenuGenericException {

        if (instance == null)
            throw new MenuGenericException(MENU_EXCEPTION_NOTCREATED);

        return instance;
    }

    private void prepareMenu(){

        shadowView = parentView.findViewById(menuConfig.getShadowId());
        if (shadowView != null) {
            shadowView.getBackground().setAlpha(0);
        }

        menuDrawerLayout = (ChildInterceptDrawerLayout) parentView.findViewById(menuConfig.getMenuId());
        if (menuDrawerLayout != null) {

            if (menuConfig.getChildInterceptId() != 0)
                menuDrawerLayout.setInterceptTouchEventChildId(menuConfig.getChildInterceptId());

            menuDrawerLayout.setScrimColor(Color.TRANSPARENT);
            menuDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
                @Override
                public void onDrawerSlide(View drawerView, float slideOffset) {

                    menuListener.onMenuSlide(isMenuOpened, slideOffset);
                    if (shadowView != null) {
                        shadowView.getBackground().setAlpha((int) (slideOffset * 255));
                    }
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    Utils_View.sendViewToFront(drawerView);
                    isMenuOpened = true;
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    Utils_View.sendViewToBack(drawerView);
                    isMenuOpened = false;
                }

                @Override
                public void onDrawerStateChanged(int newState) {
                    if (newState == DrawerLayout.STATE_IDLE) {
                        menuListener.onStateChanged(isMenuOpened);
                    }
                }
            });

            if (menuItems != null && menuItems.length > 0) {
                idSelectItem = menuItems[0].getId();
            }

            menuListView = (ListView) parentView.findViewById(menuConfig.getListviewId());
            if (menuListView != null) {
                menuAdapter = new MenuAdapter(context, menuItems[0].getLayout(), menuItems,idSelectItem);
                menuListView.setAdapter(menuAdapter);
                menuListView.setOnItemClickListener(new MenuItemClickListener());
            }
        }
    }

    private class MenuItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            MenuGenericItem selectedItem = menuItems[position];
            idSelectItem = selectedItem.getId();
            menuListener.onMenuItemClick(selectedItem.getId());
            menuAdapter.updateSelectedItem(idSelectItem);
            view.invalidate();
            menuAdapter.notifyDataSetChanged();
        }
    }

    /**
     * Block or unblock menu.
     *
     * @param mustBlock the must block
     */
    public void blockMenu(boolean mustBlock){ try {
        if (mustBlock) {
            menuDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            menuDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }

    } catch (Exception exce) {
        throw new MenuException(MENU_EXCEPTION_BLOCKMENU,exce);
    }}

    /**
     * Check if menu is open
     *
     * @return the boolean
     */
    public boolean isMenuOpen() {
        return menuDrawerLayout != null && menuDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    /**
     * Open menu.
     */
    public void openMenu(){
        menuDrawerLayout.openDrawer(GravityCompat.START);
    }

    /**
     * Close menu.
     */
    public void closeMenu() {
        menuDrawerLayout.closeDrawers();
    }
}
