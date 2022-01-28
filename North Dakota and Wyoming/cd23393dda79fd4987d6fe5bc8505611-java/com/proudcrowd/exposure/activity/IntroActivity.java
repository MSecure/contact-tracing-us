package com.proudcrowd.exposure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.core.ScanManager;
import com.proudcrowd.exposure.viewmodel.ExposureViewModel;

public class IntroActivity extends BaseActivity {
    private static final String TAG = StudyConsentActivity.class.getSimpleName();
    private ExposureViewModel exposureNotificationViewModel;
    private Button mContinue;
    private ProgressBar mProgress;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_intro);
        this.mProgress = (ProgressBar) findViewById(R.id.scan_progress);
        Button button = (Button) findViewById(R.id.scan_button);
        this.mContinue = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.IntroActivity.AnonymousClass1 */

            public void onClick(View view) {
                IntroActivity.this.mContinue.setEnabled(false);
                IntroActivity.this.mProgress.setVisibility(0);
                ScanManager.runOnce(IntroActivity.this.getApplicationContext());
                new Handler().postDelayed(new Runnable() {
                    /* class com.proudcrowd.exposure.activity.IntroActivity.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        IntroActivity.this.mProgress.setVisibility(8);
                        IntroActivity.this.startActivity(new Intent(IntroActivity.this.mAppContext, MainActivity.class));
                    }
                }, 5000);
            }
        });
    }
}
