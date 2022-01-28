package f.b.a.a.a.y;

import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.y.d0;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class m implements d {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ m(d0 d0Var, JSONObject jSONObject, boolean z) {
        this.a = d0Var;
        this.b = jSONObject;
        this.c = z;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        d0 d0Var = this.a;
        JSONObject jSONObject = this.b;
        boolean z = this.c;
        Objects.requireNonNull(d0Var);
        j jVar = new j(d0Var, jSONObject, bVar);
        k kVar = new k(d0Var, bVar);
        a aVar = d0.f2496h;
        aVar.a("Submitting " + jSONObject);
        d0.a aVar2 = new d0.a(d0Var.b, jSONObject, jVar, kVar, d0Var.f2500f, z);
        d0Var.c.a(aVar2);
        return aVar2;
    }
}
