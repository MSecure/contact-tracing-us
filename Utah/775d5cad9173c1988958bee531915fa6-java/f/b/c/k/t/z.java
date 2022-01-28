package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.u.l;
import java.util.HashMap;
import java.util.HashSet;

public class z implements f {
    public final a a = new a();

    public static class a {
        public final HashMap<String, HashSet<l>> a = new HashMap<>();

        public boolean a(l lVar) {
            boolean z = true;
            if (lVar.n() % 2 != 1) {
                z = false;
            }
            b.O0(z, "Expected a collection path.", new Object[0]);
            String h2 = lVar.h();
            l lVar2 = (l) lVar.q();
            HashSet<l> hashSet = this.a.get(h2);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.a.put(h2, hashSet);
            }
            return hashSet.add(lVar2);
        }
    }
}
