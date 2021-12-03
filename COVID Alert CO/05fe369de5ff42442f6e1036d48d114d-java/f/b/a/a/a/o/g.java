package f.b.a.a.a.o;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.o.a0;
import f.b.a.a.a.o.e0;
import f.b.a.a.a.v.d;
import f.b.b.a.t;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class g implements p.b {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e0 f2312d;

    public /* synthetic */ g(c0 c0Var, JSONObject jSONObject, b bVar, e0 e0Var) {
        this.a = c0Var;
        this.b = jSONObject;
        this.c = bVar;
        this.f2312d = e0Var;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        c0 c0Var = this.a;
        JSONObject jSONObject = this.b;
        b bVar = this.c;
        e0 e0Var = this.f2312d;
        JSONObject jSONObject2 = (JSONObject) obj;
        c0Var.f2303g.c(d.EnumC0076d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        a aVar = c0.f2296h;
        aVar.a("Certificate obtained: " + jSONObject2);
        if (!e0Var.f()) {
            e0.a q = e0Var.q();
            try {
                if (jSONObject2.has("certificate") && !t.a(jSONObject2.getString("certificate"))) {
                    ((a0.b) q).f2282h = jSONObject2.getString("certificate");
                }
                e0Var = q.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(e0Var);
    }
}
