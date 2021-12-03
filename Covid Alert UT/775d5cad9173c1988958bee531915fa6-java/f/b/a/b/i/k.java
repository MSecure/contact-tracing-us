package f.b.a.b.i;

import f.b.a.a.a.z.l;
import f.b.a.a.a.z.p;
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

public final class k<T> implements f<T> {
    public final i a;
    public final String b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final e<T, byte[]> f2583d;

    /* renamed from: e  reason: collision with root package name */
    public final l f2584e;

    public k(i iVar, String str, b bVar, e<T, byte[]> eVar, l lVar) {
        this.a = iVar;
        this.b = str;
        this.c = bVar;
        this.f2583d = eVar;
        this.f2584e = lVar;
    }

    @Override // f.b.a.b.f
    public void a(c<T> cVar, l lVar) {
        l lVar2 = this.f2584e;
        i iVar = this.a;
        Objects.requireNonNull(iVar, "Null transportContext");
        String str = this.b;
        Objects.requireNonNull(str, "Null transportName");
        e<T, byte[]> eVar = this.f2583d;
        Objects.requireNonNull(eVar, "Null transformer");
        b bVar = this.c;
        Objects.requireNonNull(bVar, "Null encoding");
        m mVar = (m) lVar2;
        f.b.a.b.i.s.e eVar2 = mVar.c;
        a aVar = (a) cVar;
        d dVar = aVar.b;
        i.a a2 = i.a();
        a2.b(iVar.b());
        a2.c(dVar);
        b.C0076b bVar2 = (b.C0076b) a2;
        bVar2.b = iVar.c();
        i a3 = bVar2.a();
        a.b bVar3 = new a.b();
        bVar3.f2573f = new HashMap();
        bVar3.e(mVar.a.a());
        bVar3.g(mVar.b.a());
        bVar3.f(str);
        p pVar = (p) eVar;
        bVar3.d(new e(bVar, aVar.a.toByteArray()));
        bVar3.b = null;
        eVar2.a(a3, bVar3.b(), lVar);
    }
}
