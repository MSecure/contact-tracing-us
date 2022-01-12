package kotlinx.coroutines;

import com.google.common.util.concurrent.MoreExecutors;
import kotlinx.coroutines.EventLoopImplBase;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: EventLoop.common.kt */
public abstract class EventLoop extends CoroutineDispatcher {
    public boolean shared;
    public ArrayQueue<DispatchedTask<?>> unconfinedQueue;
    public long useCount;

    public final void decrementUseCount(boolean z) {
        ThreadSafeHeapNode removeAtImpl;
        long delta = this.useCount - delta(z);
        this.useCount = delta;
        if (delta <= 0) {
            if (DebugKt.ASSERTIONS_ENABLED) {
                if (!(delta == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.shared) {
                EventLoopImplBase eventLoopImplBase = (EventLoopImplBase) this;
                ThreadLocalEventLoop threadLocalEventLoop = ThreadLocalEventLoop.INSTANCE;
                ThreadLocalEventLoop.ref.set(null);
                eventLoopImplBase._isCompleted = 1;
                if (!DebugKt.ASSERTIONS_ENABLED || eventLoopImplBase._isCompleted != 0) {
                    while (true) {
                        Object obj = eventLoopImplBase._queue;
                        if (obj == null) {
                            if (EventLoopImplBase._queue$FU.compareAndSet(eventLoopImplBase, null, EventLoop_commonKt.CLOSED_EMPTY)) {
                                break;
                            }
                        } else if (obj instanceof LockFreeTaskQueueCore) {
                            ((LockFreeTaskQueueCore) obj).close();
                            break;
                        } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                            break;
                        } else {
                            LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                            lockFreeTaskQueueCore.addLast((Runnable) obj);
                            if (EventLoopImplBase._queue$FU.compareAndSet(eventLoopImplBase, obj, lockFreeTaskQueueCore)) {
                                break;
                            }
                        }
                    }
                    do {
                    } while (eventLoopImplBase.processNextEvent() <= 0);
                    long nanoTime = System.nanoTime();
                    while (true) {
                        EventLoopImplBase.DelayedTaskQueue delayedTaskQueue = (EventLoopImplBase.DelayedTaskQueue) eventLoopImplBase._delayed;
                        if (delayedTaskQueue != null) {
                            synchronized (delayedTaskQueue) {
                                removeAtImpl = delayedTaskQueue._size > 0 ? delayedTaskQueue.removeAtImpl(0) : null;
                            }
                            EventLoopImplBase.DelayedTask delayedTask = (EventLoopImplBase.DelayedTask) removeAtImpl;
                            if (delayedTask != null) {
                                eventLoopImplBase.reschedule(nanoTime, delayedTask);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new AssertionError();
                }
            }
        }
    }

    public final long delta(boolean z) {
        return z ? 4294967296L : 1;
    }

    public final void dispatchUnconfined(DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.unconfinedQueue = arrayQueue;
        }
        Object[] objArr = arrayQueue.elements;
        int i = arrayQueue.tail;
        objArr[i] = dispatchedTask;
        int length = (objArr.length - 1) & (i + 1);
        arrayQueue.tail = length;
        int i2 = arrayQueue.head;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[(length2 << 1)];
            MoreExecutors.copyInto$default(objArr, objArr2, 0, i2, 0, 10);
            Object[] objArr3 = arrayQueue.elements;
            int length3 = objArr3.length;
            int i3 = arrayQueue.head;
            MoreExecutors.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4);
            arrayQueue.elements = objArr2;
            arrayQueue.head = 0;
            arrayQueue.tail = length2;
        }
    }

    public final void incrementUseCount(boolean z) {
        this.useCount = delta(z) + this.useCount;
        if (!z) {
            this.shared = true;
        }
    }

    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= delta(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final boolean processUnconfinedEvent() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null) {
            return false;
        }
        int i = arrayQueue.head;
        DispatchedTask dispatchedTask = null;
        if (i != arrayQueue.tail) {
            ?? r3 = arrayQueue.elements;
            ?? r6 = r3[i];
            r3[i] = 0;
            arrayQueue.head = (i + 1) & (r3.length - 1);
            if (r6 != 0) {
                dispatchedTask = r6;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type T");
            }
        }
        DispatchedTask dispatchedTask2 = dispatchedTask;
        if (dispatchedTask2 == null) {
            return false;
        }
        dispatchedTask2.run();
        return true;
    }
}
