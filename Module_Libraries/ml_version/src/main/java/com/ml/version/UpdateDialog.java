package com.ml.version;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ml.utils.utils.Utils_Dialog;
import com.ml.utils.utils.Utils_Dimen;

public class UpdateDialog extends Dialog {

    private final double PERCENTAGE_WIDH = 0.95;
    private final double PERCENTAGE_HEIGHT = 0.35;
    private final float PERCENTAGE_BUTTONTEXSIZE = 0.022f;
    private final float PERCENTAGE_TITLETEXSIZE = 0.026f;

    private VersionConfig config;
    private Context context;
    private OnNoUpdateListener onNoUpdateListener;
    private OnUpdateListener onUpdateListener;

    private TextView noUpdateText;
    private TextView updateText;
    private TextView descriptionText;
    private TextView titleText;

    private LinearLayout noUpdateButton;
    private LinearLayout updateButton;

    private Dialog instance;

    public UpdateDialog(Context context, VersionConfig config) {
        super(context);
        this.config = config;
        this.context = context;
        init();
        setDefaultListener();
    }

    private void init() {

        this.instance = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_update);
        this.setCancelable(true);

        //Set dialog size
        getWindow().setLayout((int) (config.getParentWidth() * PERCENTAGE_WIDH), (int) (config.getParentHeight() * PERCENTAGE_HEIGHT));

        findViews();
        setColor();
        setDinamicSize();
        setTypeface();
        prepareListeners();
    }

    /**
     * Find views.
     */
    public void findViews() {
        noUpdateText = (TextView) findViewById(R.id.update_noUpdate_text);
        updateText = (TextView) findViewById(R.id.update_update_text);
        titleText = (TextView) findViewById(R.id.update_title_text);
        descriptionText = (TextView) findViewById(R.id.update_description_text);

        noUpdateButton = (LinearLayout) findViewById(R.id.update_noUpdate_button);
        updateButton = (LinearLayout) findViewById(R.id.update_update_button);

        if (descriptionText != null)
            descriptionText.setText(config.getTextUpdate());
    }

    /**
     * Set color.
     */
    public void setColor() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.update_mainLayout);
        layout.setBackgroundColor(config.getDialogMainColor());

        LinearLayout topLine = (LinearLayout) findViewById(R.id.update_line_topseparator);
        topLine.setBackgroundColor(config.getDialogTextColor());

        LinearLayout bottomLine = (LinearLayout) findViewById(R.id.update_line_bottomSeparator);
        bottomLine.setBackgroundColor(config.getDialogTextColor());

        this.titleText.setTextColor(config.getDialogTextColor());
        this.noUpdateText.setTextColor(config.getDialogTextColor());
        this.updateText.setTextColor(config.getDialogTextColor());
        this.descriptionText.setTextColor(config.getDialogTextColor());
    }

    /**
     * Set typeface
     */
    public void setTypeface(){

        if (config.isHasTypeface() && config.getTypeface() != null){
            this.titleText.setTypeface(config.getTypeface());
            this.noUpdateText.setTypeface(config.getTypeface());
            this.updateText.setTypeface(config.getTypeface());
            this.descriptionText.setTypeface(config.getTypeface());
        }
    }

    /**
     * Set default listener.
     */
    public void setDefaultListener() {
        onNoUpdateListener = new OnNoUpdateListener() {
            @Override
            public void onNoUpdate(Dialog dialog) {
                dialog.dismiss();
            }
        };

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

        this.noUpdateButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    noUpdateButton.setBackgroundColor(config.getDialogSecondColor());
                    noUpdateText.setTextColor(config.getDialogMainColor());
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    noUpdateButton.setBackgroundColor(config.getDialogMainColor());
                    noUpdateText.setTextColor(config.getDialogTextColor());
                }

                return false;
            }
        });

        this.noUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNoUpdateListener.onNoUpdate(instance);
            }
        });

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

        noUpdateText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        updateText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        titleText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_TITLETEXSIZE));
        descriptionText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_TITLETEXSIZE));
    }

    /**
     * Sets on no update listener.
     *
     * @param onNoUpdateListener the on no update listener
     */
    public void setOnNoUpdateListener(OnNoUpdateListener onNoUpdateListener) {
        this.onNoUpdateListener = onNoUpdateListener;
    }

    /**
     * Sets on update listener.
     *
     * @param onUpdateListener the on update listener
     */
    public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.onUpdateListener = onUpdateListener;
    }

    /**
     * The interface On no update listener.
     */
    public interface OnNoUpdateListener {
        /**
         * On no update.
         *
         * @param dialog the dialog
         */
        void onNoUpdate(Dialog dialog);
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
