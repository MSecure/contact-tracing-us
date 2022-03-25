package f.b.a.a.a.p;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.n.b.b;
import f.b.a.a.a.m.n;
import f.b.a.a.a.o.p;
import f.b.a.a.a.z.m;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class j0 implements b<ProvideDiagnosisKeysWorker> {
    public final a<n> a;
    public final a<f0> b;
    public final a<d0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<DiagnosisKeysDataMapping> f2225d;

    /* renamed from: e  reason: collision with root package name */
    public final a<ExecutorService> f2226e;

    /* renamed from: f  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2227f;

    /* renamed from: g  reason: collision with root package name */
    public final a<m> f2228g;

    /* renamed from: h  reason: collision with root package name */
    public final a<p> f2229h;

    public j0(a<n> aVar, a<f0> aVar2, a<d0> aVar3, a<DiagnosisKeysDataMapping> aVar4, a<ExecutorService> aVar5, a<ScheduledExecutorService> aVar6, a<m> aVar7, a<p> aVar8) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2225d = aVar4;
        this.f2226e = aVar5;
        this.f2227f = aVar6;
        this.f2228g = aVar7;
        this.f2229h = aVar8;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public ProvideDiagnosisKeysWorker a(Context context, WorkerParameters workerParameters) {
        return new ProvideDiagnosisKeysWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2225d.get(), this.f2226e.get(), this.f2227f.get(), this.f2228g.get(), this.f2229h.get());
    }
}
