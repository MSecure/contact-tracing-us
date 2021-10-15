package gov.michigan.MiCovidExposure.notify;

import android.os.Bundle;
import android.view.View;
import b.b.k.f;
import e.a.a.f.h;
import gov.michigan.MiCovidExposure.R;

public class NotifyLearnMoreActivity extends f {
    public static final String TAG = "NotifyLearnMoreActivity";

    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.i.d.e, b.l.d.m
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_notify_learn_more);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new h(this));
    }
}
