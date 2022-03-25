package f.b.a.a.a.y;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.t.i;
import e.t.p.b;
import java.util.concurrent.Callable;

public class b0 implements Callable<String> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ v c;

    public b0(v vVar, i iVar, CancellationSignal cancellationSignal) {
        this.c = vVar;
        this.a = iVar;
        this.b = cancellationSignal;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public String call() {
        Cursor b2 = b.b(this.c.a, this.a, false, this.b);
        try {
            return b2.moveToFirst() ? b2.getString(0) : null;
        } finally {
            b2.close();
        }
    }
}
