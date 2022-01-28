package c.b.d;

import c.b.d.y0;
import java.util.Map;

public class d1 implements b1 {
    @Override // c.b.d.b1
    public Object a(Object obj, Object obj2) {
        a1 a1Var = (a1) obj;
        a1 a1Var2 = (a1) obj2;
        if (!a1Var2.isEmpty()) {
            if (!a1Var.f5231b) {
                a1Var = a1Var.isEmpty() ? new a1() : new a1(a1Var);
            }
            a1Var.d();
            if (!a1Var2.isEmpty()) {
                a1Var.putAll(a1Var2);
            }
        }
        return a1Var;
    }

    @Override // c.b.d.b1
    public Map<?, ?> b(Object obj) {
        return (a1) obj;
    }

    @Override // c.b.d.b1
    public Object c(Object obj) {
        a1 a1Var = a1.f5230c;
        return a1Var.isEmpty() ? new a1() : new a1(a1Var);
    }

    @Override // c.b.d.b1
    public int d(int i, Object obj, Object obj2) {
        a1 a1Var = (a1) obj;
        y0 y0Var = (y0) obj2;
        int i2 = 0;
        if (!a1Var.isEmpty()) {
            for (Map.Entry entry : a1Var.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (y0Var != null) {
                    i2 += m.x(y0.a(key, value)) + m.N(i);
                } else {
                    throw null;
                }
            }
        }
        return i2;
    }

    @Override // c.b.d.b1
    public Map<?, ?> e(Object obj) {
        return (a1) obj;
    }

    @Override // c.b.d.b1
    public boolean f(Object obj) {
        return !((a1) obj).f5231b;
    }

    @Override // c.b.d.b1
    public Object g(Object obj) {
        ((a1) obj).f5231b = false;
        return obj;
    }

    @Override // c.b.d.b1
    public y0.a<?, ?> h(Object obj) {
        if (((y0) obj) != null) {
            return null;
        }
        throw null;
    }
}
