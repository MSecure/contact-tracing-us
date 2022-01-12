package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ConstraintTracker<T> {
    public static final String TAG = Logger.tagWithPrefix("ConstraintTracker");
    public final Context mAppContext;
    public T mCurrentState;
    public final Set<ConstraintListener<T>> mListeners = new LinkedHashSet();
    public final Object mLock = new Object();
    public final TaskExecutor mTaskExecutor;

    public ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public abstract T getInitialState();

    public void removeListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            if (this.mListeners.remove(constraintListener) && this.mListeners.isEmpty()) {
                stopTracking();
            }
        }
    }

    public void setState(T t) {
        synchronized (this.mLock) {
            if (this.mCurrentState != t) {
                if (this.mCurrentState == null || !this.mCurrentState.equals(t)) {
                    this.mCurrentState = t;
                    final ArrayList arrayList = new ArrayList(this.mListeners);
                    ((WorkManagerTaskExecutor) this.mTaskExecutor).mMainThreadExecutor.execute(new Runnable() {
                        /* class androidx.work.impl.constraints.trackers.ConstraintTracker.AnonymousClass1 */

                        public void run() {
                            for (ConstraintListener constraintListener : arrayList) {
                                constraintListener.onConstraintChanged(ConstraintTracker.this.mCurrentState);
                            }
                        }
                    });
                }
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
