package com.google.android.apps.exposurenotification.onboarding;

import e.c0.t;
import e.p.a0;
import f.b.a.a.a.y.q0;

public class OnboardingViewModel extends a0 {
    public final q0 c;

    /* renamed from: d  reason: collision with root package name */
    public final t f401d;

    public OnboardingViewModel(q0 q0Var, t tVar) {
        this.c = q0Var;
        this.f401d = tVar;
    }

    public void c(boolean z) {
        this.c.a.edit().putInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", z ? 1 : 2).apply();
    }
}
