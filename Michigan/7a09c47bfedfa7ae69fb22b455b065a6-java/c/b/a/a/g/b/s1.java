package c.b.a.a.g.b;

public final class s1 extends p1 {
    public s1(q1 q1Var) {
        super(null);
    }

    public static <E> e1<E> c(Object obj, long j) {
        return (e1) n3.t(obj, j);
    }

    @Override // c.b.a.a.g.b.p1
    public final void a(Object obj, long j) {
        c(obj, j).G();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // c.b.a.a.g.b.p1
    public final <E> void b(Object obj, Object obj2, long j) {
        e1<E> c2 = c(obj, j);
        e1<E> c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        e1<E> e1Var = c2;
        e1Var = c2;
        if (size > 0 && size2 > 0) {
            boolean y = c2.y();
            e1<E> e1Var2 = c2;
            if (!y) {
                e1Var2 = c2.r(size2 + size);
            }
            e1Var2.addAll(c3);
            e1Var = e1Var2;
        }
        if (size > 0) {
            c3 = e1Var;
        }
        n3.f(obj, j, c3);
    }
}
