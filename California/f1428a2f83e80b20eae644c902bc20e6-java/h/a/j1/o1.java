package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.c1;
import h.a.h0;

public final class o1 extends h0.i {
    public final h0.e a;
    public final /* synthetic */ Throwable b;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public o1(m1 m1Var, Throwable th) {
        this.b = th;
        c1 f2 = c1.m.g("Panic! This is a bug!").f(th);
        h0.e eVar = h0.e.f3532e;
        b.o(!f2.e(), "drop status shouldn't be OK");
        this.a = new h0.e(null, null, f2, true);
    }

    @Override // h.a.h0.i
    public h0.e a(h0.f fVar) {
        return this.a;
    }

    public String toString() {
        k kVar = new k(o1.class.getSimpleName(), null);
        kVar.d("panicPickResult", this.a);
        return kVar.toString();
    }
}
