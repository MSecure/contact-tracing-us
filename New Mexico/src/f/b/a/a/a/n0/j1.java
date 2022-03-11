package f.b.a.a.a.n0;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.b.a.m;
import e.v.i;
import e.v.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l.b.a.e;
/* loaded from: classes.dex */
public class j1 implements Callable<List<k1>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ f1 c;

    public j1(f1 f1Var, i iVar, CancellationSignal cancellationSignal) {
        this.c = f1Var;
        this.a = iVar;
        this.b = cancellationSignal;
    }

    @Override // java.util.concurrent.Callable
    public List<k1> call() {
        Cursor b = b.b(this.c.a, this.a, false, this.b);
        try {
            int h0 = m.e.h0(b, "id");
            int h02 = m.e.h0(b, "requestTime");
            int h03 = m.e.h0(b, "expiresAtTime");
            int h04 = m.e.h0(b, "nonce");
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                b.getLong(h0);
                arrayList.add(k1.a(e.z(b.getLong(h02)), e.z(b.getLong(h03)), b.getString(h04)));
            }
            return arrayList;
        } finally {
            b.close();
        }
    }
}
