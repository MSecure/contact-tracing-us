package f.b.a.a.a.j0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.i;
import gov.ut.covid19.exposurenotifications.R;

public class k0 extends q0 {
    public i b0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_agency, (ViewGroup) null, false);
        int i2 = R.id.agency_message_link;
        TextView textView = (TextView) inflate.findViewById(R.id.agency_message_link);
        if (textView != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                FrameLayout frameLayout = (FrameLayout) inflate;
                this.b0 = new i(frameLayout, textView, imageButton);
                return frameLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.agency_message_title);
        this.b0.c.setContentDescription(E(R.string.navigate_up));
        this.b0.c.setOnClickListener(new a(this));
        String E = E(R.string.health_authority_website_url);
        a aVar = b.a;
        f.b.a.a.a.m0.a aVar2 = new f.b.a.a.a.m0.a(E);
        String F = F(R.string.agency_message_link, E);
        SpannableString spannableString = new SpannableString(F);
        int indexOf = F.indexOf(E);
        spannableString.setSpan(aVar2, indexOf, E.length() + indexOf, 33);
        this.b0.b.setText(spannableString);
        this.b0.b.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
