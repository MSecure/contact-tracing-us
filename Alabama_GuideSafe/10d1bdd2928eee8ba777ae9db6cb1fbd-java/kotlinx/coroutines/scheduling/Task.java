package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
public abstract class Task implements Runnable {
    public long submissionTime;
    public TaskContext taskContext;

    public Task(long j, TaskContext taskContext2) {
        this.submissionTime = j;
        this.taskContext = taskContext2;
    }

    public Task() {
        NonBlockingContext nonBlockingContext = NonBlockingContext.INSTANCE;
        this.submissionTime = 0;
        this.taskContext = nonBlockingContext;
    }
}
