package f.b.a.a.a.w;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.home.SplashViewModel;
import e.b.a.m;
import e.n.a.m;
import e.q.f0;
import e.q.s;
import f.b.a.a.a.s.e0.a;
import f.b.a.a.a.t.u;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.d;

public class j1 extends e1 {
    public static final d g0 = d.i(2500);
    public a b0;
    public m c0 = new f1();
    public u d0;
    public CountDownTimer e0 = null;
    public long f0;

    public final void I0() {
        e.n.a.a aVar = new e.n.a.a(v());
        aVar.f(R.id.main_fragment, this.c0, "MAIN_FRAGMENT_TAG");
        aVar.f1744f = 4099;
        aVar.d();
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_start, viewGroup, false);
        Objects.requireNonNull(inflate, "rootView");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.d0 = new u(linearLayout);
        return linearLayout;
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.d0 = null;
    }

    @Override // e.n.a.m
    public void c0() {
        this.D = true;
        CountDownTimer countDownTimer = this.e0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // e.n.a.m
    public void g0() {
        this.D = true;
        CountDownTimer countDownTimer = this.e0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        i1 i1Var = new i1(this, g0.t(), 1000);
        this.e0 = i1Var;
        i1Var.start();
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        this.f0 = this.b0.a();
        SplashViewModel splashViewModel = (SplashViewModel) new f0(this).a(SplashViewModel.class);
        s<Boolean> sVar = this.W.f341f;
        LiveData U = m.e.U(splashViewModel.c.f2314f);
        LiveData U2 = m.e.U(splashViewModel.c.f2315g);
        s sVar2 = new s(Boolean.valueOf(splashViewModel.f357d.a()));
        l1 l1Var = new l1();
        l1Var.m(sVar, new x0(l1Var));
        l1Var.m(U, new u0(l1Var));
        l1Var.m(U2, new w0(l1Var));
        l1Var.m(sVar2, new v0(l1Var));
        l1Var.f(G(), new s0(this));
        view.setOnClickListener(new t0(this));
    }
}
