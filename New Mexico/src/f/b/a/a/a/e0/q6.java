package f.b.a.a.a.e0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import f.b.a.a.a.u.j0;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class q6 extends v5 {
    public j0 k0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_not_shared, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.share_done_button);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) inflate;
            this.k0 = new j0(linearLayout, button);
            return linearLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.share_done_button)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.k0 = null;
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.not_shared_confirm_title);
        this.k0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                q6.this.L0();
            }
        });
    }
}
