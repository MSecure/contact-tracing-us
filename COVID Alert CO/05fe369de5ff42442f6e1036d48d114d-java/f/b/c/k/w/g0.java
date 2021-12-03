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
    public final Map<f, i> f3335d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<f> f3336e;

    public g0(m mVar, Map<Integer, o0> map, Set<Integer> set, Map<f, i> map2, Set<f> set2) {
        this.a = mVar;
        this.b = map;
        this.c = set;
        this.f3335d = map2;
        this.f3336e = set2;
    }

    public String toString() {
        StringBuilder i2 = a.i("RemoteEvent{snapshotVersion=");
        i2.append(this.a);
        i2.append(", targetChanges=");
        i2.append(this.b);
        i2.append(", targetMismatches=");
        i2.append(this.c);
        i2.append(", documentUpdates=");
        i2.append(this.f3335d);
        i2.append(", resolvedLimboDocuments=");
        i2.append(this.f3336e);
        i2.append('}');
        return i2.toString();
    }
}
