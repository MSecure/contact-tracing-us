package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import e.o.a.b;
import java.util.Objects;

public class c implements b {
    public final /* synthetic */ k a;

    public c(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        return new FirelogAnalyticsWorker(context, workerParameters, kVar.A.get(), kVar.t(), kVar.u.get());
    }
}
