package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import f.b.a.a.a.k.n;
import f.b.a.a.a.m.p;
import f.b.a.a.a.n.d0;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.n.q;
import f.b.a.a.a.n.r;
import f.b.a.a.a.n.s;
import f.b.a.a.a.n.t;
import f.b.a.a.a.n.v;
import f.b.a.a.a.n.w;
import f.b.a.a.a.x.l;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.c;

public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final c m = c.f(4);
    public static final c n = c.l(10);
    public static final c o = c.l(10);

    /* renamed from: e  reason: collision with root package name */
    public final n f355e;

    /* renamed from: f  reason: collision with root package name */
    public final d0 f356f;

    /* renamed from: g  reason: collision with root package name */
    public final f0 f357g;

    /* renamed from: h  reason: collision with root package name */
    public final DiagnosisKeysDataMapping f358h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f359i;

    /* renamed from: j  reason: collision with root package name */
    public final ScheduledExecutorService f360j;

    /* renamed from: k  reason: collision with root package name */
    public final l f361k;

    /* renamed from: l  reason: collision with root package name */
    public final p f362l;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public ProvideDiagnosisKeysWorker(Context context, WorkerParameters workerParameters, n nVar, f0 f0Var, d0 d0Var, DiagnosisKeysDataMapping diagnosisKeysDataMapping, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, l lVar, p pVar) {
        super(context, workerParameters);
        this.f355e = nVar;
        this.f357g = f0Var;
        this.f356f = d0Var;
        this.f358h = diagnosisKeysDataMapping;
        this.f359i = executorService;
        this.f360j = scheduledExecutorService;
        this.f361k = lVar;
        this.f362l = pVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f.b.b.f.a.l z = f.b.b.f.a.l.x(this.f361k.a()).z(new s(this), this.f359i).z(new t(this), this.f359i);
        f.b.a.a.a.n.u uVar = f.b.a.a.a.n.u.a;
        ExecutorService executorService = this.f359i;
        a.C0105a aVar = new a.C0105a(z, Exception.class, uVar);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.A1(executorService, aVar));
        f.b.b.f.a.l z2 = aVar.z(new r(this), this.f359i);
        d0 d0Var = this.f356f;
        Objects.requireNonNull(d0Var);
        f.b.b.f.a.l y = z2.z(new f.b.a.a.a.n.p(d0Var), this.f359i).y(new q(this), this.f359i);
        w wVar = new w(this);
        ExecutorService executorService2 = this.f359i;
        a.b bVar = new a.b(y, b.class, wVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.A1(executorService2, bVar));
        v vVar = new v(this);
        ExecutorService executorService3 = this.f359i;
        a.b bVar2 = new a.b(bVar, Exception.class, vVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.A1(executorService3, bVar2));
        return bVar2;
    }
}
