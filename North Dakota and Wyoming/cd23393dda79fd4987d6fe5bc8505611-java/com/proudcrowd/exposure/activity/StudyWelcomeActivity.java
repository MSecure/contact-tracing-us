package com.proudcrowd.exposure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.proudcrowd.exposure.R;

public class StudyWelcomeActivity extends BaseActivity {
    Button mContinue;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_study_welcome);
        Button button = (Button) findViewById(R.id.welcome_button);
        this.mContinue = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.StudyWelcomeActivity.AnonymousClass1 */

            public void onClick(View view) {
                StudyWelcomeActivity.this.startActivity(new Intent(StudyWelcomeActivity.this.mAppContext, StudyConsentActivity.class));
                StudyWelcomeActivity.this.overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.study_welcome_text)).setText(this.mAppContext.mStudy.introPageOneText);
    }
}
