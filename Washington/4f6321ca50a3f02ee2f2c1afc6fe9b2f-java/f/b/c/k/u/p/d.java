package f.b.c.k.u.p;

import f.b.c.k.u.h;

public final class d {
    public final h a;
    public final o b;

    public d(h hVar, o oVar) {
        this.a = hVar;
        this.b = oVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.a.equals(dVar.a)) {
            return false;
        }
        return this.b.equals(dVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }
}
