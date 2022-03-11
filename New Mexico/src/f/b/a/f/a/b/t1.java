package f.b.a.f.a.b;

import f.b.a.f.a.e.t;
import f.b.a.f.a.e.u;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class t1 implements u<s1> {
    public final u<d0> a;
    public final u<v3> b;
    public final u<d1> c;

    /* renamed from: d  reason: collision with root package name */
    public final u<Executor> f3314d;

    public t1(u<d0> uVar, u<v3> uVar2, u<d1> uVar3, u<Executor> uVar4) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
        this.f3314d = uVar4;
    }

    @Override // f.b.a.f.a.e.u
    public final /* bridge */ /* synthetic */ s1 a() {
        d0 a = this.a.a();
        return new s1(a, t.b(this.b), this.c.a(), t.b(this.f3314d));
    }
}
