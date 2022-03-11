package f.b.a.a.a.e0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import f.b.a.a.a.u.d0;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class c6 extends p5 {
    public d0 k0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_already_reported, viewGroup, false);
        int i2 = R.id.already_reported_content;
        TextView textView = (TextView) inflate.findViewById(R.id.already_reported_content);
        if (textView != null) {
            i2 = R.id.btn_done;
            Button button = (Button) inflate.findViewById(R.id.btn_done);
            if (button != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.k0 = new d0(linearLayout, textView, button);
                return linearLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.k0 = null;
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.positive_result_already_reported_title);
        this.k0.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c6.this.L0();
            }
        });
        this.k0.b.setText(G(R.string.positive_result_already_reported_content, F(R.string.health_authority_name)));
    }
}
