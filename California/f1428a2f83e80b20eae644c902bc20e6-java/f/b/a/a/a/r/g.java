package f.b.a.a.a.r;

import f.b.a.a.a.s.c;
import f.b.a.a.a.s.d;
import java.util.Objects;

public final /* synthetic */ class g implements f.b.b.a.g {
    public final /* synthetic */ z a;

    public /* synthetic */ g(z zVar) {
        this.a = zVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        z zVar = this.a;
        c cVar = (c) obj;
        Objects.requireNonNull(zVar);
        Objects.requireNonNull(cVar, "Null createPacketsParameters");
        d a2 = zVar.f2238f.a(cVar);
        Objects.requireNonNull(a2, "Null createPacketsResponse");
        return new p(cVar, a2, null);
    }
}
