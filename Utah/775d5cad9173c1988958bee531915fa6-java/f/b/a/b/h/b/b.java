package f.b.a.b.h.b;

import f.b.c.i.d;
import f.b.c.i.e;

public final class b implements d<a> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // f.b.c.i.b
    public void a(Object obj, e eVar) {
        a aVar = (a) obj;
        e eVar2 = eVar;
        eVar2.c("sdkVersion", aVar.h());
        eVar2.c("model", aVar.e());
        eVar2.c("hardware", aVar.c());
        eVar2.c("device", aVar.a());
        eVar2.c("product", aVar.g());
        eVar2.c("osBuild", aVar.f());
        eVar2.c("manufacturer", aVar.d());
        eVar2.c("fingerprint", aVar.b());
    }
}
