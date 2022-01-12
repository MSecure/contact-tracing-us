package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Executors.kt */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    static {
        CoroutineDispatcher.Key key = CoroutineDispatcher.Key;
        ExecutorCoroutineDispatcher$Key$1 executorCoroutineDispatcher$Key$1 = ExecutorCoroutineDispatcher$Key$1.INSTANCE;
        Intrinsics.checkNotNullParameter(key, "baseKey");
        Intrinsics.checkNotNullParameter(executorCoroutineDispatcher$Key$1, "safeCast");
        if (key instanceof AbstractCoroutineContextKey) {
            CoroutineContext.Key<?> key2 = key.topmostKey;
        }
    }
}
