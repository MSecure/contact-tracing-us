package f.b.a.a.a.l0;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.u.i;
import e.u.p.b;
import java.util.concurrent.Callable;

public class z implements Callable<String> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ a0 c;

    public z(a0 a0Var, i iVar, CancellationSignal cancellationSignal) {
        this.c = a0Var;
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
