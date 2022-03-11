package l.b.a.y;

import f.a.a.a.a;
import java.io.Serializable;
import l.b.a.g;
import l.b.a.r;
/* loaded from: classes.dex */
public final class d implements Comparable<d>, Serializable {
    public final g b;
    public final r c;

    /* renamed from: d  reason: collision with root package name */
    public final r f4803d;

    public d(long j2, r rVar, r rVar2) {
        this.b = g.G(j2, 0, rVar);
        this.c = rVar;
        this.f4803d = rVar2;
    }

    public d(g gVar, r rVar, r rVar2) {
        this.b = gVar;
        this.c = rVar;
        this.f4803d = rVar2;
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public g a() {
        return this.b.K((long) (this.f4803d.c - this.c.c));
    }

    public boolean b() {
        return this.f4803d.c > this.c.c;
    }

    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        d dVar2 = dVar;
        return this.b.w(this.c).compareTo(dVar2.b.w(dVar2.c));
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.b.equals(dVar.b) && this.c.equals(dVar.c) && this.f4803d.equals(dVar.f4803d);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.b.hashCode() ^ this.c.c) ^ Integer.rotateLeft(this.f4803d.c, 16);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = a.h("Transition[");
        h2.append(b() ? "Gap" : "Overlap");
        h2.append(" at ");
        h2.append(this.b);
        h2.append(this.c);
        h2.append(" to ");
        h2.append(this.f4803d);
        h2.append(']');
        return h2.toString();
    }
}
