package f.b.a.c.e.c;

import f.b.a.c.i.d;
import f.b.a.c.i.h;
import f.b.a.c.i.i;

public final /* synthetic */ class p2 implements d {
    public final /* synthetic */ i a;

    public /* synthetic */ p2(i iVar) {
        this.a = iVar;
    }

    @Override // f.b.a.c.i.d
    public final void a(h hVar) {
        i iVar = this.a;
        if (hVar.o()) {
            iVar.b(hVar.l());
            return;
        }
        Exception k2 = hVar.k();
        if (k2 != null) {
            iVar.a(k2);
        } else {
            iVar.a(new IllegalStateException("Failed task has null exception"));
        }
    }
}
