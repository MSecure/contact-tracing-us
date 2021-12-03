package f.b.a.a.a.o;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.n.b.b;
import e.z.t;
import f.b.a.a.a.d0.m;
import f.b.b.f.a.x;
import i.a.a;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public final class g0 implements b<UploadCoverTrafficWorker> {
    public final a<f0> a;
    public final a<ExecutorService> b;
    public final a<ExecutorService> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<x> f2313d;

    /* renamed from: e  reason: collision with root package name */
    public final a<SecureRandom> f2314e;

    /* renamed from: f  reason: collision with root package name */
    public final a<m> f2315f;

    /* renamed from: g  reason: collision with root package name */
    public final a<t> f2316g;

    public g0(a<f0> aVar, a<ExecutorService> aVar2, a<ExecutorService> aVar3, a<x> aVar4, a<SecureRandom> aVar5, a<m> aVar6, a<t> aVar7) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2313d = aVar4;
        this.f2314e = aVar5;
        this.f2315f = aVar6;
        this.f2316g = aVar7;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public UploadCoverTrafficWorker a(Context context, WorkerParameters workerParameters) {
        return new UploadCoverTrafficWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2313d.get(), this.f2314e.get(), this.f2315f.get(), this.f2316g.get());
    }
}
