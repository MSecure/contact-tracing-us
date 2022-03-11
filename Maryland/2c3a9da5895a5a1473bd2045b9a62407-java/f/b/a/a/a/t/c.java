package f.b.a.a.a.t;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.u.i;
import org.json.JSONObject;

public final /* synthetic */ class c implements p.b {
    public final /* synthetic */ y a;
    public final /* synthetic */ b b;

    public /* synthetic */ c(y yVar, b bVar) {
        this.a = yVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        y yVar = this.a;
        b bVar = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        yVar.f2319e.b(i.d.RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH, jSONObject.toString().length());
        bVar.a(jSONObject);
    }
}
