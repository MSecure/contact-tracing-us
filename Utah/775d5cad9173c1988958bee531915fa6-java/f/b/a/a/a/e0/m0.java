package f.b.a.a.a.e0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import e.b.a.m;
import e.n.a.m;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.t;
import gov.ut.covid19.exposurenotifications.R;

public class m0 extends h0 {
    public static final a d0 = a.e("OnboardingPrivateAnalyticsFragment");
    public t c0;

    public static void K0(m mVar) {
        mVar.v().X(null, 1);
        e.n.a.a aVar = new e.n.a.a(mVar.v());
        aVar.f(R.id.main_fragment, new m0(), "MAIN_FRAGMENT_TAG");
        aVar.f1744f = 4097;
        aVar.d();
    }

    @Override // f.b.a.a.a.e0.e0
    public void G0() {
        this.X.f417d.u(false);
    }

    @Override // f.b.a.a.a.e0.e0
    public void H0() {
        d0.a("Onboarding complete: private analytics enabled.");
        this.X.f417d.u(true);
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_private_analytics, viewGroup, false);
        int i2 = R.id.private_analytics_accept;
        Button button = (Button) inflate.findViewById(R.id.private_analytics_accept);
        if (button != null) {
            i2 = R.id.private_analytics_dismiss;
            Button button2 = (Button) inflate.findViewById(R.id.private_analytics_dismiss);
            if (button2 != null) {
                i2 = R.id.private_analytics_footer;
                TextView textView = (TextView) inflate.findViewById(R.id.private_analytics_footer);
                if (textView != null) {
                    LinearLayout linearLayout = (LinearLayout) inflate;
                    this.c0 = new t(linearLayout, button, button2, textView);
                    return linearLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.c0 = null;
    }

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.e0.e0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        m.e.U(this.X.f417d.f2315g).f(G(), new a0(this));
    }
}
