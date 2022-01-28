package f.b.a.a.a.p;

import f.b.a.a.a.b0.c;
import f.b.a.a.a.b0.d;
import f.b.a.a.a.b0.f;
import f.b.a.a.a.i.e0.a;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class h implements g {
    public final /* synthetic */ s a;
    public final /* synthetic */ f.b.a.a.a.b0.g b;

    public /* synthetic */ h(s sVar, f.b.a.a.a.b0.g gVar) {
        this.a = sVar;
        this.b = gVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        s sVar = this.a;
        f.b.a.a.a.b0.g gVar = this.b;
        Objects.requireNonNull(sVar);
        if (gVar != null) {
            a aVar = s.f2323j;
            aVar.a("ErasingEventsBatchUpToIncludingEvent " + gVar);
            c cVar = sVar.f2327f.a;
            d dVar = (d) cVar;
            e.t.n.d.a(dVar.a, true, new f(dVar, gVar.b()));
        } else {
            sVar.f2327f.a();
        }
        s.f2323j.f("Analytics log batch sent to Firelog.");
        return null;
    }
}
