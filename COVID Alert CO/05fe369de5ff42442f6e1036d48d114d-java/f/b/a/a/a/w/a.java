package f.b.a.a.a.w;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker;
import e.n.b.b;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.w;

public final class a implements b<RestoreNotificationWorker> {
    public final i.a.a<w> a;
    public final i.a.a<v0> b;

    public a(i.a.a<w> aVar, i.a.a<v0> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public RestoreNotificationWorker a(Context context, WorkerParameters workerParameters) {
        return new RestoreNotificationWorker(context, workerParameters, this.a.get(), this.b.get());
    }
}
