package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandler.kt */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
