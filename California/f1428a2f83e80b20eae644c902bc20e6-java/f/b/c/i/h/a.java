package f.b.c.i.h;

import f.b.c.i.c;
import f.b.c.i.d;
import f.b.c.i.e;
import f.b.c.i.h.e;

public final /* synthetic */ class a implements d {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // f.b.c.i.b
    public void a(Object obj, e eVar) {
        e.a aVar = e.f2974e;
        StringBuilder h2 = f.a.a.a.a.h("Couldn't find encoder for type ");
        h2.append(obj.getClass().getCanonicalName());
        throw new c(h2.toString());
    }
}
