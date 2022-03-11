package f.b.a.d.a.j0;

import f.a.b.k;
import f.a.b.p;
import f.a.b.w.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends f {
    public e(int i2, String str, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar) {
        super(i2, str, null, bVar, aVar);
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
        return super.q(kVar);
    }
}
