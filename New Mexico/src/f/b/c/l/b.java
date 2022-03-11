package f.b.c.l;

import android.content.Context;
import f.b.c.l.c;
/* loaded from: classes.dex */
public class b implements c {
    public d a;

    public b(Context context) {
        d dVar;
        synchronized (d.class) {
            if (d.b == null) {
                d.b = new d(context);
            }
            dVar = d.b;
        }
        this.a = dVar;
    }

    @Override // f.b.c.l.c
    public c.a a(String str) {
        boolean a;
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = this.a.a(str, currentTimeMillis);
        d dVar = this.a;
        synchronized (dVar) {
            a = dVar.a("fire-global", currentTimeMillis);
        }
        if (a2 && a) {
            return c.a.COMBINED;
        }
        if (a) {
            return c.a.GLOBAL;
        }
        return a2 ? c.a.SDK : c.a.NONE;
    }
}
