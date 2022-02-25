package f.b.a.a.a.l;

import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.l.s;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class j implements d {
    public final /* synthetic */ s a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ j(s sVar, JSONObject jSONObject, boolean z) {
        this.a = sVar;
        this.b = jSONObject;
        this.c = z;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        s sVar = this.a;
        JSONObject jSONObject = this.b;
        boolean z = this.c;
        Objects.requireNonNull(sVar);
        g gVar = new g(sVar, jSONObject, bVar);
        h hVar = new h(sVar, bVar);
        String str = "Submitting " + jSONObject;
        s.a aVar = new s.a(sVar.b, jSONObject, gVar, hVar, sVar.f2123f, z);
        sVar.c.a(aVar);
        return aVar;
    }
}
