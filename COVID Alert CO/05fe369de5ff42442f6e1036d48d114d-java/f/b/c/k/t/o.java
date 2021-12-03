package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.m;
import f.b.c.k.w.g0;
import f.b.c.k.w.o0;
import f.b.c.k.x.m;
import f.b.c.k.x.n;
import f.b.g.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final /* synthetic */ class o implements n {
    public final r a;
    public final g0 b;
    public final m c;

    public o(r rVar, g0 g0Var, m mVar) {
        this.a = rVar;
        this.b = g0Var;
        this.c = mVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d1 A[SYNTHETIC] */
    @Override // f.b.c.k.x.n
    public Object get() {
        r rVar = this.a;
        g0 g0Var = this.b;
        m mVar = this.c;
        int i2 = r.f3289k;
        Map<Integer, o0> map = g0Var.b;
        long d2 = rVar.a.c().d();
        Iterator<Map.Entry<Integer, o0>> it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, o0> next = it.next();
            int intValue = next.getKey().intValue();
            o0 value = next.getValue();
            d1 d1Var = rVar.f3294h.get(intValue);
            if (d1Var != null) {
                rVar.f3293g.c(value.f3351e, intValue);
                rVar.f3293g.b(value.c, intValue);
                j jVar = value.a;
                if (!jVar.isEmpty()) {
                    d1 b2 = d1Var.a(jVar, g0Var.a).b(d2);
                    rVar.f3294h.put(intValue, b2);
                    b.M0(!b2.f3280g.isEmpty(), "Attempted to persist query data with empty resume token", new Object[0]);
                    if (!d1Var.f3280g.isEmpty() && b2.f3278e.b.b - d1Var.f3278e.b.b < r.f3288j) {
                        if (value.f3351e.size() + value.f3350d.size() + value.c.size() <= 0) {
                            z = false;
                        }
                    }
                    if (z) {
                        rVar.f3293g.d(b2);
                    }
                }
            }
        }
        HashMap hashMap = new HashMap();
        Map<f, i> map2 = g0Var.f3335d;
        Set<f> set = g0Var.f3336e;
        Map<f, i> d3 = rVar.c.d(map2.keySet());
        for (Map.Entry<f, i> entry : map2.entrySet()) {
            f key = entry.getKey();
            i value2 = entry.getValue();
            i iVar = d3.get(key);
            if ((value2 instanceof f.b.c.k.u.j) && value2.b.equals(m.c)) {
                rVar.c.c(value2.a);
            } else if (iVar == null || value2.b.compareTo(iVar.b) > 0 || (value2.b.compareTo(iVar.b) == 0 && iVar.a())) {
                b.M0(!m.c.equals(g0Var.a), "Cannot add a document when the remote version is zero", new Object[0]);
                rVar.c.a(value2, g0Var.a);
            } else {
                f.b.c.k.x.m.a(m.a.DEBUG, "LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key, iVar.b, value2.b);
                if (!set.contains(key)) {
                    rVar.a.c().b(key);
                }
            }
            hashMap.put(key, value2);
            if (!set.contains(key)) {
            }
        }
        f.b.c.k.u.m a2 = rVar.f3293g.a();
        if (!mVar.equals(f.b.c.k.u.m.c)) {
            b.M0(mVar.compareTo(a2) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", mVar, a2);
            rVar.f3293g.e(mVar);
        }
        return rVar.f3290d.b(hashMap);
    }
}
