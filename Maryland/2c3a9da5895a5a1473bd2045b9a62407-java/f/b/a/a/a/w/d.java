package f.b.a.a.a.w;

import f.b.a.a.a.h.s.a;
import f.b.a.a.a.y.i;
import f.b.a.a.a.y.p;
import f.b.a.a.a.y.q;
import f.b.a.a.a.y.s;
import f.b.b.a.t;
import java.util.Objects;

public class d {
    public final f a;
    public final s b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2327d;

    public d(f fVar, s sVar, a aVar, String str) {
        this.a = fVar;
        this.b = sVar;
        this.c = aVar;
        this.f2327d = str;
    }

    public void a() {
        String networkCountryIso = this.a.a.getNetworkCountryIso();
        if (t.a(networkCountryIso)) {
            networkCountryIso = null;
        }
        if (networkCountryIso != null) {
            s sVar = this.b;
            p pVar = sVar.a;
            long a2 = sVar.b.a();
            Objects.requireNonNull(pVar);
            i iVar = new i(networkCountryIso, a2);
            q qVar = (q) pVar;
            qVar.a.b();
            qVar.a.c();
            try {
                qVar.b.f(iVar);
                qVar.a.l();
            } finally {
                qVar.a.g();
            }
        }
    }
}
