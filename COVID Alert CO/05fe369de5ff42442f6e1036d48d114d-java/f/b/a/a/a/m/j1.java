package f.b.a.a.a.m;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.home.SplashViewModel;
import e.b.a.m;
import e.m.a.m;
import e.p.f0;
import e.p.s;
import f.b.a.a.a.i.f0.a;
import f.b.a.a.a.j.u;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;
import l.b.a.d;

public class j1 extends e1 {
    public static final d f0 = d.i(2500);
    public a a0;
    public m b0 = new f1();
    public u c0;
    public CountDownTimer d0 = null;
    public long e0;

    public final void C0() {
        e.m.a.a aVar = new e.m.a.a(u());
        aVar.f(R.id.main_fragment, this.b0, "MAIN_FRAGMENT_TAG");
        aVar.f1471f = 4099;
        aVar.d();
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_start, viewGroup, false);
        Objects.requireNonNull(inflate, "rootView");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.c0 = new u(linearLayout);
        return linearLayout;
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.c0 = null;
    }

    @Override // e.m.a.m
    public void Y() {
        this.D = true;
        CountDownTimer countDownTimer = this.d0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // e.m.a.m
    public void c0() {
        this.D = true;
        CountDownTimer countDownTimer = this.d0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        i1 i1Var = new i1(this, f0.t(), 1000);
        this.d0 = i1Var;
        i1Var.start();
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        this.e0 = this.a0.a();
        SplashViewModel splashViewModel = (SplashViewModel) new f0(this).a(SplashViewModel.class);
        s<Boolean> sVar = this.W.f336f;
        LiveData S = m.h.S(splashViewModel.c.f2117f);
        LiveData S2 = m.h.S(splashViewModel.c.f2118g);
        s sVar2 = new s(Boolean.valueOf(splashViewModel.f352d.a()));
        l1 l1Var = new l1();
        l1Var.m(sVar, new x0(l1Var));
        l1Var.m(S, new u0(l1Var));
        l1Var.m(S2, new w0(l1Var));
        l1Var.m(sVar2, new v0(l1Var));
        l1Var.f(C(), new s0(this));
        view.setOnClickListener(new t0(this));
    }
}
