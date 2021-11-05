package gov.nc.dhhs.exposurenotification.notify;

import android.os.Bundle;
import android.view.View;
import b.b.k.f;
import d.a.a.a.h.g;
import gov.nc.dhhs.exposurenotification.R;

public class NotifyLearnMoreActivity extends f {
    public static final String TAG = "NotifyLearnMoreActivity";

    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.l.d.d, b.i.d.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_notify_learn_more);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.back_btn_content_description));
        findViewById.setOnClickListener(new g(this));
    }
}
