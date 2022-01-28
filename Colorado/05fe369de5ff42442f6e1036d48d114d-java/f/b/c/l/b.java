package f.b.c.l;

import android.content.Context;
import f.b.c.l.c;

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
        boolean a2;
        long currentTimeMillis = System.currentTimeMillis();
        boolean a3 = this.a.a(str, currentTimeMillis);
        d dVar = this.a;
        synchronized (dVar) {
            a2 = dVar.a("fire-global", currentTimeMillis);
        }
        if (a3 && a2) {
            return c.a.COMBINED;
        }
        if (a2) {
            return c.a.GLOBAL;
        }
        return a3 ? c.a.SDK : c.a.NONE;
    }
}
