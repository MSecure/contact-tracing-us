package e.o.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

public interface b<T extends ListenableWorker> {
    T a(Context context, WorkerParameters workerParameters);
}
