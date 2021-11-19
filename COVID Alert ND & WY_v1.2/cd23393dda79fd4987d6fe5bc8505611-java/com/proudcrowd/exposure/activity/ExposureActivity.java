package com.proudcrowd.exposure.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.fragment.ExposureFragment;

public class ExposureActivity extends BaseActivity {
    ImageButton mBackButton;
    ExposureFragment mFragment;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_host_dialog);
        ExposureFragment exposureFragment = (ExposureFragment) getSupportFragmentManager().findFragmentByTag("ExposureFragment");
        this.mFragment = exposureFragment;
        if (exposureFragment == null) {
            this.mFragment = ExposureFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_host, this.mFragment, "ExposureFragment").commit();
        }
        ((TextView) findViewById(R.id.dialog_prompt)).setText("EXPOSURE");
        ImageButton imageButton = (ImageButton) findViewById(R.id.dialog_back_button);
        this.mBackButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.ExposureActivity.AnonymousClass1 */

            public void onClick(View view) {
                ExposureActivity.this.finish();
                ExposureActivity.this.overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
            }
        });
    }
}
