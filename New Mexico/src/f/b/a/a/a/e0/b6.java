package f.b.a.a.a.e0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import f.b.a.a.a.u.a0;
import f.b.a.a.a.x.a1;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class b6 extends a1 {
    public a0 X;

    @Override // f.b.a.a.a.x.a1
    public boolean I0() {
        w().X();
        return false;
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pre_auth_teks_released, viewGroup, false);
        int i2 = R.id.btn_done;
        Button button = (Button) inflate.findViewById(R.id.btn_done);
        if (button != null) {
            i2 = R.id.main_content;
            TextView textView = (TextView) inflate.findViewById(R.id.main_content);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.X = new a0(linearLayout, button, textView);
                return linearLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.X = null;
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.thank_you_for_notifying_title);
        this.X.c.setText(G(R.string.thank_you_for_notifying_content, F(R.string.health_authority_name)));
        this.X.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b6.this.w().X();
            }
        });
    }
}
