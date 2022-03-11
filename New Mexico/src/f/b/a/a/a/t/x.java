package f.b.a.a.a.t;

import e.b.a.m;
import e.d.q;
import e.d.r;
import f.b.a.a.a.e0.c7;
import f.b.a.a.a.x.g1;
import f.b.a.a.a.x.z0;
import f.b.a.c.b.o.b;
import java.util.Objects;
/* loaded from: classes.dex */
public class x extends q {
    public final /* synthetic */ y a;

    public x(y yVar) {
        this.a = yVar;
    }

    @Override // e.d.q
    public void a(int i2, CharSequence charSequence) {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 8 || i2 == 14 || i2 == 11 || i2 == 12) {
            ((g1.a) this.a).a(true);
        }
        ((g1.a) this.a).a(false);
    }

    @Override // e.d.q
    public void b() {
        g1.a aVar = (g1.a) this.a;
        g1 g1Var = g1.this;
        g1Var.g0 = false;
        m.e.Y0(g1Var.u0(), g1.this.b0.a);
    }

    @Override // e.d.q
    public void c(r rVar) {
        g1.a aVar = (g1.a) this.a;
        g1 g1Var = g1.this;
        int i2 = g1.j0;
        Objects.requireNonNull(g1Var);
        c7 c7Var = new c7();
        e.o.a.r u0 = g1Var.u0();
        b.o(u0 instanceof z0);
        ((z0) u0).B(c7Var);
        g1 g1Var2 = g1.this;
        g1Var2.g0 = false;
        m.e.Y0(g1Var2.u0(), g1.this.b0.a);
    }
}
