package f.b.a.a.a.y;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.g0.d;
import f.b.a.a.a.y.b0;
import f.b.a.a.a.y.i0;
import f.b.b.a.t;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class e implements p.b {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i0 f2502d;

    public /* synthetic */ e(c0 c0Var, JSONObject jSONObject, b bVar, i0 i0Var) {
        this.a = c0Var;
        this.b = jSONObject;
        this.c = bVar;
        this.f2502d = i0Var;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        c0 c0Var = this.a;
        JSONObject jSONObject = this.b;
        b bVar = this.c;
        i0 i0Var = this.f2502d;
        JSONObject jSONObject2 = (JSONObject) obj;
        c0Var.f2495g.c(d.EnumC0074d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        if (!i0Var.c()) {
            i0.a h2 = i0Var.h();
            try {
                if (jSONObject2.has("expiresAt") && !t.a(jSONObject2.getString("expiresAt"))) {
                    ((b0.b) h2).f2484d = jSONObject2.getString("expiresAt");
                }
                if (jSONObject2.has("expiresAtTimestamp") && !t.a(jSONObject2.getString("expiresAtTimestamp"))) {
                    h2.b((long) Integer.parseInt(jSONObject2.getString("expiresAtTimestamp")));
                }
                i0Var = h2.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(i0Var);
    }
}
