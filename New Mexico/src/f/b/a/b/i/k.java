package f.b.a.b.i;

import f.b.a.a.a.a0.l;
import f.b.a.a.a.a0.p;
import f.b.a.b.a;
import f.b.a.b.b;
import f.b.a.b.c;
import f.b.a.b.d;
import f.b.a.b.e;
import f.b.a.b.f;
import f.b.a.b.i.a;
import f.b.a.b.i.b;
import f.b.a.b.i.i;
import java.util.HashMap;
import java.util.Objects;
/* loaded from: classes.dex */
public final class k<T> implements f<T> {
    public final i a;
    public final String b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final e<T, byte[]> f2624d;

    /* renamed from: e  reason: collision with root package name */
    public final l f2625e;

    public k(i iVar, String str, b bVar, e<T, byte[]> eVar, l lVar) {
        this.a = iVar;
        this.b = str;
        this.c = bVar;
        this.f2624d = eVar;
        this.f2625e = lVar;
    }

    @Override // f.b.a.b.f
    public void a(c<T> cVar, l lVar) {
        l lVar2 = this.f2625e;
        i iVar = this.a;
        Objects.requireNonNull(iVar, "Null transportContext");
        String str = this.b;
        Objects.requireNonNull(str, "Null transportName");
        e<T, byte[]> eVar = this.f2624d;
        Objects.requireNonNull(eVar, "Null transformer");
        b bVar = this.c;
        Objects.requireNonNull(bVar, "Null encoding");
        m mVar = (m) lVar2;
        f.b.a.b.i.s.e eVar2 = mVar.c;
        a aVar = (a) cVar;
        d dVar = aVar.b;
        i.a a = i.a();
        a.b(iVar.b());
        a.c(dVar);
        b.C0078b bVar2 = (b.C0078b) a;
        bVar2.b = iVar.c();
        i a2 = bVar2.a();
        a.b bVar3 = new a.b();
        bVar3.f2614f = new HashMap();
        bVar3.e(mVar.a.a());
        bVar3.g(mVar.b.a());
        bVar3.f(str);
        p pVar = (p) eVar;
        bVar3.d(new e(bVar, ((f.b.a.a.a.h0.c) aVar.a).toByteArray()));
        bVar3.b = null;
        eVar2.a(a2, bVar3.b(), lVar);
    }
}
