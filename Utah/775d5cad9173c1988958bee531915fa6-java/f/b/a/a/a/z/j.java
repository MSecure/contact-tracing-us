package f.b.a.a.a.z;

import e.b.a.m;
import f.b.a.a.a.g0.c;
import f.b.a.a.a.z.s;
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
            return m.e.l0(new i(sVar, cVar));
        }
        s.f2511j.f("Skipped firelog upload.");
        sVar.f2515f.a();
        return new s.a(new s.b(null));
    }
}
