package b.s.o;

import android.os.CancellationSignal;
import c.b.b.e.a.u;

public final class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f2543b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CancellationSignal f2544c;

    public a(u uVar, CancellationSignal cancellationSignal) {
        this.f2543b = uVar;
        this.f2544c = cancellationSignal;
    }

    public void run() {
        if (this.f2543b.isCancelled()) {
            this.f2544c.cancel();
        }
    }
}
