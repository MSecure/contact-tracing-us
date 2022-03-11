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
import f.b.a.a.a.i.a;
import f.b.a.a.a.x.i0;
import gov.md.covid19.exposurenotifications.R;

public class AgencyActivity extends i0 {
    public a s;

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.x.i0, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_agency, (ViewGroup) null, false);
        int i2 = R.id.agency_message_link;
        TextView textView = (TextView) inflate.findViewById(R.id.agency_message_link);
        if (textView != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                FrameLayout frameLayout = (FrameLayout) inflate;
                this.s = new a(frameLayout, textView, imageButton);
                setContentView(frameLayout);
                this.s.c.setContentDescription(getString(R.string.navigate_up));
                this.s.c.setOnClickListener(new f.b.a.a.a.x.a(this));
                String string = getString(R.string.health_authority_website_url);
                URLSpan uRLSpan = new URLSpan(string);
                String string2 = getString(R.string.agency_message_link, new Object[]{string});
                SpannableString spannableString = new SpannableString(string2);
                int indexOf = string2.indexOf(string);
                spannableString.setSpan(uRLSpan, indexOf, string.length() + indexOf, 33);
                this.s.b.setText(spannableString);
                this.s.b.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
