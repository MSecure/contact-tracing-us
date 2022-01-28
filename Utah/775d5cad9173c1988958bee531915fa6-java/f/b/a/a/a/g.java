package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import e.b.a.m;
import e.o.a.b;
import java.util.Objects;

public class g implements b {
    public final /* synthetic */ k a;

    public g(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        return new SmsVerificationWorker(context, workerParameters, kVar.w.get(), kVar.b(), kVar.j(), kVar.r(), m.e.d1(kVar.b), kVar.u.get(), kVar.F.get(), kVar.y.get(), kVar.G.get(), kVar.t(), m.e.e1(kVar.f2257e));
    }
}
