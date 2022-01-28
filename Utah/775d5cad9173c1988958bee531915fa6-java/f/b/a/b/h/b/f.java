package f.b.a.b.h.b;

import f.b.c.i.d;
import f.b.c.i.e;

public final class f implements d<r> {
    public static final f a = new f();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // f.b.c.i.b
    public void a(Object obj, e eVar) {
        r rVar = (r) obj;
        e eVar2 = eVar;
        eVar2.d("requestTimeMs", rVar.f());
        eVar2.d("requestUptimeMs", rVar.g());
        eVar2.c("clientInfo", rVar.a());
        eVar2.c("logSource", rVar.c());
        eVar2.c("logSourceName", rVar.d());
        eVar2.c("logEvent", rVar.b());
        eVar2.c("qosTier", rVar.e());
    }
}
