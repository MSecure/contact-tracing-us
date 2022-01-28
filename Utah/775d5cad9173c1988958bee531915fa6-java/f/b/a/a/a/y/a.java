package f.b.a.a.a.y;

import android.text.TextUtils;
import e.b.a.m;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.y.c0;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class a implements d {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ e0 b;

    public /* synthetic */ a(c0 c0Var, e0 e0Var) {
        this.a = c0Var;
        this.b = e0Var;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        c0 c0Var = this.a;
        e0 e0Var = this.b;
        Objects.requireNonNull(c0Var);
        JSONObject put = new JSONObject().put("code", e0Var.r()).put("accept", c0.f2491k);
        if (!TextUtils.isEmpty(e0Var.k())) {
            put.put("nonce", e0Var.k());
        }
        m.e.a(put);
        f.b.a.a.a.s.d0.a aVar = c0.f2488h;
        aVar.a("Submitting verification code: " + put);
        c0.a aVar2 = new c0.a(c0Var.f2493e, c0Var.a, put, new b(c0Var, put, bVar, e0Var), new f(c0Var, bVar), c0Var.f2494f, e0Var.f());
        c0Var.f2492d.a(aVar2);
        return aVar2;
    }
}
