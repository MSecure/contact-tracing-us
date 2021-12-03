package h.a;

import h.a.k;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class m {
    public static final m b = new m(new k.a(), k.b.a);
    public final ConcurrentMap<String, l> a = new ConcurrentHashMap();

    public m(l... lVarArr) {
        for (l lVar : lVarArr) {
            this.a.put(lVar.a(), lVar);
        }
    }
}
