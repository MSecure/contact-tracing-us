package f.b.a.a.a.n;

import f.b.a.a.a.n.r;
import f.b.a.a.a.n.v;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class i implements f.b.b.f.a.i {
    public final /* synthetic */ t a;
    public final /* synthetic */ u b;

    public /* synthetic */ i(t tVar, u uVar) {
        this.a = tVar;
        this.b = uVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        t tVar = this.a;
        u uVar = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        Objects.requireNonNull(tVar);
        if (uVar.f()) {
            return b.d1(uVar);
        }
        try {
            r.b bVar = (r.b) uVar.p();
            bVar.f2191k = jSONObject.getString("revisionToken");
            return b.d1(bVar.a());
        } catch (JSONException unused) {
            throw new v.a(x.SERVER_ERROR);
        }
    }
}
