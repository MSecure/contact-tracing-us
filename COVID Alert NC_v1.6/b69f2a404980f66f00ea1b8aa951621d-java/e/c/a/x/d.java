package e.c.a.x;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.f;
import e.c.a.q;
import java.io.Serializable;

public final class d implements Comparable<d>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final f f5206b;

    /* renamed from: c  reason: collision with root package name */
    public final q f5207c;

    /* renamed from: d  reason: collision with root package name */
    public final q f5208d;

    public d(long j, q qVar, q qVar2) {
        this.f5206b = f.J(j, 0, qVar);
        this.f5207c = qVar;
        this.f5208d = qVar2;
    }

    public d(f fVar, q qVar, q qVar2) {
        this.f5206b = fVar;
        this.f5207c = qVar;
        this.f5208d = qVar2;
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public f b() {
        return this.f5206b.N((long) (this.f5208d.f5002b - this.f5207c.f5002b));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        d dVar2 = dVar;
        e.c.a.d y = this.f5206b.y(this.f5207c);
        e.c.a.d y2 = dVar2.f5206b.y(dVar2.f5207c);
        int A = c.A(y.f4967b, y2.f4967b);
        return A != 0 ? A : y.f4968c - y2.f4968c;
    }

    public boolean d() {
        return this.f5208d.f5002b > this.f5207c.f5002b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f5206b.equals(dVar.f5206b) && this.f5207c.equals(dVar.f5207c) && this.f5208d.equals(dVar.f5208d);
    }

    public int hashCode() {
        return (this.f5206b.hashCode() ^ this.f5207c.f5002b) ^ Integer.rotateLeft(this.f5208d.f5002b, 16);
    }

    public String toString() {
        StringBuilder g = a.g("Transition[");
        g.append(d() ? "Gap" : "Overlap");
        g.append(" at ");
        g.append(this.f5206b);
        g.append(this.f5207c);
        g.append(" to ");
        g.append(this.f5208d);
        g.append(']');
        return g.toString();
    }
}
