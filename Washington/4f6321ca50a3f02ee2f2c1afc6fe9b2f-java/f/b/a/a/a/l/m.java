package f.b.a.a.a.l;

import android.util.Log;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.b.a.m;
import f.b.a.a.a.h.r;
import f.b.a.a.a.l.q;
import f.b.a.a.a.l.t;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class m implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ m(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        t tVar = (t) obj;
        u uVar = uploadCoverTrafficWorker.f346e;
        t.a i2 = t.i("FAKE-VALIDATION-CODE");
        i2.b(true);
        i2.c(uploadCoverTrafficWorker.g());
        q.b bVar = (q.b) i2;
        bVar.f2105e = r.a(100);
        t a2 = bVar.a();
        Objects.requireNonNull(uVar);
        Log.i("UploadController", "Submitting keys for verification certificate...");
        r rVar = uVar.a;
        Objects.requireNonNull(rVar);
        return m.h.f0(new a(rVar, a2));
    }
}
