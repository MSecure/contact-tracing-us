package io.realm.internal;

import java.lang.ref.ReferenceQueue;

public class NativeContext {
    public static final NativeContext dummyContext = new NativeContext();
    public static final Thread finalizingThread = new Thread(new FinalizerRunnable(referenceQueue));
    public static final ReferenceQueue<NativeObject> referenceQueue = new ReferenceQueue<>();

    static {
        finalizingThread.setName("RealmFinalizingDaemon");
        finalizingThread.start();
    }

    public void addReference(NativeObject nativeObject) {
        new NativeObjectReference(this, nativeObject, referenceQueue);
    }
}
