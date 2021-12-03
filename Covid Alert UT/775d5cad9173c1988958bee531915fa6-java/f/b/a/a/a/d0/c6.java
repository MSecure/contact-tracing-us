package f.b.a.a.a.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import f.b.a.a.a.t.g0;
import gov.ut.covid19.exposurenotifications.R;

public class c6 extends h5 {
    public g0 h0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_not_shared, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.share_done_button);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) inflate;
            this.h0 = new g0(linearLayout, button);
            return linearLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.share_done_button)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.h0 = null;
    }

    @Override // f.b.a.a.a.d0.q5, e.n.a.m, f.b.a.a.a.w.z0
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.not_shared_confirm_title);
        this.h0.b.setOnClickListener(new l1(this));
    }
}
