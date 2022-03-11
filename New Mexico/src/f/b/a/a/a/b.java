package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import java.util.Objects;
/* loaded from: classes.dex */
public class b implements e.p.a.b {
    public final /* synthetic */ k a;

    public b(k kVar) {
        this.a = kVar;
    }

    @Override // e.p.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.t;
        Objects.requireNonNull(kVar);
        return new CountryCheckingWorker(context, workerParameters, kVar.v.get(), kVar.h(), kVar.v(), kVar.B.get());
    }
}
