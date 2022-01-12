package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo$State;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.LinkedList;

public abstract class CancelWorkRunnable implements Runnable {
    public final OperationImpl mOperation = new OperationImpl();

    public void cancel(WorkManagerImpl workManagerImpl, String str) {
        boolean z;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (true) {
            z = false;
            if (linkedList.isEmpty()) {
                break;
            }
            String str2 = (String) linkedList.remove();
            WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
            WorkInfo$State state = workSpecDao_Impl.getState(str2);
            if (!(state == WorkInfo$State.SUCCEEDED || state == WorkInfo$State.FAILED)) {
                workSpecDao_Impl.setState(WorkInfo$State.CANCELLED, str2);
            }
            linkedList.addAll(((DependencyDao_Impl) dependencyDao).getDependentWorkIds(str2));
        }
        Processor processor = workManagerImpl.mProcessor;
        synchronized (processor.mLock) {
            Logger.get().debug(Processor.TAG, String.format("Processor cancelling %s", str), new Throwable[0]);
            processor.mCancelledIds.add(str);
            WorkerWrapper remove = processor.mForegroundWorkMap.remove(str);
            if (remove != null) {
                z = true;
            }
            if (remove == null) {
                remove = processor.mEnqueuedWorkMap.remove(str);
            }
            Processor.interrupt(str, remove);
            if (z) {
                processor.stopForegroundService();
            }
        }
        for (Scheduler scheduler : workManagerImpl.mSchedulers) {
            scheduler.cancel(str);
        }
    }

    public void run() {
        try {
            runInternal();
            this.mOperation.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    public abstract void runInternal();
}
