package f.b.a.c.e.c;

import f.b.a.c.i.d;
import f.b.a.c.i.h;
import f.b.a.c.i.i;

public final /* synthetic */ class h2 implements d {
    public final i a;

    public h2(i iVar) {
        this.a = iVar;
    }

    @Override // f.b.a.c.i.d
    public final void a(h hVar) {
        i iVar = this.a;
        if (hVar.n()) {
            iVar.b(hVar.k());
            return;
        }
        Exception j2 = hVar.j();
        if (j2 != null) {
            iVar.a(j2);
        } else {
            iVar.a(new IllegalStateException("Failed task has null exception"));
        }
    }
}
