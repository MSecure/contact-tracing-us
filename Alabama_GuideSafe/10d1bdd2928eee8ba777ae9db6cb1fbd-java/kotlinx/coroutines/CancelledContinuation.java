package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;

/* compiled from: CompletionState.kt */
public final class CancelledContinuation extends CompletedExceptionally {
    public static final AtomicIntegerFieldUpdater _resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");
    public volatile int _resumed;

    /* JADX WARNING: Illegal instructions before constructor call */
    public CancelledContinuation(Continuation<?> continuation, Throwable th, boolean z) {
        super(th, z);
        if (th == null) {
            th = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        this._resumed = 0;
    }
}
