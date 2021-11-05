package c.b.d;

import java.util.Arrays;

public class r2 extends o2<q2, q2> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // c.b.d.o2
    public void a(q2 q2Var, int i, int i2) {
        q2Var.c((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.o2
    public void b(q2 q2Var, int i, long j) {
        q2Var.c((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // c.b.d.o2
    public void c(q2 q2Var, int i, q2 q2Var2) {
        q2Var.c((i << 3) | 3, q2Var2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, c.b.d.j] */
    @Override // c.b.d.o2
    public void d(q2 q2Var, int i, j jVar) {
        q2Var.c((i << 3) | 2, jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.o2
    public void e(q2 q2Var, int i, long j) {
        q2Var.c((i << 3) | 0, Long.valueOf(j));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.o2
    public q2 f(Object obj) {
        j0 j0Var = (j0) obj;
        q2 q2Var = j0Var.f3921b;
        if (q2Var != q2.f) {
            return q2Var;
        }
        q2 b2 = q2.b();
        j0Var.f3921b = b2;
        return b2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.o2
    public q2 g(Object obj) {
        return ((j0) obj).f3921b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.o2
    public int h(q2 q2Var) {
        return q2Var.a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.o2
    public int i(q2 q2Var) {
        q2 q2Var2 = q2Var;
        int i = q2Var2.f4059d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < q2Var2.f4056a; i3++) {
            i2 += m.C(q2Var2.f4057b[i3] >>> 3, (j) q2Var2.f4058c[i3]);
        }
        q2Var2.f4059d = i2;
        return i2;
    }

    @Override // c.b.d.o2
    public void j(Object obj) {
        ((j0) obj).f3921b.f4060e = false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.o2
    public q2 k(q2 q2Var, q2 q2Var2) {
        q2 q2Var3 = q2Var;
        q2 q2Var4 = q2Var2;
        if (q2Var4.equals(q2.f)) {
            return q2Var3;
        }
        int i = q2Var3.f4056a + q2Var4.f4056a;
        int[] copyOf = Arrays.copyOf(q2Var3.f4057b, i);
        System.arraycopy(q2Var4.f4057b, 0, copyOf, q2Var3.f4056a, q2Var4.f4056a);
        Object[] copyOf2 = Arrays.copyOf(q2Var3.f4058c, i);
        System.arraycopy(q2Var4.f4058c, 0, copyOf2, q2Var3.f4056a, q2Var4.f4056a);
        return new q2(i, copyOf, copyOf2, true);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.o2
    public q2 m() {
        return q2.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.o2
    public void n(Object obj, q2 q2Var) {
        ((j0) obj).f3921b = q2Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.o2
    public void o(Object obj, q2 q2Var) {
        ((j0) obj).f3921b = q2Var;
    }

    @Override // c.b.d.o2
    public boolean p(a2 a2Var) {
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.o2
    public q2 q(q2 q2Var) {
        q2 q2Var2 = q2Var;
        q2Var2.f4060e = false;
        return q2Var2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.x2] */
    @Override // c.b.d.o2
    public void r(q2 q2Var, x2 x2Var) {
        q2 q2Var2 = q2Var;
        if (q2Var2 != null) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                for (int i = 0; i < q2Var2.f4056a; i++) {
                    nVar.i(q2Var2.f4057b[i] >>> 3, q2Var2.f4058c[i]);
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.x2] */
    @Override // c.b.d.o2
    public void s(q2 q2Var, x2 x2Var) {
        q2Var.e(x2Var);
    }
}
