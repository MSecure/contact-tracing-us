package f.b.a.a.a.n0;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.v.i;
import e.v.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class i1 implements Callable<List<String>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ f1 c;

    public i1(f1 f1Var, i iVar, CancellationSignal cancellationSignal) {
        this.c = f1Var;
        this.a = iVar;
        this.b = cancellationSignal;
    }

    @Override // java.util.concurrent.Callable
    public List<String> call() {
        Cursor b = b.b(this.c.a, this.a, false, this.b);
        try {
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(b.getString(0));
            }
            return arrayList;
        } finally {
            b.close();
        }
    }
}
