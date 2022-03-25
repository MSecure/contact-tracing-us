package f.b.a.b.i;

import f.b.a.a.a.o.d;
import f.b.a.a.a.o.o;
import f.b.a.b.a;
import f.b.a.b.b;
import f.b.a.b.c;
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
    public final e<T, byte[]> f2440d;

    /* renamed from: e  reason: collision with root package name */
    public final l f2441e;

    public k(i iVar, String str, b bVar, e<T, byte[]> eVar, l lVar) {
        this.a = iVar;
        this.b = str;
        this.c = bVar;
        this.f2440d = eVar;
        this.f2441e = lVar;
    }

    @Override // f.b.a.b.f
    public void a(c<T> cVar, d dVar) {
        l lVar = this.f2441e;
        i iVar = this.a;
        Objects.requireNonNull(iVar, "Null transportContext");
        String str = this.b;
        Objects.requireNonNull(str, "Null transportName");
        e<T, byte[]> eVar = this.f2440d;
        Objects.requireNonNull(eVar, "Null transformer");
        b bVar = this.c;
        Objects.requireNonNull(bVar, "Null encoding");
        m mVar = (m) lVar;
        f.b.a.b.i.s.e eVar2 = mVar.c;
        a aVar = (a) cVar;
        f.b.a.b.d dVar2 = aVar.b;
        i.a a2 = i.a();
        a2.b(iVar.b());
        a2.c(dVar2);
        b.C0079b bVar2 = (b.C0079b) a2;
        bVar2.b = iVar.c();
        i a3 = bVar2.a();
        a.b bVar3 = new a.b();
        bVar3.f2430f = new HashMap();
        bVar3.e(mVar.a.a());
        bVar3.g(mVar.b.a());
        bVar3.f(str);
        o oVar = (o) eVar;
        bVar3.d(new e(bVar, aVar.a.toByteArray()));
        bVar3.b = null;
        eVar2.a(a3, bVar3.b(), dVar);
    }
}
