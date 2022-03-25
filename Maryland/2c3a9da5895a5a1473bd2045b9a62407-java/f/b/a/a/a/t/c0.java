package f.b.a.a.a.t;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.n.b.b;
import f.b.a.a.a.o.p;
import f.b.a.a.a.y.q0;
import f.b.a.a.a.z.m;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class c0 implements b<SubmitPrivateAnalyticsWorker> {
    public final a<a0> a;
    public final a<ExecutorService> b;
    public final a<m> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<p> f2280d;

    /* renamed from: e  reason: collision with root package name */
    public final a<f.b.a.a.a.h.s.a> f2281e;

    /* renamed from: f  reason: collision with root package name */
    public final a<q0> f2282f;

    public c0(a<a0> aVar, a<ExecutorService> aVar2, a<m> aVar3, a<p> aVar4, a<f.b.a.a.a.h.s.a> aVar5, a<q0> aVar6) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2280d = aVar4;
        this.f2281e = aVar5;
        this.f2282f = aVar6;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public SubmitPrivateAnalyticsWorker a(Context context, WorkerParameters workerParameters) {
        return new SubmitPrivateAnalyticsWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2280d.get(), this.f2281e.get(), this.f2282f.get());
    }
}
