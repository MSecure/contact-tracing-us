package f.b.c.k.u;

import f.a.a.a.a;
import f.b.c.d;
/* loaded from: classes.dex */
public final class m implements Comparable<m> {
    public static final m c = new m(new d(0, 0));
    public final d b;

    public m(d dVar) {
        this.b = dVar;
    }

    /* renamed from: a */
    public int compareTo(m mVar) {
        return this.b.compareTo(mVar.b);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof m) && compareTo((m) obj) == 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = a.h("SnapshotVersion(seconds=");
        h2.append(this.b.b);
        h2.append(", nanos=");
        h2.append(this.b.c);
        h2.append(")");
        return h2.toString();
    }
}
