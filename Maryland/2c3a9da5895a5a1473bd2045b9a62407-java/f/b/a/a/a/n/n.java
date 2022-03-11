package f.b.a.a.a.n;

import android.util.Log;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.b.a.m;
import f.b.a.a.a.n.r;
import f.b.a.a.a.n.u;
import java.util.Objects;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ n(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        v vVar = uploadCoverTrafficWorker.f355e;
        u.a i2 = u.i("FAKE-VALIDATION-CODE");
        i2.b(true);
        i2.c(uploadCoverTrafficWorker.g());
        r.b bVar = (r.b) i2;
        bVar.f2185e = f.b.a.a.a.h.r.a(100);
        u a2 = bVar.a();
        Objects.requireNonNull(vVar);
        Log.i("UploadController", "Submitting keys for verification certificate...");
        s sVar = vVar.a;
        Objects.requireNonNull(sVar);
        return m.h.f0(new a(sVar, a2));
    }
}
