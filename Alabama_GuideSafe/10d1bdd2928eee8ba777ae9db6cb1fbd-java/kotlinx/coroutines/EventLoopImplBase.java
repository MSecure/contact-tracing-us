package kotlinx.coroutines;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: EventLoop.common.kt */
public abstract class EventLoopImplBase extends EventLoopImplPlatform {
    public static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    public static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    public volatile Object _delayed = null;
    public volatile int _isCompleted = 0;
    public volatile Object _queue = null;

    /* compiled from: EventLoop.common.kt */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        public Object _heap;
        public int index;
        public long nanoTime;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(DelayedTask delayedTask) {
            int i = ((this.nanoTime - delayedTask.nanoTime) > 0 ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj != EventLoop_commonKt.DISPOSED_TASK) {
                if (!(obj instanceof DelayedTaskQueue)) {
                    obj = null;
                }
                DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) obj;
                if (delayedTaskQueue != null) {
                    synchronized (delayedTaskQueue) {
                        boolean z = true;
                        if (getHeap() != null) {
                            int index2 = getIndex();
                            if (DebugKt.ASSERTIONS_ENABLED) {
                                if (index2 < 0) {
                                    z = false;
                                }
                                if (!z) {
                                    throw new AssertionError();
                                }
                            }
                            delayedTaskQueue.removeAtImpl(index2);
                        }
                    }
                }
                this._heap = EventLoop_commonKt.DISPOSED_TASK;
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            if (this._heap != EventLoop_commonKt.DISPOSED_TASK) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Delayed[nanos=");
            outline17.append(this.nanoTime);
            outline17.append(']');
            return outline17.toString();
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public final void enqueue(Runnable runnable) {
        if (enqueueImpl(runnable)) {
            Thread thread = getThread();
            if (Thread.currentThread() != thread) {
                LockSupport.unpark(thread);
                return;
            }
            return;
        }
        DefaultExecutor.INSTANCE.enqueue(runnable);
    }

    public final boolean enqueueImpl(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore.addLast(runnable);
                if (addLast == 0) {
                    return true;
                }
                if (addLast == 1) {
                    _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
                } else if (addLast == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.addLast((Runnable) obj);
                lockFreeTaskQueueCore2.addLast(runnable);
                if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    public boolean isEmpty() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (!(arrayQueue == null || arrayQueue.head == arrayQueue.tail)) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null) {
            if (!(delayedTaskQueue._size == 0)) {
                return false;
            }
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof LockFreeTaskQueueCore) {
            return ((LockFreeTaskQueueCore) obj).isEmpty();
        }
        return obj == EventLoop_commonKt.CLOSED_EMPTY;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    public long processNextEvent() {
        long j;
        ThreadSafeHeapNode firstImpl;
        Object obj;
        if (processUnconfinedEvent()) {
            return 0;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        boolean z = true;
        Runnable runnable = null;
        if (delayedTaskQueue != null) {
            if (!(delayedTaskQueue._size == 0)) {
                long nanoTime = System.nanoTime();
                do {
                    synchronized (delayedTaskQueue) {
                        ThreadSafeHeapNode firstImpl2 = delayedTaskQueue.firstImpl();
                        if (firstImpl2 != null) {
                            DelayedTask delayedTask = (DelayedTask) firstImpl2;
                            obj = ((nanoTime - delayedTask.nanoTime) > 0 ? 1 : ((nanoTime - delayedTask.nanoTime) == 0 ? 0 : -1)) >= 0 ? enqueueImpl(delayedTask) : false ? delayedTaskQueue.removeAtImpl(0) : null;
                        } else {
                            obj = null;
                        }
                    }
                } while (((DelayedTask) obj) != null);
            }
        }
        while (true) {
            Object obj2 = this._queue;
            if (obj2 != null) {
                if (!(obj2 instanceof LockFreeTaskQueueCore)) {
                    if (obj2 == EventLoop_commonKt.CLOSED_EMPTY) {
                        break;
                    } else if (_queue$FU.compareAndSet(this, obj2, null)) {
                        runnable = (Runnable) obj2;
                        break;
                    }
                } else {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj2;
                    Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                    if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                        runnable = (Runnable) removeFirstOrNull;
                        break;
                    }
                    _queue$FU.compareAndSet(this, obj2, lockFreeTaskQueueCore.next());
                }
            } else {
                break;
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0;
        }
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue != null) {
            if (arrayQueue.head != arrayQueue.tail) {
                z = false;
            }
            if (!z) {
                j = 0;
                if (j != 0) {
                    return 0;
                }
                Object obj3 = this._queue;
                if (obj3 != null) {
                    if (!(obj3 instanceof LockFreeTaskQueueCore)) {
                        if (obj3 != EventLoop_commonKt.CLOSED_EMPTY) {
                            return 0;
                        }
                        return RecyclerView.FOREVER_NS;
                    } else if (!((LockFreeTaskQueueCore) obj3).isEmpty()) {
                        return 0;
                    }
                }
                DelayedTaskQueue delayedTaskQueue2 = (DelayedTaskQueue) this._delayed;
                if (delayedTaskQueue2 != null) {
                    synchronized (delayedTaskQueue2) {
                        firstImpl = delayedTaskQueue2.firstImpl();
                    }
                    DelayedTask delayedTask2 = (DelayedTask) firstImpl;
                    if (delayedTask2 != null) {
                        long nanoTime2 = delayedTask2.nanoTime - System.nanoTime();
                        if (nanoTime2 < 0) {
                            return 0;
                        }
                        return nanoTime2;
                    }
                }
                return RecyclerView.FOREVER_NS;
            }
        }
        j = Long.MAX_VALUE;
        if (j != 0) {
        }
    }
}
