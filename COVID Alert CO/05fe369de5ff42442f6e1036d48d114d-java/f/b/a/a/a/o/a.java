package f.b.a.a.a.o;

import android.text.TextUtils;
import e.b.a.m;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.o.c0;
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
        JSONObject put = new JSONObject().put("code", e0Var.r()).put("accept", c0.f2299k);
        if (!TextUtils.isEmpty(e0Var.k())) {
            put.put("nonce", e0Var.k());
        }
        m.h.a(put);
        f.b.a.a.a.i.e0.a aVar = c0.f2296h;
        aVar.a("Submitting verification code: " + put);
        c0.a aVar2 = new c0.a(c0Var.f2301e, c0Var.a, put, new b(c0Var, put, bVar, e0Var), new f(c0Var, bVar), c0Var.f2302f, e0Var.f());
        c0Var.f2300d.a(aVar2);
        return aVar2;
    }
}
