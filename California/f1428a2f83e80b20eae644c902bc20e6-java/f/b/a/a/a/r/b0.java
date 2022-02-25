package f.b.a.a.a.r;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.n.b.b;
import f.b.a.a.a.m.p;
import f.b.a.a.a.x.l;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class b0 implements b<SubmitPrivateAnalyticsWorker> {
    public final a<z> a;
    public final a<ExecutorService> b;
    public final a<l> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<p> f2198d;

    public b0(a<z> aVar, a<ExecutorService> aVar2, a<l> aVar3, a<p> aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2198d = aVar4;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public SubmitPrivateAnalyticsWorker a(Context context, WorkerParameters workerParameters) {
        return new SubmitPrivateAnalyticsWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2198d.get());
    }
}
