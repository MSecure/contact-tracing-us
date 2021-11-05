package b.r.o;

import android.os.CancellationSignal;
import c.b.b.e.a.u;

public final class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f1673b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CancellationSignal f1674c;

    public a(u uVar, CancellationSignal cancellationSignal) {
        this.f1673b = uVar;
        this.f1674c = cancellationSignal;
    }

    public void run() {
        if (this.f1673b.isCancelled()) {
            this.f1674c.cancel();
        }
    }
}
