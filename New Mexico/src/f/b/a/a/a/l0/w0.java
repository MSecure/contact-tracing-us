package f.b.a.a.a.l0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import f.b.a.a.a.u.r;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class w0 extends t0 {
    public r b0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_legal_terms, (ViewGroup) null, false);
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            FrameLayout frameLayout = (FrameLayout) inflate;
            this.b0 = new r(frameLayout, imageButton);
            return frameLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(16908332)));
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.settings_legal_terms);
        this.b0.b.setContentDescription(F(R.string.navigate_up));
        this.b0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0.this.u0().onBackPressed();
            }
        });
    }
}
