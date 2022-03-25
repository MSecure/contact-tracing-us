package f.b.a.a.a.n;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.a.a.a.n.u;
import f.b.a.c.b.o.b;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class o implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ o(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        Objects.requireNonNull(uploadCoverTrafficWorker);
        if (!((Boolean) obj).booleanValue()) {
            return b.d1(null);
        }
        v vVar = uploadCoverTrafficWorker.f355e;
        u.a i2 = u.i("FAKE-VALIDATION-CODE");
        i2.b(true);
        return l.x(vVar.a(i2.a())).z(new l(uploadCoverTrafficWorker), uploadCoverTrafficWorker.f356f).z(new q(uploadCoverTrafficWorker), uploadCoverTrafficWorker.f356f);
    }
}
