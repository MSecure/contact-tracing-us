package f.b.a.a.a.p;

import e.b.a.m;
import f.b.a.a.a.p.s;
import f.b.a.a.a.v.c;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class j implements i {
    public final /* synthetic */ s a;
    public final /* synthetic */ c b;

    public /* synthetic */ j(s sVar, c cVar) {
        this.a = sVar;
        this.b = cVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        s sVar = this.a;
        c cVar = this.b;
        Objects.requireNonNull(sVar);
        if (((Boolean) obj).booleanValue()) {
            return m.h.h0(new i(sVar, cVar));
        }
        s.f2323j.f("Skipped firelog upload.");
        sVar.f2327f.a();
        return new s.a(new s.b(null));
    }
}
