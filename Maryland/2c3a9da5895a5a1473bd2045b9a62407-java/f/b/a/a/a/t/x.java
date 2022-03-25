package f.b.a.a.a.t;

import f.b.a.a.a.u.g;
import f.b.a.c.b.o.b;
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
import l.b.a.c;
import l.b.a.q;
import l.b.a.u.d;

public class x {

    /* renamed from: f  reason: collision with root package name */
    public static final c f2311f = c.i(5);

    /* renamed from: g  reason: collision with root package name */
    public static final l.b.a.u.c f2312g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f2313h = a.a;
    public final v a;
    public final f b;
    public final f.b.a.a.a.h.s.a c;

    /* renamed from: d  reason: collision with root package name */
    public final ScheduledExecutorService f2314d;

    /* renamed from: e  reason: collision with root package name */
    public final SecureRandom f2315e;

    static {
        Locale locale = Locale.US;
        l.b.a.u.c cVar = l.b.a.u.c.f4216h;
        d dVar = new d();
        dVar.h("yyyy-MM-dd-HH");
        f2312g = dVar.r(locale).h(q.f4166g);
    }

    public x(v vVar, f.b.a.a.a.h.s.a aVar, f fVar, ScheduledExecutorService scheduledExecutorService, SecureRandom secureRandom) {
        this.a = vVar;
        this.b = fVar;
        this.c = aVar;
        this.f2314d = scheduledExecutorService;
        this.f2315e = secureRandom;
        if (fVar != null) {
            h.b bVar = new h.b();
            bVar.c = false;
            h a2 = bVar.a();
            synchronized (fVar.b) {
                b.C(a2, "Provided settings must not be null.");
                if (fVar.f3087h != null) {
                    if (!fVar.f3086g.equals(a2)) {
                        throw new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
                    }
                }
                fVar.f3086g = a2;
            }
        }
    }

    public static <T> void b(d.a<String, Object> aVar, String str, boolean z, T t) {
        if (z) {
            aVar.b(str, t);
            return;
        }
        throw new Exception(f.a.a.a.a.t("Prio params missing: ", str));
    }

    public final Map<String, Object> a(u uVar, String str, b0 b0Var) {
        g prioParameters = uVar.a().getPrioParameters();
        HashMap hashMap = new HashMap();
        hashMap.put("uuid", str);
        hashMap.put("created", e.a);
        d.a aVar = new d.a();
        b(aVar, "bins", prioParameters.hasBins(), Integer.valueOf(prioParameters.getBins()));
        b(aVar, "prime", prioParameters.hasPrime(), Long.valueOf(prioParameters.getPrime()));
        b(aVar, "epsilon", prioParameters.hasEpsilon(), Double.valueOf(prioParameters.getEpsilon()));
        b(aVar, "numberServers", prioParameters.hasNumberServers(), Integer.valueOf(prioParameters.getNumberServers()));
        if (prioParameters.hasHammingWeight()) {
            aVar.b("hammingWeight", Integer.valueOf(prioParameters.getHammingWeight()));
        }
        hashMap.put("prioParams", aVar.a());
        hashMap.put("schemaVersion", 2);
        f.b.a.a.a.u.d b2 = uVar.b();
        f.b.b.b.a<Object> aVar2 = f.b.b.b.c.c;
        c.a aVar3 = new c.a();
        String p = b0Var.p();
        a aVar4 = f2313h;
        aVar3.c(f.b.b.b.d.b("payload", aVar4.c(b2.getShares(0).z()), "encryptionKeyId", p));
        aVar3.c(f.b.b.b.d.b("payload", aVar4.c(b2.getShares(1).z()), "encryptionKeyId", b0Var.g()));
        hashMap.put("encryptedDataShares", aVar3.f());
        return hashMap;
    }
}
