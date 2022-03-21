package f.b.a.a.a.u;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.n.b.b;
import f.b.a.a.a.m.p;
import f.b.a.a.a.x.k;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class c implements b<CountryCheckingWorker> {
    public final a<ExecutorService> a;
    public final a<d> b;
    public final a<k> c;

    /* renamed from: d  reason: collision with root package name */
    public final a<p> f2249d;

    public c(a<ExecutorService> aVar, a<d> aVar2, a<k> aVar3, a<p> aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f2249d = aVar4;
    }

    /* Return type fixed from 'androidx.work.ListenableWorker' to match base method */
    @Override // e.n.b.b
    public CountryCheckingWorker a(Context context, WorkerParameters workerParameters) {
        return new CountryCheckingWorker(context, workerParameters, this.a.get(), this.b.get(), this.c.get(), this.f2249d.get());
    }
}
