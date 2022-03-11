package f.b.a.a.a.n0;

import android.os.CancellationSignal;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import e.v.i;
import e.v.n.d;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.t.q0.a;
import f.b.b.a.g;
import f.b.b.a.l;
import f.b.b.b.c;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: d */
    public static final List<j0.c> f2367d = c.w(j0.c.NOT_SHARED, j0.c.NOT_ATTEMPTED);

    /* renamed from: e */
    public static final List<j0.c> f2368e = c.v(j0.c.SHARED);

    /* renamed from: f */
    public static final List<j0.d> f2369f = c.w(j0.d.CONFIRMED, j0.d.USER_REPORT);
    public final x a;
    public final ExecutorService b;
    public final a c;

    public k0(ExposureNotificationDatabase exposureNotificationDatabase, ExecutorService executorService, a aVar) {
        this.a = exposureNotificationDatabase.o();
        this.b = executorService;
        this.c = aVar;
    }

    public Long a(long j2, g<j0, j0> gVar) {
        a aVar = new g(gVar) { // from class: f.b.a.a.a.n0.a
            public final /* synthetic */ g b;

            {
                this.b = r2;
            }

            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                k0 k0Var = k0.this;
                Objects.requireNonNull(k0Var);
                return k0Var.g(k0Var.f((j0) this.b.a((j0) obj)));
            }
        };
        d0 d0Var = (d0) this.a;
        d0Var.a.c();
        try {
            Long b = d0.b(d0Var, j2, aVar);
            d0Var.a.l();
            return b;
        } finally {
            d0Var.a.g();
        }
    }

    public u<j0> b(long j2) {
        d0 d0Var = (d0) this.a;
        Objects.requireNonNull(d0Var);
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        t.x(1, j2);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(d0Var.a, false, new h0(d0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public u<List<j0>> c(String str) {
        d0 d0Var = (d0) this.a;
        Objects.requireNonNull(d0Var);
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE verificationCode = ?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(d0Var.a, false, new g0(d0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public u<String> d() {
        d0 d0Var = (d0) this.a;
        Objects.requireNonNull(d0Var);
        i t = i.t("SELECT revisionToken FROM RevisionTokenEntity WHERE revisionToken IS NOT NULL ORDER BY createdTimestampMs DESC LIMIT 1", 0);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(d0Var.a, false, new c0(d0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public u<l<j0>> e() {
        d0 d0Var = (d0) this.a;
        Objects.requireNonNull(d0Var);
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE isPreAuth == 1 ORDER BY createdTimestampMs DESC LIMIT 1", 0);
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(d0Var.a, false, new a0(d0Var, t, cancellationSignal), t, true, cancellationSignal);
    }

    public final j0 f(j0 j0Var) {
        if (j0Var.c() >= 1) {
            return j0Var;
        }
        j0.a r = j0Var.r();
        r.b(this.c.c().G());
        return r.a();
    }

    public final j0 g(j0 j0Var) {
        j0.a r = j0Var.r();
        r.d(this.c.c().G());
        return r.a();
    }
}
