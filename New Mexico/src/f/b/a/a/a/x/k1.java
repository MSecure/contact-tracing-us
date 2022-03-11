package f.b.a.a.a.x;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.home.SplashViewModel;
import e.b.a.m;
import e.o.a.m;
import e.r.f0;
import e.r.s;
import e.r.t;
import f.b.a.a.a.t.q0.a;
import f.b.a.a.a.u.x;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.d;
/* loaded from: classes.dex */
public class k1 extends f1 {
    public static final d g0 = d.i(2500);
    public a b0;
    public x d0;
    public long f0;
    public m c0 = new g1();
    public CountDownTimer e0 = null;

    public final void L0() {
        e.o.a.a aVar = new e.o.a.a(w());
        aVar.g(R.id.main_fragment, this.c0, "MAIN_FRAGMENT_TAG");
        aVar.f1829f = 4099;
        aVar.d();
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_start, viewGroup, false);
        Objects.requireNonNull(inflate, "rootView");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.d0 = new x(linearLayout);
        return linearLayout;
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.d0 = null;
    }

    @Override // e.o.a.m
    public void e0() {
        this.D = true;
        CountDownTimer countDownTimer = this.e0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // e.o.a.m
    public void i0() {
        this.D = true;
        CountDownTimer countDownTimer = this.e0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        j1 j1Var = new j1(this, g0.u(), 1000);
        this.e0 = j1Var;
        j1Var.start();
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        this.f0 = this.b0.a();
        SplashViewModel splashViewModel = (SplashViewModel) new f0(this).a(SplashViewModel.class);
        ExposureNotificationViewModel exposureNotificationViewModel = this.W;
        s<Boolean> sVar = exposureNotificationViewModel.f343f;
        s<ExposureNotificationViewModel.b> sVar2 = exposureNotificationViewModel.c;
        Context v0 = v0();
        LiveData V = m.e.V(splashViewModel.c.f2315f);
        LiveData V2 = m.e.V(splashViewModel.c.f2316g);
        s sVar3 = new s(Boolean.valueOf(splashViewModel.f359d.a()));
        boolean b = splashViewModel.f360e.b(v0);
        m1 m1Var = new m1();
        m1Var.m(sVar, new t() { // from class: f.b.a.a.a.x.y0
            @Override // e.r.t
            public final void a(Object obj) {
                m1 m1Var2 = m1.this;
                m1Var2.m = ((Boolean) obj).booleanValue();
                m1Var2.n();
            }
        });
        m1Var.m(sVar2, new t() { // from class: f.b.a.a.a.x.x0
            @Override // e.r.t
            public final void a(Object obj) {
                m1 m1Var2 = m1.this;
                m1Var2.n = (ExposureNotificationViewModel.b) obj;
                m1Var2.n();
            }
        });
        m1Var.m(V, new t() { // from class: f.b.a.a.a.x.u0
            @Override // e.r.t
            public final void a(Object obj) {
                m1 m1Var2 = m1.this;
                m1Var2.o = ((Boolean) obj).booleanValue();
                m1Var2.n();
            }
        });
        m1Var.m(V2, new t() { // from class: f.b.a.a.a.x.w0
            @Override // e.r.t
            public final void a(Object obj) {
                m1 m1Var2 = m1.this;
                m1Var2.p = ((Boolean) obj).booleanValue();
                m1Var2.n();
            }
        });
        m1Var.m(sVar3, new t() { // from class: f.b.a.a.a.x.v0
            @Override // e.r.t
            public final void a(Object obj) {
                m1 m1Var2 = m1.this;
                m1Var2.q = ((Boolean) obj).booleanValue();
                m1Var2.n();
            }
        });
        m1Var.r = b;
        m1Var.f(H(), new t() { // from class: f.b.a.a.a.x.s0
            @Override // e.r.t
            public final void a(Object obj) {
                k1.this.c0 = (e.o.a.m) obj;
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k1 k1Var = k1.this;
                if (k1Var.b0.a() - k1Var.f0 > k1.g0.u()) {
                    k1Var.L0();
                }
            }
        });
    }
}
