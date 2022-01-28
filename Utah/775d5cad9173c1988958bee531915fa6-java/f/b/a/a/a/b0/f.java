package f.b.a.a.a.b0;

import f.b.a.c.i.a;
import f.b.a.c.i.h;

public final /* synthetic */ class f implements a {
    public static final /* synthetic */ f a = new f();

    @Override // f.b.a.c.i.a
    public final Object a(h hVar) {
        f.b.a.a.a.s.d0.a aVar = i1.c;
        if (hVar.o()) {
            try {
                boolean z = false;
                if (Long.parseLong(Long.toString(((Long) hVar.l()).longValue()).substring(0, 2)) >= 17) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } catch (NumberFormatException unused) {
                i1.c.c("Unable to parse version");
            }
        }
        return Boolean.FALSE;
    }
}
