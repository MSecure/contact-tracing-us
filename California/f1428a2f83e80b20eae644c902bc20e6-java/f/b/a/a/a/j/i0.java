package f.b.a.a.a.j;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.home.SplashViewModel;
import e.b.a.m;
import e.m.a.l;
import e.p.b0;
import e.p.q;
import f.b.a.a.a.h.j;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.w.n0;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.c;

public class i0 extends d0 {
    public static final c f0;
    public a Z;
    public l a0 = new e0();
    public long b0;
    public CountDownTimer c0 = null;
    public ExposureNotificationViewModel d0;
    public SplashViewModel e0;

    static {
        c cVar = c.f4031d;
        long j2 = 2;
        int i2 = (int) 500;
        if (i2 < 0) {
            i2 += 1000;
            j2 = 1;
        }
        f0 = c.c(j2, i2 * 1000000);
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_start, viewGroup, false);
    }

    @Override // e.m.a.l
    public void Y() {
        this.D = true;
        CountDownTimer countDownTimer = this.c0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.d0.d();
        CountDownTimer countDownTimer = this.c0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        h0 h0Var = new h0(this, f0.q(), 1000);
        this.c0 = h0Var;
        h0Var.start();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.b0 = this.Z.a();
        this.d0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        this.e0 = (SplashViewModel) new b0(this).a(SplashViewModel.class);
        Intent intent = g().getIntent();
        SplashViewModel splashViewModel = this.e0;
        String action = intent == null ? null : intent.getAction();
        q<Boolean> qVar = this.d0.f333f;
        n0 n0Var = splashViewModel.c;
        Objects.requireNonNull(n0Var);
        LiveData R = m.h.R(new j(n0Var.a, "ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY"));
        n0 n0Var2 = splashViewModel.c;
        Objects.requireNonNull(n0Var2);
        LiveData R2 = m.h.R(new j(n0Var2.a, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY"));
        q qVar2 = new q(Boolean.TRUE);
        k0 k0Var = new k0(action);
        k0Var.m(qVar, new y(k0Var));
        k0Var.m(R, new v(k0Var));
        k0Var.m(R2, new x(k0Var));
        k0Var.m(qVar2, new w(k0Var));
        k0Var.f(B(), new t(this));
        view.setOnClickListener(new u(this));
    }

    public final void z0() {
        e.m.a.a aVar = new e.m.a.a(t());
        aVar.f(R.id.home_fragment, this.a0, "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        aVar.f1638f = 4099;
        aVar.c();
    }
}
