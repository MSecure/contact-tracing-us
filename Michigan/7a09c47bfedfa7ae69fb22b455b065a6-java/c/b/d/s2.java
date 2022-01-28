package c.b.d;

import java.util.Arrays;

public class s2 extends p2<r2, r2> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // c.b.d.p2
    public void a(r2 r2Var, int i, int i2) {
        r2Var.c((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.p2
    public void b(r2 r2Var, int i, long j) {
        r2Var.c((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // c.b.d.p2
    public void c(r2 r2Var, int i, r2 r2Var2) {
        r2Var.c((i << 3) | 3, r2Var2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, c.b.d.j] */
    @Override // c.b.d.p2
    public void d(r2 r2Var, int i, j jVar) {
        r2Var.c((i << 3) | 2, jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.p2
    public void e(r2 r2Var, int i, long j) {
        r2Var.c((i << 3) | 0, Long.valueOf(j));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.p2
    public r2 f(Object obj) {
        k0 k0Var = (k0) obj;
        r2 r2Var = k0Var.f5348b;
        if (r2Var != r2.f5781f) {
            return r2Var;
        }
        r2 b2 = r2.b();
        k0Var.f5348b = b2;
        return b2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.p2
    public r2 g(Object obj) {
        return ((k0) obj).f5348b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.p2
    public int h(r2 r2Var) {
        return r2Var.a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.p2
    public int i(r2 r2Var) {
        r2 r2Var2 = r2Var;
        int i = r2Var2.f5785d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < r2Var2.f5782a; i3++) {
            i2 += m.C(r2Var2.f5783b[i3] >>> 3, (j) r2Var2.f5784c[i3]);
        }
        r2Var2.f5785d = i2;
        return i2;
    }

    @Override // c.b.d.p2
    public void j(Object obj) {
        ((k0) obj).f5348b.f5786e = false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.p2
    public r2 k(r2 r2Var, r2 r2Var2) {
        r2 r2Var3 = r2Var;
        r2 r2Var4 = r2Var2;
        if (r2Var4.equals(r2.f5781f)) {
            return r2Var3;
        }
        int i = r2Var3.f5782a + r2Var4.f5782a;
        int[] copyOf = Arrays.copyOf(r2Var3.f5783b, i);
        System.arraycopy(r2Var4.f5783b, 0, copyOf, r2Var3.f5782a, r2Var4.f5782a);
        Object[] copyOf2 = Arrays.copyOf(r2Var3.f5784c, i);
        System.arraycopy(r2Var4.f5784c, 0, copyOf2, r2Var3.f5782a, r2Var4.f5782a);
        return new r2(i, copyOf, copyOf2, true);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.p2
    public r2 m() {
        return r2.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.p2
    public void n(Object obj, r2 r2Var) {
        ((k0) obj).f5348b = r2Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.p2
    public void o(Object obj, r2 r2Var) {
        ((k0) obj).f5348b = r2Var;
    }

    @Override // c.b.d.p2
    public boolean p(b2 b2Var) {
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.p2
    public r2 q(r2 r2Var) {
        r2 r2Var2 = r2Var;
        r2Var2.f5786e = false;
        return r2Var2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.y2] */
    @Override // c.b.d.p2
    public void r(r2 r2Var, y2 y2Var) {
        r2 r2Var2 = r2Var;
        if (r2Var2 != null) {
            n nVar = (n) y2Var;
            if (nVar != null) {
                for (int i = 0; i < r2Var2.f5782a; i++) {
                    nVar.i(r2Var2.f5783b[i] >>> 3, r2Var2.f5784c[i]);
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.y2] */
    @Override // c.b.d.p2
    public void s(r2 r2Var, y2 y2Var) {
        r2Var.e(y2Var);
    }
}
