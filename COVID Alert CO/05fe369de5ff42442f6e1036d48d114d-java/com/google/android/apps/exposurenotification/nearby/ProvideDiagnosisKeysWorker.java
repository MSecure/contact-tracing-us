package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.n.n;
import f.b.a.a.a.p.r;
import f.b.a.a.a.q.d0;
import f.b.a.a.a.q.e0;
import f.b.a.a.a.q.f0;
import f.b.a.a.a.q.g0;
import f.b.a.a.a.q.g1;
import f.b.a.a.a.q.h0;
import f.b.a.a.a.q.i0;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.q.j0;
import f.b.a.a.a.q.p;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;

public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final d m = d.h(4);
    public static final f.b.a.a.a.i.e0.a n = f.b.a.a.a.i.e0.a.e("ProvideDiagnosisKeysWkr");
    public static final d o = d.n(10);
    public static final d p = d.n(10);

    /* renamed from: e  reason: collision with root package name */
    public final n f374e;

    /* renamed from: f  reason: collision with root package name */
    public final g1 f375f;

    /* renamed from: g  reason: collision with root package name */
    public final i1 f376g;

    /* renamed from: h  reason: collision with root package name */
    public final DiagnosisKeysDataMapping f377h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f378i;

    /* renamed from: j  reason: collision with root package name */
    public final ScheduledExecutorService f379j;

    /* renamed from: k  reason: collision with root package name */
    public final m f380k;

    /* renamed from: l  reason: collision with root package name */
    public final r f381l;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public ProvideDiagnosisKeysWorker(Context context, WorkerParameters workerParameters, n nVar, i1 i1Var, g1 g1Var, DiagnosisKeysDataMapping diagnosisKeysDataMapping, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, m mVar, r rVar) {
        super(context, workerParameters);
        this.f374e = nVar;
        this.f376g = i1Var;
        this.f375f = g1Var;
        this.f377h = diagnosisKeysDataMapping;
        this.f378i = executorService;
        this.f379j = scheduledExecutorService;
        this.f380k = mVar;
        this.f381l = rVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        n.a("Starting worker providing the DiagnosisKeysDataMapping to the API, downloading diagnosis key files and submitting them to the API for exposure detection, then storing the token used.");
        l z = l.x(this.f380k.b()).z(new f0(this), this.f378i).z(new g0(this), this.f378i);
        h0 h0Var = h0.a;
        ExecutorService executorService = this.f378i;
        a.C0108a aVar = new a.C0108a(z, Exception.class, h0Var);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.g1(executorService, aVar));
        l z2 = aVar.z(new e0(this), this.f378i);
        g1 g1Var = this.f375f;
        Objects.requireNonNull(g1Var);
        l y = z2.z(new p(g1Var), this.f378i).y(new d0(this), this.f378i);
        j0 j0Var = new j0(this);
        ExecutorService executorService2 = this.f378i;
        a.b bVar = new a.b(y, b.class, j0Var);
        y.a(bVar, f.b.a.c.b.o.b.g1(executorService2, bVar));
        i0 i0Var = new i0(this);
        ExecutorService executorService3 = this.f378i;
        a.b bVar2 = new a.b(bVar, Exception.class, i0Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.g1(executorService3, bVar2));
        return bVar2;
    }
}
