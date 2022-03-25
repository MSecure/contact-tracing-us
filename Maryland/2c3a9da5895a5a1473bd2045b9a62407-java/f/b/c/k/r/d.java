package f.b.c.k.r;

import f.b.a.c.b.o.b;
import f.b.a.c.i.a;
import f.b.a.c.i.c0;
import f.b.a.c.i.h;
import f.b.c.k.x.m;
import java.util.Objects;

public final /* synthetic */ class d implements a {
    public final e a;
    public final int b;

    public d(e eVar, int i2) {
        this.a = eVar;
        this.b = i2;
    }

    @Override // f.b.a.c.i.a
    public Object a(h hVar) {
        h<String> F0;
        e eVar = this.a;
        int i2 = this.b;
        synchronized (eVar) {
            if (i2 != 0) {
                m.a(m.a.DEBUG, "FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                F0 = eVar.a();
            } else if (hVar.n()) {
                Objects.requireNonNull((f.b.c.e.a) hVar.k());
                F0 = b.F0(null);
            } else {
                Exception j2 = hVar.j();
                c0 c0Var = new c0();
                c0Var.p(j2);
                return c0Var;
            }
            return F0;
        }
    }
}
