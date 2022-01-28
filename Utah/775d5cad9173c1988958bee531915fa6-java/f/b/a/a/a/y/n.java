package f.b.a.a.a.y;

import e.b.a.m;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class n implements i {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ e0 b;

    public /* synthetic */ n(d0 d0Var, e0 e0Var) {
        this.a = d0Var;
        this.b = e0Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        d0 d0Var = this.a;
        e0 e0Var = this.b;
        Objects.requireNonNull(d0Var);
        return m.e.l0(new m(d0Var, (JSONObject) obj, e0Var.f()));
    }
}
