package f.b.a.a.a.h;

import e.f.a.b;
import f.b.a.c.i.d;
import f.b.a.c.i.h;

public final /* synthetic */ class e implements d {
    public final /* synthetic */ b a;

    public /* synthetic */ e(b bVar) {
        this.a = bVar;
    }

    @Override // f.b.a.c.i.d
    public final void a(h hVar) {
        b bVar = this.a;
        try {
            if (hVar.l()) {
                boolean z = true;
                bVar.f1212d = true;
                e.f.a.e<T> eVar = bVar.b;
                if (eVar == null || !eVar.c.cancel(true)) {
                    z = false;
                }
                if (z) {
                    bVar.b();
                }
            } else if (hVar.j() != null) {
                bVar.c(hVar.j());
            } else {
                bVar.a(hVar.k());
            }
        } catch (Exception e2) {
            bVar.c(e2);
        }
    }
}
