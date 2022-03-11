package f.b.c.k.t;

import android.database.Cursor;
import f.b.c.k.u.i;
import f.b.c.k.x.g;
import java.util.Map;

public final /* synthetic */ class t0 implements g {
    public final u0 a;
    public final Map b;

    public t0(u0 u0Var, Map map) {
        this.a = u0Var;
        this.b = map;
    }

    @Override // f.b.c.k.x.g
    public void a(Object obj) {
        u0 u0Var = this.a;
        Map map = this.b;
        i e2 = u0Var.e(((Cursor) obj).getBlob(0));
        map.put(e2.a, e2);
    }
}
