package f.b.a.a.a.b0;

import e.b.a.m;
import f.b.a.a.a.b0.g1;
import f.b.a.a.a.g0.k;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.x.q;
import f.b.a.c.b.o.b;
import f.b.a.c.i.h;
import f.b.b.b.c;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public final /* synthetic */ class p implements i {
    public final /* synthetic */ g1 a;

    public /* synthetic */ p(g1 g1Var) {
        this.a = g1Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        g1 g1Var = this.a;
        c<q> cVar = (c) obj;
        Objects.requireNonNull(g1Var);
        if (cVar.isEmpty()) {
            g1.f2161h.a("No files to provide to google play services.");
            return b.Q0(null);
        }
        a aVar = g1.f2161h;
        StringBuilder h2 = f.a.a.a.a.h("Providing  ");
        h2.append(cVar.size());
        h2.append(" diagnosis key files to google play services.");
        aVar.a(h2.toString());
        if (!g1Var.f2165d.m().isEmpty()) {
            StringBuilder h3 = f.a.a.a.a.h("Logging keyfiles; keys limited to those containing [");
            h3.append(g1Var.f2165d.m());
            h3.append("] (hex).");
            aVar.a(h3.toString());
            String m = g1Var.f2165d.m();
            f.b.b.b.a t = cVar.listIterator();
            int i2 = 1;
            while (t.hasNext()) {
                q qVar = (q) t.next();
                try {
                    g1.a a2 = g1Var.a(qVar.a());
                    a aVar2 = g1.f2161h;
                    aVar2.a("File " + i2 + " has signature:\n" + a2.b);
                    aVar2.a("File " + i2 + " has [" + a2.a.getKeysCount() + "] keys.");
                    for (k kVar : a2.a.getKeysList()) {
                        String c = g1.f2163j.c(kVar.getKeyData().z());
                        if (c.contains(m.toLowerCase())) {
                            a aVar3 = g1.f2161h;
                            aVar3.a("TEK hex:[" + c + "] base64:[" + g1.f2164k.c(kVar.getKeyData().z()) + "] interval_num:[" + kVar.getRollingStartIntervalNumber() + "] rolling_period:[" + kVar.getRollingPeriod() + "] risk:[" + kVar.getTransmissionRiskLevel() + "]");
                        }
                    }
                    i2++;
                } catch (IOException e2) {
                    a aVar4 = g1.f2161h;
                    aVar4.b("Failed to read or parse file " + qVar, e2);
                }
            }
        }
        i1 i1Var = g1Var.a;
        ArrayList arrayList = new ArrayList();
        for (q qVar2 : cVar) {
            arrayList.add(qVar2.a());
        }
        h<Void> b = i1Var.a.b(arrayList);
        b.d(new e(i1Var)).f(new a(i1Var));
        u m0 = m.e.m0(b, g1.f2162i, g1Var.f2167f);
        f1 f1Var = new f1(g1Var, cVar);
        m0.a(new f.b.b.f.a.q(m0, f1Var), g1Var.f2166e);
        return m0;
    }
}
