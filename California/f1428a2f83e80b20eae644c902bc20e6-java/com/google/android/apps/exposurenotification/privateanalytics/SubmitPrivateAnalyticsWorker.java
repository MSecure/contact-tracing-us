package com.google.android.apps.exposurenotification.privateanalytics;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.m.p;
import f.b.a.a.a.r.m;
import f.b.a.a.a.r.n;
import f.b.a.a.a.r.o;
import f.b.a.a.a.r.z;
import f.b.a.a.a.x.l;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import l.b.a.c;

public class SubmitPrivateAnalyticsWorker extends ListenableWorker {

    /* renamed from: i  reason: collision with root package name */
    public static final c f388i = c.e(1);

    /* renamed from: e  reason: collision with root package name */
    public final z f389e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f390f;

    /* renamed from: g  reason: collision with root package name */
    public final p f391g;

    /* renamed from: h  reason: collision with root package name */
    public final l f392h;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public SubmitPrivateAnalyticsWorker(Context context, WorkerParameters workerParameters, z zVar, ExecutorService executorService, l lVar, p pVar) {
        super(context, workerParameters);
        this.f389e = zVar;
        this.f390f = executorService;
        this.f392h = lVar;
        this.f391g = pVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f.b.b.f.a.l y = f.b.b.f.a.l.x(this.f392h.a()).z(new n(this), this.f390f).y(f.b.a.a.a.r.l.a, this.f390f);
        m mVar = m.a;
        ExecutorService executorService = this.f390f;
        a.b bVar = new a.b(y, b.class, mVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.A1(executorService, bVar));
        o oVar = o.a;
        ExecutorService executorService2 = this.f390f;
        a.b bVar2 = new a.b(bVar, Exception.class, oVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.A1(executorService2, bVar2));
        return bVar2;
    }
}
