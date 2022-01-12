package kotlinx.coroutines.scheduling;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;

public final class CoroutineScheduler implements Executor, Closeable {
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    public static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    public static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public volatile int _isTerminated;
    public volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    public volatile long parkedWorkersStack;
    public final String schedulerName;
    public final AtomicReferenceArray<Worker> workers;

    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        public volatile int indexInArray;
        public final WorkQueue localQueue = new WorkQueue();
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        public volatile Object nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
        public int rngState;
        public WorkerState state = WorkerState.DORMANT;
        public long terminationDeadline;
        public volatile int workerCtl = 0;

        public Worker(int i) {
            CoroutineScheduler.this = r1;
            setDaemon(true);
            Random.Default r1 = Random.Default;
            this.rngState = Random.defaultRandom.nextInt();
            setIndexInArray(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
        public final Task findTask(boolean z) {
            boolean z2;
            Task task;
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            boolean z3;
            WorkerState workerState = WorkerState.CPU_ACQUIRED;
            boolean z4 = true;
            if (this.state != workerState) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                        if (CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                            z3 = true;
                            break;
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    this.state = workerState;
                } else {
                    z2 = false;
                    if (!z2) {
                        if (z) {
                            if (nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.corePoolSize * 2) != 0) {
                                z4 = false;
                            }
                            if (z4 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                                return pollGlobalQueues2;
                            }
                            Task poll = this.localQueue.poll();
                            if (poll != null) {
                                return poll;
                            }
                            if (!z4 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                                return pollGlobalQueues;
                            }
                        } else {
                            Task pollGlobalQueues3 = pollGlobalQueues();
                            if (pollGlobalQueues3 != null) {
                                return pollGlobalQueues3;
                            }
                        }
                        return trySteal(false);
                    }
                    if (z) {
                        task = this.localQueue.poll();
                        if (task == null) {
                            task = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                        }
                    } else {
                        task = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                    }
                    return task != null ? task : trySteal(true);
                }
            }
            z2 = true;
            if (!z2) {
            }
        }

