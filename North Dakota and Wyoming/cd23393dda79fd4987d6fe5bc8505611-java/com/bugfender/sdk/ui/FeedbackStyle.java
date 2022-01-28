package com.bugfender.sdk.ui;

import com.bugfender.android.R;
import java.io.Serializable;

public class FeedbackStyle implements Serializable {
    private static final long serialVersionUID = 42;
    int appBarActionButtonColor = R.color.feedback_appbar_action_button;
    int appBarBackgroundColor = R.color.feedback_appbar_background;
    int appBarCloseButtonColor = R.color.feedback_appbar_close_button;
    int appBarTitleColor = R.color.feedback_appbar_title;
    int backgroundColor = R.color.feedback_background;
    int inputBackgroundColor = R.color.feedback_input_background;
    int inputHintColor = R.color.feedback_input_hint;
    int inputTextColor = R.color.feedback_input_text;
    int textColor = R.color.feedback_text;

    public FeedbackStyle setAppBarColors(int i, int i2, int i3, int i4) {
        this.appBarBackgroundColor = i;
        this.appBarTitleColor = i2;
        this.appBarCloseButtonColor = i3;
        this.appBarActionButtonColor = i4;
        return this;
    }

    public FeedbackStyle setInputColors(int i, int i2, int i3) {
        this.inputBackgroundColor = i;
        this.inputTextColor = i2;
        this.inputHintColor = i3;
        return this;
    }

    public FeedbackStyle setScreenColors(int i, int i2) {
        this.backgroundColor = i;
        this.textColor = i2;
        return this;
    }
}
