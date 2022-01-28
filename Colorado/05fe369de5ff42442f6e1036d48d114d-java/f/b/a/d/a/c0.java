package f.b.a.d.a;

import f.b.a.a.a.u.q;
import f.b.a.c.b.o.b;
import f.b.a.d.a.d0;
import f.b.b.b.c;
import f.b.b.b.d;
import f.b.b.c.a;
import f.b.c.k.e;
import f.b.c.k.f;
import f.b.c.k.h;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;
import l.b.a.r;
import l.b.a.v.c;

public class c0 {

    /* renamed from: f  reason: collision with root package name */
    public static final d f2743f = d.l(5);

    /* renamed from: g  reason: collision with root package name */
    public static final c f2744g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f2745h = a.a;
    public final z a;
    public final f b;
    public final d0 c;

    /* renamed from: d  reason: collision with root package name */
    public final ScheduledExecutorService f2746d = t.f2776e;

    /* renamed from: e  reason: collision with root package name */
    public final SecureRandom f2747e = new SecureRandom();

    static {
        Locale locale = Locale.US;
        c cVar = c.f4371h;
        l.b.a.v.d dVar = new l.b.a.v.d();
        dVar.h("yyyy-MM-dd-HH");
        f2744g = dVar.r(locale).h(r.f4321g);
    }

    public c0(z zVar, f fVar, d0.a aVar) {
        this.a = zVar;
        this.b = fVar;
        if (fVar != null) {
            h.b bVar = new h.b();
            bVar.c = false;
            h a2 = bVar.a();
            synchronized (fVar.b) {
                b.B(a2, "Provided settings must not be null.");
                if (fVar.f3182h != null) {
                    if (!fVar.f3181g.equals(a2)) {
                        throw new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
                    }
                }
                fVar.f3181g = a2;
            }
        }
        this.c = aVar.a("PAPrioFirestoreRepository");
    }

    public static <T> void b(d.a<String, Object> aVar, String str, boolean z, T t) {
        if (z) {
            aVar.b(str, t);
            return;
        }
        throw new Exception(f.a.a.a.a.c("Prio params missing: ", str));
    }

    public final Map<String, Object> a(y yVar, String str, h0 h0Var) {
        f.b.a.d.a.i0.d f2 = yVar.a().f();
        HashMap hashMap = new HashMap();
        hashMap.put("uuid", str);
        hashMap.put("created", e.a);
        d.a aVar = new d.a();
        b(aVar, "bins", f2.m(), Integer.valueOf(f2.g()));
        b(aVar, "prime", f2.q(), Long.valueOf(f2.l()));
        b(aVar, "epsilon", f2.n(), Double.valueOf(f2.i()));
        b(aVar, "numberServers", f2.p(), Integer.valueOf(f2.k()));
        if (f2.o()) {
            aVar.b("hammingWeight", Integer.valueOf(f2.j()));
        }
        hashMap.put("prioParams", aVar.a());
        hashMap.put("schemaVersion", 2);
        f.b.a.d.a.i0.b b2 = yVar.b();
        f.b.b.b.a<Object> aVar2 = f.b.b.b.c.c;
        c.a aVar3 = new c.a();
        String h2 = h0Var.h();
        a aVar4 = f2745h;
        aVar3.c(f.b.b.b.d.b("payload", aVar4.c(b2.e(0).z()), "encryptionKeyId", h2));
        d0 d0Var = this.c;
        ((q) d0Var).a.a(f.a.a.a.a.c("PHA encryption key id:: ", h2));
        String e2 = h0Var.e();
        aVar3.c(f.b.b.b.d.b("payload", aVar4.c(b2.e(1).z()), "encryptionKeyId", e2));
        d0 d0Var2 = this.c;
        ((q) d0Var2).a.a(f.a.a.a.a.c("Facilitator encryption key id: ", e2));
        hashMap.put("encryptedDataShares", aVar3.f());
        return hashMap;
    }
}
