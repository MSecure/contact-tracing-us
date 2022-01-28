package f.b.c.k.w;

import f.b.c.k.w.b;
import f.b.c.k.x.m;
import h.a.n0;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final /* synthetic */ class c implements Runnable {
    public final b.c b;
    public final n0 c;

    public c(b.c cVar, n0 n0Var) {
        this.b = cVar;
        this.c = n0Var;
    }

    public void run() {
        Set<String> set;
        b.c cVar = this.b;
        n0 n0Var = this.c;
        HashMap hashMap = new HashMap();
        if (n0Var.e()) {
            set = Collections.emptySet();
        } else {
            HashSet hashSet = new HashSet(n0Var.b);
            for (int i2 = 0; i2 < n0Var.b; i2++) {
                hashSet.add(new String(n0Var.g(i2), 0));
            }
            set = Collections.unmodifiableSet(hashSet);
        }
        for (String str : set) {
            if (j.f3401d.contains(str.toLowerCase(Locale.ENGLISH))) {
                hashMap.put(str, (String) n0Var.d(n0.f.a(str, n0.c)));
            }
        }
        if (!hashMap.isEmpty()) {
            m.a(m.a.DEBUG, b.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(b.this)), hashMap);
        }
    }
}
