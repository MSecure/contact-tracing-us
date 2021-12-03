package f.b.a.a.a.p;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import e.n.b.b;
import f.b.a.a.a.d0.m;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class t implements b<FirelogAnalyticsWorker> {
    public final a<r> a;
    public final a<m> b;
    public final a<ExecutorService> c;

    public t(a<r> aVar, a<m> aVar2, a<ExecutorService> aVar3) {
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
