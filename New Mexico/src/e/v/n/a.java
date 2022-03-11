package e.v.n;

import android.os.CancellationSignal;
import f.b.b.f.a.u;
/* loaded from: classes.dex */
public final class a implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ CancellationSignal c;

    public a(u uVar, CancellationSignal cancellationSignal) {
        this.b = uVar;
        this.c = cancellationSignal;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.isCancelled()) {
            this.c.cancel();
        }
    }
}
