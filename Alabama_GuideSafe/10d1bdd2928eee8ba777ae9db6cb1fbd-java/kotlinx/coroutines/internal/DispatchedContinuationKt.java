package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;

public final class DispatchedContinuationKt {
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    public static final <T> void resumeCancellableWith(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z;
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Object state = MoreExecutors.toState(obj, function1);
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            boolean z2 = DebugKt.ASSERTIONS_ENABLED;
            ThreadLocalEventLoop threadLocalEventLoop = ThreadLocalEventLoop.INSTANCE;
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException cancellationException = job.getCancellationException();
                    if (state instanceof CompletedWithCancellation) {
                        ((CompletedWithCancellation) state).onCancellation.invoke(cancellationException);
                    }
                    dispatchedContinuation.resumeWith(MoreExecutors.createFailure(cancellationException));
                    z = true;
                }
                if (!z) {
                    CoroutineContext context = dispatchedContinuation.getContext();
                    Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                    try {
                        dispatchedContinuation.continuation.resumeWith(obj);
                    } finally {
                        ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    }
                }
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } catch (Throwable th) {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                throw th;
            }
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void resumeCancellableWith$default(Continuation continuation, Object obj, Function1 function1, int i) {
        int i2 = i & 2;
        resumeCancellableWith(continuation, obj, null);
    }
}
