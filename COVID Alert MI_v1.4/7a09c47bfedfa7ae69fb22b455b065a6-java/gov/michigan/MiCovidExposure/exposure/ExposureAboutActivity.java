package gov.michigan.MiCovidExposure.exposure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import b.b.k.f;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import e.a.a.b.a;
import e.a.a.b.b;
import gov.michigan.MiCovidExposure.R;

public class ExposureAboutActivity extends f {
    public static final String TAG = "ExposureAboutActivity";

    private void settingsAction() {
        startActivity(new Intent(ExposureNotificationClient.ACTION_EXPOSURE_NOTIFICATION_SETTINGS));
    }

    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public /* synthetic */ void b(View view) {
        settingsAction();
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.i.d.e, b.l.d.m
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_exposure_about);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new a(this));
        ((Button) findViewById(R.id.exposure_about_settings_button)).setOnClickListener(new b(this));
    }
}
