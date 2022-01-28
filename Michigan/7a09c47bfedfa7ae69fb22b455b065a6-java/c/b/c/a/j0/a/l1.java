package c.b.c.a.j0.a;

public abstract class l1<T, B> {
    public abstract void a(B b2, int i, i iVar);

    public abstract B b(Object obj);

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: c.b.c.a.j0.a.l1<T, B> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    public final boolean c(B b2, e1 e1Var) {
        int i = e1Var.i();
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            b2.c((i2 << 3) | 0, Long.valueOf(e1Var.z()));
            return true;
        } else if (i3 == 1) {
            b2.c((i2 << 3) | 1, Long.valueOf(e1Var.l()));
            return true;
        } else if (i3 == 2) {
            a(b2, i2, e1Var.c());
            return true;
        } else if (i3 == 3) {
            m1 b3 = m1.b();
            int i4 = i2 << 3;
            int i5 = i4 | 4;
            while (e1Var.G() != Integer.MAX_VALUE && c(b3, e1Var)) {
                while (e1Var.G() != Integer.MAX_VALUE) {
                    while (e1Var.G() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i5 == e1Var.i()) {
                b3.f4988e = false;
                b2.c(i4 | 3, b3);
                return true;
            }
            throw b0.a();
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                b2.c((i2 << 3) | 5, Integer.valueOf(e1Var.B()));
                return true;
            }
            throw b0.d();
        }
    }

    public abstract B d();

    public abstract void e(Object obj, B b2);

    public abstract boolean f(e1 e1Var);
}
