package f.b.a.f.a.b;

import android.content.Context;
import f.b.a.f.a.e.r;
import f.b.a.f.a.e.t;
import f.b.a.f.a.e.u;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class z implements u<y> {
    public final u<Context> a;
    public final u<s1> b;
    public final u<a1> c;

    /* renamed from: d  reason: collision with root package name */
    public final u<v3> f3348d;

    /* renamed from: e  reason: collision with root package name */
    public final u<d1> f3349e;

    /* renamed from: f  reason: collision with root package name */
    public final u<o0> f3350f;

    /* renamed from: g  reason: collision with root package name */
    public final u<Executor> f3351g;

    /* renamed from: h  reason: collision with root package name */
    public final u<Executor> f3352h;

    /* renamed from: i  reason: collision with root package name */
    public final u<m2> f3353i;

    public z(u<Context> uVar, u<s1> uVar2, u<a1> uVar3, u<v3> uVar4, u<d1> uVar5, u<o0> uVar6, u<Executor> uVar7, u<Executor> uVar8, u<m2> uVar9) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
        this.f3348d = uVar4;
        this.f3349e = uVar5;
        this.f3350f = uVar6;
        this.f3351g = uVar7;
        this.f3352h = uVar8;
        this.f3353i = uVar9;
    }

    @Override // f.b.a.f.a.e.u
    public final /* bridge */ /* synthetic */ y a() {
        Context b = ((r3) this.a).b();
        s1 a = this.b.a();
        a1 a2 = this.c.a();
        r b2 = t.b(this.f3348d);
        d1 a3 = this.f3349e.a();
        return new y(b, a, a2, b2, a3, this.f3350f.a(), t.b(this.f3351g), t.b(this.f3352h), this.f3353i.a());
    }
}
