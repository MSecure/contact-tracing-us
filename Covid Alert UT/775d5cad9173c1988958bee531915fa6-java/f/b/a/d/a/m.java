package f.b.a.d.a;

import f.a.a.a.a;
import f.b.a.a.a.f0.q;
import f.b.a.d.a.i0.a;
import f.b.a.d.a.i0.d;
import f.b.b.a.g;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class m implements g {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ w b;
    public final /* synthetic */ h0 c;

    public /* synthetic */ m(g0 g0Var, w wVar, h0 h0Var) {
        this.a = g0Var;
        this.b = wVar;
        this.c = h0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        g0 g0Var = this.a;
        w wVar = this.b;
        h0 h0Var = this.c;
        List list = (List) obj;
        Objects.requireNonNull(g0Var);
        double d2 = wVar.b;
        String g2 = h0Var.g();
        String d3 = h0Var.d();
        d.b r = d.r();
        int size = list.size();
        r.copyOnWrite();
        d.c((d) r.instance, size);
        r.copyOnWrite();
        d.d((d) r.instance, d2);
        r.copyOnWrite();
        d.f((d) r.instance, 2);
        r.copyOnWrite();
        d.e((d) r.instance, 4293918721L);
        d dVar = (d) r.build();
        d0 d0Var = g0Var.f2805f;
        StringBuilder h2 = a.h("Generating packets w/ params: bins=");
        h2.append(dVar.g());
        h2.append(" epsilon=");
        h2.append(dVar.i());
        ((q) d0Var).a.f(h2.toString());
        a.b g3 = f.b.a.d.a.i0.a.g();
        g3.copyOnWrite();
        f.b.a.d.a.i0.a.d((f.b.a.d.a.i0.a) g3.instance, list);
        g3.copyOnWrite();
        f.b.a.d.a.i0.a.c((f.b.a.d.a.i0.a) g3.instance, dVar);
        g3.copyOnWrite();
        f.b.a.d.a.i0.a.e((f.b.a.d.a.i0.a) g3.instance, g2);
        g3.copyOnWrite();
        f.b.a.d.a.i0.a.e((f.b.a.d.a.i0.a) g3.instance, d3);
        return (f.b.a.d.a.i0.a) g3.build();
    }
}
