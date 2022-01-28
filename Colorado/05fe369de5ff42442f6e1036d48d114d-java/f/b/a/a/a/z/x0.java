package f.b.a.a.a.z;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import f.b.a.a.a.j.q;
import gov.co.cdphe.exposurenotifications.R;

public class x0 extends u0 {
    public q a0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = q().inflate(R.layout.fragment_legal_terms, (ViewGroup) null, false);
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            FrameLayout frameLayout = (FrameLayout) inflate;
            this.a0 = new q(frameLayout, imageButton);
            return frameLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(16908332)));
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.settings_legal_terms);
        this.a0.b.setContentDescription(A(R.string.navigate_up));
        this.a0.b.setOnClickListener(new s(this));
    }
}
