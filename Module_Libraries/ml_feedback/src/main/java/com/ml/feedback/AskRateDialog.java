package com.ml.feedback;

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

/**
 * <p> Class AskRateDialog </p>
 * Dialog for getting feedback from users and good rates on Play Store
 *
 * @author Javier Cáceres
 * @version 1.0.0
 * @see BadRateDialog
 */
public class AskRateDialog extends Dialog {

    private final double PERCENTAGE_WIDH = 0.95;
    private final double PERCENTAGE_HEIGHT = 0.35;
    private final float PERCENTAGE_BUTTONTEXSIZE = 0.022f;
    private final float PERCENTAGE_TITLETEXSIZE = 0.027f;

    private FeedbackConfig config;
    private Context context;
    private OnRemindLaterListener onRemindLaterListener;
    private OnNoRateListener onNoRateListener;
    private OnRateListener onRateListener;

    private TextView noRateText;
    private TextView rateText;
    private TextView remindLaterText;
    private TextView titleText;

    private ImageView star_1_image;
    private ImageView star_2_image;
    private ImageView star_3_image;
    private ImageView star_4_image;
    private ImageView star_5_image;

    private LinearLayout star_1_button;
    private LinearLayout star_2_button;
    private LinearLayout star_3_button;
    private LinearLayout star_4_button;
    private LinearLayout star_5_button;

    private LinearLayout noRateButton;
    private LinearLayout rateButton;
    private LinearLayout remindLaterButton;

    private Dialog instance;
    private int countStart = 0;

    /**
     * Instantiates a new Ask rate dialog.
     *
     * @param context the context
     * @param config  the config
     */
    public AskRateDialog(Context context, FeedbackConfig config) {
        super(context);
        this.config = config;
        this.context = context;
        init();
        setDefaultListener();
    }

    private void init() {

        this.instance = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_askrate);
        this.setCancelable(true);

        //Set dialog size
        getWindow().setLayout((int) (config.getParentWidth() * PERCENTAGE_WIDH), (int) (config.getParentHeight() * PERCENTAGE_HEIGHT));

