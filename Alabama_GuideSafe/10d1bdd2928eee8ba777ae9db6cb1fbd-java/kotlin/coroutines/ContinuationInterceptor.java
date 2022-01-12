package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationInterceptor.kt */
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: ContinuationInterceptor.kt */
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
