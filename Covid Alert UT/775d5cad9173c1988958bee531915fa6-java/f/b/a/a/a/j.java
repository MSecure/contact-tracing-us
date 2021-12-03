package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.o.a.b;
import java.util.Objects;

public class j implements b {
    public final /* synthetic */ k a;

    public j(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        return new UploadCoverTrafficWorker(context, workerParameters, kVar.r(), kVar.u.get(), kVar.F.get(), kVar.y.get(), kVar.G.get(), kVar.t(), kVar.s());
    }
}
