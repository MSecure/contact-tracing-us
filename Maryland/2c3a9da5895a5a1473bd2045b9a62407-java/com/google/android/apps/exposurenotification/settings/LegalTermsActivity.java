package com.google.android.apps.exposurenotification.settings;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import f.b.a.a.a.i.e;
import f.b.a.a.a.x.l0;
import f.b.a.a.a.x.n;
import gov.md.covid19.exposurenotifications.R;

public class LegalTermsActivity extends l0 {
    public e s;

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.x.l0, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_legal_terms, (ViewGroup) null, false);
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            FrameLayout frameLayout = (FrameLayout) inflate;
            this.s = new e(frameLayout, imageButton);
            setContentView(frameLayout);
            this.s.b.setContentDescription(getString(R.string.navigate_up));
            this.s.b.setOnClickListener(new n(this));
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(16908332)));
    }
}
