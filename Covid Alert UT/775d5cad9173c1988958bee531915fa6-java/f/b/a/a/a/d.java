package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker;
import e.b.a.m;
import e.o.a.b;

public class d implements b {
    public final /* synthetic */ k a;

    public d(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        return new PreAuthTEKsReceivedWorker(context, workerParameters, kVar.b(), kVar.j(), kVar.r(), kVar.u.get(), kVar.F.get(), kVar.G.get(), m.e.e1(kVar.f2257e));
    }
}
