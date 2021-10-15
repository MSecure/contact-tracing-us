package c.b.a.a.g.h;

import java.util.Iterator;
import java.util.Map;

public final class y2 implements v2 {
    @Override // c.b.a.a.g.h.v2
    public final Map<?, ?> a(Object obj) {
        return (w2) obj;
    }

    @Override // c.b.a.a.g.h.v2
    public final int b(int i, Object obj, Object obj2) {
        w2 w2Var = (w2) obj;
        u2 u2Var = (u2) obj2;
        if (w2Var.isEmpty()) {
            return 0;
        }
        Iterator it = w2Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // c.b.a.a.g.h.v2
    public final boolean c(Object obj) {
        return !((w2) obj).f4054b;
    }

    @Override // c.b.a.a.g.h.v2
    public final Object d(Object obj) {
        w2 w2Var = w2.f4053c;
        return w2Var.isEmpty() ? new w2() : new w2(w2Var);
    }

    @Override // c.b.a.a.g.h.v2
    public final Object e(Object obj, Object obj2) {
        w2 w2Var = (w2) obj;
        w2 w2Var2 = (w2) obj2;
        if (!w2Var2.isEmpty()) {
            if (!w2Var.f4054b) {
                w2Var = w2Var.isEmpty() ? new w2() : new w2(w2Var);
            }
            w2Var.a();
            if (!w2Var2.isEmpty()) {
                w2Var.putAll(w2Var2);
            }
        }
        return w2Var;
    }

    @Override // c.b.a.a.g.h.v2
    public final Map<?, ?> f(Object obj) {
        return (w2) obj;
    }

    @Override // c.b.a.a.g.h.v2
    public final Object g(Object obj) {
        ((w2) obj).f4054b = false;
        return obj;
    }

    @Override // c.b.a.a.g.h.v2
    public final t2<?, ?> h(Object obj) {
        u2 u2Var = (u2) obj;
        throw new NoSuchMethodError();
    }
}
