package c.b.d;

import c.b.d.x0;
import c.b.d.y0;
import java.util.LinkedHashMap;
import java.util.Map;

public class b1 implements a1 {
    @Override // c.b.d.a1
    public Object a(Object obj, Object obj2) {
        y0 y0Var = (y0) obj;
        y0 y0Var2 = (y0) obj2;
        if (!y0Var.f4393a) {
            new y0(y0Var.f4397e, y0.d.MAP, z0.c(y0Var.e()));
        }
        ((y0.c) y0Var.g()).putAll(z0.c(y0Var2.e()));
        return y0Var;
    }

    @Override // c.b.d.a1
    public Map<?, ?> b(Object obj) {
        return ((y0) obj).e();
    }

    @Override // c.b.d.a1
    public Object c(Object obj) {
        return new y0(new y0.b((w0) obj), y0.d.MAP, new LinkedHashMap());
    }

    @Override // c.b.d.a1
    public int d(int i, Object obj, Object obj2) {
        int i2 = 0;
        if (obj != null) {
            Map e2 = ((y0) obj).e();
            w0 w0Var = (w0) obj2;
            if (!e2.isEmpty()) {
                for (Map.Entry entry : e2.entrySet()) {
                    int N = m.N(i);
                    if (w0Var != null) {
                        i2 += m.x(x0.a(entry.getKey(), entry.getValue())) + N;
                    } else {
                        throw null;
                    }
                }
            }
        }
        return i2;
    }

    @Override // c.b.d.a1
    public Map<?, ?> e(Object obj) {
        return ((y0) obj).g();
    }

    @Override // c.b.d.a1
    public boolean f(Object obj) {
        return !((y0) obj).f4393a;
    }

    @Override // c.b.d.a1
    public Object g(Object obj) {
        ((y0) obj).f4393a = false;
        return obj;
    }

    @Override // c.b.d.a1
    public x0.a<?, ?> h(Object obj) {
        if (((w0) obj) != null) {
            return null;
        }
        throw null;
    }
}
