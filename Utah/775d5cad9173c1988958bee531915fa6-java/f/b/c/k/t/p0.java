package f.b.c.k.t;

import android.database.Cursor;
import f.b.c.k.x.g;
import java.util.List;
import java.util.Set;

public final /* synthetic */ class p0 implements g {
    public final q0 a;
    public final Set b;
    public final List c;

    public p0(q0 q0Var, Set set, List list) {
        this.a = q0Var;
        this.b = set;
        this.c = list;
    }

    @Override // f.b.c.k.x.g
    public void a(Object obj) {
        q0 q0Var = this.a;
        Set set = this.b;
        List list = this.c;
        Cursor cursor = (Cursor) obj;
        int i2 = cursor.getInt(0);
        if (!set.contains(Integer.valueOf(i2))) {
            set.add(Integer.valueOf(i2));
            list.add(q0Var.k(i2, cursor.getBlob(1)));
        }
    }
}
