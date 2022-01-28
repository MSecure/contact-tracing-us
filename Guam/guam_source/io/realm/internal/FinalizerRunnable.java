package io.realm.internal;

import io.realm.log.RealmLog;
import java.lang.ref.ReferenceQueue;

public class FinalizerRunnable implements Runnable {
    public final ReferenceQueue<NativeObject> referenceQueue;

    public FinalizerRunnable(ReferenceQueue<NativeObject> referenceQueue2) {
        this.referenceQueue = referenceQueue2;
    }

    public void run() {
        while (true) {
            try {
                ((NativeObjectReference) this.referenceQueue.remove()).cleanup();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                RealmLog.log(7, null, "The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore", new Object[0]);
                return;
            }
        }
    }
}
