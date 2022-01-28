package f.b.a.a.a.q;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.n.b.b;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.b0.w0;
import f.b.a.a.a.i.w;
import f.b.a.a.a.p.r;
import f.b.a.a.a.x.c;
import f.b.a.a.a.x.e;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class r1 implements b<StateUpdatedWorker> {
    public final a<w0> a;
    public final a<i1> b;
    public final a<v0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<e> f2356d;

    /* renamed from: e  reason: collision with root package name */
    public final a<DailySummariesConfig> f2357e;

    /* renamed from: f  reason: collision with root package name */
    public final a<c> f2358f;

    /* renamed from: g  reason: collision with root package name */
    public final a<w> f2359g;

    /* renamed from: h  reason: collision with root package name */
    public final a<ExecutorService> f2360h;

    /* renamed from: i  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2361i;

    /* renamed from: j  reason: collision with root package name */
    public final a<r> f2362j;

    /* renamed from: k  reason: collision with root package name */
    public final a<f.b.a.a.a.i.f0.a> f2363k;

    public r1(a<w0> aVar, a<i1> aVar2, a<v0> aVar3, a<e> aVar4, a<DailySummariesConfig> aVar5, a<c> aVar6, a<w> aVar7, a<ExecutorService> aVar8, a<ScheduledExecutorService> aVar9, a<r> aVar10, a<f.b.a.a.a.i.f0.a> aVar11) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2356d = aVar4;
        this.f2357e = aVar5;
        this.f2358f = aVar6;
        this.f2359g = aVar7;
        this.f2360h = aVar8;
        this.f2361i = aVar9;
        this.f2362j = aVar10;
        this.f2363k = aVar11;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public StateUpdatedWorker a(Context context, WorkerParameters workerParameters) {
        return new StateUpdatedWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2356d.get(), this.f2357e.get(), this.f2358f.get(), this.f2359g.get(), this.f2360h.get(), this.f2361i.get(), this.f2362j.get(), this.f2363k.get());
    }
}
