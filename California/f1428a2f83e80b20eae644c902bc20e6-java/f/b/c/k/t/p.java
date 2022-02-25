package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.g.a.f;
import f.b.c.k.u.m;
import java.util.Iterator;
import java.util.List;

public final /* synthetic */ class p implements Runnable {
    public final r b;
    public final List c;

    public p(r rVar, List list) {
        this.b = rVar;
        this.c = list;
    }

    public void run() {
        r rVar = this.b;
        List<s> list = this.c;
        int i2 = r.f3090k;
        for (s sVar : list) {
            int i3 = sVar.a;
            rVar.f3093f.b(sVar.c, i3);
            f<f.b.c.k.u.f> fVar = sVar.f3104d;
            Iterator<f.b.c.k.u.f> it = fVar.iterator();
            while (true) {
                f.a aVar = (f.a) it;
                if (!aVar.hasNext()) {
                    break;
                }
                rVar.a.c().i((f.b.c.k.u.f) aVar.next());
            }
            rVar.f3093f.f(fVar, i3);
            if (!sVar.b) {
                d1 d1Var = rVar.f3095h.get(i3);
                b.a1(d1Var != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(i3));
                m mVar = d1Var.f3079e;
                rVar.f3095h.put(i3, new d1(d1Var.a, d1Var.b, d1Var.c, d1Var.f3078d, mVar, mVar, d1Var.f3081g));
            }
        }
    }
}
