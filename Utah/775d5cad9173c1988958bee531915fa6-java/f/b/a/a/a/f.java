package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker;
import e.b.a.m;
import e.o.a.b;
import java.util.Objects;

public class f implements b {
    public final /* synthetic */ k a;

    public f(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        return new RestoreNotificationWorker(context, workerParameters, m.e.d1(kVar.b), kVar.b());
    }
}
