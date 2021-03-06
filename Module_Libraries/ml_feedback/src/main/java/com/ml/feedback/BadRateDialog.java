package com.ml.feedback;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ml.utils.utils.Utils_Dialog;
import com.ml.utils.utils.Utils_Dimen;


@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess"})
public class BadRateDialog extends Dialog {

    private final double PERCENTAGE_WIDH = 0.95;
    private final double PERCENTAGE_HEIGHT = 0.4;
    private final float PERCENTAGE_BUTTONTEXSIZE = 0.022f;
    private final float PERCENTAGE_TITLETEXSIZE = 0.027f;
    private final float PERCENTAGE_PADDING_BODY = 0.01f;
    private final float PERCENTAGE_PADDING_BODY_INTERNAL = 0.02f;
    private final float PERCENTAGE_BODYTEXSIZE = 0.02f;

    private OnSendComment onSendComment;
    private OnNoComment onNoComment;

    private TextView noCommentText;
    private TextView sendCommentText;
    private TextView titleText;

    private LinearLayout noCommentButton;
    private LinearLayout sendCommentButton;

    private LinearLayout mainLayout;
    private LinearLayout messageBody;
    private EditText messageText;

    private Dialog instance;
    private Activity activity;
    private FeedbackConfig config;

    public BadRateDialog(Activity activity, FeedbackConfig config) {
        super(activity);
        this.config = config;
        this.activity = activity;
        init();
        setDefaultListener();
    }

    private void init() {

        this.instance = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_badrate);
        this.setCancelable(true);

        //Set dialog size
        getWindow().setLayout((int) (config.getParentWidth() * PERCENTAGE_WIDH), (int) (config.getParentHeight() * PERCENTAGE_HEIGHT));

        findViews();
        setColor();
        setDinamicSize();
        prepareListeners();
        setTypeface();

        //Open Keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    public void setDefaultListener() {
        onSendComment = new OnSendComment() {

            @Override
            public void onSendComment(Dialog dialog, String comment) {
                dialog.dismiss();
            }
        };

        onNoComment = new OnNoComment() {
            @Override
            public void onNoComment(Dialog dialog) {
                dialog.dismiss();
            }
        };
    }

    public void findViews() {

        mainLayout = (LinearLayout) findViewById(R.id.badrate_mainLayout);

        noCommentText = (TextView) findViewById(R.id.badrate_nocomment_text);
        sendCommentText = (TextView) findViewById(R.id.badrate_sendcomment_text);
        titleText = (TextView) findViewById(R.id.badrate_title_text);

        noCommentButton = (LinearLayout) findViewById(R.id.badrate_nocomment_button);
        sendCommentButton = (LinearLayout) findViewById(R.id.badrate_sendcomment_button);

        messageBody = (LinearLayout) findViewById(R.id.badrate_body_layout);
        messageText = (EditText) findViewById(R.id.badrate_body_text);
    }

    public void setColor() {

        this.mainLayout.setBackgroundColor(config.getDialogMainColor());

        LinearLayout topLine = (LinearLayout) findViewById(R.id.badrate_line_topseparator);
        topLine.setBackgroundColor(config.getDialogTextColor());

        LinearLayout firstLine = (LinearLayout) findViewById(R.id.badrate_line_bottomSeparator);
        firstLine.setBackgroundColor(config.getDialogTextColor());

        this.titleText.setTextColor(config.getDialogTextColor());
        this.noCommentText.setTextColor(config.getDialogTextColor());
        this.sendCommentText.setTextColor(config.getDialogTextColor());
        this.messageText.setTextColor(config.getDialogTextColor());

        this.messageText.setBackgroundColor(config.getDialogMainColor());

        this.messageBody.setBackgroundColor(config.getDialogSecondColor());
    }

    public void setTypeface() {

        if (config.isHasTypeface() && config.getTypeface() != null) {
            this.titleText.setTypeface(config.getTypeface());
            this.noCommentText.setTypeface(config.getTypeface());
            this.sendCommentText.setTypeface(config.getTypeface());
            this.messageText.setTypeface(config.getTypeface());
        }
    }

    public void setDinamicSize() {

        sendCommentText.setTextSize(Utils_Dimen.pixelsToSp(activity, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        noCommentText.setTextSize(Utils_Dimen.pixelsToSp(activity, config.getParentHeight() * PERCENTAGE_BUTTONTEXSIZE));
        titleText.setTextSize(Utils_Dimen.pixelsToSp(activity, config.getParentHeight() * PERCENTAGE_TITLETEXSIZE));

        int padding = (int) (config.getParentWidth() * PERCENTAGE_PADDING_BODY);
        messageBody.setPadding(padding, padding, padding, padding);

        int padding_internal = (int) (config.getParentWidth() * PERCENTAGE_PADDING_BODY_INTERNAL);
        messageText.setPadding(padding_internal, padding_internal, padding_internal, padding_internal);
        messageText.setTextSize(Utils_Dimen.pixelsToSp(activity, config.getParentHeight() * PERCENTAGE_BODYTEXSIZE));
    }

    @SuppressLint("ClickableViewAccessibility")
    public void prepareListeners() {

        this.sendCommentText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    sendCommentButton.setBackgroundColor(config.getDialogSecondColor());
                    sendCommentText.setTextColor(config.getDialogMainColor());
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    sendCommentButton.setBackgroundColor(config.getDialogMainColor());
                    sendCommentText.setTextColor(config.getDialogTextColor());
                }

                return false;
            }
        });

        this.sendCommentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comment = messageText.getText().toString();
                if (!comment.equals("")) {
                    //Close Keyboard
                    InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(messageText.getWindowToken(), 0);
                    onSendComment.onSendComment(instance, messageText.getText().toString());
                } else
                    Utils_Dialog.customSimpleToast(config.getDialogTextColor(), config.getDialogMainColor(), -1, activity.getString(R.string.badrate_messsage), activity, Utils_Dialog.DURATION_LONG);

            }
        });

        this.noCommentButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    noCommentButton.setBackgroundColor(config.getDialogSecondColor());
                    noCommentText.setTextColor(config.getDialogMainColor());
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    noCommentButton.setBackgroundColor(config.getDialogMainColor());
                    noCommentText.setTextColor(config.getDialogTextColor());
                }

                return false;
            }
        });

        this.noCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Close Keyboard
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(messageText.getWindowToken(), 0);
                onNoComment.onNoComment(instance);
            }
        });
    }

    public void setOnSendCommentListener(BadRateDialog.OnSendComment onSendComment) {
        this.onSendComment = onSendComment;
    }

    public void setOnNoCommentListener(BadRateDialog.OnNoComment onNoComment) {
        this.onNoComment = onNoComment;
    }

    public interface OnNoComment {
        /**
         * On no comment.
         *
         * @param dialog the dialog
         */
        void onNoComment(Dialog dialog);
    }

    public interface OnSendComment {
        /**
         * On send comment.
         *
         * @param dialog  the dialog
         * @param comment the comment
         */
        void onSendComment(Dialog dialog, String comment);
    }
}
