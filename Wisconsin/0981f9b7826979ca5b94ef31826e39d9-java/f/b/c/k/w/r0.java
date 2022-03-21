package f.b.c.k.w;

import f.b.a.c.b.o.b;
import f.b.c.g.a.f;
import f.b.c.k.t.d1;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class r0 {
    public final a a;
    public final Map<Integer, p0> b = new HashMap();
    public Map<f, i> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<f, Set<Integer>> f3169d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public Set<Integer> f3170e = new HashSet();

    public interface a {
    }

    public r0(a aVar) {
        this.a = aVar;
    }

    public final p0 a(int i2) {
        p0 p0Var = this.b.get(Integer.valueOf(i2));
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0();
        this.b.put(Integer.valueOf(i2), p0Var2);
        return p0Var2;
    }

    public final boolean b(int i2) {
        return c(i2) != null;
    }

    public final d1 c(int i2) {
        p0 p0Var = this.b.get(Integer.valueOf(i2));
        if (p0Var == null || !p0Var.a()) {
            return ((l0) this.a).c.get(Integer.valueOf(i2));
        }
        return null;
    }

    public final void d(int i2, f fVar, i iVar) {
        if (c(i2) != null) {
            p0 a2 = a(i2);
            if (f(i2, fVar)) {
                f.b.c.k.s.f fVar2 = f.b.c.k.s.f.REMOVED;
                a2.c = true;
                a2.b.put(fVar, fVar2);
            } else {
                a2.c = true;
                a2.b.remove(fVar);
            }
            Set<Integer> set = this.f3169d.get(fVar);
            if (set == null) {
                set = new HashSet<>();
                this.f3169d.put(fVar, set);
            }
            set.add(Integer.valueOf(i2));
            if (iVar != null) {
                this.c.put(fVar, iVar);
            }
        }
    }

    public final void e(int i2) {
        b.a1(this.b.get(Integer.valueOf(i2)) != null && !this.b.get(Integer.valueOf(i2)).a(), "Should only reset active targets", new Object[0]);
        this.b.put(Integer.valueOf(i2), new p0());
        Iterator<f> it = ((l0) this.a).a.d(i2).iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                d(i2, (f.b.c.k.u.f) aVar.next(), null);
            } else {
                return;
            }
        }
    }

    public final boolean f(int i2, f.b.c.k.u.f fVar) {
        return ((l0) this.a).a.d(i2).b.h(fVar);
    }
}
