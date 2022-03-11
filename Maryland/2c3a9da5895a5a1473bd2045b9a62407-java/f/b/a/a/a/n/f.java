package f.b.a.a.a.n;

import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.n.r;
import f.b.a.a.a.n.u;
import f.b.a.a.a.u.i;
import f.b.b.a.t;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class f implements p.b {
    public final /* synthetic */ s a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f2174d;

    public /* synthetic */ f(s sVar, JSONObject jSONObject, b bVar, u uVar) {
        this.a = sVar;
        this.b = jSONObject;
        this.c = bVar;
        this.f2174d = uVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        s sVar = this.a;
        JSONObject jSONObject = this.b;
        b bVar = this.c;
        u uVar = this.f2174d;
        JSONObject jSONObject2 = (JSONObject) obj;
        sVar.f2198f.b(i.d.RPC_TYPE_VERIFICATION, jSONObject.toString().length());
        String str = "Certificate obtained: " + jSONObject2;
        if (!uVar.f()) {
            u.a p = uVar.p();
            try {
                if (jSONObject2.has("certificate") && !t.a(jSONObject2.getString("certificate"))) {
                    ((r.b) p).f2188h = jSONObject2.getString("certificate");
                }
                uVar = p.a();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        bVar.a(uVar);
    }
}
