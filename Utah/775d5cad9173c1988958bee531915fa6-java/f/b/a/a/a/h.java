package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import e.o.a.b;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.h0.c;
import f.b.a.a.a.h0.e;
import f.b.a.a.a.h0.f;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.l0.w0;
import g.b.a.c.c.d;
import java.util.Objects;

public class h implements b {
    public final /* synthetic */ k a;

    public h(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        w0 w0Var = new w0(kVar.v.get());
        i1 i1Var = kVar.w.get();
        v0 b = kVar.b();
        f fVar = kVar.m;
        DailySummariesConfig i2 = kVar.i();
        Objects.requireNonNull(fVar);
        e eVar = new e(i2);
        DailySummariesConfig i3 = kVar.i();
        f fVar2 = kVar.m;
        Context t = d.t(kVar.c);
        Objects.requireNonNull(fVar2);
        return new StateUpdatedWorker(context, workerParameters, w0Var, i1Var, b, eVar, i3, new c(new f.b.a.a.a.h0.b[]{new f.b.a.a.a.h0.b(t, 1), new f.b.a.a.a.h0.b(t, 2), new f.b.a.a.a.h0.b(t, 3), new f.b.a.a.a.h0.b(t, 4)}), m.e.d1(kVar.b), kVar.u.get(), kVar.z.get(), kVar.A.get(), m.e.e1(kVar.f2257e));
    }
}
