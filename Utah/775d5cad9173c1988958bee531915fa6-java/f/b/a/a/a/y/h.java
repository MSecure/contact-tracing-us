package f.b.a.a.a.y;

import e.b.a.m;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.y.c0;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class h implements d {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ i0 b;

    public /* synthetic */ h(c0 c0Var, i0 i0Var) {
        this.a = c0Var;
        this.b = i0Var;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        c0 c0Var = this.a;
        i0 i0Var = this.b;
        Objects.requireNonNull(c0Var);
        JSONObject put = new JSONObject().put("testDate", i0Var.g()).put("tzOffset", i0Var.i()).put("phone", i0Var.f()).put("nonce", i0Var.e());
        m.e.a(put);
        c0.a aVar = new c0.a(c0Var.f2493e, c0Var.c, put, new e(c0Var, put, bVar, i0Var), new d(c0Var, bVar), c0Var.f2494f, i0Var.c());
        c0Var.f2492d.a(aVar);
        return aVar;
    }
}
