package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CancellableContinuationImpl.kt */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    public static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    public volatile int _decision;
    public volatile Object _parentHandle;
    public volatile Object _state;
    public final CoroutineContext context;
    public final Continuation<T> delegate;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.context = this.delegate.getContext();
        this._decision = 0;
        this._state = Active.INSTANCE;
        this._parentHandle = null;
    }

    public final void callCancelHandler(CancelHandler cancelHandler, Throwable th) {
        try {
            ((InvokeOnCancel) cancelHandler).handler.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext coroutineContext = this.context;
            MoreExecutors.handleCoroutineException(coroutineContext, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext coroutineContext = this.context;
            MoreExecutors.handleCoroutineException(coroutineContext, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean cancel(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!_state$FU.compareAndSet(this, obj, new CancelledContinuation(this, th, z)));
        if (!z) {
            obj = null;
        }
        CancelHandler cancelHandler = (CancelHandler) obj;
        if (cancelHandler != null) {
            callCancelHandler(cancelHandler, th);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof CompletedExceptionally)) {
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (!(completedContinuation.cancelCause != null)) {
                        if (_state$FU.compareAndSet(this, obj2, CompletedContinuation.copy$default(completedContinuation, null, null, null, null, th, 15))) {
                            CancelHandler cancelHandler = completedContinuation.cancelHandler;
                            if (cancelHandler != null) {
                                callCancelHandler(cancelHandler, th);
                            }
                            Function1<Throwable, Unit> function1 = completedContinuation.onCancellation;
                            if (function1 != null) {
                                callOnCancellation(function1, th);
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (_state$FU.compareAndSet(this, obj2, new CompletedContinuation(obj2, null, null, null, th, 14))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void detachChildIfNonResuable() {
        if (!isReusable()) {
            DisposableHandle disposableHandle = (DisposableHandle) this._parentHandle;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
            this._parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    public final void dispatchResume(int i) {
        boolean z;
        boolean z2;
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 == 0) {
                if (_decision$FU.compareAndSet(this, 0, 2)) {
                    z2 = true;
                    break;
                }
            } else if (i2 == 1) {
                z2 = false;
            } else {
                throw new IllegalStateException("Already resumed".toString());
            }
        }
        if (!z2) {
            if (DebugKt.ASSERTIONS_ENABLED) {
                if (!(i != -1)) {
                    throw new AssertionError();
                }
            }
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            if (i == 4) {
                z = true;
            }
            if (z || !(delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) || MoreExecutors.isCancellableMode(i) != MoreExecutors.isCancellableMode(this.resumeMode)) {
                MoreExecutors.resume(this, delegate$kotlinx_coroutines_core, z);
                return;
            }
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
            CoroutineContext context2 = delegate$kotlinx_coroutines_core.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context2)) {
                coroutineDispatcher.dispatch(context2, this);
                return;
            }
            ThreadLocalEventLoop threadLocalEventLoop = ThreadLocalEventLoop.INSTANCE;
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
                return;
            }
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                MoreExecutors.resume(this, getDelegate$kotlinx_coroutines_core(), true);
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } catch (Throwable th) {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                throw th;
            }
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core == null) {
            return null;
        }
        Continuation<T> continuation = this.delegate;
        return (!DebugKt.RECOVER_STACK_TRACES || !(continuation instanceof CoroutineStackFrame)) ? exceptionalResult$kotlinx_coroutines_core : StackTraceRecoveryKt.access$recoverFromStackFrame(exceptionalResult$kotlinx_coroutines_core, (CoroutineStackFrame) continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object getResult() {
        Job job;
        Job job2;
        boolean z = true;
        boolean z2 = !(this._state instanceof NotCompleted);
        if (this.resumeMode == 2) {
            Continuation<T> continuation = this.delegate;
            Throwable th = null;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation != null) {
                while (true) {
                    Object obj = dispatchedContinuation._reusableCancellableContinuation;
                    Symbol symbol = DispatchedContinuationKt.REUSABLE_CLAIMED;
                    if (obj == symbol) {
                        if (DispatchedContinuation._reusableCancellableContinuation$FU.compareAndSet(dispatchedContinuation, symbol, this)) {
                            break;
                        }
                    } else if (obj != null) {
                        if (!(obj instanceof Throwable)) {
                            throw new IllegalStateException(GeneratedOutlineSupport.outline9("Inconsistent state ", obj).toString());
                        } else if (DispatchedContinuation._reusableCancellableContinuation$FU.compareAndSet(dispatchedContinuation, obj, null)) {
                            th = (Throwable) obj;
                        } else {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                    }
                }
                if (th != null) {
                    if (!z2) {
                        cancel(th);
                    }
                    z2 = true;
                }
            }
        }
        if (!z2 && ((DisposableHandle) this._parentHandle) == null && (job2 = (Job) this.delegate.getContext().get(Job.Key)) != null) {
            DisposableHandle invokeOnCompletion$default = MoreExecutors.invokeOnCompletion$default(job2, true, false, new ChildContinuation(job2, this), 2, null);
            this._parentHandle = invokeOnCompletion$default;
            if ((!(this._state instanceof NotCompleted)) && !isReusable()) {
                invokeOnCompletion$default.dispose();
                this._parentHandle = NonDisposableHandle.INSTANCE;
            }
        }
        while (true) {
            int i = this._decision;
            if (i == 0) {
                if (_decision$FU.compareAndSet(this, 0, 1)) {
                    break;
                }
            } else if (i == 2) {
                z = false;
            } else {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z) {
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
        Object obj2 = this._state;
        if (obj2 instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) obj2).cause;
            if (DebugKt.RECOVER_STACK_TRACES) {
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(th2, this);
            }
            throw th2;
        } else if (!MoreExecutors.isCancellableMode(this.resumeMode) || (job = (Job) this.context.get(Job.Key)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(obj2);
        } else {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(obj2, cancellationException);
            if (DebugKt.RECOVER_STACK_TRACES) {
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(cancellationException, this);
            }
            throw cancellationException;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof CompletedContinuation ? (T) ((CompletedContinuation) obj).result : obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        CancelHandler invokeOnCancel = function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof Active)) {
                Throwable th = null;
                if (!(obj instanceof CancelHandler)) {
                    boolean z = obj instanceof CompletedExceptionally;
                    boolean z2 = true;
                    if (z) {
                        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                        if (completedExceptionally == null) {
                            throw null;
                        } else if (!CompletedExceptionally._handled$FU.compareAndSet(completedExceptionally, 0, 1)) {
                            multipleHandlersError(function1, obj);
                            throw null;
                        } else if (obj instanceof CancelledContinuation) {
                            if (!z) {
                                obj = null;
                            }
                            CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) obj;
                            if (completedExceptionally2 != null) {
                                th = completedExceptionally2.cause;
                            }
                            callCancelHandler(function1, th);
                            return;
                        } else {
                            return;
                        }
                    } else if (obj instanceof CompletedContinuation) {
                        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                        if (completedContinuation.cancelHandler == null) {
                            if (completedContinuation.cancelCause == null) {
                                z2 = false;
                            }
                            if (z2) {
                                callCancelHandler(function1, completedContinuation.cancelCause);
                                return;
                            } else {
                                if (_state$FU.compareAndSet(this, obj, CompletedContinuation.copy$default(completedContinuation, null, invokeOnCancel, null, null, null, 29))) {
                                    return;
                                }
                            }
                        } else {
                            multipleHandlersError(function1, obj);
                            throw null;
                        }
                    } else {
                        if (_state$FU.compareAndSet(this, obj, new CompletedContinuation(obj, invokeOnCancel, null, null, null, 28))) {
                            return;
                        }
                    }
                } else {
                    multipleHandlersError(function1, obj);
                    throw null;
                }
            } else if (_state$FU.compareAndSet(this, obj, invokeOnCancel)) {
                return;
            }
        }
    }

    public final boolean isReusable() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof DispatchedContinuation) {
            Object obj = ((DispatchedContinuation) continuation)._reusableCancellableContinuation;
            if (obj != null && (!(obj instanceof CancellableContinuationImpl) || obj == this)) {
                return true;
            }
        }
        return false;
    }

    public final void multipleHandlersError(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Object obj2;
        Object obj3;
        Throwable r0 = Result.m10exceptionOrNullimpl(obj);
        if (r0 != null) {
            if (DebugKt.RECOVER_STACK_TRACES) {
                r0 = StackTraceRecoveryKt.access$recoverFromStackFrame(r0, this);
            }
            obj = new CompletedExceptionally(r0, false, 2);
        }
        int i = this.resumeMode;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                NotCompleted notCompleted = (NotCompleted) obj2;
                if (obj instanceof CompletedExceptionally) {
                    boolean z = DebugKt.ASSERTIONS_ENABLED;
                } else if (MoreExecutors.isCancellableMode(i) && (notCompleted instanceof CancelHandler)) {
                    if (!(notCompleted instanceof CancelHandler)) {
                        notCompleted = null;
                    }
                    obj3 = new CompletedContinuation(obj, (CancelHandler) notCompleted, null, null, null, 16);
                }
                obj3 = obj;
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation == null) {
                        throw null;
                    } else if (CancelledContinuation._resumed$FU.compareAndSet(cancelledContinuation, 0, 1)) {
                        return;
                    }
                }
                throw new IllegalStateException(GeneratedOutlineSupport.outline9("Already resumed, but proposed with update ", obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj2, obj3));
        detachChildIfNonResuable();
        dispatchResume(i);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return this._state;
    }

    public String toString() {
        return "CancellableContinuation" + '(' + MoreExecutors.toDebugString(this.delegate) + "){" + this._state + "}@" + MoreExecutors.getHexAddress(this);
    }

    public final void callCancelHandler(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext coroutineContext = this.context;
            MoreExecutors.handleCoroutineException(coroutineContext, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }
}
