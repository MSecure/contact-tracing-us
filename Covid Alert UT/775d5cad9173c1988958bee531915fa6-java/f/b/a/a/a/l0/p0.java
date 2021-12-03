package f.b.a.a.a.l0;

import android.database.Cursor;
import e.b.a.m;
import e.u.i;
import e.u.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l.b.a.e;

public class p0 implements Callable<List<q0>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ o0 b;

    public p0(o0 o0Var, i iVar) {
        this.b = o0Var;
        this.a = iVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<q0> call() {
        Cursor b2 = b.b(this.b.a, this.a, false, null);
        try {
            int g0 = m.e.g0(b2, "checkTime");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(new m(e.z(b2.getLong(g0))));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() {
        this.a.Q();
    }
}
