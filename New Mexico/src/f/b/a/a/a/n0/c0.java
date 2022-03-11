package f.b.a.a.a.n0;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.v.i;
import e.v.p.b;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class c0 implements Callable<String> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ d0 c;

    public c0(d0 d0Var, i iVar, CancellationSignal cancellationSignal) {
        this.c = d0Var;
        this.a = iVar;
        this.b = cancellationSignal;
    }

    @Override // java.util.concurrent.Callable
    public String call() {
        Cursor b = b.b(this.c.a, this.a, false, this.b);
        try {
            return b.moveToFirst() ? b.getString(0) : null;
        } finally {
            b.close();
        }
    }
}
