package c.b.a.a.g.h;

public final class n2 extends m2 {
    public n2(l2 l2Var) {
        super(null);
    }

    public static <E> z1<E> c(Object obj, long j) {
        return (z1) j4.s(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // c.b.a.a.g.h.m2
    public final <E> void a(Object obj, Object obj2, long j) {
        z1<E> c2 = c(obj, j);
        z1<E> c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        z1<E> z1Var = c2;
        z1Var = c2;
        if (size > 0 && size2 > 0) {
            boolean s = c2.s();
            z1<E> z1Var2 = c2;
            if (!s) {
                z1Var2 = c2.B(size2 + size);
            }
            z1Var2.addAll(c3);
            z1Var = z1Var2;
        }
        if (size > 0) {
            c3 = z1Var;
        }
        j4.e(obj, j, c3);
    }

    @Override // c.b.a.a.g.h.m2
    public final void b(Object obj, long j) {
        c(obj, j).H();
    }
}
