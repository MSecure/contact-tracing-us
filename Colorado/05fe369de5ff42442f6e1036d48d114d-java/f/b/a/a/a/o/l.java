package f.b.a.a.a.o;

import f.b.a.a.a.o.a0;
import f.b.a.a.a.o.f0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class l implements i {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ e0 b;

    public /* synthetic */ l(d0 d0Var, e0 e0Var) {
        this.a = d0Var;
        this.b = e0Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        d0 d0Var = this.a;
        e0 e0Var = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        Objects.requireNonNull(d0Var);
        if (e0Var.f()) {
            return b.O0(e0Var);
        }
        try {
            a0.b bVar = (a0.b) e0Var.q();
            bVar.f2285k = jSONObject.getString("revisionToken");
            return b.O0(bVar.a());
        } catch (JSONException unused) {
            throw new f0.a(h0.SERVER_ERROR);
        }
    }
}
