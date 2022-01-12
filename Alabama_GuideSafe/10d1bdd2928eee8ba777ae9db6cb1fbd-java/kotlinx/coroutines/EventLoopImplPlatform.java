package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.EventLoopImplBase;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: EventLoop.kt */
public abstract class EventLoopImplPlatform extends EventLoop {
    public abstract Thread getThread();

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009c  */
    public final void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        boolean z;
        EventLoopImplBase.DelayedTask delayedTask2;
        Thread thread;
        ThreadSafeHeapNode firstImpl;
        boolean z2 = false;
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (!(this != DefaultExecutor.INSTANCE)) {
                throw new AssertionError();
            }
        }
        DefaultExecutor defaultExecutor = DefaultExecutor.INSTANCE;
        if (defaultExecutor._isCompleted == 0) {
            EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (EventLoopImplBase.DelayedTaskQueue) defaultExecutor._delayed;
            if (delayedTaskQueue == null) {
                EventLoopImplBase._delayed$FU.compareAndSet(defaultExecutor, null, new EventLoopImplBase.DelayedTaskQueue(j));
                Object obj = defaultExecutor._delayed;
                Intrinsics.checkNotNull(obj);
                delayedTaskQueue = (EventLoopImplBase.DelayedTaskQueue) obj;
            }
            synchronized (delayedTask) {
                if (delayedTask._heap == EventLoop_commonKt.DISPOSED_TASK) {
                    z = true;
                } else {
                    synchronized (delayedTaskQueue) {
                        EventLoopImplBase.DelayedTask delayedTask3 = (EventLoopImplBase.DelayedTask) delayedTaskQueue.firstImpl();
                        if (defaultExecutor._isCompleted == 0) {
                            if (delayedTask3 == null) {
                                delayedTaskQueue.timeNow = j;
                            } else {
                                long j2 = delayedTask3.nanoTime;
                                if (j2 - j >= 0) {
                                    j2 = j;
                                }
                                if (j2 - delayedTaskQueue.timeNow > 0) {
                                    delayedTaskQueue.timeNow = j2;
                                }
                            }
                            if (delayedTask.nanoTime - delayedTaskQueue.timeNow < 0) {
                                delayedTask.nanoTime = delayedTaskQueue.timeNow;
                            }
                            delayedTaskQueue.addImpl(delayedTask);
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                EventLoopImplBase.DelayedTaskQueue delayedTaskQueue2 = (EventLoopImplBase.DelayedTaskQueue) defaultExecutor._delayed;
                if (delayedTaskQueue2 != null) {
                    synchronized (delayedTaskQueue2) {
                        firstImpl = delayedTaskQueue2.firstImpl();
                    }
                    delayedTask2 = (EventLoopImplBase.DelayedTask) firstImpl;
                } else {
                    delayedTask2 = null;
                }
                if (delayedTask2 == delayedTask) {
                    z2 = true;
                }
                if (z2 && Thread.currentThread() != (thread = defaultExecutor.getThread())) {
                    LockSupport.unpark(thread);
                    return;
                }
                return;
            } else if (z) {
                defaultExecutor.reschedule(j, delayedTask);
                return;
            } else if (!z) {
                throw new IllegalStateException("unexpected result".toString());
            } else {
                return;
            }
        }
        z = true;
        if (z) {
        }
    }
}
