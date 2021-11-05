package gov.nc.dhhs.exposurenotification.exposure;

import android.os.Bundle;
import android.view.View;
import b.b.k.f;
import d.a.a.a.d.s;
import gov.nc.dhhs.exposurenotification.R;

public class ExposureLearnMoreActivity extends f {
    public static final String TAG = "ExposureLearnMoreActivity";

    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.l.d.d, b.i.d.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_exposure_learn_more);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.back_btn_content_description));
        findViewById.setOnClickListener(new s(this));
    }
}
