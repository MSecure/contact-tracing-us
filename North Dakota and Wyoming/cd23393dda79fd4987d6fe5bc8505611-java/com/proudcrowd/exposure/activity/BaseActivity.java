package com.proudcrowd.exposure.activity;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.proudcrowd.exposure.core.ExposureApplication;

public class BaseActivity extends FragmentActivity {
    ExposureApplication mAppContext;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAppContext = (ExposureApplication) getApplication();
    }
}
