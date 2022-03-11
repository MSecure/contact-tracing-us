package f.b.c.k.w;

import f.b.a.c.i.f;
import f.b.c.k.x.m;
import h.a.b;
import h.a.n0;
/* loaded from: classes.dex */
public final /* synthetic */ class m implements f {
    public final b.a a;

    public m(b.a aVar) {
        this.a = aVar;
    }

    @Override // f.b.a.c.i.f
    public void a(Object obj) {
        b.a aVar = this.a;
        String str = (String) obj;
        n0.f<String> fVar = o.b;
        f.b.c.k.x.m.a(m.a.DEBUG, "FirestoreCallCredentials", "Successfully fetched token.", new Object[0]);
        n0 n0Var = new n0();
        if (str != null) {
            n0.f<String> fVar2 = o.b;
            n0Var.h(fVar2, "Bearer " + str);
        }
        aVar.a(n0Var);
    }
}
