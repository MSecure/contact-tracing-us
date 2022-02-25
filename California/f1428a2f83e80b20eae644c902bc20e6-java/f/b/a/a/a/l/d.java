package f.b.a.a.a.l;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.l.q;
import f.b.a.a.a.l.t;
import f.b.a.a.a.s.i;
import l.b.a.e;
import l.b.a.u.c;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class d implements p.b {
    public final /* synthetic */ r a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ t f2094d;

    public /* synthetic */ d(r rVar, JSONObject jSONObject, b bVar, t tVar) {
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
        rVar.f2119f.b(i.d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        String str = "Verification code submission succeeded: " + jSONObject2;
        if (!tVar.f()) {
            t.a p = tVar.p();
            try {
                if (jSONObject2.has("testtype") && !f.b.a.c.b.o.b.i1(jSONObject2.getString("testtype"))) {
                    ((q.b) p).f2107f = jSONObject2.getString("testtype");
                }
                if (jSONObject2.has("token") && !f.b.a.c.b.o.b.i1(jSONObject2.getString("token"))) {
                    ((q.b) p).f2106e = jSONObject2.getString("token");
                }
                if (jSONObject2.has("symptomDate") && !f.b.a.c.b.o.b.i1(jSONObject2.getString("symptomDate"))) {
                    String string = jSONObject2.getString("symptomDate");
                    e eVar = e.f4033e;
                    ((q.b) p).f2110i = e.T(string, c.f4112h);
                }
                tVar = p.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(tVar);
    }
}
