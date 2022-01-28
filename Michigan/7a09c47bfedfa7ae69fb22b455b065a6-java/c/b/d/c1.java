package c.b.d;

import c.b.d.y0;
import c.b.d.z0;
import java.util.LinkedHashMap;
import java.util.Map;

public class c1 implements b1 {
    @Override // c.b.d.b1
    public Object a(Object obj, Object obj2) {
        z0 z0Var = (z0) obj;
        z0 z0Var2 = (z0) obj2;
        if (!z0Var.f5946a) {
            new z0(z0Var.f5950e, z0.d.MAP, a1.c(z0Var.e()));
        }
        ((z0.c) z0Var.g()).putAll(a1.c(z0Var2.e()));
        return z0Var;
    }

    @Override // c.b.d.b1
    public Map<?, ?> b(Object obj) {
        return ((z0) obj).e();
    }

    @Override // c.b.d.b1
    public Object c(Object obj) {
        return new z0(new z0.b((x0) obj), z0.d.MAP, new LinkedHashMap());
    }

    @Override // c.b.d.b1
    public int d(int i, Object obj, Object obj2) {
        int i2 = 0;
        if (obj != null) {
            Map e2 = ((z0) obj).e();
            x0 x0Var = (x0) obj2;
            if (!e2.isEmpty()) {
                for (Map.Entry entry : e2.entrySet()) {
                    int N = m.N(i);
                    if (x0Var != null) {
                        i2 += m.x(y0.a(entry.getKey(), entry.getValue())) + N;
                    } else {
                        throw null;
                    }
                }
            }
        }
        return i2;
    }

    @Override // c.b.d.b1
    public Map<?, ?> e(Object obj) {
        return ((z0) obj).g();
    }

    @Override // c.b.d.b1
    public boolean f(Object obj) {
        return !((z0) obj).f5946a;
    }

    @Override // c.b.d.b1
    public Object g(Object obj) {
        ((z0) obj).f5946a = false;
        return obj;
    }

    @Override // c.b.d.b1
    public y0.a<?, ?> h(Object obj) {
        if (((x0) obj) != null) {
            return null;
        }
        throw null;
    }
}
