package f.b.a.a.a.n;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.n.b.b;
import f.b.a.a.a.k.n;
import f.b.a.a.a.m.p;
import f.b.a.a.a.x.l;
import i.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class j0 implements b<ProvideDiagnosisKeysWorker> {
    public final a<n> a;
    public final a<f0> b;
    public final a<d0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<DiagnosisKeysDataMapping> f2142d;

    /* renamed from: e  reason: collision with root package name */
    public final a<ExecutorService> f2143e;

    /* renamed from: f  reason: collision with root package name */
    public final a<ScheduledExecutorService> f2144f;

    /* renamed from: g  reason: collision with root package name */
    public final a<l> f2145g;

    /* renamed from: h  reason: collision with root package name */
    public final a<p> f2146h;

    public j0(a<n> aVar, a<f0> aVar2, a<d0> aVar3, a<DiagnosisKeysDataMapping> aVar4, a<ExecutorService> aVar5, a<ScheduledExecutorService> aVar6, a<l> aVar7, a<p> aVar8) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2142d = aVar4;
        this.f2143e = aVar5;
        this.f2144f = aVar6;
        this.f2145g = aVar7;
        this.f2146h = aVar8;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public ProvideDiagnosisKeysWorker a(Context context, WorkerParameters workerParameters) {
        return new ProvideDiagnosisKeysWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2142d.get(), this.f2143e.get(), this.f2144f.get(), this.f2145g.get(), this.f2146h.get());
    }
}
