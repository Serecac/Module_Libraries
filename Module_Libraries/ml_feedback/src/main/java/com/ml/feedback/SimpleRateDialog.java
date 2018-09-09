package com.ml.feedback;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ml.utils.utils.Utils_Dimen;

@SuppressWarnings({"unused", "WeakerAccess", "FieldCanBeLocal"})
public class SimpleRateDialog extends Dialog {

    private final double PERCENTAGE_WIDH = 0.95;
    private final double PERCENTAGE_HEIGHT = 0.45;
    private final float PERCENTAGE_BUTTONTEXSIZE = 0.022f;
    private final float PERCENTAGE_BODYTEXSIZE = 0.024f;
    private final float PERCENTAGE_TITLETEXSIZE = 0.027f;

    private FeedbackConfig config;
    private Context context;
    private Listener listener;

    private TextView noRateText;
    private TextView rateText;
    private TextView remindLaterText;
    private TextView titleText;
    private TextView bodyText;

    private LinearLayout noRateButton;
    private LinearLayout rateButton;
    private LinearLayout remindLaterButton;
    private LinearLayout titleBody;

    private Dialog instance;

    public SimpleRateDialog(Context context, FeedbackConfig config) {
        super(context);
        this.config = config;
        this.context = context;
        init();
        setDefaultListener();
    }

    private void init() {

        this.instance = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_simplerate);
        this.setCancelable(true);

        //Set dialog size
        getWindow().setLayout((int) (config.getParentWidth() * PERCENTAGE_WIDH), (int) (config.getParentHeight() * PERCENTAGE_HEIGHT));

        findViews();
        setColor();
        setDinamicSize();
        prepareListeners();
        setTypeface();
    }

    public void findViews() {
        noRateText = (TextView) findViewById(R.id.simplerate_norate_text);
        rateText = (TextView) findViewById(R.id.simplerate_rate_text);
        remindLaterText = (TextView) findViewById(R.id.simplerate_remindLater_text);
        titleText = (TextView) findViewById(R.id.simplerate_title_text);
        bodyText = (TextView) findViewById(R.id.simplerate_body_text);

        noRateButton = (LinearLayout) findViewById(R.id.simplerate_norate_button);
        rateButton = (LinearLayout) findViewById(R.id.simplerate_rate_button);
        remindLaterButton = (LinearLayout) findViewById(R.id.simplerate_remindLater_button);
        titleBody = (LinearLayout) findViewById(R.id.simplerate_title_body);
    }

    public void setColor() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.simplerate_mainLayout);
        layout.setBackgroundColor(Color.WHITE);

        LinearLayout topLine = (LinearLayout) findViewById(R.id.simplerate_line_topseparator);
        topLine.setBackgroundColor(config.getDialogMainColor());

        LinearLayout firstLine = (LinearLayout) findViewById(R.id.simplerate_line_firstBottomSeparator);
        firstLine.setBackgroundColor(config.getDialogMainColor());

        LinearLayout secondLine = (LinearLayout) findViewById(R.id.simplerate_line_secondBottomSeparator);
        secondLine.setBackgroundColor(config.getDialogMainColor());

        this.titleBody.setBackgroundColor(config.getDialogMainColor());
        this.titleText.setTextColor(Color.WHITE);
        this.bodyText.setTextColor(Color.BLACK);
        this.noRateText.setTextColor(Color.BLACK);
        this.rateText.setTextColor(Color.BLACK);
        this.remindLaterText.setTextColor(Color.BLACK);
    }

    public void setDefaultListener() {
        listener = new Listener() {
            @Override
            public void onRate(Dialog dialog) {
                dialog.dismiss();
            }

            @Override
            public void onNoRate(Dialog dialog) {
                dialog.dismiss();
            }

            @Override
            public void onRemindLater(Dialog dialog) {
                dialog.dismiss();
            }
        };
    }

    public void setTypeface() {

        if (config.isHasTypeface() && config.getTypeface() != null) {
            this.titleText.setTypeface(config.getTypeface());
            this.noRateText.setTypeface(config.getTypeface());
            this.rateText.setTypeface(config.getTypeface());
            this.remindLaterText.setTypeface(config.getTypeface());
            this.bodyText.setTypeface(config.getTypeface());
        }
    }

    @SuppressLint("ClickableViewAccessibility")
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
                listener.onNoRate(instance);
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
                listener.onRate(instance);
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
                listener.onRemindLater(instance);
            }
        });
    }

    public void setDinamicSize() {

        noRateText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        remindLaterText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        rateText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        titleText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_TITLETEXSIZE));
        titleText.setTextSize(Utils_Dimen.pixelsToSp(context, config.getParentHeight() * PERCENTAGE_BODYTEXSIZE));
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener{
        void onRate(Dialog dialog);
        void onNoRate(Dialog dialog);
        void onRemindLater(Dialog dialog);
    }
}
