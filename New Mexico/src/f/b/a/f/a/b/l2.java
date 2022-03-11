package f.b.a.f.a.b;

import f.b.a.f.a.c.d;
import f.b.a.f.a.e.r;
import f.b.a.f.a.e.t;
import f.b.a.f.a.e.u;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class l2 implements u<k2> {
    public final u<d0> a;
    public final u<v3> b;
    public final u<s1> c;

    /* renamed from: d  reason: collision with root package name */
    public final u<Executor> f3262d;

    /* renamed from: e  reason: collision with root package name */
    public final u<d1> f3263e;

    /* renamed from: f  reason: collision with root package name */
    public final u<d> f3264f;

    /* renamed from: g  reason: collision with root package name */
    public final u<m2> f3265g;

    public l2(u<d0> uVar, u<v3> uVar2, u<s1> uVar3, u<Executor> uVar4, u<d1> uVar5, u<d> uVar6, u<m2> uVar7) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
        this.f3262d = uVar4;
        this.f3263e = uVar5;
        this.f3264f = uVar6;
        this.f3265g = uVar7;
    }

    @Override // f.b.a.f.a.e.u
    public final /* bridge */ /* synthetic */ k2 a() {
        d0 a = this.a.a();
        r b = t.b(this.b);
        s1 a2 = this.c.a();
        return new k2(a, b, a2, t.b(this.f3262d), this.f3263e.a(), this.f3264f.a(), this.f3265g.a());
    }
}
