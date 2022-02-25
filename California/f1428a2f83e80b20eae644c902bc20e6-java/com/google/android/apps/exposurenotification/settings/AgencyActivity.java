package com.google.android.apps.exposurenotification.settings;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import f.b.a.a.a.v.a;
import f.b.a.a.a.v.k0;
import gov.ca.covid19.exposurenotifications.R;

public class AgencyActivity extends k0 {
    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.v.k0, e.m.a.o, e.i.a.f
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_agency);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new a(this));
        String string = getString(R.string.health_authority_website_url);
        URLSpan uRLSpan = new URLSpan(string);
        String string2 = getString(R.string.agency_message_link, new Object[]{string});
        SpannableString spannableString = new SpannableString(string2);
        int indexOf = string2.indexOf(string);
        spannableString.setSpan(uRLSpan, indexOf, string.length() + indexOf, 33);
        TextView textView = (TextView) findViewById(R.id.agency_message_link);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
