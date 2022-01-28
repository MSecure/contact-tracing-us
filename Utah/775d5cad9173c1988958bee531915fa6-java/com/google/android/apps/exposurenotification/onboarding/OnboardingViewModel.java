package com.google.android.apps.exposurenotification.onboarding;

import e.b0.w;
import e.q.e0;
import e.q.s;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.l0.v0;
import f.b.a.d.a.a0;
import f.b.b.a.a;
import f.b.b.a.l;

public class OnboardingViewModel extends e0 {
    public final i1 c;

    /* renamed from: d  reason: collision with root package name */
    public final v0 f417d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f418e;

    /* renamed from: f  reason: collision with root package name */
    public final w f419f;

    /* renamed from: g  reason: collision with root package name */
    public final s<l<Boolean>> f420g = new s<>(a.b);

    public OnboardingViewModel(i1 i1Var, v0 v0Var, a0 a0Var, w wVar) {
        this.c = i1Var;
        this.f417d = v0Var;
        this.f418e = a0Var;
        this.f419f = wVar;
    }

    public void c(boolean z) {
        this.f417d.a.edit().putInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", z ? 1 : 2).apply();
    }
}
