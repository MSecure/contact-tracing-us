package f.b.c.k.w;

import f.a.a.a.a;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.m;
import java.util.Map;
import java.util.Set;

public final class g0 {
    public final m a;
    public final Map<Integer, o0> b;
    public final Set<Integer> c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<f, i> f3240d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<f> f3241e;

    public g0(m mVar, Map<Integer, o0> map, Set<Integer> set, Map<f, i> map2, Set<f> set2) {
        this.a = mVar;
        this.b = map;
        this.c = set;
        this.f3240d = map2;
        this.f3241e = set2;
    }

    public String toString() {
        StringBuilder h2 = a.h("RemoteEvent{snapshotVersion=");
        h2.append(this.a);
        h2.append(", targetChanges=");
        h2.append(this.b);
        h2.append(", targetMismatches=");
        h2.append(this.c);
        h2.append(", documentUpdates=");
        h2.append(this.f3240d);
        h2.append(", resolvedLimboDocuments=");
        h2.append(this.f3241e);
        h2.append('}');
        return h2.toString();
    }
}
