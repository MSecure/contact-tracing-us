package com.google.android.apps.exposurenotification.onboarding;

import android.content.Context;
import e.c0.w;
import e.r.e0;
import e.r.s;
import f.b.a.a.a.b0.f;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.n0.a1;
import f.b.a.d.a.a0;
import f.b.b.a.a;
import f.b.b.a.l;
/* loaded from: classes.dex */
public class OnboardingViewModel extends e0 {
    public final q1 c;

    /* renamed from: d */
    public final a1 f424d;

    /* renamed from: e */
    public final a0 f425e;

    /* renamed from: f */
    public final w f426f;

    /* renamed from: g */
    public final f f427g;

    /* renamed from: h */
    public final s<l<Boolean>> f428h = new s<>(a.b);

    public OnboardingViewModel(q1 q1Var, a1 a1Var, a0 a0Var, w wVar, f fVar) {
        this.c = q1Var;
        this.f424d = a1Var;
        this.f425e = a0Var;
        this.f426f = wVar;
        this.f427g = fVar;
    }

    public void c(Context context) {
        if (this.f427g.b(context)) {
            f.a.a.a.a.o(this.f427g.b.a, "ExposureNotificationSharedPreferences.HAS_DISPLAYED_ONBOARDING_FOR_MIGRATING_USERS", true);
        }
    }

    public void d(boolean z) {
        this.f424d.a.edit().putInt("ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY", z ? 1 : 2).apply();
    }
}
