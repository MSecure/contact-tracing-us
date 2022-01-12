package kotlinx.coroutines;

import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: Dispatchers.kt */
public final class Dispatchers {
    public static final CoroutineDispatcher Default = (CoroutineContextKt.useCoroutinesScheduler ? DefaultScheduler.INSTANCE : CommonPool.INSTANCE);
    public static final CoroutineDispatcher IO = DefaultScheduler.IO;

    static {
        Unconfined unconfined = Unconfined.INSTANCE;
        if (DefaultScheduler.INSTANCE != null) {
            return;
        }
        throw null;
    }
}
