package f.b.c.k.u.p;

import f.b.c.d;
import f.b.d.a.n;
import f.b.d.a.s;
import f.b.g.p1;

public class l implements o {
    public static final l a = new l();

    @Override // f.b.c.k.u.p.o
    public s a(s sVar) {
        return null;
    }

    @Override // f.b.c.k.u.p.o
    public s b(s sVar, s sVar2) {
        return sVar2;
    }

    @Override // f.b.c.k.u.p.o
    public s c(s sVar, d dVar) {
        s.b z = s.z();
        z.copyOnWrite();
        s.d((s) z.instance, "server_timestamp");
        s.b z2 = s.z();
        p1.b h2 = p1.h();
        h2.c(dVar.b);
        h2.b(dVar.c);
        z2.copyOnWrite();
        s.c((s) z2.instance, (p1) h2.build());
        n.b i2 = n.i();
        i2.b("__type__", (s) z.build());
        i2.b("__local_write_time__", (s) z2.build());
        if (sVar != null) {
            i2.b("__previous_value__", sVar);
        }
        s.b z3 = s.z();
        z3.e(i2);
        return (s) z3.build();
    }
}
