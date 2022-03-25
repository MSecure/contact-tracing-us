package f.b.a.a.a.p;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.n.b.b;
import f.b.a.a.a.h.o;
import f.b.a.a.a.o.p;
import f.b.a.a.a.v.c;
import f.b.a.a.a.v.e;
import f.b.a.a.a.y.q0;
import f.b.a.a.a.y.r0;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class k0 implements b<StateUpdatedWorker> {
    public final a<r0> a;
    public final a<f0> b;
    public final a<q0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<e> f2230d;

    /* renamed from: e  reason: collision with root package name */
    public final a<DailySummariesConfig> f2231e;

    /* renamed from: f  reason: collision with root package name */
    public final a<c> f2232f;

    /* renamed from: g  reason: collision with root package name */
    public final a<o> f2233g;

    /* renamed from: h  reason: collision with root package name */
    public final a<ExecutorService> f2234h;

    /* renamed from: i  reason: collision with root package name */
    public final a<ExecutorService> f2235i;

    /* renamed from: j  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2236j;

    /* renamed from: k  reason: collision with root package name */
    public final a<p> f2237k;

    /* renamed from: l  reason: collision with root package name */
    public final a<f.b.a.a.a.h.s.a> f2238l;

    public k0(a<r0> aVar, a<f0> aVar2, a<q0> aVar3, a<e> aVar4, a<DailySummariesConfig> aVar5, a<c> aVar6, a<o> aVar7, a<ExecutorService> aVar8, a<ExecutorService> aVar9, a<ScheduledExecutorService> aVar10, a<p> aVar11, a<f.b.a.a.a.h.s.a> aVar12) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2230d = aVar4;
        this.f2231e = aVar5;
        this.f2232f = aVar6;
        this.f2233g = aVar7;
        this.f2234h = aVar8;
        this.f2235i = aVar9;
        this.f2236j = aVar10;
        this.f2237k = aVar11;
        this.f2238l = aVar12;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public StateUpdatedWorker a(Context context, WorkerParameters workerParameters) {
        return new StateUpdatedWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2230d.get(), this.f2231e.get(), this.f2232f.get(), this.f2233g.get(), this.f2234h.get(), this.f2235i.get(), this.f2236j.get(), this.f2237k.get(), this.f2238l.get());
    }
}
