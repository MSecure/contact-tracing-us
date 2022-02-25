package f.b.a.a.a.r;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.s.i;
import org.json.JSONObject;

public final /* synthetic */ class c implements p.b {
    public final /* synthetic */ z a;
    public final /* synthetic */ b b;

    public /* synthetic */ c(z zVar, b bVar) {
        this.a = zVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        z zVar = this.a;
        b bVar = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        zVar.f2242e.b(i.d.RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH, jSONObject.toString().length());
        bVar.a(jSONObject);
    }
}
