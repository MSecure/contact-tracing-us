package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CommonPool.kt */
public final class CommonPool$createPlainPool$1 implements ThreadFactory {
    public final /* synthetic */ AtomicInteger $threadId;

    public CommonPool$createPlainPool$1(AtomicInteger atomicInteger) {
        this.$threadId = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("CommonPool-worker-");
        outline17.append(this.$threadId.incrementAndGet());
        Thread thread = new Thread(runnable, outline17.toString());
        thread.setDaemon(true);
        return thread;
    }
}
