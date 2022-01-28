package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {
    public static WorkManager getInstance(Context context) {
        return WorkManagerImpl.getInstance(context);
    }

    public final Operation enqueue(WorkRequest workRequest) {
        List singletonList = Collections.singletonList(workRequest);
        WorkManagerImpl workManagerImpl = (WorkManagerImpl) this;
        if (!singletonList.isEmpty()) {
            return new WorkContinuationImpl(workManagerImpl, null, ExistingWorkPolicy.KEEP, singletonList, null).enqueue();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }
}
