package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* compiled from: AbstractCoroutine.kt */
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    public final CoroutineContext context;
    public final CoroutineContext parentContext;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        this.parentContext = coroutineContext;
        this.context = coroutineContext.plus(this);
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // kotlinx.coroutines.JobSupport
    public String cancellationExceptionMessage() {
        return getClass().getSimpleName() + " was cancelled";
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        MoreExecutors.handleCoroutineException(this.context, th);
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        Job job = (Job) this.parentContext.get(Job.Key);
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (!(((ChildHandle) this._parentHandle) == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            this._parentHandle = NonDisposableHandle.INSTANCE;
            return;
        }
        job.start();
        ChildHandle attachChild = job.attachChild(this);
        this._parentHandle = attachChild;
        if (!(getState$kotlinx_coroutines_core() instanceof Incomplete)) {
            attachChild.dispose();
            this._parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.JobSupport
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return '\"' + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            Throwable th = completedExceptionally.cause;
            int i = completedExceptionally._handled;
        }
    }

    public void onStart() {
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(MoreExecutors.toState(obj, null));
        if (makeCompletingOnce$kotlinx_coroutines_core != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            afterResume(makeCompletingOnce$kotlinx_coroutines_core);
        }
    }
}
