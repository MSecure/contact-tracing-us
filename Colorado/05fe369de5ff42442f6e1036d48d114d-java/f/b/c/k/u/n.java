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
        StringBuilder i2 = a.i("UnknownDocument{key=");
        i2.append(this.a);
        i2.append(", version=");
        i2.append(this.b);
        i2.append('}');
        return i2.toString();
    }
}
