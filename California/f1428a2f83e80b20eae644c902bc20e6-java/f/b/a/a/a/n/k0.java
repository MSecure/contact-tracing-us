package f.b.a.a.a.n;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.n.b.b;
import f.b.a.a.a.h.o;
import f.b.a.a.a.m.p;
import f.b.a.a.a.t.c;
import f.b.a.a.a.t.e;
import f.b.a.a.a.w.n0;
import f.b.a.a.a.w.o0;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class k0 implements b<StateUpdatedWorker> {
    public final a<o0> a;
    public final a<f0> b;
    public final a<n0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<e> f2147d;

    /* renamed from: e  reason: collision with root package name */
    public final a<DailySummariesConfig> f2148e;

    /* renamed from: f  reason: collision with root package name */
    public final a<c> f2149f;

    /* renamed from: g  reason: collision with root package name */
    public final a<o> f2150g;

    /* renamed from: h  reason: collision with root package name */
    public final a<ExecutorService> f2151h;

    /* renamed from: i  reason: collision with root package name */
    public final a<ExecutorService> f2152i;

    /* renamed from: j  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2153j;

    /* renamed from: k  reason: collision with root package name */
    public final a<p> f2154k;

    /* renamed from: l  reason: collision with root package name */
    public final a<f.b.a.a.a.h.s.a> f2155l;

    public k0(a<o0> aVar, a<f0> aVar2, a<n0> aVar3, a<e> aVar4, a<DailySummariesConfig> aVar5, a<c> aVar6, a<o> aVar7, a<ExecutorService> aVar8, a<ExecutorService> aVar9, a<ScheduledExecutorService> aVar10, a<p> aVar11, a<f.b.a.a.a.h.s.a> aVar12) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2147d = aVar4;
        this.f2148e = aVar5;
        this.f2149f = aVar6;
        this.f2150g = aVar7;
        this.f2151h = aVar8;
        this.f2152i = aVar9;
        this.f2153j = aVar10;
        this.f2154k = aVar11;
        this.f2155l = aVar12;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public StateUpdatedWorker a(Context context, WorkerParameters workerParameters) {
        return new StateUpdatedWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2147d.get(), this.f2148e.get(), this.f2149f.get(), this.f2150g.get(), this.f2151h.get(), this.f2152i.get(), this.f2153j.get(), this.f2154k.get(), this.f2155l.get());
    }
}
