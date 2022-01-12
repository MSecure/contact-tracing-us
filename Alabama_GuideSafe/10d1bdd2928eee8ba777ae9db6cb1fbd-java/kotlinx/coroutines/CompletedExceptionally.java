package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletionState.kt */
public class CompletedExceptionally {
    public static final AtomicIntegerFieldUpdater _handled$FU = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    public volatile int _handled;
    public final Throwable cause;

    public CompletedExceptionally(Throwable th, boolean z) {
        this.cause = th;
        this._handled = z ? 1 : 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + this.cause + ']';
    }

    public CompletedExceptionally(Throwable th, boolean z, int i) {
        z = (i & 2) != 0 ? false : z;
        this.cause = th;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        this._handled = i2;
    }
}
