package f.b.a.a.a.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import f.b.a.a.a.t.a0;
import gov.ut.covid19.exposurenotifications.R;

public class o5 extends b5 {
    public a0 h0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_already_reported, viewGroup, false);
        int i2 = R.id.already_reported_content;
        TextView textView = (TextView) inflate.findViewById(R.id.already_reported_content);
        if (textView != null) {
            i2 = R.id.btn_done;
            Button button = (Button) inflate.findViewById(R.id.btn_done);
            if (button != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.h0 = new a0(linearLayout, textView, button);
                return linearLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.h0 = null;
    }

    @Override // f.b.a.a.a.d0.q5, e.n.a.m, f.b.a.a.a.w.z0
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.positive_result_already_reported_title);
        this.h0.c.setOnClickListener(new e(this));
        String E = E(R.string.health_authority_name);
        this.h0.b.setText(F(R.string.positive_result_already_reported_content, E));
    }
}
