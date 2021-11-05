package c.b.a.a.g.b;

public class m1 {

    /* renamed from: a  reason: collision with root package name */
    public volatile e2 f3344a;

    /* renamed from: b  reason: collision with root package name */
    public volatile y f3345b;

    static {
        l0.a();
    }

    public final int a() {
        if (this.f3345b != null) {
            return this.f3345b.size();
        }
        if (this.f3344a != null) {
            return this.f3344a.d();
        }
        return 0;
    }

    public final e2 b(e2 e2Var) {
        if (this.f3344a == null) {
            synchronized (this) {
                if (this.f3344a == null) {
                    try {
                        this.f3344a = e2Var;
                        this.f3345b = y.f3474c;
                    } catch (f1 unused) {
                        this.f3344a = e2Var;
                        this.f3345b = y.f3474c;
                    }
                }
            }
        }
        return this.f3344a;
    }

    public final y c() {
        if (this.f3345b != null) {
            return this.f3345b;
        }
        synchronized (this) {
            if (this.f3345b != null) {
                return this.f3345b;
            }
            this.f3345b = this.f3344a == null ? y.f3474c : this.f3344a.f();
            return this.f3345b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        e2 e2Var = this.f3344a;
        e2 e2Var2 = m1Var.f3344a;
        return (e2Var == null && e2Var2 == null) ? c().equals(m1Var.c()) : (e2Var == null || e2Var2 == null) ? e2Var != null ? e2Var.equals(m1Var.b(e2Var.e())) : b(e2Var2.e()).equals(e2Var2) : e2Var.equals(e2Var2);
    }

    public int hashCode() {
        return 1;
    }
}
