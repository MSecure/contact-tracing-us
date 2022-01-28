package com.google.android.apps.exposurenotification.privateanalytics;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.f0.g;
import f.b.a.a.a.f0.h;
import f.b.a.a.a.f0.i;
import f.b.a.a.a.f0.j;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.n0.m;
import f.b.a.a.a.s.d0.a;
import f.b.a.c.b.o.b;
import f.b.a.d.a.b0;
import f.b.a.d.a.g0;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.u;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import l.b.a.d;
import l.b.a.e;

public class SubmitPrivateAnalyticsWorker extends ListenableWorker {
    public static final a n = a.e("PrioSubmitWorker");
    public static final d o = d.f(1);

    /* renamed from: g  reason: collision with root package name */
    public final g0 f421g;

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f422h;

    /* renamed from: i  reason: collision with root package name */
    public final v0 f423i;

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f424j;

    /* renamed from: k  reason: collision with root package name */
    public final m f425k;

    /* renamed from: l  reason: collision with root package name */
    public final l<b0> f426l;
    public int m;

    public SubmitPrivateAnalyticsWorker(Context context, WorkerParameters workerParameters, g0 g0Var, ExecutorService executorService, m mVar, f.b.a.a.a.s.e0.a aVar, v0 v0Var, l<b0> lVar, int i2) {
        super(context, workerParameters);
        this.f421g = g0Var;
        this.f422h = executorService;
        this.f424j = aVar;
        this.f423i = v0Var;
        this.f425k = mVar;
        this.f426l = lVar;
        this.m = i2;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        n.a("Starting worker for submitting private analytics to ingestion server.");
        f.b.b.f.a.l y = f.b.b.f.a.l.x(this.f425k.b()).z(new h(this), this.f422h).y(new i(this), this.f422h);
        j jVar = new j(this);
        ExecutorService executorService = this.f422h;
        a.b bVar = new a.b(y, g0.a.class, jVar);
        y.a(bVar, b.j1(executorService, bVar));
        g gVar = new g(this);
        ExecutorService executorService2 = this.f422h;
        a.b bVar2 = new a.b(bVar, Exception.class, gVar);
        bVar.a(bVar2, b.j1(executorService2, bVar2));
        return bVar2;
    }

    public final void g() {
        v0 v0Var = this.f423i;
        e c = this.f424j.c();
        if (v0Var.g()) {
            v0Var.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME", c.G()).apply();
        }
        if (g0.a(this.m, Calendar.getInstance())) {
            v0 v0Var2 = this.f423i;
            e c2 = this.f424j.c();
            if (v0Var2.g()) {
                v0Var2.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME_FOR_BIWEEKLY", c2.G()).apply();
            }
        }
    }
}
