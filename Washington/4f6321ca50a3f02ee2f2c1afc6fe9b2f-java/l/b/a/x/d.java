package l.b.a.x;

import f.a.a.a.a;
import java.io.Serializable;
import l.b.a.f;
import l.b.a.q;

public final class d implements Comparable<d>, Serializable {
    public final f b;
    public final q c;

    /* renamed from: d  reason: collision with root package name */
    public final q f4232d;

    public d(long j2, q qVar, q qVar2) {
        this.b = f.G(j2, 0, qVar);
        this.c = qVar;
        this.f4232d = qVar2;
    }

    public d(f fVar, q qVar, q qVar2) {
        this.b = fVar;
        this.c = qVar;
        this.f4232d = qVar2;
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public f a() {
        return this.b.K((long) (this.f4232d.c - this.c.c));
    }

    public boolean b() {
        return this.f4232d.c > this.c.c;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        d dVar2 = dVar;
        return this.b.w(this.c).compareTo(dVar2.b.w(dVar2.c));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.b.equals(dVar.b) && this.c.equals(dVar.c) && this.f4232d.equals(dVar.f4232d);
    }

    public int hashCode() {
        return (this.b.hashCode() ^ this.c.c) ^ Integer.rotateLeft(this.f4232d.c, 16);
    }

    public String toString() {
        StringBuilder h2 = a.h("Transition[");
        h2.append(b() ? "Gap" : "Overlap");
        h2.append(" at ");
        h2.append(this.b);
        h2.append(this.c);
        h2.append(" to ");
        h2.append(this.f4232d);
        h2.append(']');
        return h2.toString();
    }
}
