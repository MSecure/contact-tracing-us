package f.b.a.a.a.q;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.n.b.b;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.n.n;
import f.b.a.a.a.p.r;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class o1 implements b<ProvideDiagnosisKeysWorker> {
    public final a<n> a;
    public final a<i1> b;
    public final a<g1> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<DiagnosisKeysDataMapping> f2343d;

    /* renamed from: e  reason: collision with root package name */
    public final a<ExecutorService> f2344e;

    /* renamed from: f  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2345f;

    /* renamed from: g  reason: collision with root package name */
    public final a<m> f2346g;

    /* renamed from: h  reason: collision with root package name */
    public final a<r> f2347h;

    public o1(a<n> aVar, a<i1> aVar2, a<g1> aVar3, a<DiagnosisKeysDataMapping> aVar4, a<ExecutorService> aVar5, a<ScheduledExecutorService> aVar6, a<m> aVar7, a<r> aVar8) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2343d = aVar4;
        this.f2344e = aVar5;
        this.f2345f = aVar6;
        this.f2346g = aVar7;
        this.f2347h = aVar8;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public ProvideDiagnosisKeysWorker a(Context context, WorkerParameters workerParameters) {
        return new ProvideDiagnosisKeysWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2343d.get(), this.f2344e.get(), this.f2345f.get(), this.f2346g.get(), this.f2347h.get());
    }
}
