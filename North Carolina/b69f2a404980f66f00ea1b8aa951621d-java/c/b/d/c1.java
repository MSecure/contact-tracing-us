package c.b.d;

import c.b.d.x0;
import java.util.Map;

public class c1 implements a1 {
    @Override // c.b.d.a1
    public Object a(Object obj, Object obj2) {
        z0 z0Var = (z0) obj;
        z0 z0Var2 = (z0) obj2;
        if (!z0Var2.isEmpty()) {
            if (!z0Var.f4420b) {
                z0Var = z0Var.isEmpty() ? new z0() : new z0(z0Var);
            }
            z0Var.d();
            if (!z0Var2.isEmpty()) {
                z0Var.putAll(z0Var2);
            }
        }
        return z0Var;
    }

    @Override // c.b.d.a1
    public Map<?, ?> b(Object obj) {
        return (z0) obj;
    }

    @Override // c.b.d.a1
    public Object c(Object obj) {
        z0 z0Var = z0.f4419c;
        return z0Var.isEmpty() ? new z0() : new z0(z0Var);
    }

    @Override // c.b.d.a1
    public int d(int i, Object obj, Object obj2) {
        z0 z0Var = (z0) obj;
        x0 x0Var = (x0) obj2;
        int i2 = 0;
        if (!z0Var.isEmpty()) {
            for (Map.Entry entry : z0Var.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (x0Var != null) {
                    i2 += m.x(x0.a(key, value)) + m.N(i);
                } else {
                    throw null;
                }
            }
        }
        return i2;
    }

    @Override // c.b.d.a1
    public Map<?, ?> e(Object obj) {
        return (z0) obj;
    }

    @Override // c.b.d.a1
    public boolean f(Object obj) {
        return !((z0) obj).f4420b;
    }

    @Override // c.b.d.a1
    public Object g(Object obj) {
        ((z0) obj).f4420b = false;
        return obj;
    }

    @Override // c.b.d.a1
    public x0.a<?, ?> h(Object obj) {
        if (((x0) obj) != null) {
            return null;
        }
        throw null;
    }
}
