package com.google.android.apps.exposurenotification.logging;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.n0.m;
import f.b.a.a.a.z.n;
import f.b.a.a.a.z.o;
import f.b.a.a.a.z.q;
import f.b.a.a.a.z.r;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import l.b.a.d;

public class FirelogAnalyticsWorker extends ListenableWorker {

    /* renamed from: j  reason: collision with root package name */
    public static final d f364j = d.h(4).r(30);

    /* renamed from: g  reason: collision with root package name */
    public final r f365g;

    /* renamed from: h  reason: collision with root package name */
    public final m f366h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f367i;

    public FirelogAnalyticsWorker(Context context, WorkerParameters workerParameters, r rVar, m mVar, ExecutorService executorService) {
        super(context, workerParameters);
        this.f365g = rVar;
        this.f367i = executorService;
        this.f366h = mVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l x = l.x(this.f366h.b());
        r rVar = this.f365g;
        Objects.requireNonNull(rVar);
        l y = x.z(new q(rVar), this.f367i).y(new o(this), this.f367i);
        f.b.a.a.a.z.m mVar = new f.b.a.a.a.z.m(this);
        ExecutorService executorService = this.f367i;
        a.b bVar = new a.b(y, r.a.class, mVar);
        y.a(bVar, b.j1(executorService, bVar));
        n nVar = new n(this);
        ExecutorService executorService2 = this.f367i;
        a.b bVar2 = new a.b(bVar, Exception.class, nVar);
        bVar.a(bVar2, b.j1(executorService2, bVar2));
        return bVar2;
    }
}
