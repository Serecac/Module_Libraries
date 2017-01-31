package com.ml.version;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ml.utils.utils.Utils_Dimen;

/**
 * <p> Class ForceUpdateDialog </p>
 * Dialog for show a new update is available and mandatory
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class ForceUpdateDialog extends Dialog {

    private final double PERCENTAGE_WIDH = 0.95;
    private final double PERCENTAGE_HEIGHT = 0.35;
    private final float PERCENTAGE_BUTTONTEXSIZE = 0.022f;
    private final float PERCENTAGE_TITLETEXSIZE = 0.026f;

    private VersionConfig config;
    private Context context;
    private OnUpdateListener onUpdateListener;

    private TextView updateText;
    private TextView descriptionText;
    private TextView titleText;

    private LinearLayout updateButton;

    private Dialog instance;

    /**
     * Instantiates a new ForceUpdateDialog.
     *
     * @param context the context
     * @param config  the config
     */
    public ForceUpdateDialog(Context context, VersionConfig config) {
        super(context);
        this.config = config;
        this.context = context;
        init();
        setDefaultListener();
    }

    private void init() {

        this.instance = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_forceupdate);
        this.setCancelable(false);

        //Set dialog size
        getWindow().setLayout((int) (config.getParentWidth() * PERCENTAGE_WIDH), (int) (config.getParentHeight() * PERCENTAGE_HEIGHT));

        findViews();
        setColor();
        setDinamicSize();
        prepareListeners();
    }

    /**
     * Find views.
     */
    public void findViews() {
        updateText = (TextView) findViewById(R.id.forceupdate_update_text);
        titleText = (TextView) findViewById(R.id.forceupdate_title_text);
        descriptionText = (TextView) findViewById(R.id.forceupdate_description_text);

        updateButton = (LinearLayout) findViewById(R.id.forceupdate_update_button);

        if (descriptionText != null)
            descriptionText.setText(config.getTextUpdate());
    }

    /**
     * Set color.
     */
    public void setColor() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.forceupdate_mainLayout);
        layout.setBackgroundColor(config.getDialogMainColor());

        LinearLayout topLine = (LinearLayout) findViewById(R.id.forceupdate_line_topseparator);
        topLine.setBackgroundColor(config.getDialogTextColor());

        this.titleText.setTextColor(config.getDialogTextColor());
        this.updateText.setTextColor(config.getDialogTextColor());
        this.descriptionText.setTextColor(config.getDialogTextColor());
    }

    /**
     * Set default listener.
     */
    public void setDefaultListener() {

        onUpdateListener = new OnUpdateListener() {
            @Override
            public void onUpdate(Dialog dialog) {
                dialog.dismiss();
            }
        };
    }

    /**
     * Prepare listeners.
     */
    public void prepareListeners() {

        this.updateButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    updateButton.setBackgroundColor(config.getDialogSecondColor());
                    updateText.setTextColor(config.getDialogMainColor());
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    updateButton.setBackgroundColor(config.getDialogMainColor());
                    updateText.setTextColor(config.getDialogTextColor());
                }

                return false;
            }
        });

        this.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUpdateListener.onUpdate(instance);
            }
        });
    }

    /**
     * Set dinamic size.
     */
    public void setDinamicSize() {
        updateText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        titleText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_TITLETEXSIZE));
        descriptionText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_TITLETEXSIZE));
    }

    /**
     * Sets on update listener.
     *
     * @param onUpdateListener the onUpdateListener
     */
    public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.onUpdateListener = onUpdateListener;
    }

    /**
     * The interface On update listener.
     */
    public interface OnUpdateListener {
        /**
         * On update.
         *
         * @param dialog the dialog
         */
        void onUpdate(Dialog dialog);
    }
}
