package f.b.a.a.a.o;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.o.b0;
import f.b.a.a.a.o.j0;
import f.b.a.a.a.v.d;
import f.b.b.a.t;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class e implements p.b {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j0 f2310d;

    public /* synthetic */ e(c0 c0Var, JSONObject jSONObject, b bVar, j0 j0Var) {
        this.a = c0Var;
        this.b = jSONObject;
        this.c = bVar;
        this.f2310d = j0Var;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        c0 c0Var = this.a;
        JSONObject jSONObject = this.b;
        b bVar = this.c;
        j0 j0Var = this.f2310d;
        JSONObject jSONObject2 = (JSONObject) obj;
        c0Var.f2303g.c(d.EnumC0076d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        if (!j0Var.c()) {
            j0.a h2 = j0Var.h();
            try {
                if (jSONObject2.has("expiresAt") && !t.a(jSONObject2.getString("expiresAt"))) {
                    ((b0.b) h2).f2292d = jSONObject2.getString("expiresAt");
                }
                if (jSONObject2.has("expiresAtTimestamp") && !t.a(jSONObject2.getString("expiresAtTimestamp"))) {
                    h2.b((long) Integer.parseInt(jSONObject2.getString("expiresAtTimestamp")));
                }
                j0Var = h2.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(j0Var);
    }
}
