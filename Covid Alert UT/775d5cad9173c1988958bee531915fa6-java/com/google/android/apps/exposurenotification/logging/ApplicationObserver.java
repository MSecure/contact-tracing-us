package com.google.android.apps.exposurenotification.logging;

import e.q.h;
import e.q.k;
import e.q.u;
import f.b.a.a.a.g0.n;
import f.b.a.a.a.z.r;

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
