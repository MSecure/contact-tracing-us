package f.b.a.a.a.l;

import f.b.a.a.a.l.q;
import f.b.a.a.a.l.u;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class i implements f.b.b.f.a.i {
    public final /* synthetic */ s a;
    public final /* synthetic */ t b;

    public /* synthetic */ i(s sVar, t tVar) {
        this.a = sVar;
        this.b = tVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        s sVar = this.a;
        t tVar = this.b;
        JSONObject jSONObject = (JSONObject) obj;
        Objects.requireNonNull(sVar);
        if (tVar.f()) {
            return b.c1(tVar);
        }
        try {
            q.b bVar = (q.b) tVar.p();
            bVar.f2111k = jSONObject.getString("revisionToken");
            return b.c1(bVar.a());
        } catch (JSONException unused) {
            throw new u.a(w.SERVER_ERROR);
        }
    }
}
