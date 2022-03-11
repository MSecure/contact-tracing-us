package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import f.b.a.a.a.m.n;
import f.b.a.a.a.o.p;
import f.b.a.a.a.p.d0;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.p.q;
import f.b.a.a.a.p.r;
import f.b.a.a.a.p.s;
import f.b.a.a.a.p.t;
import f.b.a.a.a.p.v;
import f.b.a.a.a.p.w;
import f.b.a.a.a.z.m;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.c;

public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final c m = c.f(4);
    public static final c n = c.m(10);
    public static final c o = c.m(10);

    /* renamed from: e  reason: collision with root package name */
    public final n f365e;

    /* renamed from: f  reason: collision with root package name */
    public final d0 f366f;

    /* renamed from: g  reason: collision with root package name */
    public final f0 f367g;

    /* renamed from: h  reason: collision with root package name */
    public final DiagnosisKeysDataMapping f368h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f369i;

    /* renamed from: j  reason: collision with root package name */
    public final ScheduledExecutorService f370j;

    /* renamed from: k  reason: collision with root package name */
    public final m f371k;

    /* renamed from: l  reason: collision with root package name */
    public final p f372l;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public ProvideDiagnosisKeysWorker(Context context, WorkerParameters workerParameters, n nVar, f0 f0Var, d0 d0Var, DiagnosisKeysDataMapping diagnosisKeysDataMapping, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, m mVar, p pVar) {
        super(context, workerParameters);
        this.f365e = nVar;
        this.f367g = f0Var;
        this.f366f = d0Var;
        this.f368h = diagnosisKeysDataMapping;
        this.f369i = executorService;
        this.f370j = scheduledExecutorService;
        this.f371k = mVar;
        this.f372l = pVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l z = l.x(this.f371k.a()).z(new s(this), this.f369i).z(new t(this), this.f369i);
        f.b.a.a.a.p.u uVar = f.b.a.a.a.p.u.a;
        ExecutorService executorService = this.f369i;
        a.C0109a aVar = new a.C0109a(z, Exception.class, uVar);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.z1(executorService, aVar));
        l z2 = aVar.z(new r(this), this.f369i);
        d0 d0Var = this.f366f;
        Objects.requireNonNull(d0Var);
        l y = z2.z(new f.b.a.a.a.p.p(d0Var), this.f369i).y(new q(this), this.f369i);
        w wVar = new w(this);
        ExecutorService executorService2 = this.f369i;
        a.b bVar = new a.b(y, b.class, wVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.z1(executorService2, bVar));
        v vVar = new v(this);
        ExecutorService executorService3 = this.f369i;
        a.b bVar2 = new a.b(bVar, Exception.class, vVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.z1(executorService3, bVar2));
        return bVar2;
    }
}
