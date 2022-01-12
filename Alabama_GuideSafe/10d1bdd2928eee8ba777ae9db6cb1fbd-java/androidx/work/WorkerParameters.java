package androidx.work;

import android.net.Network;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {
    public Executor mBackgroundExecutor;
    public ForegroundUpdater mForegroundUpdater;
    public UUID mId;
    public Data mInputData;
    public WorkerFactory mWorkerFactory;

    public static class RuntimeExtras {
        public Network network;

        public RuntimeExtras() {
            Collections.emptyList();
            Collections.emptyList();
        }
    }

    public WorkerParameters(UUID uuid, Data data, Collection<String> collection, RuntimeExtras runtimeExtras, int i, Executor executor, TaskExecutor taskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.mId = uuid;
        this.mInputData = data;
        new HashSet(collection);
        this.mBackgroundExecutor = executor;
        this.mWorkerFactory = workerFactory;
        this.mForegroundUpdater = foregroundUpdater;
    }
}
