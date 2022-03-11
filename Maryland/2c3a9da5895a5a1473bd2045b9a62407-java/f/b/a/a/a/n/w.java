package f.b.a.a.a.n;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.n.b.b;
import f.b.a.a.a.z.m;
import f.b.b.f.a.x;
import i.a.a;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public final class w implements b<UploadCoverTrafficWorker> {
    public final a<v> a;
    public final a<ExecutorService> b;
    public final a<ExecutorService> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<x> f2204d;

    /* renamed from: e  reason: collision with root package name */
    public final a<SecureRandom> f2205e;

    /* renamed from: f  reason: collision with root package name */
    public final a<m> f2206f;

    public w(a<v> aVar, a<ExecutorService> aVar2, a<ExecutorService> aVar3, a<x> aVar4, a<SecureRandom> aVar5, a<m> aVar6) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2204d = aVar4;
        this.f2205e = aVar5;
        this.f2206f = aVar6;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public UploadCoverTrafficWorker a(Context context, WorkerParameters workerParameters) {
        return new UploadCoverTrafficWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2204d.get(), this.f2205e.get(), this.f2206f.get());
    }
}
