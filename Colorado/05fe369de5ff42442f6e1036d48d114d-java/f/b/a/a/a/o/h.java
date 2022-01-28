package f.b.a.a.a.o;

import e.b.a.m;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.o.c0;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class h implements d {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ j0 b;

    public /* synthetic */ h(c0 c0Var, j0 j0Var) {
        this.a = c0Var;
        this.b = j0Var;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        c0 c0Var = this.a;
        j0 j0Var = this.b;
        Objects.requireNonNull(c0Var);
        JSONObject put = new JSONObject().put("testDate", j0Var.g()).put("tzOffset", j0Var.i()).put("phone", j0Var.f()).put("nonce", j0Var.e());
        m.h.a(put);
        c0.a aVar = new c0.a(c0Var.f2301e, c0Var.c, put, new e(c0Var, put, bVar, j0Var), new d(c0Var, bVar), c0Var.f2302f, j0Var.c());
        c0Var.f2300d.a(aVar);
        return aVar;
    }
}
