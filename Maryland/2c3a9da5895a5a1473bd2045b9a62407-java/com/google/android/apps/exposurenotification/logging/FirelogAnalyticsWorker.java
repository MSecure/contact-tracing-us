package com.google.android.apps.exposurenotification.logging;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.o.k;
import f.b.a.a.a.o.n;
import f.b.a.a.a.o.p;
import f.b.a.a.a.z.m;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import l.b.a.c;

public class FirelogAnalyticsWorker extends ListenableWorker {

    /* renamed from: h  reason: collision with root package name */
    public static final c f361h = c.f(4).o(30);

    /* renamed from: e  reason: collision with root package name */
    public final p f362e;

    /* renamed from: f  reason: collision with root package name */
    public final m f363f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f364g;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public FirelogAnalyticsWorker(Context context, WorkerParameters workerParameters, p pVar, m mVar, ExecutorService executorService) {
        super(context, workerParameters);
        this.f362e = pVar;
        this.f364g = executorService;
        this.f363f = mVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l y = l.x(this.f363f.a()).z(new n(this), this.f364g).y(new f.b.a.a.a.o.l(this), this.f364g);
        f.b.a.a.a.o.m mVar = new f.b.a.a.a.o.m(this);
        ExecutorService executorService = this.f364g;
        a.b bVar = new a.b(y, b.class, mVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.z1(executorService, bVar));
        k kVar = new k(this);
        ExecutorService executorService2 = this.f364g;
        a.b bVar2 = new a.b(bVar, Exception.class, kVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.z1(executorService2, bVar2));
        return bVar2;
    }
}
