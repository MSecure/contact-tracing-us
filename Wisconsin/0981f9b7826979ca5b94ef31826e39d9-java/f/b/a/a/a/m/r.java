package f.b.a.a.a.m;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import e.n.b.b;
import f.b.a.a.a.x.k;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class r implements b<FirelogAnalyticsWorker> {
    public final a<p> a;
    public final a<k> b;
    public final a<ExecutorService> c;

    public r(a<p> aVar, a<k> aVar2, a<ExecutorService> aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public FirelogAnalyticsWorker a(Context context, WorkerParameters workerParameters) {
        return new FirelogAnalyticsWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get());
    }
}
