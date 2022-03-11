package f.b.c.n;

import f.b.c.f.e;
import f.b.c.f.f;
import f.b.c.f.v;
import java.util.Set;
/* loaded from: classes.dex */
public final /* synthetic */ class b implements f {
    public static final b a = new b();

    @Override // f.b.c.f.f
    public Object a(e eVar) {
        Set c = ((v) eVar).c(e.class);
        d dVar = d.b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = d.b;
                if (dVar == null) {
                    dVar = new d();
                    d.b = dVar;
                }
            }
        }
        return new c(c, dVar);
    }
}
