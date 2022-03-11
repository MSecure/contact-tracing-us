package f.b.a.f.a.b;

import f.b.a.f.a.c.d;
import f.b.a.f.a.e.u;
/* loaded from: classes.dex */
public final class n2 implements u<m2> {
    public final u<d0> a;
    public final u<o2> b;
    public final u<d> c;

    public n2(u<d0> uVar, u<o2> uVar2, u<d> uVar3) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
    }

    @Override // f.b.a.f.a.e.u
    public final /* bridge */ /* synthetic */ m2 a() {
        d0 a = this.a.a();
        return new m2(a, this.b.a(), this.c.a());
    }
}
