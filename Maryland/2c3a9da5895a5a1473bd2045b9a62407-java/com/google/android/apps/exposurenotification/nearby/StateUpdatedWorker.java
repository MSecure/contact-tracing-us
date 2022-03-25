package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.h.o;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.o.p;
import f.b.a.a.a.p.d;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.p.h;
import f.b.a.a.a.p.j;
import f.b.a.a.a.p.x;
import f.b.a.a.a.p.y;
import f.b.a.a.a.v.e;
import f.b.a.a.a.y.q0;
import f.b.a.a.a.y.r0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.c;

public class StateUpdatedWorker extends ListenableWorker {
    public static final c r = c.m(120);

    /* renamed from: e  reason: collision with root package name */
    public final Context f373e;

    /* renamed from: f  reason: collision with root package name */
    public final r0 f374f;

    /* renamed from: g  reason: collision with root package name */
    public final f0 f375g;

    /* renamed from: h  reason: collision with root package name */
    public final e f376h;

    /* renamed from: i  reason: collision with root package name */
    public final DailySummariesConfig f377i;

    /* renamed from: j  reason: collision with root package name */
    public final f.b.a.a.a.v.c f378j;

    /* renamed from: k  reason: collision with root package name */
    public final o f379k;

    /* renamed from: l  reason: collision with root package name */
    public final ExecutorService f380l;
    public final ExecutorService m;
    public final ScheduledExecutorService n;
    public final p o;
    public final a p;
    public q0 q;

    public StateUpdatedWorker(Context context, WorkerParameters workerParameters, r0 r0Var, f0 f0Var, q0 q0Var, e eVar, DailySummariesConfig dailySummariesConfig, f.b.a.a.a.v.c cVar, o oVar, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService, p pVar, a aVar) {
        super(context, workerParameters);
        this.f373e = context;
        this.f374f = r0Var;
        this.f375g = f0Var;
        this.q = q0Var;
        this.f376h = eVar;
        this.f377i = dailySummariesConfig;
        this.f378j = cVar;
        this.f379k = oVar;
        this.f380l = executorService;
        this.m = executorService2;
        this.n = scheduledExecutorService;
        this.o = pVar;
        this.p = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f0 f0Var = this.f375g;
        l y = l.x(m.h.g0(f0Var.a.c(this.f377i).d(new j(f0Var)).f(new d(f0Var)).h(new h(f0Var)), r, this.n)).y(new y(this), this.f380l);
        x xVar = new x(this);
        ExecutorService executorService = this.f380l;
        a.b bVar = new a.b(y, Exception.class, xVar);
        ((l.a) y).a(bVar, b.z1(executorService, bVar));
        return bVar;
    }
}
