package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContinuationImpl.kt */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    public final CoroutineContext _context;
    public transient Continuation<Object> intercepted;

    public ContinuationImpl(Continuation<Object> continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        Intrinsics.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        Continuation<?> continuation = this.intercepted;
        if (!(continuation == null || continuation == this)) {
            CoroutineContext coroutineContext = this._context;
            Intrinsics.checkNotNull(coroutineContext);
            CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
            Intrinsics.checkNotNull(element);
            ((ContinuationInterceptor) element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = CompletedContinuation.INSTANCE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContinuationImpl(Continuation<Object> continuation) {
        super(continuation);
        CoroutineContext context = continuation != null ? continuation.getContext() : null;
        this._context = context;
    }
}
