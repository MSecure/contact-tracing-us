package f.b.a.a.a.n0;

import android.database.Cursor;
import e.b.a.m;
import e.v.i;
import e.v.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l.b.a.e;
/* loaded from: classes.dex */
public class t0 implements Callable<List<u0>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ r0 b;

    public t0(r0 r0Var, i iVar) {
        this.b = r0Var;
        this.a = iVar;
    }

    @Override // java.util.concurrent.Callable
    public List<u0> call() {
        Cursor b = b.b(this.b.a, this.a, false, null);
        try {
            int h0 = m.e.h0(b, "checkTime");
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(new m(e.z(b.getLong(h0))));
            }
            return arrayList;
        } finally {
            b.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() {
        this.a.Q();
    }
}
