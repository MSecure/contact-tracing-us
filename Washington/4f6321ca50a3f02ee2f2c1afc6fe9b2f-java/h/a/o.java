package h.a;

import f.b.a.c.b.o.b;

public final class o {
    public final n a;
    public final c1 b;

    public o(n nVar, c1 c1Var) {
        b.A(nVar, "state is null");
        this.a = nVar;
        b.A(c1Var, "status is null");
        this.b = c1Var;
    }

    public static o a(n nVar) {
        b.o(nVar != n.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new o(nVar, c1.f3517f);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a.equals(oVar.a) && this.b.equals(oVar.b);
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public String toString() {
        if (this.b.e()) {
            return this.a.toString();
        }
        return this.a + "(" + this.b + ")";
    }
}
