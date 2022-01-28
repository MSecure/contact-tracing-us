package f.b.a.a.a.z;

import f.b.a.a.a.l0.c;
import f.b.a.a.a.l0.d;
import f.b.a.a.a.l0.f;
import f.b.a.a.a.s.d0.a;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class h implements g {
    public final /* synthetic */ s a;
    public final /* synthetic */ f.b.a.a.a.l0.g b;

    public /* synthetic */ h(s sVar, f.b.a.a.a.l0.g gVar) {
        this.a = sVar;
        this.b = gVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        s sVar = this.a;
        f.b.a.a.a.l0.g gVar = this.b;
        Objects.requireNonNull(sVar);
        if (gVar != null) {
            a aVar = s.f2511j;
            aVar.a("ErasingEventsBatchUpToIncludingEvent " + gVar);
            c cVar = sVar.f2515f.a;
            d dVar = (d) cVar;
            e.u.n.d.a(dVar.a, true, new f(dVar, gVar.b()));
        } else {
            sVar.f2515f.a();
        }
        s.f2511j.f("Analytics log batch sent to Firelog.");
        return null;
    }
}
