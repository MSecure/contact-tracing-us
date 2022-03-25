package f.b.a.a.a.n;

import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.n.t;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class j implements d {
    public final /* synthetic */ t a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ j(t tVar, JSONObject jSONObject, boolean z) {
        this.a = tVar;
        this.b = jSONObject;
        this.c = z;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        t tVar = this.a;
        JSONObject jSONObject = this.b;
        boolean z = this.c;
        Objects.requireNonNull(tVar);
        g gVar = new g(tVar, jSONObject, bVar);
        h hVar = new h(tVar, bVar);
        String str = "Submitting " + jSONObject;
        t.a aVar = new t.a(tVar.b, jSONObject, gVar, hVar, tVar.f2202f, z);
        tVar.c.a(aVar);
        return aVar;
    }
}
