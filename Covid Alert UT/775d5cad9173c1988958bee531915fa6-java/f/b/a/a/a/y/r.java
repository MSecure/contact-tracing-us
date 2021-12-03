package f.b.a.a.a.y;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import java.util.concurrent.Callable;

public final /* synthetic */ class r implements Callable {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ r(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        return uploadCoverTrafficWorker.f358g.c(uploadCoverTrafficWorker.g());
    }
}
