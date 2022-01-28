package f.b.c.n;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class c implements f {
    public final String a;
    public final d b;

    public c(Set<e> set, d dVar) {
        this.a = b(set);
        this.b = dVar;
    }

    public static String b(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            e next = it.next();
            sb.append(next.a());
            sb.append('/');
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // f.b.c.n.f
    public String a() {
        Set unmodifiableSet;
        Set unmodifiableSet2;
        d dVar = this.b;
        synchronized (dVar.a) {
            unmodifiableSet = Collections.unmodifiableSet(dVar.a);
        }
        if (unmodifiableSet.isEmpty()) {
            return this.a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(' ');
        d dVar2 = this.b;
        synchronized (dVar2.a) {
            unmodifiableSet2 = Collections.unmodifiableSet(dVar2.a);
        }
        sb.append(b(unmodifiableSet2));
        return sb.toString();
    }
}
