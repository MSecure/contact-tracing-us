package f.b.a.a.a.d0;

import f.a.b.p;
import f.b.a.a.a.t.q0.a;
/* loaded from: classes.dex */
public class j extends f.a.b.w.j {
    public j(String str, p.b<String> bVar, p.a aVar, a aVar2) {
        super(0, str, bVar, aVar);
        this.f2173l = true;
        this.m = new c(aVar2);
    }

    @Override // f.a.b.n
    public void b(String str) {
        p.b<String> bVar;
        String str2 = str;
        synchronized (this.p) {
            bVar = this.q;
        }
        if (bVar != null) {
            bVar.a(str2);
        }
    }
}
