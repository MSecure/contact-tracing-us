package f.b.a.a.a.c0;

import f.b.a.c.i.a;
import f.b.a.c.i.h;
/* loaded from: classes.dex */
public final /* synthetic */ class i implements a {
    public static final /* synthetic */ i a = new i();

    @Override // f.b.a.c.i.a
    public final Object a(h hVar) {
        f.b.a.a.a.t.p0.a aVar = q1.c;
        if (hVar.o()) {
            try {
                boolean z = false;
                if (Long.parseLong(Long.toString(((Long) hVar.l()).longValue()).substring(0, 2)) >= 17) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } catch (NumberFormatException unused) {
                q1.c.c("Unable to parse version");
            }
        }
        return Boolean.FALSE;
    }
}
