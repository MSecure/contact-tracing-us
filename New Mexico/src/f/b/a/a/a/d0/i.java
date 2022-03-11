package f.b.a.a.a.d0;

import f.a.b.b;
import f.a.b.k;
import f.a.b.p;
import f.a.b.w.f;
import f.b.a.a.a.t.q0.a;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends f {
    public static final p<JSONObject> u = new p<>(new JSONObject(), new b.a());
    public final boolean t;

    public i(int i2, String str, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, a aVar2, boolean z) {
        super(i2, str, jSONObject, bVar, aVar);
        this.t = z;
        this.f2173l = true;
        this.m = new c(aVar2);
    }

    @Override // f.a.b.n
    public void b(Object obj) {
        p.b<T> bVar;
        JSONObject jSONObject = (JSONObject) obj;
        synchronized (this.p) {
            bVar = this.q;
        }
        if (bVar != 0) {
            bVar.a(jSONObject);
        }
    }

    @Override // f.a.b.w.f, f.a.b.n
    public p<JSONObject> q(k kVar) {
        return this.t ? u : super.q(kVar);
    }
}
