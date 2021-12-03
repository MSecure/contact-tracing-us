package f.b.c.k.s;

import f.b.a.c.b.o.b;
import f.b.c.k.s.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class g implements b0.b {
    public final Map<x, a> a = new HashMap();
    public final Set<Object<Void>> b = new HashSet();

    public static class a {
        public final List<y> a = new ArrayList();
    }

    public g(b0 b0Var) {
        b0Var.n = this;
    }

    public void a(List<j0> list) {
        for (j0 j0Var : list) {
            a aVar = this.a.get(j0Var.a);
            if (aVar != null) {
                Iterator<y> it = aVar.a.iterator();
                if (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                    b.M0(!j0Var.f3237d.isEmpty() || j0Var.f3240g, "We got a new snapshot with no changes?", new Object[0]);
                    throw null;
                }
            }
        }
    }
}
