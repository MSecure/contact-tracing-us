package f.b.a.d.a;

import f.a.b.p;
import f.b.a.a.a.u.q;
import org.json.JSONObject;

public final /* synthetic */ class b implements p.b {
    public final /* synthetic */ s a;
    public final /* synthetic */ e.f.a.b b;

    public /* synthetic */ b(s sVar, e.f.a.b bVar) {
        this.a = sVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        s sVar = this.a;
        e.f.a.b bVar = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        if (sVar.f2773d.b()) {
            sVar.f2773d.a().a(jSONObject.toString().length());
        }
        ((q) sVar.f2774e).a.a("Successfully fetched remote configs.");
        bVar.a(jSONObject);
    }
}
