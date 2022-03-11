package com.google.android.apps.exposurenotification.logging;

import e.r.h;
import e.r.k;
import e.r.u;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.h0.n;
/* loaded from: classes.dex */
public class ApplicationObserver implements k {
    public final r a;

    public ApplicationObserver(r rVar) {
        this.a = rVar;
    }

    @u(h.a.ON_START)
    public void onForeground() {
        this.a.a(n.c.APP_OPENED);
    }
}
