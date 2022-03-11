package f.b.a.a.a.l0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.j;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class k0 extends q0 {
    public j b0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_agency, (ViewGroup) null, false);
        int i2 = R.id.agency_message_link;
        TextView textView = (TextView) inflate.findViewById(R.id.agency_message_link);
        if (textView != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                FrameLayout frameLayout = (FrameLayout) inflate;
                this.b0 = new j(frameLayout, textView, imageButton);
                return frameLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.agency_message_title);
        this.b0.c.setContentDescription(F(R.string.navigate_up));
        this.b0.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k0.this.u0().onBackPressed();
            }
        });
        String F = F(R.string.health_authority_website_url);
        a aVar = b.a;
        f.b.a.a.a.o0.a aVar2 = new f.b.a.a.a.o0.a(F);
        String G = G(R.string.agency_message_link, F);
        SpannableString spannableString = new SpannableString(G);
        int indexOf = G.indexOf(F);
        spannableString.setSpan(aVar2, indexOf, F.length() + indexOf, 33);
        this.b0.b.setText(spannableString);
        this.b0.b.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
