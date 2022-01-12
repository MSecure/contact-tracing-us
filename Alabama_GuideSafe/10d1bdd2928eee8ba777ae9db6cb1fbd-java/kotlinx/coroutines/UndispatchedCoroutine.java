package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: Builders.common.kt */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    public UndispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.internal.ScopeCoroutine
    public void afterResume(Object obj) {
        Object recoverResult = MoreExecutors.recoverResult(obj, this.uCont);
        CoroutineContext context = this.uCont.getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
        try {
            this.uCont.resumeWith(recoverResult);
        } finally {
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
        }
    }
}
