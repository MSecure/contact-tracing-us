package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: Builders.common.kt */
public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {
    public static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    public volatile int _decision = 0;

    public DispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.internal.ScopeCoroutine
    public void afterCompletion(Object obj) {
        afterResume(obj);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.internal.ScopeCoroutine
    public void afterResume(Object obj) {
        boolean z;
        while (true) {
            int i = this._decision;
            z = false;
            if (i == 0) {
                if (_decision$FU.compareAndSet(this, 0, 2)) {
                    z = true;
                    break;
                }
            } else if (i != 1) {
                throw new IllegalStateException("Already resumed".toString());
            }
        }
        if (!z) {
            DispatchedContinuationKt.resumeCancellableWith$default(MoreExecutors.intercepted(this.uCont), MoreExecutors.recoverResult(obj, this.uCont), null, 2);
        }
    }
}
