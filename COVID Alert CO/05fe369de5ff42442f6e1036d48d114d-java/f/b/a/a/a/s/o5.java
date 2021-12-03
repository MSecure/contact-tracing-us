package f.b.a.a.a.s;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import f.b.a.a.a.j.x;
import f.b.a.a.a.m.z0;
import gov.co.cdphe.exposurenotifications.R;

public class o5 extends z0 {
    public x X;

    @Override // f.b.a.a.a.m.z0
    public boolean A0() {
        u().W();
        return false;
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.X = null;
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.thank_you_for_notifying_title);
        this.X.c.setText(B(R.string.thank_you_for_notifying_content, A(R.string.health_authority_name)));
        this.X.b.setOnClickListener(new d(this));
    }
}