        findViews();
        setColor();
        setDinamicSize();
        prepareListeners();
        setTypeface();
        setStarLogic();
    }

    /**
     * Find views.
     */
    public void findViews() {
        noRateText = (TextView) findViewById(R.id.askrate_norate_text);
        rateText = (TextView) findViewById(R.id.askrate_rate_text);
        remindLaterText = (TextView) findViewById(R.id.askrate_remindLater_text);
        titleText = (TextView) findViewById(R.id.askrate_title_text);

        noRateButton = (LinearLayout) findViewById(R.id.askrate_norate_button);
        rateButton = (LinearLayout) findViewById(R.id.askrate_rate_button);
        remindLaterButton = (LinearLayout) findViewById(R.id.askrate_remindLater_button);

        star_1_image = (ImageView) findViewById(R.id.askrate_firstrate_image);
        star_2_image = (ImageView) findViewById(R.id.askrate_secondrate_image);
        star_3_image = (ImageView) findViewById(R.id.askrate_thirdrate_image);
        star_4_image = (ImageView) findViewById(R.id.askrate_fourthrstrate_image);
        star_5_image = (ImageView) findViewById(R.id.askrate_fifthrate_image);

        star_1_button = (LinearLayout) findViewById(R.id.askrate_firstrate_button);
        star_2_button = (LinearLayout) findViewById(R.id.askrate_secondrate_button);
        star_3_button = (LinearLayout) findViewById(R.id.askrate_thirdrate_button);
        star_4_button = (LinearLayout) findViewById(R.id.askrate_fourthrstrate_button);
        star_5_button = (LinearLayout) findViewById(R.id.askrate_fifthrate_button);
    }


    /**
     * Set color.
     */
    public void setColor() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.askrate_mainLayout);
        layout.setBackgroundColor(config.getDialogMainColor());

        LinearLayout topLine = (LinearLayout) findViewById(R.id.askrate_line_topseparator);
        topLine.setBackgroundColor(config.getDialogTextColor());

        LinearLayout firstLine = (LinearLayout) findViewById(R.id.askrate_line_firstBottomSeparator);
        firstLine.setBackgroundColor(config.getDialogTextColor());

        LinearLayout secondLine = (LinearLayout) findViewById(R.id.askrate_line_secondBottomSeparator);
        secondLine.setBackgroundColor(config.getDialogTextColor());

        this.titleText.setTextColor(config.getDialogTextColor());
        this.noRateText.setTextColor(config.getDialogTextColor());
        this.rateText.setTextColor(config.getDialogTextColor());
        this.remindLaterText.setTextColor(config.getDialogTextColor());
    }

    /**
     * Set default listener.
     */
    public void setDefaultListener() {
        onRemindLaterListener = new OnRemindLaterListener() {
            @Override
            public void onRemindLater(Dialog dialog) {
                dialog.dismiss();
            }
        };

        onNoRateListener = new OnNoRateListener() {
            @Override
            public void onNoRate(Dialog dialog) {
                dialog.dismiss();
            }
        };

        onRateListener = new OnRateListener() {
            @Override
            public void onRate(Dialog dialog, int countStars) {
                dialog.dismiss();
            }
        };
    }

    /**
     * Set typeface
     */
    public void setTypeface() {

        if (config.isHasTypeface() && config.getTypeface() != null) {
            this.titleText.setTypeface(config.getTypeface());
            this.noRateText.setTypeface(config.getTypeface());
            this.rateText.setTypeface(config.getTypeface());
            this.remindLaterText.setTypeface(config.getTypeface());
        }
    }

    /**
     * Set star logic.
     */
    public void setStarLogic() {

        star_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countStart = 1;
                printStars();
            }
        });

        star_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countStart = 2;
                printStars();
            }
        });

        star_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countStart = 3;
                printStars();
            }
        });

        star_4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countStart = 4;
                printStars();
            }
        });

        star_5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countStart = 5;
                printStars();
            }
        });
    }

    /**
     * Prepare listeners.
     */
    public void prepareListeners() {

        this.noRateButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    noRateButton.setBackgroundColor(config.getDialogSecondColor());
                    noRateText.setTextColor(config.getDialogMainColor());
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    noRateButton.setBackgroundColor(config.getDialogMainColor());
                    noRateText.setTextColor(config.getDialogTextColor());
                }

                return false;
            }
        });

        this.noRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNoRateListener.onNoRate(instance);
            }
        });

        this.rateButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    rateButton.setBackgroundColor(config.getDialogSecondColor());
                    rateText.setTextColor(config.getDialogMainColor());
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    rateButton.setBackgroundColor(config.getDialogMainColor());
                    rateText.setTextColor(config.getDialogTextColor());
                }

                return false;
            }
        });

        this.rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countStart > 0)
                    onRateListener.onRate(instance, countStart);
                else
                    Utils_Dialog.centerCustomiczeToastMessage(config.getDialogTextColor(), config.getDialogMainColor(), context.getString(R.string.askrate_messsage), context, Utils_Dialog.DURATION_LONG);
            }
        });

        this.remindLaterButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    remindLaterButton.setBackgroundColor(config.getDialogSecondColor());
                    remindLaterText.setTextColor(config.getDialogMainColor());
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    remindLaterButton.setBackgroundColor(config.getDialogMainColor());
                    remindLaterText.setTextColor(config.getDialogTextColor());
                }

                return false;
            }
        });

        this.remindLaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRemindLaterListener.onRemindLater(instance);
            }
        });
    }

    /**
     * Print stars.
     */
    public void printStars() {

        if (countStart > 4)
            star_5_image.setImageResource(R.drawable.star_1_selected);
        else
            star_5_image.setImageResource(R.drawable.star_1_unselected);

        if (countStart > 3)
            star_4_image.setImageResource(R.drawable.star_1_selected);
        else
            star_4_image.setImageResource(R.drawable.star_1_unselected);

        if (countStart > 2)
            star_3_image.setImageResource(R.drawable.star_1_selected);
        else
            star_3_image.setImageResource(R.drawable.star_1_unselected);

        if (countStart > 1)
            star_2_image.setImageResource(R.drawable.star_1_selected);
        else
            star_2_image.setImageResource(R.drawable.star_1_unselected);

        if (countStart > 0)
            star_1_image.setImageResource(R.drawable.star_1_selected);
        else
            star_1_image.setImageResource(R.drawable.star_1_unselected);
    }

    /**
     * Set dinamic size.
     */
    public void setDinamicSize() {

        noRateText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        remindLaterText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        rateText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        titleText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_TITLETEXSIZE));
    }

    /**
     * Sets on remind later listener.
     *
     * @param onRemindLaterListener the on remind later listener
     */
    public void setOnRemindLaterListener(OnRemindLaterListener onRemindLaterListener) {
        this.onRemindLaterListener = onRemindLaterListener;
    }

    /**
     * Sets on no rate listener.
     *
     * @param onNoRateListener the on no rate listener
     */
    public void setOnNoRateListener(OnNoRateListener onNoRateListener) {
        this.onNoRateListener = onNoRateListener;
    }

    /**
     * Sets on rate listener.
     *
     * @param onRateListener the on rate listener
     */
    public void setOnRateListener(OnRateListener onRateListener) {
        this.onRateListener = onRateListener;
    }

    /**
     * The interface On remind later listener.
     */
    public interface OnRemindLaterListener {
        /**
         * On remind later.
         *
         * @param dialog the dialog
         */
        void onRemindLater(Dialog dialog);
    }

    /**
     * The interface On no rate listener.
     */
    public interface OnNoRateListener {
        /**
         * On no rate.
         *
         * @param dialog the dialog
         */
        void onNoRate(Dialog dialog);
    }

    /**
     * The interface On rate listener.
     */
    public interface OnRateListener {
        /**
         * On rate.
         *
         * @param dialog     the dialog
         * @param countStars the count stars
         */
        void onRate(Dialog dialog, int countStars);
    }
}
