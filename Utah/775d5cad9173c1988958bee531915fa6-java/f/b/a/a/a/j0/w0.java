package f.b.a.a.a.j0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import f.b.a.a.a.t.q;
import gov.ut.covid19.exposurenotifications.R;

public class w0 extends t0 {
    public q b0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_legal_terms, (ViewGroup) null, false);
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            FrameLayout frameLayout = (FrameLayout) inflate;
            this.b0 = new q(frameLayout, imageButton);
            return frameLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(16908332)));
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.settings_legal_terms);
        this.b0.b.setContentDescription(E(R.string.navigate_up));
        this.b0.b.setOnClickListener(new s(this));
    }
}
