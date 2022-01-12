package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* compiled from: CoroutineDispatcher.kt */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public static final Key Key = new Key(null);

    /* compiled from: CoroutineDispatcher.kt */
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {
        public Key(DefaultConstructorMarker defaultConstructorMarker) {
            super(ContinuationInterceptor.Key, AnonymousClass1.INSTANCE);
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            CoroutineContext.Key<?> key2 = getKey();
            Intrinsics.checkNotNullParameter(key2, "key");
            if (!(key2 == abstractCoroutineContextKey || abstractCoroutineContextKey.topmostKey == key2)) {
                return null;
            }
            Intrinsics.checkNotNullParameter(this, "element");
            E invoke = abstractCoroutineContextKey.safeCast.invoke(this);
            if (!(invoke instanceof CoroutineContext.Element)) {
                return null;
            }
            return invoke;
        } else if (ContinuationInterceptor.Key == key) {
            return this;
        } else {
            return null;
        }
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return true;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            CoroutineContext.Key<?> key2 = getKey();
            Intrinsics.checkNotNullParameter(key2, "key");
            if (key2 == abstractCoroutineContextKey || abstractCoroutineContextKey.topmostKey == key2) {
                Intrinsics.checkNotNullParameter(this, "element");
                if (abstractCoroutineContextKey.safeCast.invoke(this) != null) {
                    return EmptyCoroutineContext.INSTANCE;
                }
            }
        } else if (ContinuationInterceptor.Key == key) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return this;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Object obj = ((DispatchedContinuation) continuation)._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl)) {
            obj = null;
        }
        CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) obj;
        if (cancellableContinuationImpl != null) {
            DisposableHandle disposableHandle = (DisposableHandle) cancellableContinuationImpl._parentHandle;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
            cancellableContinuationImpl._parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + MoreExecutors.getHexAddress(this);
    }
}
