package com.google.android.apps.exposurenotification.logging;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.m.k;
import f.b.a.a.a.m.m;
import f.b.a.a.a.m.n;
import f.b.a.a.a.m.p;
import f.b.a.a.a.x.l;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import l.b.a.c;

public class FirelogAnalyticsWorker extends ListenableWorker {

    /* renamed from: h  reason: collision with root package name */
    public static final c f351h = c.f(4).n(30);

    /* renamed from: e  reason: collision with root package name */
    public final p f352e;

    /* renamed from: f  reason: collision with root package name */
    public final l f353f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f354g;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public FirelogAnalyticsWorker(Context context, WorkerParameters workerParameters, p pVar, l lVar, ExecutorService executorService) {
        super(context, workerParameters);
        this.f352e = pVar;
        this.f354g = executorService;
        this.f353f = lVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f.b.b.f.a.l y = f.b.b.f.a.l.x(this.f353f.a()).z(new n(this), this.f354g).y(new f.b.a.a.a.m.l(this), this.f354g);
        m mVar = new m(this);
        ExecutorService executorService = this.f354g;
        a.b bVar = new a.b(y, b.class, mVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.A1(executorService, bVar));
        k kVar = new k(this);
        ExecutorService executorService2 = this.f354g;
        a.b bVar2 = new a.b(bVar, Exception.class, kVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.A1(executorService2, bVar2));
        return bVar2;
    }
}
