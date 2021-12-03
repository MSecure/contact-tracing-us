package f.b.a.a.a.c0;

import f.a.b.b;
import f.a.b.k;
import f.a.b.p;
import f.a.b.w.f;
import f.b.a.a.a.s.e0.a;
import org.json.JSONObject;

public class i extends f {
    public static final p<JSONObject> u = new p<>(new JSONObject(), new b.a());
    public final boolean t;

    public i(int i2, String str, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, a aVar2, boolean z) {
        super(i2, str, jSONObject, bVar, aVar);
        this.t = z;
        this.f2146l = true;
        this.m = new c(aVar2);
    }

    @Override // f.a.b.n
    public void b(Object obj) {
        p.b<T> bVar;
        JSONObject jSONObject = (JSONObject) obj;
        synchronized (this.p) {
            bVar = this.q;
        }
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }

    @Override // f.a.b.n, f.a.b.w.f
    public p<JSONObject> q(k kVar) {
        return this.t ? u : super.q(kVar);
    }
}
