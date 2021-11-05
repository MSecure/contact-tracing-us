package c.b.a.a.g.b;

import java.util.Iterator;
import java.util.Map;

public final class a2 implements z1 {
    @Override // c.b.a.a.g.b.z1
    public final Object a(Object obj) {
        ((y1) obj).f3479b = false;
        return obj;
    }

    @Override // c.b.a.a.g.b.z1
    public final int b(int i, Object obj, Object obj2) {
        y1 y1Var = (y1) obj;
        if (y1Var.isEmpty()) {
            return 0;
        }
        Iterator it = y1Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // c.b.a.a.g.b.z1
    public final Map<?, ?> c(Object obj) {
        return (y1) obj;
    }

    @Override // c.b.a.a.g.b.z1
    public final x1<?, ?> d(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // c.b.a.a.g.b.z1
    public final Map<?, ?> e(Object obj) {
        return (y1) obj;
    }

    @Override // c.b.a.a.g.b.z1
    public final boolean f(Object obj) {
        return !((y1) obj).f3479b;
    }

    @Override // c.b.a.a.g.b.z1
    public final Object g(Object obj) {
        y1 y1Var = y1.f3478c;
        return y1Var.isEmpty() ? new y1() : new y1(y1Var);
    }

    @Override // c.b.a.a.g.b.z1
    public final Object h(Object obj, Object obj2) {
        y1 y1Var = (y1) obj;
        y1 y1Var2 = (y1) obj2;
        if (!y1Var2.isEmpty()) {
            if (!y1Var.f3479b) {
                y1Var = y1Var.isEmpty() ? new y1() : new y1(y1Var);
            }
            y1Var.a();
            if (!y1Var2.isEmpty()) {
                y1Var.putAll(y1Var2);
            }
        }
        return y1Var;
    }
}
