package f.b.a.f.a.b;

import android.content.Context;
import f.b.a.f.a.e.t;
import f.b.a.f.a.e.u;
import java.io.File;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class b2 implements u<a2> {
    public final u<String> a;
    public final u<y> b;
    public final u<d1> c;

    /* renamed from: d  reason: collision with root package name */
    public final u<Context> f3193d;

    /* renamed from: e  reason: collision with root package name */
    public final u<o2> f3194e;

    /* renamed from: f  reason: collision with root package name */
    public final u<Executor> f3195f;

    /* renamed from: g  reason: collision with root package name */
    public final u<m2> f3196g;

    public b2(u<String> uVar, u<y> uVar2, u<d1> uVar3, u<Context> uVar4, u<o2> uVar5, u<Executor> uVar6, u<m2> uVar7) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
        this.f3193d = uVar4;
        this.f3194e = uVar5;
        this.f3195f = uVar6;
        this.f3196g = uVar7;
    }

    @Override // f.b.a.f.a.e.u
    public final /* bridge */ /* synthetic */ a2 a() {
        String a = this.a.a();
        y a2 = this.b.a();
        d1 a3 = this.c.a();
        Context b = ((r3) this.f3193d).b();
        o2 a4 = this.f3194e.a();
        return new a2(a != null ? new File(b.getExternalFilesDir(null), a) : b.getExternalFilesDir(null), a2, a3, b, a4, t.b(this.f3195f), this.f3196g.a());
    }
}
