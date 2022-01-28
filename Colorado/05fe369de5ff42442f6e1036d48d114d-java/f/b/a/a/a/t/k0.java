package f.b.a.a.a.t;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import e.b.a.m;
import e.m.a.m;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.j.t;
import gov.co.cdphe.exposurenotifications.R;

public class k0 extends f0 {
    public static final a c0 = a.e("OnboardingPrivateAnalyticsFragment");
    public t b0;

    public static void E0(m mVar) {
        mVar.u().X(null, 1);
        e.m.a.a aVar = new e.m.a.a(mVar.u());
        aVar.f(R.id.main_fragment, new k0(), "MAIN_FRAGMENT_TAG");
        aVar.f1471f = 4097;
        aVar.d();
    }

    @Override // f.b.a.a.a.t.c0
    public void B0() {
        this.X.c.u(false);
    }

    @Override // f.b.a.a.a.t.c0
    public void C0() {
        c0.a("Onboarding complete: private analytics enabled.");
        this.X.c.u(true);
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.b0 = new t(linearLayout, button, button2, textView);
                    return linearLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.t.c0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        m.h.S(this.X.c.f2118g).f(C(), new z(this));
    }
}
