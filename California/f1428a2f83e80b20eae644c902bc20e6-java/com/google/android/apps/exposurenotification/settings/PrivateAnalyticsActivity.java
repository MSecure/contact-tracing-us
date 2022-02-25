package com.google.android.apps.exposurenotification.settings;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.b0;
import f.b.a.a.a.h.h;
import f.b.a.a.a.v.o0;
import f.b.a.a.a.v.q;
import f.b.a.a.a.v.r;
import f.b.a.a.a.w.n0;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public class PrivateAnalyticsActivity extends o0 {
    public static final /* synthetic */ int r = 0;

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.v.o0, e.m.a.o, e.i.a.f
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_private_analytics);
        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new b0(this).a(PrivateAnalyticsViewModel.class);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new r(this));
        SwitchMaterial switchMaterial = (SwitchMaterial) findViewById(R.id.private_analytics_switch);
        switchMaterial.setText(getString(R.string.private_analytics_subtitle));
        n0 n0Var = privateAnalyticsViewModel.c;
        Objects.requireNonNull(n0Var);
        new h(n0Var.a, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false).f(this, new q(switchMaterial, privateAnalyticsViewModel));
        String string = getString(R.string.private_analytics_footer_learn_more);
        URLSpan uRLSpan = new URLSpan(getString(R.string.private_analytics_link));
        String string2 = getString(R.string.private_analytics_footer, new Object[]{string});
        SpannableString spannableString = new SpannableString(string2);
        int indexOf = string2.indexOf(string);
        spannableString.setSpan(uRLSpan, indexOf, string.length() + indexOf, 33);
        TextView textView = (TextView) findViewById(R.id.private_analytics_footer);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
