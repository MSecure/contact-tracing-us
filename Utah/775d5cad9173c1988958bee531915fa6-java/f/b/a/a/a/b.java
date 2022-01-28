package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import java.util.Objects;

public class b implements e.o.a.b {
    public final /* synthetic */ k a;

    public b(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        return new CountryCheckingWorker(context, workerParameters, kVar.u.get(), kVar.h(), kVar.t(), kVar.A.get());
    }
}
