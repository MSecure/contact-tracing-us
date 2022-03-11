package f.b.c.k.u;

import f.a.a.a.a;

public final class n extends i {
    public n(f fVar, m mVar) {
        super(fVar, mVar);
    }

    @Override // f.b.c.k.u.i
    public boolean a() {
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.b.equals(nVar.b) || !this.a.equals(nVar.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder h2 = a.h("UnknownDocument{key=");
        h2.append(this.a);
        h2.append(", version=");
        h2.append(this.b);
        h2.append('}');
        return h2.toString();
    }
}
