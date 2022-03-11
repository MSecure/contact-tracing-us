package com.google.android.apps.exposurenotification.privateanalytics;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.o.p;
import f.b.a.a.a.t.a0;
import f.b.a.a.a.t.n;
import f.b.a.a.a.t.o;
import f.b.a.a.a.y.q0;
import f.b.a.a.a.z.m;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import l.b.a.c;

public class SubmitPrivateAnalyticsWorker extends ListenableWorker {

    /* renamed from: k  reason: collision with root package name */
    public static final c f402k = c.e(1);

    /* renamed from: e  reason: collision with root package name */
    public final a0 f403e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f404f;

    /* renamed from: g  reason: collision with root package name */
    public final p f405g;

    /* renamed from: h  reason: collision with root package name */
    public final m f406h;

    /* renamed from: i  reason: collision with root package name */
    public final q0 f407i;

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f408j;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public SubmitPrivateAnalyticsWorker(Context context, WorkerParameters workerParameters, a0 a0Var, ExecutorService executorService, m mVar, p pVar, f.b.a.a.a.h.s.a aVar, q0 q0Var) {
        super(context, workerParameters);
        this.f403e = a0Var;
        this.f404f = executorService;
        this.f406h = mVar;
        this.f405g = pVar;
        this.f408j = aVar;
        this.f407i = q0Var;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l y = l.x(this.f406h.a()).z(new f.b.a.a.a.t.p(this), this.f404f).y(new o(this), this.f404f);
        f.b.a.a.a.t.m mVar = new f.b.a.a.a.t.m(this);
        ExecutorService executorService = this.f404f;
        a.b bVar = new a.b(y, b.class, mVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.z1(executorService, bVar));
        n nVar = new n(this);
        ExecutorService executorService2 = this.f404f;
        a.b bVar2 = new a.b(bVar, Exception.class, nVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.z1(executorService2, bVar2));
        return bVar2;
    }
}
