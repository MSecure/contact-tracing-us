package f.b.a.a.a.n;

import e.b.a.m;
import e.f.a.d;
import f.b.a.a.a.n.s;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class b implements d {
    public final /* synthetic */ s a;
    public final /* synthetic */ u b;

    public /* synthetic */ b(s sVar, u uVar) {
        this.a = sVar;
        this.b = uVar;
    }

    @Override // e.f.a.d
    public final Object a(e.f.a.b bVar) {
        s sVar = this.a;
        u uVar = this.b;
        Objects.requireNonNull(sVar);
        JSONObject put = new JSONObject().put("code", uVar.q()).put("accept", s.f2195i);
        m.h.a(put);
        String str = "Submitting verification code: " + put;
        s.a aVar = new s.a(sVar.f2196d, sVar.a, put, new d(sVar, put, bVar, uVar), new e(sVar, bVar), sVar.f2197e, uVar.f());
        sVar.c.a(aVar);
        return aVar;
    }
}
