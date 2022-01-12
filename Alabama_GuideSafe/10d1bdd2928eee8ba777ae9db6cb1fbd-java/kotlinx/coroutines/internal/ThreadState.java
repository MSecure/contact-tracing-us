package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContext.kt */
public final class ThreadState {
    public Object[] a;
    public final CoroutineContext context;
    public int i;

    public ThreadState(CoroutineContext coroutineContext, int i2) {
        this.context = coroutineContext;
        this.a = new Object[i2];
    }
}
