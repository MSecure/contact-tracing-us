package com.proudcrowd.exposure.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bugfender.sdk.Bugfender;
import com.google.android.gms.common.GoogleApiAvailability;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.core.ExposureApplication;

public class TriageActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_triage);
        if (checkPlayServices()) {
            ExposureApplication exposureApplication = (ExposureApplication) getApplication();
            if (exposureApplication.getHaveConsent()) {
                startActivity(new Intent(exposureApplication, MainActivity.class));
            } else {
                startActivity(new Intent(exposureApplication, StudyPickerActivity.class));
            }
        }
    }

    private boolean checkPlayServices() {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (GoogleApiAvailability.getInstance().isUserResolvableError(isGooglePlayServicesAvailable)) {
            GoogleApiAvailability.getInstance().getErrorDialog(this, isGooglePlayServicesAvailable, 9000).show();
            return false;
        }
        Bugfender.e("Google Play Check", "This device is not supported.");
        finish();
        return false;
    }

    @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, androidx.fragment.app.FragmentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
