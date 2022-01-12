package kotlinx.coroutines.scheduling;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;

/* compiled from: Tasks.kt */
public final class TaskImpl extends Task {
    public final Runnable block;

    public TaskImpl(Runnable runnable, long j, TaskContext taskContext) {
        super(j, taskContext);
        this.block = runnable;
    }

    public void run() {
        try {
            this.block.run();
        } finally {
            this.taskContext.afterTask();
        }
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Task[");
        outline17.append(MoreExecutors.getClassSimpleName(this.block));
        outline17.append('@');
        outline17.append(MoreExecutors.getHexAddress(this.block));
        outline17.append(", ");
        outline17.append(this.submissionTime);
        outline17.append(", ");
        outline17.append(this.taskContext);
        outline17.append(']');
        return outline17.toString();
    }
}