        public final int nextInt$kotlinx_coroutines_core(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        public final Task pollGlobalQueues() {
            if (nextInt$kotlinx_coroutines_core(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    return task;
                }
                return (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (task2 != null) {
                return task2;
            }
            return (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        public void run() {
            boolean z;
            WorkerState workerState = WorkerState.PARKING;
            WorkerState workerState2 = WorkerState.TERMINATED;
            loop0:
            while (true) {
                boolean z2 = false;
                boolean z3 = false;
                while (CoroutineScheduler.this._isTerminated == 0 && this.state != workerState2) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    long j = -2097152;
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0;
                        WorkerState workerState3 = WorkerState.BLOCKING;
                        int taskMode = findTask.taskContext.getTaskMode();
                        this.terminationDeadline = 0;
                        if (this.state == workerState) {
                            if (DebugKt.ASSERTIONS_ENABLED) {
                                if (!(taskMode == 1 ? true : z2)) {
                                    throw new AssertionError();
                                }
                            }
                            this.state = workerState3;
                        }
                        if (taskMode != 0 && tryReleaseCpu$kotlinx_coroutines_core(workerState3)) {
                            CoroutineScheduler.this.signalCpuWork$kotlinx_coroutines_core();
                        }
                        CoroutineScheduler.this.runSafely(findTask);
                        if (taskMode == 0) {
                            continue;
                        } else {
                            CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, -2097152);
                            WorkerState workerState4 = this.state;
                            if (workerState4 == workerState2) {
                                continue;
                            } else {
                                if (DebugKt.ASSERTIONS_ENABLED) {
                                    if (workerState4 == workerState3) {
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        throw new AssertionError();
                                    }
                                }
                                this.state = WorkerState.DORMANT;
                            }
                        }
                    } else {
                        this.mayHaveLocalTasks = z2;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK ? true : z2) {
                                z = z3;
                                if (DebugKt.ASSERTIONS_ENABLED) {
                                    if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                                        throw new AssertionError();
                                    }
                                }
                                this.workerCtl = -1;
                                while (true) {
                                    if (!(this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) || this.workerCtl != -1 || CoroutineScheduler.this._isTerminated != 0 || this.state == workerState2) {
                                        break;
                                    }
                                    tryReleaseCpu$kotlinx_coroutines_core(workerState);
                                    Thread.interrupted();
                                    if (this.terminationDeadline == 0) {
                                        this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                    }
                                    LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                    if (System.nanoTime() - this.terminationDeadline >= 0) {
                                        this.terminationDeadline = 0;
                                        synchronized (CoroutineScheduler.this.workers) {
                                            if (CoroutineScheduler.this._isTerminated == 0) {
                                                if (((int) (CoroutineScheduler.this.controlState & 2097151)) > CoroutineScheduler.this.corePoolSize) {
                                                    if (workerCtl$FU.compareAndSet(this, -1, 1)) {
                                                        int i = this.indexInArray;
                                                        setIndexInArray(0);
                                                        CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(this, i, 0);
                                                        int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(CoroutineScheduler.this) & 2097151);
                                                        if (andDecrement != i) {
                                                            Worker worker = CoroutineScheduler.this.workers.get(andDecrement);
                                                            Intrinsics.checkNotNull(worker);
                                                            Worker worker2 = worker;
                                                            CoroutineScheduler.this.workers.set(i, worker2);
                                                            worker2.setIndexInArray(i);
                                                            CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(worker2, andDecrement, i);
                                                        }
                                                        CoroutineScheduler.this.workers.set(andDecrement, null);
                                                        this.state = workerState2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                                if (coroutineScheduler == null) {
                                    throw null;
                                } else if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                    z = z3;
                                } else {
                                    while (true) {
                                        long j2 = coroutineScheduler.parkedWorkersStack;
                                        int i2 = (int) (j2 & 2097151);
                                        long j3 = (2097152 + j2) & j;
                                        int i3 = this.indexInArray;
                                        if (DebugKt.ASSERTIONS_ENABLED) {
                                            if (!(i3 != 0 ? true : z2)) {
                                                throw new AssertionError();
                                            }
                                        }
                                        this.nextParkedWorker = coroutineScheduler.workers.get(i2);
                                        z = z3;
                                        if (CoroutineScheduler.parkedWorkersStack$FU.compareAndSet(coroutineScheduler, j2, ((long) i3) | j3)) {
                                            break;
                                        }
                                        z3 = z;
                                        z2 = false;
                                        j = -2097152;
                                    }
                                }
                            }
                            z2 = false;
                            z3 = z;
                        } else if (!z3) {
                            z3 = true;
                        } else {
                            tryReleaseCpu$kotlinx_coroutines_core(workerState);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0;
                        }
                    }
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(workerState2);
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public final Task trySteal(boolean z) {
            long j;
            long j2;
            if (DebugKt.ASSERTIONS_ENABLED) {
                if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                    throw new AssertionError();
                }
            }
            int i = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int nextInt$kotlinx_coroutines_core = nextInt$kotlinx_coroutines_core(i);
            long j3 = RecyclerView.FOREVER_NS;
            for (int i2 = 0; i2 < i; i2++) {
                nextInt$kotlinx_coroutines_core++;
                if (nextInt$kotlinx_coroutines_core > i) {
                    nextInt$kotlinx_coroutines_core = 1;
                }
                Worker worker = CoroutineScheduler.this.workers.get(nextInt$kotlinx_coroutines_core);
                if (worker != null && worker != this) {
                    if (DebugKt.ASSERTIONS_ENABLED) {
                        if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        WorkQueue workQueue = this.localQueue;
                        WorkQueue workQueue2 = worker.localQueue;
                        if (workQueue != null) {
                            if (DebugKt.ASSERTIONS_ENABLED) {
                                if (!(workQueue.getBufferSize$kotlinx_coroutines_core() == 0)) {
                                    throw new AssertionError();
                                }
                            }
                            int i3 = workQueue2.consumerIndex;
                            int i4 = workQueue2.producerIndex;
                            AtomicReferenceArray<Task> atomicReferenceArray = workQueue2.buffer;
                            while (true) {
                                if (i3 == i4) {
                                    break;
                                }
                                int i5 = i3 & 127;
                                if (workQueue2.blockingTasksInBuffer == 0) {
                                    break;
                                }
                                Task task = atomicReferenceArray.get(i5);
                                if (task != null) {
                                    if ((task.taskContext.getTaskMode() == 1) && atomicReferenceArray.compareAndSet(i5, task, null)) {
                                        WorkQueue.blockingTasksInBuffer$FU.decrementAndGet(workQueue2);
                                        workQueue.add(task, false);
                                        j2 = -1;
                                        break;
                                    }
                                }
                                i3++;
                            }
                            j2 = workQueue.tryStealLastScheduled(workQueue2, true);
                            j = j2;
                        } else {
                            throw null;
                        }
                    } else {
                        WorkQueue workQueue3 = this.localQueue;
                        WorkQueue workQueue4 = worker.localQueue;
                        if (workQueue3 != null) {
                            if (DebugKt.ASSERTIONS_ENABLED) {
                                if (!(workQueue3.getBufferSize$kotlinx_coroutines_core() == 0)) {
                                    throw new AssertionError();
                                }
                            }
                            Task pollBuffer = workQueue4.pollBuffer();
                            if (pollBuffer != null) {
                                Task add = workQueue3.add(pollBuffer, false);
                                if (DebugKt.ASSERTIONS_ENABLED) {
                                    if (!(add == null)) {
                                        throw new AssertionError();
                                    }
                                }
                                j = -1;
                            } else {
                                j = workQueue3.tryStealLastScheduled(workQueue4, false);
                            }
                        } else {
                            throw null;
                        }
                    }
                    if (j == -1) {
                        return this.localQueue.poll();
                    }
                    if (j > 0) {
                        j3 = Math.min(j3, j);
                    }
                }
            }
            if (j3 == RecyclerView.FOREVER_NS) {
                j3 = 0;
            }
            this.minDelayUntilStealableTaskNs = j3;
            return null;
        }
    }

    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i >= 1) {
            if (this.maxPoolSize >= this.corePoolSize) {
                if (this.maxPoolSize <= 2097150) {
                    if (this.idleWorkerKeepAliveNs > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.parkedWorkersStack = 0;
                        this.workers = new AtomicReferenceArray<>(this.maxPoolSize + 1);
                        this.controlState = ((long) this.corePoolSize) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Idle worker keep alive time ");
                    outline17.append(this.idleWorkerKeepAliveNs);
                    outline17.append(" must be positive");
                    throw new IllegalArgumentException(outline17.toString().toString());
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline13(GeneratedOutlineSupport.outline17("Max pool size "), this.maxPoolSize, " should not exceed maximal supported number of threads 2097150").toString());
            }
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Max pool size ");
            outline172.append(this.maxPoolSize);
            outline172.append(" should be greater than or equals to core pool size ");
            outline172.append(this.corePoolSize);
            throw new IllegalArgumentException(outline172.toString().toString());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline13(GeneratedOutlineSupport.outline17("Core pool size "), this.corePoolSize, " should be at least 1").toString());
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i) {
        NonBlockingContext nonBlockingContext = (i & 2) != 0 ? NonBlockingContext.INSTANCE : null;
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, nonBlockingContext, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0089, code lost:
        if (r4 != null) goto L_0x0094;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i;
        Task task;
        boolean z;
        WorkerState workerState = WorkerState.TERMINATED;
        boolean z2 = false;
        if (_isTerminated$FU.compareAndSet(this, 0, 1)) {
            Worker currentWorker = currentWorker();
            synchronized (this.workers) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Worker worker = this.workers.get(i2);
                    Intrinsics.checkNotNull(worker);
                    Worker worker2 = worker;
                    if (worker2 != currentWorker) {
                        while (worker2.isAlive()) {
                            LockSupport.unpark(worker2);
                            worker2.join(10000);
                        }
                        WorkerState workerState2 = worker2.state;
                        if (DebugKt.ASSERTIONS_ENABLED) {
                            if (!(workerState2 == workerState)) {
                                throw new AssertionError();
                            }
                        }
                        WorkQueue workQueue = worker2.localQueue;
                        GlobalQueue globalQueue = this.globalBlockingQueue;
                        if (workQueue != null) {
                            Task task2 = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, null);
                            if (task2 != null) {
                                globalQueue.addLast(task2);
                            }
                            do {
                                Task pollBuffer = workQueue.pollBuffer();
                                if (pollBuffer != null) {
                                    globalQueue.addLast(pollBuffer);
                                    z = true;
                                    continue;
                                } else {
                                    z = false;
                                    continue;
                                }
                            } while (z);
                        } else {
                            throw null;
                        }
                    }
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (currentWorker != null) {
                    task = currentWorker.findTask(true);
                }
                task = (Task) this.globalCpuQueue.removeFirstOrNull();
                if (task == null) {
                    task = (Task) this.globalBlockingQueue.removeFirstOrNull();
                }
                if (task == null) {
                    break;
                }
                runSafely(task);
            }
            if (currentWorker != null) {
                currentWorker.tryReleaseCpu$kotlinx_coroutines_core(workerState);
            }
            if (DebugKt.ASSERTIONS_ENABLED) {
                if (((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.corePoolSize) {
                    z2 = true;
                }
                if (!z2) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public final int createNewWorker() {
        synchronized (this.workers) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int i2 = i - ((int) ((j & 4398044413952L) >> 21));
            boolean z = false;
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.workers.get(i3) == null) {
                Worker worker = new Worker(i3);
                this.workers.set(i3, worker);
                if (i3 == ((int) (2097151 & controlState$FU.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    worker.start();
                    return i2 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Task createTask$kotlinx_coroutines_core(Runnable runnable, TaskContext taskContext) {
        if (((NanoTimeSource) TasksKt.schedulerTimeSource) != null) {
            long nanoTime = System.nanoTime();
            if (!(runnable instanceof Task)) {
                return new TaskImpl(runnable, nanoTime, taskContext);
            }
            Task task = (Task) runnable;
            task.submissionTime = nanoTime;
            task.taskContext = taskContext;
            return task;
        }
        throw null;
    }

    public final Worker currentWorker() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z) {
        Task task;
        boolean z2;
        Task createTask$kotlinx_coroutines_core = createTask$kotlinx_coroutines_core(runnable, taskContext);
        Worker currentWorker = currentWorker();
        boolean z3 = true;
        if (currentWorker == null || currentWorker.state == WorkerState.TERMINATED || (createTask$kotlinx_coroutines_core.taskContext.getTaskMode() == 0 && currentWorker.state == WorkerState.BLOCKING)) {
            task = createTask$kotlinx_coroutines_core;
        } else {
            currentWorker.mayHaveLocalTasks = true;
            task = currentWorker.localQueue.add(createTask$kotlinx_coroutines_core, z);
        }
        if (task != null) {
            if (task.taskContext.getTaskMode() == 1) {
                z2 = this.globalBlockingQueue.addLast(task);
            } else {
                z2 = this.globalCpuQueue.addLast(task);
            }
            if (!z2) {
                throw new RejectedExecutionException(GeneratedOutlineSupport.outline14(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        if (!z || currentWorker == null) {
            z3 = false;
        }
        if (createTask$kotlinx_coroutines_core.taskContext.getTaskMode() != 0) {
            long addAndGet = controlState$FU.addAndGet(this, 2097152);
            if (!z3 && !tryUnpark() && !tryCreateWorker(addAndGet)) {
                tryUnpark();
            }
        } else if (!z3) {
            signalCpuWork$kotlinx_coroutines_core();
        }
    }

    public void execute(Runnable runnable) {
        dispatch(runnable, NonBlockingContext.INSTANCE, false);
    }

    public final int parkedWorkersStackNextIndex(Worker worker) {
        Object obj = worker.nextParkedWorker;
        while (obj != NOT_IN_STACK) {
            if (obj == null) {
                return 0;
            }
            Worker worker2 = (Worker) obj;
            int i = worker2.indexInArray;
            if (i != 0) {
                return i;
            }
            obj = worker2.nextParkedWorker;
        }
        return -1;
    }

    public final void parkedWorkersStackTopUpdate$kotlinx_coroutines_core(Worker worker, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & -2097152;
            if (i3 == i) {
                i3 = i2 == 0 ? parkedWorkersStackNextIndex(worker) : i2;
            }
            if (i3 >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, j2 | ((long) i3))) {
                return;
            }
        }
    }

    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public final void signalCpuWork$kotlinx_coroutines_core() {
        if (!tryUnpark() && !tryCreateWorker(this.controlState)) {
            tryUnpark();
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.workers.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            Worker worker = this.workers.get(i6);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int ordinal = worker.state.ordinal();
                if (ordinal == 0) {
                    i++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "c");
                } else if (ordinal == 1) {
                    i2++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "b");
                } else if (ordinal == 2) {
                    i3++;
                } else if (ordinal == 3) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "d");
                    }
                } else if (ordinal == 4) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.schedulerName + '@' + MoreExecutors.getHexAddress(this) + '[' + "Pool Size {" + "core = " + this.corePoolSize + ", " + "max = " + this.maxPoolSize + "}, " + "Worker States {" + "CPU = " + i + ", " + "blocking = " + i2 + ", " + "parked = " + i3 + ", " + "dormant = " + i4 + ", " + "terminated = " + i5 + "}, " + "running workers queues = " + arrayList + ", " + "global CPU queue size = " + this.globalCpuQueue.getSize() + ", " + "global blocking queue size = " + this.globalBlockingQueue.getSize() + ", " + "Control State {" + "created workers= " + ((int) (2097151 & j)) + ", " + "blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", " + "CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    public final boolean tryCreateWorker(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        if (i < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryUnpark() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = this.workers.get((int) (2097151 & j));
            if (worker != null) {
                long j2 = (2097152 + j) & -2097152;
                int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
                if (parkedWorkersStackNextIndex >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, ((long) parkedWorkersStackNextIndex) | j2)) {
                    worker.nextParkedWorker = NOT_IN_STACK;
                }
            } else {
                worker = null;
            }
            if (worker == null) {
                return false;
            }
            if (Worker.workerCtl$FU.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }
}
