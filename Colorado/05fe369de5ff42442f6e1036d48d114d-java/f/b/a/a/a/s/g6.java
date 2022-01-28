package f.b.a.a.a.s;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import f.b.a.a.a.j.i0;
import gov.co.cdphe.exposurenotifications.R;

public class g6 extends i5 {
    public i0 g0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_shared, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.share_done_button);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) inflate;
            this.g0 = new i0(linearLayout, button);
            return linearLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.share_done_button)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.g0 = null;
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.share_confirm_title);
        this.g0.b.setOnClickListener(new t1(this));
    }
}
