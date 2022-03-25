package f.b.a.a.a.y;

import android.database.Cursor;
import e.b.a.m;
import e.t.i;
import e.t.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l.b.a.d;

public class k0 implements Callable<List<l0>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ j0 b;

    public k0(j0 j0Var, i iVar) {
        this.b = j0Var;
        this.a = iVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<l0> call() {
        Cursor b2 = b.b(this.b.a, this.a, false, null);
        try {
            int b0 = m.h.b0(b2, "checkTime");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(new l(d.y(b2.getLong(b0))));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() {
        this.a.V();
    }
}
