package f.b.a.a.a.o;

import f.a.b.p;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.o.a0;
import f.b.a.a.a.o.e0;
import f.b.a.a.a.v.d;
import f.b.b.a.t;
import l.b.a.f;
import l.b.a.v.c;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class b implements p.b {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ e.f.a.b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e0 f2287d;

    public /* synthetic */ b(c0 c0Var, JSONObject jSONObject, e.f.a.b bVar, e0 e0Var) {
        this.a = c0Var;
        this.b = jSONObject;
        this.c = bVar;
        this.f2287d = e0Var;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        c0 c0Var = this.a;
        JSONObject jSONObject = this.b;
        e.f.a.b bVar = this.c;
        e0 e0Var = this.f2287d;
        JSONObject jSONObject2 = (JSONObject) obj;
        c0Var.f2303g.c(d.EnumC0076d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        a aVar = c0.f2296h;
        aVar.a("Verification code submission succeeded: " + jSONObject2);
        if (!e0Var.f()) {
            e0.a q = e0Var.q();
            try {
                if (jSONObject2.has("testtype") && !t.a(jSONObject2.getString("testtype"))) {
                    ((a0.b) q).f2280f = jSONObject2.getString("testtype");
                }
                if (jSONObject2.has("token") && !t.a(jSONObject2.getString("token"))) {
                    ((a0.b) q).f2279e = jSONObject2.getString("token");
                }
                if (jSONObject2.has("symptomDate") && !t.a(jSONObject2.getString("symptomDate"))) {
                    String string = jSONObject2.getString("symptomDate");
                    f fVar = f.f4292e;
                    ((a0.b) q).f2283i = f.T(string, c.f4371h);
                }
                e0Var = q.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(e0Var);
    }
}
