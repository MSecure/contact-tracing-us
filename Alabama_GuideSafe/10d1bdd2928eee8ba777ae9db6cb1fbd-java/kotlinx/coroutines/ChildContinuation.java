package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* compiled from: JobSupport.kt */
public final class ChildContinuation extends JobCancellingNode<Job> {
    public final CancellableContinuationImpl<?> child;

    public ChildContinuation(Job job, CancellableContinuationImpl<?> cancellableContinuationImpl) {
        super(job);
        this.child = cancellableContinuationImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.child;
        J j = this.job;
        if (cancellableContinuationImpl != null) {
            CancellationException cancellationException = j.getCancellationException();
            boolean z = true;
            boolean z2 = false;
            if (cancellableContinuationImpl.resumeMode == 2) {
                Continuation<T> continuation = cancellableContinuationImpl.delegate;
                if (!(continuation instanceof DispatchedContinuation)) {
                    continuation = null;
                }
                DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
                if (dispatchedContinuation != null) {
                    while (true) {
                        Object obj = dispatchedContinuation._reusableCancellableContinuation;
                        if (!Intrinsics.areEqual(obj, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                            if (obj instanceof Throwable) {
                                break;
                            } else if (DispatchedContinuation._reusableCancellableContinuation$FU.compareAndSet(dispatchedContinuation, obj, null)) {
                                z = false;
                                break;
                            }
                        } else if (DispatchedContinuation._reusableCancellableContinuation$FU.compareAndSet(dispatchedContinuation, DispatchedContinuationKt.REUSABLE_CLAIMED, cancellationException)) {
                            break;
                        }
                    }
                    z2 = z;
                }
            }
            if (!z2) {
                cancellableContinuationImpl.cancel(cancellationException);
                cancellableContinuationImpl.detachChildIfNonResuable();
                return;
            }
            return;
        }
        throw null;
    }
}
