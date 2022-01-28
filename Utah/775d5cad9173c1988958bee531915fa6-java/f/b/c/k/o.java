package f.b.c.k;

import f.b.a.c.b.o.b;
import f.b.c.k.u.p.c;

public final class o {
    public static final o c = new o(false, null);
    public final boolean a;
    public final c b = null;

    static {
        b.u(true, "Cannot specify a fieldMask for non-merge sets()", new Object[0]);
    }

    public o(boolean z, c cVar) {
        b.u(true, "Cannot specify a fieldMask for non-merge sets()", new Object[0]);
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.a != oVar.a) {
            return false;
        }
        c cVar = this.b;
        c cVar2 = oVar.b;
        return cVar != null ? cVar.equals(cVar2) : cVar2 == null;
    }

    public int hashCode() {
        int i2 = (this.a ? 1 : 0) * 31;
        c cVar = this.b;
        return i2 + (cVar != null ? cVar.hashCode() : 0);
    }
}
