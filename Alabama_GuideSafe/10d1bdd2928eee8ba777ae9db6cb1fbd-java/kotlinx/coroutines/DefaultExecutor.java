package kotlinx.coroutines;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: DefaultExecutor.kt */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    public static final DefaultExecutor INSTANCE;
    public static final long KEEP_ALIVE_NANOS;
    public static volatile Thread _thread;
    public static volatile int debugStatus;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        defaultExecutor.incrementUseCount(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            this._queue = null;
            this._delayed = null;
            notifyAll();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public Thread getThread() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    public final boolean isShutdownRequested() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public void run() {
        boolean z;
        ThreadLocalEventLoop threadLocalEventLoop = ThreadLocalEventLoop.INSTANCE;
        ThreadLocalEventLoop.ref.set(this);
        try {
            synchronized (this) {
                if (isShutdownRequested()) {
                    z = false;
                } else {
                    z = true;
                    debugStatus = 1;
                    notifyAll();
                }
            }
            if (z) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long processNextEvent = processNextEvent();
                    if (processNextEvent == RecyclerView.FOREVER_NS) {
                        long nanoTime = System.nanoTime();
                        if (j == RecyclerView.FOREVER_NS) {
                            j = KEEP_ALIVE_NANOS + nanoTime;
                        }
                        long j2 = j - nanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        } else if (processNextEvent > j2) {
                            processNextEvent = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (processNextEvent > 0) {
                        if (isShutdownRequested()) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        }
                        LockSupport.parkNanos(this, processNextEvent);
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            if (!isEmpty()) {
                getThread();
            }
        }
    }
}
