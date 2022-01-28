package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import f.b.a.a.a.b0.d0;
import f.b.a.a.a.b0.e0;
import f.b.a.a.a.b0.f0;
import f.b.a.a.a.b0.g0;
import f.b.a.a.a.b0.g1;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.b0.j0;
import f.b.a.a.a.b0.p;
import f.b.a.a.a.n0.m;
import f.b.a.a.a.x.n;
import f.b.a.a.a.z.r;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;

public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final d o = d.h(4);
    public static final f.b.a.a.a.s.d0.a p = f.b.a.a.a.s.d0.a.e("ProvideDiagnosisKeysWkr");
    public static final d q = d.n(10);
    public static final d r = d.n(10);

    /* renamed from: g  reason: collision with root package name */
    public final n f376g;

    /* renamed from: h  reason: collision with root package name */
    public final g1 f377h;

    /* renamed from: i  reason: collision with root package name */
    public final i1 f378i;

    /* renamed from: j  reason: collision with root package name */
    public final DiagnosisKeysDataMapping f379j;

    /* renamed from: k  reason: collision with root package name */
    public final ExecutorService f380k;

    /* renamed from: l  reason: collision with root package name */
    public final ScheduledExecutorService f381l;
    public final m m;
    public final r n;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public ProvideDiagnosisKeysWorker(Context context, WorkerParameters workerParameters, n nVar, i1 i1Var, g1 g1Var, DiagnosisKeysDataMapping diagnosisKeysDataMapping, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, m mVar, r rVar) {
        super(context, workerParameters);
        this.f376g = nVar;
        this.f378i = i1Var;
        this.f377h = g1Var;
        this.f379j = diagnosisKeysDataMapping;
        this.f380k = executorService;
        this.f381l = scheduledExecutorService;
        this.m = mVar;
        this.n = rVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        p.a("Starting worker providing the DiagnosisKeysDataMapping to the API, downloading diagnosis key files and submitting them to the API for exposure detection, then storing the token used.");
        l z = l.x(this.m.b()).z(new f0(this), this.f380k).z(new g0(this), this.f380k);
        h0 h0Var = h0.a;
        ExecutorService executorService = this.f380k;
        a.C0108a aVar = new a.C0108a(z, Exception.class, h0Var);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.j1(executorService, aVar));
        l z2 = aVar.z(new e0(this), this.f380k);
        g1 g1Var = this.f377h;
        Objects.requireNonNull(g1Var);
        l y = z2.z(new p(g1Var), this.f380k).y(new d0(this), this.f380k);
        j0 j0Var = new j0(this);
        ExecutorService executorService2 = this.f380k;
        a.b bVar = new a.b(y, b.class, j0Var);
        y.a(bVar, f.b.a.c.b.o.b.j1(executorService2, bVar));
        i0 i0Var = new i0(this);
        ExecutorService executorService3 = this.f380k;
        a.b bVar2 = new a.b(bVar, Exception.class, i0Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.j1(executorService3, bVar2));
        return bVar2;
    }
}
