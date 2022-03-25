package f.b.a.a.a.n;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.n.r;
import f.b.a.a.a.n.u;
import f.b.a.a.a.u.i;
import f.b.b.a.t;
import l.b.a.e;
import l.b.a.u.c;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class d implements p.b {
    public final /* synthetic */ s a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f2173d;

    public /* synthetic */ d(s sVar, JSONObject jSONObject, b bVar, u uVar) {
        this.a = sVar;
        this.b = jSONObject;
        this.c = bVar;
        this.f2173d = uVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        s sVar = this.a;
        JSONObject jSONObject = this.b;
        b bVar = this.c;
        u uVar = this.f2173d;
        JSONObject jSONObject2 = (JSONObject) obj;
        sVar.f2198f.b(i.d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        String str = "Verification code submission succeeded: " + jSONObject2;
        if (!uVar.f()) {
            u.a p = uVar.p();
            try {
                if (jSONObject2.has("testtype") && !t.a(jSONObject2.getString("testtype"))) {
                    ((r.b) p).f2186f = jSONObject2.getString("testtype");
                }
                if (jSONObject2.has("token") && !t.a(jSONObject2.getString("token"))) {
                    ((r.b) p).f2185e = jSONObject2.getString("token");
                }
                if (jSONObject2.has("symptomDate") && !t.a(jSONObject2.getString("symptomDate"))) {
                    String string = jSONObject2.getString("symptomDate");
                    e eVar = e.f4137e;
                    ((r.b) p).f2189i = e.T(string, c.f4216h);
                }
                uVar = p.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(uVar);
    }
}
