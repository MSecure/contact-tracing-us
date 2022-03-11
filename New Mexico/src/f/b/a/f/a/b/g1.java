package f.b.a.f.a.b;

import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public final /* synthetic */ class g1 implements r1 {
    public final /* synthetic */ s1 a;
    public final /* synthetic */ int b;

    public /* synthetic */ g1(s1 s1Var, int i2) {
        this.a = s1Var;
        this.b = i2;
    }

    @Override // f.b.a.f.a.b.r1
    public final Object a() {
        s1 s1Var = this.a;
        int i2 = this.b;
        p1 a = s1Var.a(i2);
        if (b.V1(a.c.f3270d)) {
            d0 d0Var = s1Var.a;
            o1 o1Var = a.c;
            d0Var.c(o1Var.a, a.b, o1Var.b);
            o1 o1Var2 = a.c;
            int i3 = o1Var2.f3270d;
            if (i3 != 5 && i3 != 6) {
                return null;
            }
            d0 d0Var2 = s1Var.a;
            String str = o1Var2.a;
            int i4 = a.b;
            long j2 = o1Var2.b;
            if (!d0Var2.n(str, i4, j2).exists()) {
                return null;
            }
            d0.j(d0Var2.n(str, i4, j2));
            return null;
        }
        throw new z0(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i2)), i2);
    }
}
