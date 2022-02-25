package com.google.android.apps.exposurenotification.onboarding;

import androidx.lifecycle.LiveData;
import e.b.a.m;
import e.b0.t;
import e.p.a0;
import e.p.o;
import e.p.x;
import f.b.a.a.a.h.j;
import f.b.a.a.a.q.u;
import f.b.a.a.a.w.n0;
import java.util.Objects;

public class OnboardingViewModel extends a0 {
    public final n0 c;

    /* renamed from: d  reason: collision with root package name */
    public final t f387d;

    public OnboardingViewModel(n0 n0Var, t tVar) {
        this.c = n0Var;
        this.f387d = tVar;
    }

    public void c(boolean z) {
        this.c.a.edit().putInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", z ? 1 : 2).apply();
    }

    public LiveData<Boolean> d() {
        n0 n0Var = this.c;
        Objects.requireNonNull(n0Var);
        LiveData R = m.h.R(new j(n0Var.a, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY"));
        u uVar = u.a;
        o oVar = new o();
        oVar.m(R, new x(oVar, uVar));
        return oVar;
    }
}
