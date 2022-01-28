package f.b.a.a.a.l0;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.b.a.m;
import e.u.i;
import e.u.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l.b.a.e;

public class d1 implements Callable<List<e1>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ a1 c;

    public d1(a1 a1Var, i iVar, CancellationSignal cancellationSignal) {
        this.c = a1Var;
        this.a = iVar;
        this.b = cancellationSignal;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<e1> call() {
        Cursor b2 = b.b(this.c.a, this.a, false, this.b);
        try {
            int g0 = m.e.g0(b2, "id");
            int g02 = m.e.g0(b2, "requestTime");
            int g03 = m.e.g0(b2, "expiresAtTime");
            int g04 = m.e.g0(b2, "nonce");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                b2.getLong(g0);
                arrayList.add(e1.a(e.z(b2.getLong(g02)), e.z(b2.getLong(g03)), b2.getString(g04)));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }
}
