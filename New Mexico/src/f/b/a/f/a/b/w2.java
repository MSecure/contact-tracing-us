package f.b.a.f.a.b;

import f.b.a.f.a.e.t;
import f.b.a.f.a.e.u;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class w2 implements u<v2> {
    public final u<d0> a;
    public final u<v3> b;
    public final u<s1> c;

    /* renamed from: d  reason: collision with root package name */
    public final u<Executor> f3332d;

    /* renamed from: e  reason: collision with root package name */
    public final u<d1> f3333e;

    public w2(u<d0> uVar, u<v3> uVar2, u<s1> uVar3, u<Executor> uVar4, u<d1> uVar5) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
        this.f3332d = uVar4;
        this.f3333e = uVar5;
    }

    @Override // f.b.a.f.a.e.u
    public final /* bridge */ /* synthetic */ v2 a() {
        d0 a = this.a.a();
        return new v2(a, t.b(this.b), this.c.a(), t.b(this.f3332d), this.f3333e.a());
    }
}
