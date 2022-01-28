package f.b.a.a.a.l0;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.u.i;
import e.u.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class c1 implements Callable<List<String>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ a1 c;

    public c1(a1 a1Var, i iVar, CancellationSignal cancellationSignal) {
        this.c = a1Var;
        this.a = iVar;
        this.b = cancellationSignal;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<String> call() {
        Cursor b2 = b.b(this.c.a, this.a, false, this.b);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }
}
