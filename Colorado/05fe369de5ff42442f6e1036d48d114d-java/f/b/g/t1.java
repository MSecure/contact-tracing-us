package f.b.g;

import java.util.Objects;

public class t1 extends r1<s1, s1> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // f.b.g.r1
    public void a(s1 s1Var, int i2, int i3) {
        s1Var.f((i2 << 3) | 5, Integer.valueOf(i3));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // f.b.g.r1
    public void b(s1 s1Var, int i2, long j2) {
        s1Var.f((i2 << 3) | 1, Long.valueOf(j2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // f.b.g.r1
    public void c(s1 s1Var, int i2, s1 s1Var2) {
        s1Var.f((i2 << 3) | 3, s1Var2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, f.b.g.j] */
    @Override // f.b.g.r1
    public void d(s1 s1Var, int i2, j jVar) {
        s1Var.f((i2 << 3) | 2, jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // f.b.g.r1
    public void e(s1 s1Var, int i2, long j2) {
        s1Var.f((i2 << 3) | 0, Long.valueOf(j2));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // f.b.g.r1
    public s1 f(Object obj) {
        z zVar = (z) obj;
        s1 s1Var = zVar.unknownFields;
        if (s1Var != s1.f3618f) {
            return s1Var;
        }
        s1 e2 = s1.e();
        zVar.unknownFields = e2;
        return e2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // f.b.g.r1
    public s1 g(Object obj) {
        return ((z) obj).unknownFields;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.g.r1
    public int h(s1 s1Var) {
        return s1Var.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.g.r1
    public int i(s1 s1Var) {
        s1 s1Var2 = s1Var;
        int i2 = s1Var2.f3619d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < s1Var2.a; i4++) {
            int z = m.z(2, s1Var2.b[i4] >>> 3);
            i3 += m.d(3, (j) s1Var2.c[i4]) + z + (m.y(1) * 2);
        }
        s1Var2.f3619d = i3;
        return i3;
    }

    @Override // f.b.g.r1
    public void j(Object obj) {
        ((z) obj).unknownFields.f3620e = false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // f.b.g.r1
    public s1 k(s1 s1Var, s1 s1Var2) {
        s1 s1Var3 = s1Var;
        s1 s1Var4 = s1Var2;
        return s1Var4.equals(s1.f3618f) ? s1Var3 : s1.d(s1Var3, s1Var4);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // f.b.g.r1
    public s1 m() {
        return s1.e();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // f.b.g.r1
    public void n(Object obj, s1 s1Var) {
        ((z) obj).unknownFields = s1Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // f.b.g.r1
    public void o(Object obj, s1 s1Var) {
        ((z) obj).unknownFields = s1Var;
    }

    @Override // f.b.g.r1
    public boolean p(h1 h1Var) {
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.g.r1
    public s1 q(s1 s1Var) {
        s1 s1Var2 = s1Var;
        s1Var2.f3620e = false;
        return s1Var2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, f.b.g.a2] */
    @Override // f.b.g.r1
    public void r(s1 s1Var, a2 a2Var) {
        s1 s1Var2 = s1Var;
        Objects.requireNonNull(s1Var2);
        Objects.requireNonNull(a2Var);
        for (int i2 = 0; i2 < s1Var2.a; i2++) {
            ((n) a2Var).e(s1Var2.b[i2] >>> 3, s1Var2.c[i2]);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, f.b.g.a2] */
    @Override // f.b.g.r1
    public void s(s1 s1Var, a2 a2Var) {
        s1Var.h(a2Var);
    }
}
