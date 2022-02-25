package f.b.a.a.a.u;

import f.b.a.a.a.h.s.a;
import f.b.a.a.a.w.i;
import f.b.a.a.a.w.o;
import f.b.a.a.a.w.p;
import f.b.a.a.a.w.r;
import f.b.a.c.b.o.b;
import java.util.Objects;

public class d {
    public final f a;
    public final r b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2249d;

    public d(f fVar, r rVar, a aVar, String str) {
        this.a = fVar;
        this.b = rVar;
        this.c = aVar;
        this.f2249d = str;
    }

    public void a() {
        String networkCountryIso = this.a.a.getNetworkCountryIso();
        if (b.i1(networkCountryIso)) {
            networkCountryIso = null;
        }
        if (networkCountryIso != null) {
            r rVar = this.b;
            o oVar = rVar.a;
            long a2 = rVar.b.a();
            Objects.requireNonNull(oVar);
            i iVar = new i(networkCountryIso, a2);
            p pVar = (p) oVar;
            pVar.a.b();
            pVar.a.c();
            try {
                pVar.b.f(iVar);
                pVar.a.l();
            } finally {
                pVar.a.g();
            }
        }
    }
}
