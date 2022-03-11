package f.b.a.a.a.n;

import e.b.a.m;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class k implements i {
    public final /* synthetic */ t a;
    public final /* synthetic */ u b;

    public /* synthetic */ k(t tVar, u uVar) {
        this.a = tVar;
        this.b = uVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        t tVar = this.a;
        u uVar = this.b;
        Objects.requireNonNull(tVar);
        return m.h.f0(new j(tVar, (JSONObject) obj, uVar.f()));
    }
}
