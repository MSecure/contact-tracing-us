package f.b.c.k.w;

import f.b.a.c.i.e;
import f.b.c.k.x.m;
import h.a.b;
import h.a.c1;
import h.a.n0;
/* loaded from: classes.dex */
public final /* synthetic */ class n implements e {
    public final b.a a;

    public n(b.a aVar) {
        this.a = aVar;
    }

    @Override // f.b.a.c.i.e
    public void b(Exception exc) {
        b.a aVar = this.a;
        n0.f<String> fVar = o.b;
        m.a(m.a.WARN, "FirestoreCallCredentials", "Failed to get token: %s.", exc);
        aVar.b(c1.f4092k.f(exc));
    }
}
