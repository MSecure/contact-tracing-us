package f.b.a.a.a.l;

import e.b.a.m;
import e.f.a.d;
import f.b.a.a.a.l.r;
import java.util.Objects;
import org.json.JSONObject;

public final /* synthetic */ class b implements d {
    public final /* synthetic */ r a;
    public final /* synthetic */ t b;

    public /* synthetic */ b(r rVar, t tVar) {
        this.a = rVar;
        this.b = tVar;
    }

    @Override // e.f.a.d
    public final Object a(e.f.a.b bVar) {
        r rVar = this.a;
        t tVar = this.b;
        Objects.requireNonNull(rVar);
        JSONObject put = new JSONObject().put("code", tVar.q()).put("accept", r.f2115i);
        m.h.a(put);
        String str = "Submitting verification code: " + put;
        r.a aVar = new r.a(rVar.f2116d, rVar.a, put, new d(rVar, put, bVar, tVar), new e(rVar, bVar), rVar.f2117e, tVar.f());
        rVar.c.a(aVar);
        return aVar;
    }
}
