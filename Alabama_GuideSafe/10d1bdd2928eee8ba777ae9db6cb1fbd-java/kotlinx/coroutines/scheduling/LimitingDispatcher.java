package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: Dispatcher.kt */
public final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    public static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    public final ExperimentalCoroutineDispatcher dispatcher;
    public volatile int inFlightTasks = 0;
    public final String name;
    public final int parallelism;
    public final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
    public final int taskMode;

    public LimitingDispatcher(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, String str, int i2) {
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = i;
        this.name = str;
        this.taskMode = i2;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        Runnable poll = this.queue.poll();
        if (poll != null) {
            ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher = this.dispatcher;
            if (experimentalCoroutineDispatcher != null) {
                try {
                    experimentalCoroutineDispatcher.coroutineScheduler.dispatch(poll, this, true);
                } catch (RejectedExecutionException unused) {
                    DefaultExecutor.INSTANCE.enqueue(experimentalCoroutineDispatcher.coroutineScheduler.createTask$kotlinx_coroutines_core(poll, this));
                }
            } else {
                throw null;
            }
        } else {
            inFlightTasks$FU.decrementAndGet(this);
            Runnable poll2 = this.queue.poll();
            if (poll2 != null) {
                dispatch(poll2, true);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(runnable, false);
    }

    public void execute(Runnable runnable) {
        dispatch(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.taskMode;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.dispatcher + ']';
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    public final void dispatch(Runnable runnable, boolean z) {
        while (inFlightTasks$FU.incrementAndGet(this) > this.parallelism) {
            this.queue.add(runnable);
            if (inFlightTasks$FU.decrementAndGet(this) >= this.parallelism || (runnable = this.queue.poll()) == null) {
                return;
            }
            while (inFlightTasks$FU.incrementAndGet(this) > this.parallelism) {
            }
        }
        ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher = this.dispatcher;
        if (experimentalCoroutineDispatcher != null) {
            try {
                experimentalCoroutineDispatcher.coroutineScheduler.dispatch(runnable, this, z);
            } catch (RejectedExecutionException unused) {
                DefaultExecutor.INSTANCE.enqueue(experimentalCoroutineDispatcher.coroutineScheduler.createTask$kotlinx_coroutines_core(runnable, this));
            }
        } else {
            throw null;
        }
    }
}
