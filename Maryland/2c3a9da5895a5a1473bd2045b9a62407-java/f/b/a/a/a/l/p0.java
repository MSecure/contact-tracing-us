package f.b.a.a.a.l;

import android.content.Intent;
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
import e.m.a.l;
import e.p.b0;
import e.p.q;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.i.r;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.c;

public class p0 extends k0 {
    public static final c h0 = c.h(2500);
    public a a0;
    public l b0 = new l0();
    public long c0;
    public CountDownTimer d0 = null;
    public r e0;
    public ExposureNotificationViewModel f0;
    public SplashViewModel g0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_start, viewGroup, false);
        Objects.requireNonNull(inflate, "rootView");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.e0 = new r(linearLayout);
        return linearLayout;
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.e0 = null;
    }

    @Override // e.m.a.l
    public void Y() {
        this.D = true;
        CountDownTimer countDownTimer = this.d0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.f0.d();
        CountDownTimer countDownTimer = this.d0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        o0 o0Var = new o0(this, h0.r(), 1000);
        this.d0 = o0Var;
        o0Var.start();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.c0 = this.a0.a();
        this.f0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        this.g0 = (SplashViewModel) new b0(this).a(SplashViewModel.class);
        Intent intent = g().getIntent();
        SplashViewModel splashViewModel = this.g0;
        String action = intent == null ? null : intent.getAction();
        q<Boolean> qVar = this.f0.f343g;
        LiveData R = m.h.R(splashViewModel.c.f2358e);
        LiveData R2 = m.h.R(splashViewModel.c.f2359f);
        q qVar2 = new q(Boolean.TRUE);
        r0 r0Var = new r0(action);
        r0Var.m(qVar, new f0(r0Var));
        r0Var.m(R, new c0(r0Var));
        r0Var.m(R2, new e0(r0Var));
        r0Var.m(qVar2, new d0(r0Var));
        r0Var.f(B(), new a0(this));
        view.setOnClickListener(new b0(this));
    }

    public final void z0() {
        e.m.a.a aVar = new e.m.a.a(t());
        aVar.f(R.id.home_fragment, this.b0, "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        aVar.f1665f = 4099;
        aVar.c();
    }
}
