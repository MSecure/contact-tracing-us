package f.b.a.a.a.w;

import android.os.CancellationSignal;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import e.t.i;
import e.t.n.d;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.w.b0;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class c0 {
    public final t a;
    public final ExecutorService b;
    public final a c;

    public c0(ExposureNotificationDatabase exposureNotificationDatabase, ExecutorService executorService, a aVar) {
        this.a = exposureNotificationDatabase.o();
        this.b = executorService;
        this.c = aVar;
    }

    public u<b0> a(long j2) {
        u uVar = (u) this.a;
        Objects.requireNonNull(uVar);
        i v = i.v("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        v.A(1, j2);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.a(uVar.a, false, new x(uVar, v, cancellationSignal), v, true, cancellationSignal);
    }

    public final b0 b(b0 b0Var) {
        if (b0Var.c() >= 1) {
            return b0Var;
        }
        b0.a p = b0Var.p();
        p.b(this.c.b().D());
        return p.a();
    }
}
