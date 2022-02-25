package f.b.a.a.a.l;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.n.b.b;
import f.b.a.a.a.x.l;
import i.a.a;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public final class v implements b<UploadCoverTrafficWorker> {
    public final a<u> a;
    public final a<ExecutorService> b;
    public final a<ExecutorService> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<SecureRandom> f2124d;

    /* renamed from: e  reason: collision with root package name */
    public final a<l> f2125e;

    public v(a<u> aVar, a<ExecutorService> aVar2, a<ExecutorService> aVar3, a<SecureRandom> aVar4, a<l> aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2124d = aVar4;
        this.f2125e = aVar5;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public UploadCoverTrafficWorker a(Context context, WorkerParameters workerParameters) {
        return new UploadCoverTrafficWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2124d.get(), this.f2125e.get());
    }
}
