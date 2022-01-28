package f.b.g;

import f.b.g.m0;
import java.util.Map;
import java.util.Objects;

public class p0 implements o0 {
    @Override // f.b.g.o0
    public Object a(Object obj, Object obj2) {
        n0 n0Var = (n0) obj;
        n0 n0Var2 = (n0) obj2;
        if (!n0Var2.isEmpty()) {
            if (!n0Var.b) {
                n0Var = n0Var.c();
            }
            n0Var.b();
            if (!n0Var2.isEmpty()) {
                n0Var.putAll(n0Var2);
            }
        }
        return n0Var;
    }

    @Override // f.b.g.o0
    public Map<?, ?> b(Object obj) {
        return (n0) obj;
    }

    @Override // f.b.g.o0
    public Object c(Object obj) {
        return n0.c.c();
    }

    @Override // f.b.g.o0
    public int d(int i2, Object obj, Object obj2) {
        n0 n0Var = (n0) obj;
        m0 m0Var = (m0) obj2;
        int i3 = 0;
        if (!n0Var.isEmpty()) {
            for (Map.Entry entry : n0Var.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                Objects.requireNonNull(m0Var);
                i3 += m.p(m0.a(m0Var.a, key, value)) + m.y(i2);
            }
        }
        return i3;
    }

    @Override // f.b.g.o0
    public Map<?, ?> e(Object obj) {
        return (n0) obj;
    }

    @Override // f.b.g.o0
    public boolean f(Object obj) {
        return !((n0) obj).b;
    }

    @Override // f.b.g.o0
    public Object g(Object obj) {
        ((n0) obj).b = false;
        return obj;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: f.b.g.m0$a<K, V>, f.b.g.m0$a<?, ?> */
    @Override // f.b.g.o0
    public m0.a<?, ?> h(Object obj) {
        return (m0.a<K, V>) ((m0) obj).a;
    }
}
