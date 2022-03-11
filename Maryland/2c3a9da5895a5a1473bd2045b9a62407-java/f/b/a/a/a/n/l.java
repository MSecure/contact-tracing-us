package f.b.a.a.a.n;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import l.b.a.c;

public final /* synthetic */ class l implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ l(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        u uVar = (u) obj;
        return uploadCoverTrafficWorker.f358h.schedule((Callable) new n(uploadCoverTrafficWorker), c.h((long) uploadCoverTrafficWorker.f359i.nextInt(3001)).r(), TimeUnit.MILLISECONDS);
    }
}
