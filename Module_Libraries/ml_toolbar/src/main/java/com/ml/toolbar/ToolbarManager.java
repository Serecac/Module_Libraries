package com.ml.toolbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ml.toolbar.main_icon.MainIcon;
import com.ml.toolbar.main_icon.MainIcon_MaterialMenu;
import com.ml.utils.utils.Utils_Toolbar;

import static com.ml.toolbar.ToolbarGenericException.TOOLBAR_EXCEPTION_NOTCREATED;

/**
 * <p> Class ToolbarManager </p>
 * Control and change toolbar styles and events
 *
 * @author jcaceres
 * @version 1.0.0
 */
public class ToolbarManager {

    private Context context;

    private static ToolbarManager instance = null;

    private int mainAction = 0;
    private MainIcon mainIcon = null;

    private ImageButton firstButton = null;
    private ImageButton secondButton = null;
    private TextView titleTexview = null;

    private ToolbarConfig toolbarConfig = null;
    private Toolbar toolbar = null;
    private ToolbarListener listener = null;
    private View parentView;

    /**
     * Instantiates a new ToolbarManager.
     *
     * @param context       the context
     * @param parentView    the parent view
     * @param toolbarConfig the toolbar config
     * @param listener      the listener
     */
    public ToolbarManager(Context context, View parentView, ToolbarConfig toolbarConfig, ToolbarListener listener) {
        this.context = context;
        this.parentView = parentView;
        this.listener = listener;
        this.toolbarConfig = toolbarConfig;
        prepareToolbar();
    }

    /**
     * Init.
     *
     * @param context       the context
     * @param parentView    the parent view
     * @param toolbarConfig the toolbar config
     * @param listener      the listener
     */
    public static void init(Context context, View parentView, ToolbarConfig toolbarConfig, ToolbarListener listener){
        instance = new ToolbarManager(context,parentView,toolbarConfig,listener);
    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws ToolbarGenericException the toolbar generic exception
     */
    public static ToolbarManager getInstance() throws ToolbarGenericException {

        if (instance == null)
            throw new ToolbarGenericException(TOOLBAR_EXCEPTION_NOTCREATED);

        return instance;
    }

    private void prepareToolbar(){

        this.toolbar = (Toolbar) parentView.findViewById(toolbarConfig.getToolbarId());
        this.titleTexview = (TextView) toolbar.findViewById(toolbarConfig.getToolbatTitleId());
        this.firstButton = (ImageButton) toolbar.findViewById(toolbarConfig.getToolbarFirsButtonId());
        this.secondButton = (ImageButton) toolbar.findViewById(toolbarConfig.getToolbarSecondButtonId());

        titleTexview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "msg msg", Toast.LENGTH_SHORT).show();

            }
        });

        if (firstButton != null) {
            ((View) firstButton.getParent()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFirstIconClick();
                }
            });
        }

        if (secondButton != null) {
            ((View) secondButton.getParent()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSecondIconClick();
                }
            });
        }

        this.mainIcon = new MainIcon_MaterialMenu();
        this.mainIcon.create((Activity)context, toolbarConfig.getToolbarId());

        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMainIconClick(mainAction);
            }
        });
    }

    /**
     * Change toolbar style.
     *
     * @param info the info
     */
    public void changeToolbar(ToolbarInfo info) {
        changeToolbarGeneral(info.getImageFirstIcon(), info.isFirstIcon(), info.getImageSecondIcon(), info.isSecondIcon(), info.getTitle());
        if (info.isMainIcon()) {
            changeToolbarMainIcon(info.getActionMainIcon(), info.getColorMainIcon(), info.isMainIcon());
        }
    }

    private void changeToolbarMainIcon(int mainAction, int color, boolean isMainButton) {

        this.mainAction = mainAction;
        this.mainIcon.animateState(mainAction);
        this.mainIcon.setColor(isMainButton,color);
    }

    private void changeToolbarGeneral(int imageFirstIcon, boolean isFirstIcon, int imageSecondIcon, boolean isSecondIcon, String title) {

        if (firstButton != null) {
            if (isFirstIcon) {
                if (toolbarConfig.isAnimated()) {
                    Animation anim = AnimationUtils.loadAnimation(context, R.anim.toolbar_buttons_first);
                    ((View) firstButton.getParent()).startAnimation(anim);
                }
                ((View) firstButton.getParent()).setVisibility(View.VISIBLE);
                firstButton.setImageResource(imageFirstIcon);
            } else {
                ((View) firstButton.getParent()).setVisibility(View.INVISIBLE);
            }
        }

        if (secondButton != null) {
            if (isSecondIcon) {
                if (toolbarConfig.isAnimated()) {
                    Animation anim = AnimationUtils.loadAnimation(context, R.anim.toolbar_buttons_second);
                    ((View) secondButton.getParent()).startAnimation(anim);
                }
                ((View) secondButton.getParent()).setVisibility(View.VISIBLE);
                secondButton.setImageResource(imageSecondIcon);
            } else {
                ((View) secondButton.getParent()).setVisibility(View.INVISIBLE);
            }
        }

        if (titleTexview != null) {
            titleTexview.setText(title);
        }
    }

    /**
     * Gets main icon action.
     *
     * @return the main action
     */
    public int getMainAction() {
        return mainAction;
    }

    /**
     * Sets main icon action.
     *
     * @param mainAction the main action
     */
    public void setMainAction(int mainAction) {
        this.mainAction = mainAction;
    }

    /**
     * Set mainIcon state.
     *
     * @param state the state
     */
    public void setMainIconState(int state){
        mainIcon.setState(state);
    }

    public void setSaveActionIconState(){
        mainIcon.setState(mainAction);
    }


    /**
     * Set mainIcon slide offset.
     *
     * @param isMenuOpen the is menu open
     * @param offset     the offset
     */
    public void setMainIconSlide(boolean isMenuOpen, float offset){
        mainIcon.onSlide(isMenuOpen,offset,mainAction);
    }

    /**
     * Load mainIcon.
     *
     * @param savedInstanceState the saved instance state
     */
    public void loadStateMainIcon(Bundle savedInstanceState){
        mainIcon.loadState(savedInstanceState);
    }

    /**
     * Save state main icon.
     *
     * @param savedInstanceState the saved instance state
     */
    public void saveStateMainIcon(Bundle savedInstanceState){
        mainIcon.saveState(savedInstanceState);
    }
}
