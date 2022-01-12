package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* compiled from: DispatchedTask.kt */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                MoreExecutors.addSuppressed(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            Intrinsics.checkNotNull(th);
            MoreExecutors.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". " + "Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public final void run() {
        Object obj;
        Object obj2;
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (!(this.resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.taskContext;
        try {
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            if (delegate$kotlinx_coroutines_core != null) {
                DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
                Continuation<T> continuation = dispatchedContinuation.continuation;
                CoroutineContext context = continuation.getContext();
                Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                try {
                    Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                    Job job = (exceptionalResult$kotlinx_coroutines_core != null || !MoreExecutors.isCancellableMode(this.resumeMode)) ? null : (Job) context.get(Job.Key);
                    if (job != null && !job.isActive()) {
                        Throwable cancellationException = job.getCancellationException();
                        cancelCompletedResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                        if (DebugKt.RECOVER_STACK_TRACES) {
                            if (continuation instanceof CoroutineStackFrame) {
                                cancellationException = StackTraceRecoveryKt.access$recoverFromStackFrame(cancellationException, (CoroutineStackFrame) continuation);
                            }
                        }
                        continuation.resumeWith(MoreExecutors.createFailure(cancellationException));
                    } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                        continuation.resumeWith(MoreExecutors.createFailure(exceptionalResult$kotlinx_coroutines_core));
                    } else {
                        continuation.resumeWith(getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core));
                    }
                    try {
                        taskContext.afterTask();
                        obj2 = Unit.INSTANCE;
                    } catch (Throwable th) {
                        obj2 = MoreExecutors.createFailure(th);
                    }
                    handleFatalException$kotlinx_coroutines_core(null, Result.m10exceptionOrNullimpl(obj2));
                    return;
                } finally {
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            }
        } catch (Throwable th2) {
            obj = MoreExecutors.createFailure(th2);
        }
        handleFatalException$kotlinx_coroutines_core(th, Result.m10exceptionOrNullimpl(obj));
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}
