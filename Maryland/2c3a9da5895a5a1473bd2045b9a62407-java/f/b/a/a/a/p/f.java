package f.b.a.a.a.p;

import android.util.Log;
import f.b.a.c.i.a;
import f.b.a.c.i.h;

public final /* synthetic */ class f implements a {
    public static final /* synthetic */ f a = new f();

    @Override // f.b.a.c.i.a
    public final Object a(h hVar) {
        if (hVar.n()) {
            try {
                boolean z = false;
                if (Long.parseLong(Long.toString(((Long) hVar.k()).longValue()).substring(0, 2)) >= 17) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } catch (NumberFormatException unused) {
                Log.e("ENClientWrapper", "Unable to parse version");
            }
        }
        return Boolean.FALSE;
    }
}
