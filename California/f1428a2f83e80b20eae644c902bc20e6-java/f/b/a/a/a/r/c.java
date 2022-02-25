package f.b.a.a.a.r;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.s.i;
import org.json.JSONObject;

public final /* synthetic */ class c implements p.b {
    public final /* synthetic */ x a;
    public final /* synthetic */ b b;

    public /* synthetic */ c(x xVar, b bVar) {
        this.a = xVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        x xVar = this.a;
        b bVar = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        xVar.f2235e.b(i.d.RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH, jSONObject.toString().length());
        bVar.a(jSONObject);
    }
}
