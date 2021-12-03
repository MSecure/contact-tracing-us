package f.b.c.k.u;

import f.a.a.a.a;

public final class j extends i {
    public boolean c;

    public j(f fVar, m mVar, boolean z) {
        super(fVar, mVar);
        this.c = z;
    }

    @Override // f.b.c.k.u.i
    public boolean a() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.c != jVar.c || !this.b.equals(jVar.b) || !this.a.equals(jVar.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.b.hashCode() + (((this.a.hashCode() * 31) + (this.c ? 1 : 0)) * 31);
    }

    public String toString() {
        StringBuilder i2 = a.i("NoDocument{key=");
        i2.append(this.a);
        i2.append(", version=");
        i2.append(this.b);
        i2.append(", hasCommittedMutations=");
        i2.append(this.c);
        i2.append("}");
        return i2.toString();
    }
}
