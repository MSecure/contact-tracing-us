package f.b.a.a.a.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import f.b.a.a.a.t.x;
import f.b.a.a.a.w.z0;
import gov.ut.covid19.exposurenotifications.R;

public class n5 extends z0 {
    public x X;

    @Override // f.b.a.a.a.w.z0
    public boolean F0() {
        v().W();
        return false;
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pre_auth_teks_released, viewGroup, false);
        int i2 = R.id.btn_done;
        Button button = (Button) inflate.findViewById(R.id.btn_done);
        if (button != null) {
            i2 = R.id.main_content;
            TextView textView = (TextView) inflate.findViewById(R.id.main_content);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.X = new x(linearLayout, button, textView);
                return linearLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.X = null;
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.thank_you_for_notifying_title);
        this.X.c.setText(F(R.string.thank_you_for_notifying_content, E(R.string.health_authority_name)));
        this.X.b.setOnClickListener(new d(this));
    }
}
