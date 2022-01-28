package c.b.a.a.g.h;

public class h2 {

    /* renamed from: a  reason: collision with root package name */
    public volatile c3 f3903a;

    /* renamed from: b  reason: collision with root package name */
    public volatile q0 f3904b;

    static {
        e1.a();
    }

    public final q0 a() {
        if (this.f3904b != null) {
            return this.f3904b;
        }
        synchronized (this) {
            if (this.f3904b != null) {
                return this.f3904b;
            }
            this.f3904b = this.f3903a == null ? q0.f4006c : this.f3903a.c();
            return this.f3904b;
        }
    }

    public final int b() {
        if (this.f3904b != null) {
            return this.f3904b.size();
        }
        if (this.f3903a != null) {
            return this.f3903a.d();
        }
        return 0;
    }

    public final c3 c(c3 c3Var) {
        if (this.f3903a == null) {
            synchronized (this) {
                if (this.f3903a == null) {
                    try {
                        this.f3903a = c3Var;
                        this.f3904b = q0.f4006c;
                    } catch (c2 unused) {
                        this.f3903a = c3Var;
                        this.f3904b = q0.f4006c;
                    }
                }
            }
        }
        return this.f3903a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h2)) {
            return false;
        }
        h2 h2Var = (h2) obj;
        c3 c3Var = this.f3903a;
        c3 c3Var2 = h2Var.f3903a;
        return (c3Var == null && c3Var2 == null) ? a().equals(h2Var.a()) : (c3Var == null || c3Var2 == null) ? c3Var != null ? c3Var.equals(h2Var.c(c3Var.b())) : c(c3Var2.b()).equals(c3Var2) : c3Var.equals(c3Var2);
    }

    public int hashCode() {
        return 1;
    }
}
