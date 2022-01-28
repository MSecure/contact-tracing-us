package f.b.a.a.a.o;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.a.a.a.i.y;
import f.b.a.a.a.o.e0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;

public final /* synthetic */ class p implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ p(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        f0 f0Var = uploadCoverTrafficWorker.f354e;
        e0.a i2 = e0.i("FAKE-VALIDATION-CODE", y.a(uploadCoverTrafficWorker.f358i));
        i2.b(true);
        return f0Var.b(i2.a());
    }
}
