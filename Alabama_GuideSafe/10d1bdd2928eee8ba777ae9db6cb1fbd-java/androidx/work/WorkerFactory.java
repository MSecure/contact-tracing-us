package androidx.work;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;

public abstract class WorkerFactory {
    public static final String TAG = Logger.tagWithPrefix("WorkerFactory");

    public static WorkerFactory getDefaultWorkerFactory() {
        return new WorkerFactory() {
            /* class androidx.work.WorkerFactory.AnonymousClass1 */
        };
    }

    public final ListenableWorker createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        Class<? extends U> cls;
        ListenableWorker listenableWorker = null;
        try {
            cls = Class.forName(str).asSubclass(ListenableWorker.class);
        } catch (Throwable th) {
            Logger.get().error(TAG, GeneratedOutlineSupport.outline10("Invalid class: ", str), th);
            cls = null;
        }
        if (cls != null) {
            try {
                listenableWorker = (ListenableWorker) cls.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th2) {
                Logger.get().error(TAG, GeneratedOutlineSupport.outline10("Could not instantiate ", str), th2);
            }
        }
        if (listenableWorker == null || !listenableWorker.mUsed) {
            return listenableWorker;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", getClass().getName(), str));
    }
}
