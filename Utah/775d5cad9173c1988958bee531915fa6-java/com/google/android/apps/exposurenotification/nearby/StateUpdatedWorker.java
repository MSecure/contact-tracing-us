package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.b0.a1;
import f.b.a.a.a.b0.h;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.b0.j;
import f.b.a.a.a.b0.x0;
import f.b.a.a.a.b0.y0;
import f.b.a.a.a.b0.z0;
import f.b.a.a.a.h0.c;
import f.b.a.a.a.h0.e;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.l0.w0;
import f.b.a.a.a.s.v;
import f.b.a.a.a.z.r;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;

public class StateUpdatedWorker extends ListenableWorker {
    public static final f.b.a.a.a.s.d0.a s = f.b.a.a.a.s.d0.a.e("StateUpdatedWorker");
    public static final d t = d.n(120);
    public static final d u = d.h(24);

    /* renamed from: g  reason: collision with root package name */
    public final Context f388g;

    /* renamed from: h  reason: collision with root package name */
    public final w0 f389h;

    /* renamed from: i  reason: collision with root package name */
    public final i1 f390i;

    /* renamed from: j  reason: collision with root package name */
    public final e f391j;

    /* renamed from: k  reason: collision with root package name */
    public final DailySummariesConfig f392k;

    /* renamed from: l  reason: collision with root package name */
    public final c f393l;
    public final v m;
    public final ExecutorService n;
    public final ScheduledExecutorService o;
    public final r p;
    public final f.b.a.a.a.s.e0.a q;
    public v0 r;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public StateUpdatedWorker(Context context, WorkerParameters workerParameters, w0 w0Var, i1 i1Var, v0 v0Var, e eVar, DailySummariesConfig dailySummariesConfig, c cVar, v vVar, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, r rVar, f.b.a.a.a.s.e0.a aVar) {
        super(context, workerParameters);
        this.f388g = context;
        this.f389h = w0Var;
        this.f390i = i1Var;
        this.r = v0Var;
        this.f391j = eVar;
        this.f392k = dailySummariesConfig;
        this.f393l = cVar;
        this.m = vVar;
        this.n = executorService;
        this.o = scheduledExecutorService;
        this.p = rVar;
        this.q = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        i1 i1Var = this.f390i;
        l y = l.x(m.e.m0(i1Var.a.d(this.f392k).d(new j(i1Var)).f(new f.b.a.a.a.b0.d(i1Var)).h(new h(i1Var)), t, this.o)).z(new a1(this), this.n).y(new z0(this), this.n);
        x0 x0Var = x0.a;
        ExecutorService executorService = this.n;
        a.b bVar = new a.b(y, b.class, x0Var);
        y.a(bVar, f.b.a.c.b.o.b.j1(executorService, bVar));
        y0 y0Var = new y0(this);
        ExecutorService executorService2 = this.n;
        a.b bVar2 = new a.b(bVar, Exception.class, y0Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.j1(executorService2, bVar2));
        return bVar2;
    }

    public final int g(Set<f.b.a.c.f.b.d> set) {
        f.b.a.c.f.b.d dVar = f.b.a.c.f.b.d.BLUETOOTH_SUPPORT_UNKNOWN;
        f.b.a.c.f.b.d dVar2 = f.b.a.c.f.b.d.BLUETOOTH_DISABLED;
        f.b.a.c.f.b.d dVar3 = f.b.a.c.f.b.d.LOCATION_DISABLED;
        if (set.contains(dVar3) && (set.contains(dVar2) || set.contains(dVar))) {
            return R.string.updated_bluetooth_location_state_notification;
        }
        if (set.contains(dVar2) || set.contains(dVar)) {
            return R.string.updated_bluetooth_state_notification;
        }
        if (set.contains(dVar3)) {
            return R.string.updated_location_state_notification;
        }
        return 0;
    }
}
