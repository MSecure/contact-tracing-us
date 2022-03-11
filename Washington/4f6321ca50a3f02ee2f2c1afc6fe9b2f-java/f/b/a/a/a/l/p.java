package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.a.a.a.l.t;
import f.b.a.c.b.o.b;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class p implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ p(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        Objects.requireNonNull(uploadCoverTrafficWorker);
        if (!((Boolean) obj).booleanValue()) {
            return b.c1(null);
        }
        u uVar = uploadCoverTrafficWorker.f346e;
        t.a i2 = t.i("FAKE-VALIDATION-CODE");
        i2.b(true);
        return l.x(uVar.a(i2.a())).z(new m(uploadCoverTrafficWorker), uploadCoverTrafficWorker.f347f).z(new l(uploadCoverTrafficWorker), uploadCoverTrafficWorker.f347f);
    }
}
