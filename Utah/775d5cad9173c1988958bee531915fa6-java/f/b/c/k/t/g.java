package f.b.c.k.t;

import f.b.c.g.a.d;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.j;
import f.b.c.k.u.m;
import java.util.List;
import java.util.Map;

public class g {
    public final k0 a;
    public final e0 b;
    public final f c;

    public g(k0 k0Var, e0 e0Var, f fVar) {
        this.a = k0Var;
        this.b = e0Var;
        this.c = fVar;
    }

    public d<f, i> a(Iterable<f> iterable) {
        return b(this.a.d(iterable));
    }

    public d<f, i> b(Map<f, i> map) {
        d<f, ?> dVar = f.b.c.k.u.d.a;
        List<f.b.c.k.u.p.f> e2 = this.b.e(map.keySet());
        for (Map.Entry<f, i> entry : map.entrySet()) {
            i value = entry.getValue();
            for (f.b.c.k.u.p.f fVar : e2) {
                value = fVar.a(entry.getKey(), value);
            }
            entry.setValue(value);
        }
        d dVar2 = dVar;
        for (Map.Entry<f, i> entry2 : map.entrySet()) {
            f key = entry2.getKey();
            Object obj = (i) entry2.getValue();
            if (obj == null) {
                obj = new j(key, m.c, false);
            }
            dVar2 = dVar2.l(key, obj);
        }
        return dVar2;
    }
}
