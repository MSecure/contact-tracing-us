package com.google.android.apps.exposurenotification.onboarding;

import e.p.e0;
import e.z.t;
import f.b.a.a.a.b0.v0;
import f.b.a.d.a.a0;

public class OnboardingViewModel extends e0 {
    public final v0 c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f421d;

    /* renamed from: e  reason: collision with root package name */
    public final t f422e;

    public OnboardingViewModel(v0 v0Var, a0 a0Var, t tVar) {
        this.c = v0Var;
        this.f421d = a0Var;
        this.f422e = tVar;
    }

    public void c(boolean z) {
        this.c.a.edit().putInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", z ? 1 : 2).apply();
    }
}
