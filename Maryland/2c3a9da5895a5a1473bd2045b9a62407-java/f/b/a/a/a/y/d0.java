package f.b.a.a.a.y;

import android.os.CancellationSignal;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import e.f.a.f;
import e.t.g;
import e.t.i;
import e.t.n.c;
import e.t.n.d;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.y.c0;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class d0 {
    public final u a;
    public final ExecutorService b;
    public final a c;

    public d0(ExposureNotificationDatabase exposureNotificationDatabase, ExecutorService executorService, a aVar) {
        this.a = exposureNotificationDatabase.o();
        this.b = executorService;
        this.c = aVar;
    }

    public u<Void> a(long j2) {
        v vVar = (v) this.a;
        g gVar = vVar.a;
        w wVar = new w(vVar, j2);
        Executor executor = gVar.c;
        f fVar = new f();
        executor.execute(new c(wVar, fVar));
        return fVar;
    }

    public u<c0> b(long j2) {
        v vVar = (v) this.a;
        Objects.requireNonNull(vVar);
        i v = i.v("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        v.A(1, j2);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.a(vVar.a, false, new y(vVar, v, cancellationSignal), v, true, cancellationSignal);
    }

    public final c0 c(c0 c0Var) {
        if (c0Var.c() >= 1) {
            return c0Var;
        }
        c0.a p = c0Var.p();
        p.b(this.c.b().E());
        return p.a();
    }
}
