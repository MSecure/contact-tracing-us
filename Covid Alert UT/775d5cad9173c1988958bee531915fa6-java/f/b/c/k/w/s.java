package f.b.c.k.w;

import f.b.a.c.b.o.b;
import f.b.a.c.i.h;
import h.a.f;
import h.a.x;

public class s extends x<ReqT, RespT> {
    public final /* synthetic */ f[] a;
    public final /* synthetic */ h b;
    public final /* synthetic */ t c;

    public s(t tVar, f[] fVarArr, h hVar) {
        this.c = tVar;
        this.a = fVarArr;
        this.b = hVar;
    }

    @Override // h.a.f
    public void a() {
        if (this.a[0] == null) {
            this.b.g(this.c.a.a, r.a);
        } else {
            e().a();
        }
    }

    @Override // h.a.v0
    public f<ReqT, RespT> e() {
        b.O0(this.a[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
        return this.a[0];
    }
}
