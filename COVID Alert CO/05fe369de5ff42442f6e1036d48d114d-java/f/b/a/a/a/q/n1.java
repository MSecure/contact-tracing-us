package f.b.a.a.a.q;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker;
import e.n.b.b;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.o.f0;
import i.a.a;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public final class n1 implements b<PreAuthTEKsReceivedWorker> {
    public final a<v0> a;
    public final a<i0> b;
    public final a<f0> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<ExecutorService> f2339d;

    /* renamed from: e  reason: collision with root package name */
    public final a<ExecutorService> f2340e;

    /* renamed from: f  reason: collision with root package name */
    public final a<SecureRandom> f2341f;

    /* renamed from: g  reason: collision with root package name */
    public final a<f.b.a.a.a.i.f0.a> f2342g;

    public n1(a<v0> aVar, a<i0> aVar2, a<f0> aVar3, a<ExecutorService> aVar4, a<ExecutorService> aVar5, a<SecureRandom> aVar6, a<f.b.a.a.a.i.f0.a> aVar7) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2339d = aVar4;
        this.f2340e = aVar5;
        this.f2341f = aVar6;
        this.f2342g = aVar7;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public PreAuthTEKsReceivedWorker a(Context context, WorkerParameters workerParameters) {
        return new PreAuthTEKsReceivedWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2339d.get(), this.f2340e.get(), this.f2341f.get(), this.f2342g.get());
    }
}
