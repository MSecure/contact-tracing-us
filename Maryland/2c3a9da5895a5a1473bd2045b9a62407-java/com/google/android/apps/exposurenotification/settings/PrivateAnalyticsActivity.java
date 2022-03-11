package com.google.android.apps.exposurenotification.settings;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.b0;
import f.b.a.a.a.i.f;
import f.b.a.a.a.x.m0;
import f.b.a.a.a.x.o;
import f.b.a.a.a.x.p;
import gov.md.covid19.exposurenotifications.R;

public class PrivateAnalyticsActivity extends m0 {
    public static final /* synthetic */ int t = 0;
    public f s;

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.x.m0, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_private_analytics, (ViewGroup) null, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            i2 = R.id.private_analytics_footer;
            TextView textView = (TextView) inflate.findViewById(R.id.private_analytics_footer);
            if (textView != null) {
                i2 = R.id.private_analytics_switch;
                SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.private_analytics_switch);
                if (switchMaterial != null) {
                    i2 = R.id.watermark;
                    TextView textView2 = (TextView) inflate.findViewById(R.id.watermark);
                    if (textView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) inflate;
                        this.s = new f(frameLayout, imageButton, textView, switchMaterial, textView2, frameLayout);
                        setContentView(frameLayout);
                        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new b0(this).a(PrivateAnalyticsViewModel.class);
                        this.s.b.setContentDescription(getString(R.string.navigate_up));
                        this.s.b.setOnClickListener(new p(this));
                        this.s.f2101d.setText(getString(R.string.private_analytics_subtitle));
                        privateAnalyticsViewModel.c.f2357d.f(this, new o(this, privateAnalyticsViewModel));
                        String string = getString(R.string.private_analytics_footer_learn_more);
                        URLSpan uRLSpan = new URLSpan(getString(R.string.private_analytics_link));
                        String string2 = getString(R.string.private_analytics_footer, new Object[]{string});
                        SpannableString spannableString = new SpannableString(string2);
                        int indexOf = string2.indexOf(string);
                        spannableString.setSpan(uRLSpan, indexOf, string.length() + indexOf, 33);
                        this.s.c.setText(spannableString);
                        this.s.c.setMovementMethod(LinkMovementMethod.getInstance());
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
