package e.t.n;

import android.os.CancellationSignal;
import f.b.b.f.a.u;

public final class a implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ CancellationSignal c;

    public a(u uVar, CancellationSignal cancellationSignal) {
        this.b = uVar;
        this.c = cancellationSignal;
    }

    public void run() {
        if (this.b.isCancelled()) {
            this.c.cancel();
        }
    }
}
