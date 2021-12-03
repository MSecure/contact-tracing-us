package f.b.g;

public class g0 {
    public volatile t0 a;
    public volatile j b;

    static {
        r.a();
    }

    public t0 a(t0 t0Var) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    try {
                        this.a = t0Var;
                        this.b = j.c;
                    } catch (d0 unused) {
                        this.a = t0Var;
                        this.b = j.c;
                    }
                }
            }
        }
        return this.a;
    }

    public j b() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            this.b = this.a == null ? j.c : this.a.toByteString();
            return this.b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        t0 t0Var = this.a;
        t0 t0Var2 = g0Var.a;
        return (t0Var == null && t0Var2 == null) ? b().equals(g0Var.b()) : (t0Var == null || t0Var2 == null) ? t0Var != null ? t0Var.equals(g0Var.a(t0Var.getDefaultInstanceForType())) : a(t0Var2.getDefaultInstanceForType()).equals(t0Var2) : t0Var.equals(t0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
