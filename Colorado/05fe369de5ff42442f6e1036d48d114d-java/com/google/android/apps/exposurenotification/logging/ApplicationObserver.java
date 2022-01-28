package com.google.android.apps.exposurenotification.logging;

import e.p.h;
import e.p.k;
import e.p.u;
import f.b.a.a.a.p.r;
import f.b.a.a.a.v.n;

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
