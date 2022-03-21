package f.b.a.a.a.r;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.n.b.b;
import f.b.a.a.a.m.p;
import f.b.a.a.a.x.k;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class d0 implements b<SubmitPrivateAnalyticsWorker> {
    public final a<b0> a;
    public final a<ExecutorService> b;
    public final a<k> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<p> f2204d;

    public d0(a<b0> aVar, a<ExecutorService> aVar2, a<k> aVar3, a<p> aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2204d = aVar4;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public SubmitPrivateAnalyticsWorker a(Context context, WorkerParameters workerParameters) {
        return new SubmitPrivateAnalyticsWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2204d.get());
    }
}
