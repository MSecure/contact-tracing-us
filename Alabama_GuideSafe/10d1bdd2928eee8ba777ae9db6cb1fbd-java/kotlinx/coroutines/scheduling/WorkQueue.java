package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.DebugKt;

/* compiled from: WorkQueue.kt */
public final class WorkQueue {
    public static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
    public static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    public static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    public static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    public volatile int blockingTasksInBuffer = 0;
    public final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    public volatile int consumerIndex = 0;
    public volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;

    public final Task add(Task task, boolean z) {
        if (z) {
            return addLast(task);
        }
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 != null) {
            return addLast(task2);
        }
        return null;
    }

    public final Task addLast(Task task) {
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return task;
        }
        int i = this.producerIndex & 127;
        while (this.buffer.get(i) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        return task != null ? task : pollBuffer();
    }

    public final Task pollBuffer() {
        Task andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (consumerIndex$FU.compareAndSet(this, i, i + 1) && (andSet = this.buffer.getAndSet(i2, null)) != null) {
                boolean z = false;
                if (andSet.taskContext.getTaskMode() == 1) {
                    int decrementAndGet = blockingTasksInBuffer$FU.decrementAndGet(this);
                    if (DebugKt.ASSERTIONS_ENABLED) {
                        if (decrementAndGet >= 0) {
                            z = true;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                    }
                }
                return andSet;
            }
        }
    }

    public final long tryStealLastScheduled(WorkQueue workQueue, boolean z) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (task.taskContext.getTaskMode() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            if (((NanoTimeSource) TasksKt.schedulerTimeSource) != null) {
                long nanoTime = System.nanoTime() - task.submissionTime;
                long j = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
                if (nanoTime < j) {
                    return j - nanoTime;
                }
            } else {
                throw null;
            }
        } while (!lastScheduledTask$FU.compareAndSet(workQueue, task, null));
        add(task, false);
        return -1;
    }
}
