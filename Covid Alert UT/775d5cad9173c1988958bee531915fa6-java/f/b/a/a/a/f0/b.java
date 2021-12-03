package f.b.a.a.a.f0;

import f.a.b.p;
import org.json.JSONObject;

public final /* synthetic */ class b implements p.b {
    public final /* synthetic */ n a;
    public final /* synthetic */ e.f.a.b b;

    public /* synthetic */ b(n nVar, e.f.a.b bVar) {
        this.a = nVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        n nVar = this.a;
        e.f.a.b bVar = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        if (nVar.c.b()) {
            nVar.c.a().a(jSONObject.toString().length());
        }
        n.f2219e.a("Successfully fetched remote configs.");
        bVar.a(jSONObject);
    }
}
