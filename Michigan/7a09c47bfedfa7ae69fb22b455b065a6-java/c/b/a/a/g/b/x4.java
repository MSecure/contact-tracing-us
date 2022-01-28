package c.b.a.a.g.b;

public final class x4 extends e4<x4> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static volatile x4[] f3471f;

    /* renamed from: d  reason: collision with root package name */
    public String f3472d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f3473e = "";

    public x4() {
        this.f3257c = null;
        this.f3330b = -1;
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final void a(c4 c4Var) {
        String str = this.f3472d;
        if (str != null && !str.equals("")) {
            c4Var.c(1, this.f3472d);
        }
        String str2 = this.f3473e;
        if (str2 != null && !str2.equals("")) {
            c4Var.c(2, this.f3473e);
        }
        super.a(c4Var);
    }

    @Override // c.b.a.a.g.b.e4, java.lang.Object, c.b.a.a.g.b.j4
    public final Object clone() {
        try {
            return (x4) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final int d() {
        super.d();
        String str = this.f3472d;
        int i = 0;
        if (str != null && !str.equals("")) {
            i = 0 + c4.h(1, this.f3472d);
        }
        String str2 = this.f3473e;
        return (str2 == null || str2.equals("")) ? i : i + c4.h(2, this.f3473e);
    }

    @Override // c.b.a.a.g.b.e4, c.b.a.a.g.b.j4
    public final /* synthetic */ j4 e() {
        return (x4) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x4)) {
            return false;
        }
        x4 x4Var = (x4) obj;
        String str = this.f3472d;
        if (str == null) {
            if (x4Var.f3472d != null) {
                return false;
            }
        } else if (!str.equals(x4Var.f3472d)) {
            return false;
        }
        String str2 = this.f3473e;
        if (str2 == null) {
            if (x4Var.f3473e != null) {
                return false;
            }
        } else if (!str2.equals(x4Var.f3473e)) {
            return false;
        }
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            return this.f3257c.equals(x4Var.f3257c);
        }
        g4 g4Var2 = x4Var.f3257c;
        return g4Var2 == null || g4Var2.a();
    }

    /* Return type fixed from 'c.b.a.a.g.b.e4' to match base method */
    @Override // c.b.a.a.g.b.e4
    public final /* synthetic */ x4 f() {
        return (x4) clone();
    }

    public final int hashCode() {
        int hashCode = (x4.class.getName().hashCode() + 527) * 31;
        String str = this.f3472d;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f3473e;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        g4 g4Var = this.f3257c;
        if (g4Var != null && !g4Var.a()) {
            i = this.f3257c.hashCode();
        }
        return hashCode3 + i;
    }
}
