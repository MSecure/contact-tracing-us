package f.b.a.a.a.l;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.l.q;
import f.b.a.a.a.l.t;
import f.b.a.a.a.s.i;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class f implements p.b {
    public final /* synthetic */ r a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ t f2094d;

    public /* synthetic */ f(r rVar, JSONObject jSONObject, b bVar, t tVar) {
        this.a = rVar;
        this.b = jSONObject;
        this.c = bVar;
        this.f2094d = tVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        r rVar = this.a;
        JSONObject jSONObject = this.b;
        b bVar = this.c;
        t tVar = this.f2094d;
        JSONObject jSONObject2 = (JSONObject) obj;
        rVar.f2118f.b(i.d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        String str = "Certificate obtained: " + jSONObject2;
        if (!tVar.f()) {
            t.a p = tVar.p();
            try {
                if (jSONObject2.has("certificate") && !f.b.a.c.b.o.b.i1(jSONObject2.getString("certificate"))) {
                    ((q.b) p).f2108h = jSONObject2.getString("certificate");
                }
                tVar = p.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(tVar);
    }
}
