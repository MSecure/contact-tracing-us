package com.google.android.apps.exposurenotification.privateanalytics;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.u.g;
import f.b.a.a.a.u.h;
import f.b.a.a.a.u.i;
import f.b.a.a.a.u.j;
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

    /* renamed from: l  reason: collision with root package name */
    public static final f.b.a.a.a.i.e0.a f423l = f.b.a.a.a.i.e0.a.e("PrioSubmitWorker");
    public static final d m = d.f(1);

    /* renamed from: e  reason: collision with root package name */
    public final g0 f424e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f425f;

    /* renamed from: g  reason: collision with root package name */
    public final v0 f426g;

    /* renamed from: h  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.a f427h;

    /* renamed from: i  reason: collision with root package name */
    public final m f428i;

    /* renamed from: j  reason: collision with root package name */
    public final l<b0> f429j;

    /* renamed from: k  reason: collision with root package name */
    public int f430k;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public SubmitPrivateAnalyticsWorker(Context context, WorkerParameters workerParameters, g0 g0Var, ExecutorService executorService, m mVar, f.b.a.a.a.i.f0.a aVar, v0 v0Var, l<b0> lVar, int i2) {
        super(context, workerParameters);
        this.f424e = g0Var;
        this.f425f = executorService;
        this.f427h = aVar;
        this.f426g = v0Var;
        this.f428i = mVar;
        this.f429j = lVar;
        this.f430k = i2;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f423l.a("Starting worker for submitting private analytics to ingestion server.");
        f.b.b.f.a.l y = f.b.b.f.a.l.x(this.f428i.b()).z(new j(this), this.f425f).y(new i(this), this.f425f);
        g gVar = new g(this);
        ExecutorService executorService = this.f425f;
        a.b bVar = new a.b(y, b.class, gVar);
        y.a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
        h hVar = new h(this);
        ExecutorService executorService2 = this.f425f;
        a.b bVar2 = new a.b(bVar, Exception.class, hVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.g1(executorService2, bVar2));
        return bVar2;
    }

    public final void g() {
        v0 v0Var = this.f426g;
        e c = this.f427h.c();
        if (v0Var.g()) {
            v0Var.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME", c.G()).apply();
        }
        if (g0.a(this.f430k, Calendar.getInstance())) {
            v0 v0Var2 = this.f426g;
            e c2 = this.f427h.c();
            if (v0Var2.g()) {
                v0Var2.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME_FOR_BIWEEKLY", c2.G()).apply();
            }
        }
    }
}
