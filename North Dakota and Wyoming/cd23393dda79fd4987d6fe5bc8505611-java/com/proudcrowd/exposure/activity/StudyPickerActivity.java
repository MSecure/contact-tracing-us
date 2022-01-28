package com.proudcrowd.exposure.activity;

import android.os.Bundle;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.fragment.StudyPickerFragment;

public class StudyPickerActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_host);
        if (((StudyPickerFragment) getSupportFragmentManager().findFragmentByTag("StudyPickerFragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_host, StudyPickerFragment.newInstance(), "StudyPickerFragment").commit();
        }
    }
}
