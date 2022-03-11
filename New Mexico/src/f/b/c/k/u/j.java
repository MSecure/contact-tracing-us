package f.b.c.k.u;

import f.a.a.a.a;
/* loaded from: classes.dex */
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
        StringBuilder h2 = a.h("NoDocument{key=");
        h2.append(this.a);
        h2.append(", version=");
        h2.append(this.b);
        h2.append(", hasCommittedMutations=");
        h2.append(this.c);
        h2.append("}");
        return h2.toString();
    }
}
