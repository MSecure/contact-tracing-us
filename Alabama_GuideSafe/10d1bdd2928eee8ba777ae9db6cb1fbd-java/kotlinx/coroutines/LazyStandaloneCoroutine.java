package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* compiled from: Builders.common.kt */
public final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    public final Continuation<Unit> continuation;

    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.continuation = MoreExecutors.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onStart() {
        try {
            DispatchedContinuationKt.resumeCancellableWith$default(MoreExecutors.intercepted(this.continuation), Unit.INSTANCE, null, 2);
        } catch (Throwable th) {
            resumeWith(MoreExecutors.createFailure(th));
        }
    }
}
