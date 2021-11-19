package com.bugfender.sdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bugfender.android.R;
import com.bugfender.sdk.Bugfender;
import java.io.Serializable;
import java.net.URL;

public class FeedbackActivity extends Activity {
    public static final int REQUEST_CODE = 2222;
    public static final String RESULT_FEEDBACK_URL = "result.feedback.url";
    private static final String g = "extra.texts";
    private static final String h = "extra.style";
    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private EditText e;
    private EditText f;

    /* access modifiers changed from: package-private */
    public class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            FeedbackActivity.this.setResult(0);
            FeedbackActivity.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            URL sendUserFeedback = Bugfender.sendUserFeedback(FeedbackActivity.this.e.getText().toString(), FeedbackActivity.this.f.getText().toString());
            if (sendUserFeedback != null) {
                Intent intent = new Intent();
                intent.putExtra(FeedbackActivity.RESULT_FEEDBACK_URL, sendUserFeedback.toString());
                FeedbackActivity.this.setResult(-1, intent);
            }
            FeedbackActivity.this.finish();
        }
    }

    /* access modifiers changed from: private */
    public static class c implements Serializable {
        private static final long f = 41;
        final String a;
        final String b;
        final String c;
        final String d;
        final String e;

        /* synthetic */ c(a aVar) {
            this();
        }

        c(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        private c() {
            this.a = "Feedback";
            this.b = "Please insert your feedback here and click send";
            this.c = "Feedback subject";
            this.d = "Feedback message";
            this.e = "Send";
        }
    }

    public static Intent getIntent(Context context, String str, String str2, String str3, String str4, String str5, FeedbackStyle feedbackStyle) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        intent.putExtra(g, new c(str, str2, str3, str4, str5));
        if (feedbackStyle == null) {
            feedbackStyle = new FeedbackStyle();
        }
        intent.putExtra(h, feedbackStyle);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bf_feedback_screen);
        this.a = (ImageView) findViewById(R.id.close_iv);
        this.b = (TextView) findViewById(R.id.title_tv);
        this.c = (TextView) findViewById(R.id.positive_action_tv);
        this.d = (TextView) findViewById(R.id.message_tv);
        this.e = (EditText) findViewById(R.id.feedback_title_et);
        this.f = (EditText) findViewById(R.id.feedback_message_et);
        b();
        a();
        this.a.setOnClickListener(new a());
        this.c.setOnClickListener(new b());
    }

    private void a() {
        FeedbackStyle feedbackStyle = getIntent().hasExtra(h) ? (FeedbackStyle) getIntent().getSerializableExtra(h) : new FeedbackStyle();
        findViewById(R.id.appbar_rl).setBackgroundResource(feedbackStyle.appBarBackgroundColor);
        this.a.setColorFilter(getResources().getColor(feedbackStyle.appBarCloseButtonColor), PorterDuff.Mode.SRC_ATOP);
        this.b.setTextColor(getResources().getColor(feedbackStyle.appBarTitleColor));
        this.c.setTextColor(getResources().getColor(feedbackStyle.appBarActionButtonColor));
        findViewById(R.id.root_vg).setBackgroundResource(feedbackStyle.backgroundColor);
        this.d.setTextColor(getResources().getColor(feedbackStyle.textColor));
        TextView textView = (TextView) findViewById(R.id.bugfender_tv);
        Drawable drawable = getResources().getDrawable(R.drawable.bugfender_logo);
        drawable.setColorFilter(getResources().getColor(feedbackStyle.textColor), PorterDuff.Mode.SRC_ATOP);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setTextColor(getResources().getColor(feedbackStyle.textColor));
        this.e.setTextColor(getResources().getColor(feedbackStyle.inputTextColor));
        this.e.setHintTextColor(getResources().getColor(feedbackStyle.inputHintColor));
        this.e.setBackgroundResource(feedbackStyle.inputBackgroundColor);
        this.f.setTextColor(getResources().getColor(feedbackStyle.inputTextColor));
        this.f.setHintTextColor(getResources().getColor(feedbackStyle.inputHintColor));
        this.f.setBackgroundResource(feedbackStyle.inputBackgroundColor);
    }

    private void b() {
        c cVar = getIntent().hasExtra(g) ? (c) getIntent().getSerializableExtra(g) : new c(null);
        this.b.setText(cVar.a);
        this.c.setText(cVar.e);
        this.d.setText(cVar.b);
        this.e.setHint(cVar.c);
        this.f.setHint(cVar.d);
    }
}
