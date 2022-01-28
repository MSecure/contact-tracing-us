package g.b.a.x;

import b.x.t;
import c.a.a.a.a;
import g.b.a.f;
import g.b.a.q;
import java.io.Serializable;

public final class d implements Comparable<d>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final f f6693b;

    /* renamed from: c  reason: collision with root package name */
    public final q f6694c;

    /* renamed from: d  reason: collision with root package name */
    public final q f6695d;

    public d(long j, q qVar, q qVar2) {
        this.f6693b = f.Z(j, 0, qVar);
        this.f6694c = qVar;
        this.f6695d = qVar2;
    }

    public d(f fVar, q qVar, q qVar2) {
        this.f6693b = fVar;
        this.f6694c = qVar;
        this.f6695d = qVar2;
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public f b() {
        return this.f6693b.d0((long) (this.f6695d.f6447c - this.f6694c.f6447c));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        d dVar2 = dVar;
        g.b.a.d L = this.f6693b.L(this.f6694c);
        g.b.a.d L2 = dVar2.f6693b.L(dVar2.f6694c);
        int L3 = t.L(L.f6404b, L2.f6404b);
        return L3 != 0 ? L3 : L.f6405c - L2.f6405c;
    }

    public boolean d() {
        return this.f6695d.f6447c > this.f6694c.f6447c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6693b.equals(dVar.f6693b) && this.f6694c.equals(dVar.f6694c) && this.f6695d.equals(dVar.f6695d);
    }

    public int hashCode() {
        return (this.f6693b.hashCode() ^ this.f6694c.f6447c) ^ Integer.rotateLeft(this.f6695d.f6447c, 16);
    }

    public String toString() {
        StringBuilder h = a.h("Transition[");
        h.append(d() ? "Gap" : "Overlap");
        h.append(" at ");
        h.append(this.f6693b);
        h.append(this.f6694c);
        h.append(" to ");
        h.append(this.f6695d);
        h.append(']');
        return h.toString();
    }
}
