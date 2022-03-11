package f.b.a.a.a.f0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.b.a.m;
import e.c0.p;
import e.o.a.m;
import e.r.t;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.w;
import f.b.a.a.a.x.g1;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class u0 extends l0 {
    public static final a d0 = a.e("OnboardingPrivateAnalyticsFragment");
    public w c0;

    public static void N0(m mVar) {
        mVar.w().Y(null, 1);
        e.o.a.a aVar = new e.o.a.a(mVar.w());
        aVar.g(R.id.main_fragment, new u0(), "MAIN_FRAGMENT_TAG");
        aVar.f1829f = 4097;
        aVar.d();
    }

    @Override // f.b.a.a.a.f0.g0
    public void J0() {
        this.X.f424d.y(false);
    }

    @Override // f.b.a.a.a.f0.g0
    public void K0() {
        d0.a("Onboarding complete: private analytics enabled.");
        this.X.f424d.y(true);
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.c0 = new w(linearLayout, button, button2, textView);
                    return linearLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.c0 = null;
    }

    @Override // f.b.a.a.a.f0.g0, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        m.e.V(this.X.f424d.f2316g).f(H(), new t() { // from class: f.b.a.a.a.f0.c0
            @Override // e.r.t
            public final void a(Object obj) {
                u0 u0Var = u0.this;
                Objects.requireNonNull(u0Var);
                if (((Boolean) obj).booleanValue()) {
                    u0Var.X.f426f.c(new p.a(SubmitPrivateAnalyticsWorker.class).a());
                    g1.M0(u0Var);
                }
            }
        });
    }
}
