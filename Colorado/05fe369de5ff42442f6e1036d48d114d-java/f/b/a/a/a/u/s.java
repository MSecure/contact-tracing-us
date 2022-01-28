package f.b.a.a.a.u;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.n.b.b;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.d0.m;
import f.b.a.d.a.b0;
import f.b.a.d.a.g0;
import f.b.b.a.l;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class s implements b<SubmitPrivateAnalyticsWorker> {
    public final a<g0> a;
    public final a<ExecutorService> b;
    public final a<m> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<f.b.a.a.a.i.f0.a> f2426d;

    /* renamed from: e  reason: collision with root package name */
    public final a<v0> f2427e;

    /* renamed from: f  reason: collision with root package name */
    public final a<l<b0>> f2428f;

    /* renamed from: g  reason: collision with root package name */
    public final a<Integer> f2429g;

    public s(a<g0> aVar, a<ExecutorService> aVar2, a<m> aVar3, a<f.b.a.a.a.i.f0.a> aVar4, a<v0> aVar5, a<l<b0>> aVar6, a<Integer> aVar7) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2426d = aVar4;
        this.f2427e = aVar5;
        this.f2428f = aVar6;
        this.f2429g = aVar7;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public SubmitPrivateAnalyticsWorker a(Context context, WorkerParameters workerParameters) {
        return new SubmitPrivateAnalyticsWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2426d.get(), this.f2427e.get(), this.f2428f.get(), this.f2429g.get().intValue());
    }
}
