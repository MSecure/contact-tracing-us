package f.b.a.a.a.l;

import e.b.a.m;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class k implements i {
    public final /* synthetic */ s a;
    public final /* synthetic */ t b;

    public /* synthetic */ k(s sVar, t tVar) {
        this.a = sVar;
        this.b = tVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        s sVar = this.a;
        t tVar = this.b;
        Objects.requireNonNull(sVar);
        return m.h.f0(new j(sVar, (JSONObject) obj, tVar.f()));
    }
}
