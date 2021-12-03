package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.b0.w0;
import f.b.a.a.a.i.w;
import f.b.a.a.a.p.r;
import f.b.a.a.a.q.a1;
import f.b.a.a.a.q.h;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.q.j;
import f.b.a.a.a.q.x0;
import f.b.a.a.a.q.y0;
import f.b.a.a.a.q.z0;
import f.b.a.a.a.x.c;
import f.b.a.a.a.x.e;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;

public class StateUpdatedWorker extends ListenableWorker {
    public static final f.b.a.a.a.i.e0.a q = f.b.a.a.a.i.e0.a.e("StateUpdatedWorker");
    public static final d r = d.n(120);
    public static final d s = d.h(24);

    /* renamed from: e  reason: collision with root package name */
    public final Context f390e;

    /* renamed from: f  reason: collision with root package name */
    public final w0 f391f;

    /* renamed from: g  reason: collision with root package name */
    public final i1 f392g;

    /* renamed from: h  reason: collision with root package name */
    public final e f393h;

    /* renamed from: i  reason: collision with root package name */
    public final DailySummariesConfig f394i;

    /* renamed from: j  reason: collision with root package name */
    public final c f395j;

    /* renamed from: k  reason: collision with root package name */
    public final w f396k;

    /* renamed from: l  reason: collision with root package name */
    public final ExecutorService f397l;
    public final ScheduledExecutorService m;
    public final r n;
    public final f.b.a.a.a.i.f0.a o;
    public v0 p;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public StateUpdatedWorker(Context context, WorkerParameters workerParameters, w0 w0Var, i1 i1Var, v0 v0Var, e eVar, DailySummariesConfig dailySummariesConfig, c cVar, w wVar, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, r rVar, f.b.a.a.a.i.f0.a aVar) {
        super(context, workerParameters);
        this.f390e = context;
        this.f391f = w0Var;
        this.f392g = i1Var;
        this.p = v0Var;
        this.f393h = eVar;
        this.f394i = dailySummariesConfig;
        this.f395j = cVar;
        this.f396k = wVar;
        this.f397l = executorService;
        this.m = scheduledExecutorService;
        this.n = rVar;
        this.o = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        i1 i1Var = this.f392g;
        l y = l.x(m.h.i0(i1Var.a.d(this.f394i).d(new j(i1Var)).f(new f.b.a.a.a.q.d(i1Var)).h(new h(i1Var)), r, this.m)).z(new a1(this), this.f397l).y(new z0(this), this.f397l);
        x0 x0Var = x0.a;
        ExecutorService executorService = this.f397l;
        a.b bVar = new a.b(y, b.class, x0Var);
        y.a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
        y0 y0Var = new y0(this);
        ExecutorService executorService2 = this.f397l;
        a.b bVar2 = new a.b(bVar, Exception.class, y0Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.g1(executorService2, bVar2));
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
