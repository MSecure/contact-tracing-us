package f.b.g;

import java.util.Objects;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public class t1 extends r1<s1, s1> {
    @Override // f.b.g.r1
    public void a(Object obj, int i2, int i3) {
        ((s1) obj).f((i2 << 3) | 5, Integer.valueOf(i3));
    }

    public void b(Object obj, int i2, long j2) {
        ((s1) obj).f((i2 << 3) | 1, Long.valueOf(j2));
    }

    public void c(Object obj, int i2, Object obj2) {
        ((s1) obj).f((i2 << 3) | 3, (s1) obj2);
    }

    public void d(Object obj, int i2, j jVar) {
        ((s1) obj).f((i2 << 3) | 2, jVar);
    }

    public void e(Object obj, int i2, long j2) {
        ((s1) obj).f((i2 << 3) | 0, Long.valueOf(j2));
    }

    public Object f(Object obj) {
        z zVar = (z) obj;
        s1 s1Var = zVar.unknownFields;
        if (s1Var != s1.f3937f) {
            return s1Var;
        }
        s1 e2 = s1.e();
        zVar.unknownFields = e2;
        return e2;
    }

    public Object g(Object obj) {
        return ((z) obj).unknownFields;
    }

    public int h(Object obj) {
        return ((s1) obj).b();
    }

    public int i(Object obj) {
        s1 s1Var = (s1) obj;
        int i2 = s1Var.f3938d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < s1Var.a; i4++) {
            int z = m.z(2, s1Var.b[i4] >>> 3);
            i3 += m.d(3, (j) s1Var.c[i4]) + z + (m.y(1) * 2);
        }
        s1Var.f3938d = i3;
        return i3;
    }

    public void j(Object obj) {
        ((z) obj).unknownFields.f3939e = false;
    }

    public Object k(Object obj, Object obj2) {
        s1 s1Var = (s1) obj;
        s1 s1Var2 = (s1) obj2;
        return s1Var2.equals(s1.f3937f) ? s1Var : s1.d(s1Var, s1Var2);
    }

    public Object m() {
        return s1.e();
    }

    public void n(Object obj, Object obj2) {
        ((z) obj).unknownFields = (s1) obj2;
    }

    public void o(Object obj, Object obj2) {
        ((z) obj).unknownFields = (s1) obj2;
    }

    public boolean p(h1 h1Var) {
        return false;
    }

    public Object q(Object obj) {
        s1 s1Var = (s1) obj;
        s1Var.f3939e = false;
        return s1Var;
    }

    public void r(Object obj, a2 a2Var) {
        s1 s1Var = (s1) obj;
        Objects.requireNonNull(s1Var);
        Objects.requireNonNull(a2Var);
        for (int i2 = 0; i2 < s1Var.a; i2++) {
            ((n) a2Var).e(s1Var.b[i2] >>> 3, s1Var.c[i2]);
        }
    }

    public void s(Object obj, a2 a2Var) {
        ((s1) obj).h(a2Var);
    }
}
