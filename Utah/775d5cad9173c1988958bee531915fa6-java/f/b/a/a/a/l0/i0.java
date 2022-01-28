package f.b.a.a.a.l0;

import android.os.CancellationSignal;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import e.u.i;
import e.u.n.d;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.e0.a;
import f.b.b.a.g;
import f.b.b.a.l;
import f.b.b.b.c;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class i0 {

    /* renamed from: d  reason: collision with root package name */
    public static final List<h0.c> f2289d = c.w(h0.c.NOT_SHARED, h0.c.NOT_ATTEMPTED);

    /* renamed from: e  reason: collision with root package name */
    public static final List<h0.c> f2290e = c.v(h0.c.SHARED);

    /* renamed from: f  reason: collision with root package name */
    public static final List<h0.d> f2291f = c.w(h0.d.CONFIRMED, h0.d.USER_REPORT);
    public final w a;
    public final ExecutorService b;
    public final a c;

    public i0(ExposureNotificationDatabase exposureNotificationDatabase, ExecutorService executorService, a aVar) {
        this.a = exposureNotificationDatabase.o();
        this.b = executorService;
        this.c = aVar;
    }

    public Long a(long j2, g<h0, h0> gVar) {
        a aVar = new a(this, gVar);
        a0 a0Var = (a0) this.a;
        a0Var.a.c();
        try {
            Long b2 = a0.b(a0Var, j2, aVar);
            a0Var.a.l();
            return b2;
        } finally {
            a0Var.a.g();
        }
    }

    public u<h0> b(long j2) {
        a0 a0Var = (a0) this.a;
        Objects.requireNonNull(a0Var);
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        t.x(1, j2);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(a0Var.a, false, new d0(a0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public u<List<h0>> c(String str) {
        a0 a0Var = (a0) this.a;
        Objects.requireNonNull(a0Var);
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE verificationCode = ?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(a0Var.a, false, new c0(a0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public u<String> d() {
        a0 a0Var = (a0) this.a;
        Objects.requireNonNull(a0Var);
        i t = i.t("SELECT revisionToken FROM RevisionTokenEntity WHERE revisionToken IS NOT NULL ORDER BY createdTimestampMs DESC LIMIT 1", 0);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(a0Var.a, false, new z(a0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public u<l<h0>> e() {
        a0 a0Var = (a0) this.a;
        Objects.requireNonNull(a0Var);
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE isPreAuth == 1 ORDER BY createdTimestampMs DESC LIMIT 1", 0);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(a0Var.a, false, new x(a0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public final h0 f(h0 h0Var) {
        if (h0Var.c() >= 1) {
            return h0Var;
        }
        h0.a r = h0Var.r();
        r.b(this.c.c().G());
        return r.a();
    }

    public final h0 g(h0 h0Var) {
        h0.a r = h0Var.r();
        r.d(this.c.c().G());
        return r.a();
    }
}
