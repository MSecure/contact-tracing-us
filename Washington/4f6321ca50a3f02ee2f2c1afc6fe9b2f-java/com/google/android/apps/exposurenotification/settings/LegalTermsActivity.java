package com.google.android.apps.exposurenotification.settings;

import android.os.Bundle;
import android.view.View;
import f.b.a.a.a.v.n0;
import f.b.a.a.a.v.p;
import gov.wa.doh.exposurenotifications.R;

public class LegalTermsActivity extends n0 {
    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.v.n0, e.m.a.o, e.i.a.f
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_legal_terms);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new p(this));
    }
}
