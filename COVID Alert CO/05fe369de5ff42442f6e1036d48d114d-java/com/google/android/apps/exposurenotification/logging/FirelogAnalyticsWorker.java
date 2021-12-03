package com.google.android.apps.exposurenotification.logging;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.p.n;
import f.b.a.a.a.p.o;
import f.b.a.a.a.p.q;
import f.b.a.a.a.p.r;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import l.b.a.d;

public class FirelogAnalyticsWorker extends ListenableWorker {

    /* renamed from: h  reason: collision with root package name */
    public static final d f361h = d.h(4).r(30);

    /* renamed from: e  reason: collision with root package name */
    public final r f362e;

    /* renamed from: f  reason: collision with root package name */
    public final m f363f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f364g;

    public FirelogAnalyticsWorker(Context context, WorkerParameters workerParameters, r rVar, m mVar, ExecutorService executorService) {
        super(context, workerParameters);
        this.f362e = rVar;
        this.f364g = executorService;
        this.f363f = mVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l x = l.x(this.f363f.b());
        r rVar = this.f362e;
        Objects.requireNonNull(rVar);
        l y = x.z(new q(rVar), this.f364g).y(new o(this), this.f364g);
        f.b.a.a.a.p.m mVar = new f.b.a.a.a.p.m(this);
        ExecutorService executorService = this.f364g;
        a.b bVar = new a.b(y, r.a.class, mVar);
        y.a(bVar, b.g1(executorService, bVar));
        n nVar = new n(this);
        ExecutorService executorService2 = this.f364g;
        a.b bVar2 = new a.b(bVar, Exception.class, nVar);
        bVar.a(bVar2, b.g1(executorService2, bVar2));
        return bVar2;
    }
}
