package f.b.a.f.a.b;

import f.b.a.f.a.c.d;
import f.b.a.f.a.e.u;
/* loaded from: classes.dex */
public final class w1 implements u<v1> {
    public final u<s1> a;
    public final u<d0> b;
    public final u<l0> c;

    /* renamed from: d  reason: collision with root package name */
    public final u<d> f3331d;

    public w1(u<s1> uVar, u<d0> uVar2, u<l0> uVar3, u<d> uVar4) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
        this.f3331d = uVar4;
    }

    @Override // f.b.a.f.a.e.u
    public final /* bridge */ /* synthetic */ v1 a() {
        s1 a = this.a.a();
        d0 a2 = this.b.a();
        return new v1(a, a2, this.c.a(), this.f3331d.a());
    }
}
