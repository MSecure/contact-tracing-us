package f.b.a.a.a.s;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import f.b.a.a.a.j.a0;
import gov.co.cdphe.exposurenotifications.R;

public class p5 extends b5 {
    public a0 g0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_already_reported, viewGroup, false);
        int i2 = R.id.already_reported_content;
        TextView textView = (TextView) inflate.findViewById(R.id.already_reported_content);
        if (textView != null) {
            i2 = R.id.btn_done;
            Button button = (Button) inflate.findViewById(R.id.btn_done);
            if (button != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.g0 = new a0(linearLayout, textView, button);
                return linearLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.g0 = null;
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.positive_result_already_reported_title);
        this.g0.c.setOnClickListener(new e(this));
        String A = A(R.string.health_authority_name);
        this.g0.b.setText(B(R.string.positive_result_already_reported_content, A));
    }
}
