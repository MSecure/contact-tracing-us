package c.b.c.a.j0.a;

import c.b.c.a.j0.a.k0;
import java.util.Map;

public class n0 implements m0 {
    @Override // c.b.c.a.j0.a.m0
    public Object a(Object obj, Object obj2) {
        l0 l0Var = (l0) obj;
        l0 l0Var2 = (l0) obj2;
        if (!l0Var2.isEmpty()) {
            if (!l0Var.f4981b) {
                l0Var = l0Var.isEmpty() ? new l0() : new l0(l0Var);
            }
            l0Var.b();
            if (!l0Var2.isEmpty()) {
                l0Var.putAll(l0Var2);
            }
        }
        return l0Var;
    }

    @Override // c.b.c.a.j0.a.m0
    public Map<?, ?> b(Object obj) {
        return (l0) obj;
    }

    @Override // c.b.c.a.j0.a.m0
    public Object c(Object obj) {
        l0 l0Var = l0.f4980c;
        return l0Var.isEmpty() ? new l0() : new l0(l0Var);
    }

    @Override // c.b.c.a.j0.a.m0
    public int d(int i, Object obj, Object obj2) {
        l0 l0Var = (l0) obj;
        k0 k0Var = (k0) obj2;
        int i2 = 0;
        if (!l0Var.isEmpty()) {
            for (Map.Entry entry : l0Var.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (k0Var != null) {
                    i2 += l.u(k0.a(key, value)) + l.G(i);
                } else {
                    throw null;
                }
            }
        }
        return i2;
    }

    @Override // c.b.c.a.j0.a.m0
    public Map<?, ?> e(Object obj) {
        return (l0) obj;
    }

    @Override // c.b.c.a.j0.a.m0
    public boolean f(Object obj) {
        return !((l0) obj).f4981b;
    }

    @Override // c.b.c.a.j0.a.m0
    public Object g(Object obj) {
        ((l0) obj).f4981b = false;
        return obj;
    }

    @Override // c.b.c.a.j0.a.m0
    public k0.a<?, ?> h(Object obj) {
        if (((k0) obj) != null) {
            return null;
        }
        throw null;
    }
}
