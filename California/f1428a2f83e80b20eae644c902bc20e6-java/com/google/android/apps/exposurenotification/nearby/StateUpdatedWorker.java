package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.h.o;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.m.p;
import f.b.a.a.a.n.d;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.n.h;
import f.b.a.a.a.n.j;
import f.b.a.a.a.n.x;
import f.b.a.a.a.n.y;
import f.b.a.a.a.t.e;
import f.b.a.a.a.w.n0;
import f.b.a.a.a.w.o0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.c;

public class StateUpdatedWorker extends ListenableWorker {
    public static final c r = c.l(120);

    /* renamed from: e  reason: collision with root package name */
    public final Context f363e;

    /* renamed from: f  reason: collision with root package name */
    public final o0 f364f;

    /* renamed from: g  reason: collision with root package name */
    public final f0 f365g;

    /* renamed from: h  reason: collision with root package name */
    public final e f366h;

    /* renamed from: i  reason: collision with root package name */
    public final DailySummariesConfig f367i;

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.t.c f368j;

    /* renamed from: k  reason: collision with root package name */
    public final o f369k;

    /* renamed from: l  reason: collision with root package name */
    public final ExecutorService f370l;
    public final ExecutorService m;
    public final ScheduledExecutorService n;
    public final p o;
    public final a p;
    public n0 q;

    public StateUpdatedWorker(Context context, WorkerParameters workerParameters, o0 o0Var, f0 f0Var, n0 n0Var, e eVar, DailySummariesConfig dailySummariesConfig, f.b.a.a.a.t.c cVar, o oVar, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService, p pVar, a aVar) {
        super(context, workerParameters);
        this.f363e = context;
        this.f364f = o0Var;
        this.f365g = f0Var;
        this.q = n0Var;
        this.f366h = eVar;
        this.f367i = dailySummariesConfig;
        this.f368j = cVar;
        this.f369k = oVar;
        this.f370l = executorService;
        this.m = executorService2;
        this.n = scheduledExecutorService;
        this.o = pVar;
        this.p = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f0 f0Var = this.f365g;
        l y = l.x(m.h.g0(f0Var.a.d(this.f367i).d(new j(f0Var)).f(new d(f0Var)).h(new h(f0Var)), r, this.n)).y(new y(this), this.f370l);
        x xVar = new x(this);
        ExecutorService executorService = this.f370l;
        a.b bVar = new a.b(y, Exception.class, xVar);
        ((l.a) y).a(bVar, b.A1(executorService, bVar));
        return bVar;
    }
}
