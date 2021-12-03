package f.b.a.a.a.z;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import f.b.a.a.a.c0.b;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.j.i;
import gov.co.cdphe.exposurenotifications.R;

public class k0 extends r0 {
    public i a0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = q().inflate(R.layout.fragment_agency, (ViewGroup) null, false);
        int i2 = R.id.agency_message_link;
        TextView textView = (TextView) inflate.findViewById(R.id.agency_message_link);
        if (textView != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                FrameLayout frameLayout = (FrameLayout) inflate;
                this.a0 = new i(frameLayout, textView, imageButton);
                return frameLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.agency_message_title);
        this.a0.c.setContentDescription(A(R.string.navigate_up));
        this.a0.c.setOnClickListener(new a(this));
        String A = A(R.string.health_authority_website_url);
        a aVar = b.a;
        f.b.a.a.a.c0.a aVar2 = new f.b.a.a.a.c0.a(A);
        String B = B(R.string.agency_message_link, A);
        SpannableString spannableString = new SpannableString(B);
        int indexOf = B.indexOf(A);
        spannableString.setSpan(aVar2, indexOf, A.length() + indexOf, 33);
        this.a0.b.setText(spannableString);
        this.a0.b.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
