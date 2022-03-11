package f.b.a.a.a.n;

import e.b.a.m;
import f.b.a.a.a.k.q;
import f.b.a.a.a.n.d0;
import f.b.a.c.b.o.b;
import f.b.a.c.i.h;
import f.b.b.b.a;
import f.b.b.b.c;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public final /* synthetic */ class p implements i {
    public final /* synthetic */ d0 a;

    public /* synthetic */ p(d0 d0Var) {
        this.a = d0Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        d0 d0Var = this.a;
        c<q> cVar = (c) obj;
        Objects.requireNonNull(d0Var);
        if (cVar.isEmpty()) {
            return b.c1(null);
        }
        cVar.size();
        if (!d0Var.c.g().isEmpty()) {
            d0Var.c.g();
            String g2 = d0Var.c.g();
            a t = cVar.listIterator();
            int i2 = 1;
            while (t.hasNext()) {
                q qVar = (q) t.next();
                try {
                    d0.a a2 = d0Var.a(qVar.a());
                    String str = "File " + i2 + " has signature:\n" + a2.b;
                    a2.a.getKeysCount();
                    for (f.b.a.a.a.s.p pVar : a2.a.getKeysList()) {
                        if (d0.f2138g.c(pVar.getKeyData().z()).contains(g2.toLowerCase())) {
                            d0.f2139h.c(pVar.getKeyData().z());
                            pVar.getRollingStartIntervalNumber();
                            pVar.getRollingPeriod();
                            pVar.getTransmissionRiskLevel();
                        }
                    }
                    i2++;
                } catch (IOException unused) {
                    String str2 = "Failed to read or parse file " + qVar;
                }
            }
        }
        f0 f0Var = d0Var.a;
        ArrayList arrayList = new ArrayList();
        for (q qVar2 : cVar) {
            arrayList.add(qVar2.a());
        }
        h<Void> a3 = f0Var.a.a(arrayList);
        a3.d(new e(f0Var)).f(new a(f0Var));
        u g0 = m.h.g0(a3, d0.f2137f, d0Var.f2141e);
        g0.a(new f.b.b.f.a.q(g0, new c0(d0Var, cVar)), d0Var.f2140d);
        return g0;
    }
}
