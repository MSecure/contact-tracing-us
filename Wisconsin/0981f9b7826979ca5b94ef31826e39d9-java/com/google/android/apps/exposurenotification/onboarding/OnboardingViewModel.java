package com.google.android.apps.exposurenotification.onboarding;

import androidx.lifecycle.LiveData;
import e.b.a.m;
import e.b0.t;
import e.p.a0;
import e.p.o;
import e.p.x;
import f.b.a.a.a.q.u;
import f.b.a.a.a.w.k0;

public class OnboardingViewModel extends a0 {
    public final k0 c;

    /* renamed from: d  reason: collision with root package name */
    public final t f387d;

    public OnboardingViewModel(k0 k0Var, t tVar) {
        this.c = k0Var;
        this.f387d = tVar;
    }

    public void c(boolean z) {
        this.c.a.edit().putInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", z ? 1 : 2).apply();
    }

    public LiveData<Boolean> d() {
        LiveData R = m.h.R(this.c.f2282f);
        u uVar = u.a;
        o oVar = new o();
        oVar.m(R, new x(oVar, uVar));
        return oVar;
    }
}
