package f.b.a.a.a.q;

import e.b.a.m;
import f.a.b.b;
import f.a.b.k;
import f.a.b.p;
import f.a.b.w.f;
import f.b.a.a.a.h.s.a;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends f {
    public static final p<JSONObject> u = new p<>(new JSONObject(), new b.a());
    public final boolean t;

    public i(int i2, String str, JSONObject jSONObject, p.b<JSONObject> bVar, p.a aVar, a aVar2, boolean z) {
        super(i2, str, jSONObject, bVar, aVar);
        this.t = z;
        this.f2061l = true;
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

    @Override // f.a.b.n
    public p<JSONObject> q(k kVar) {
        p<JSONObject> pVar;
        if (this.t) {
            return u;
        }
        try {
            return new p<>(new JSONObject(new String(kVar.b, m.h.I0(kVar.c, "utf-8"))), m.h.H0(kVar));
        } catch (UnsupportedEncodingException e2) {
            pVar = new p<>(new f.a.b.m(e2));
        } catch (JSONException e3) {
            pVar = new p<>(new f.a.b.m(e3));
        }
        return pVar;
    }
}
