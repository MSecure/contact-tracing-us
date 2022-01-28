package io.realm.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public final class NativeObjectReference extends PhantomReference<NativeObject> {
    public static ReferencePool referencePool = new ReferencePool(null);
    public final NativeContext context;
    public final long nativeFinalizerPtr;
    public final long nativePtr;
    public NativeObjectReference next;
    public NativeObjectReference prev;

    public static class ReferencePool {
        public NativeObjectReference head;

        public ReferencePool(AnonymousClass1 r1) {
        }
    }

    public NativeObjectReference(NativeContext nativeContext, NativeObject nativeObject, ReferenceQueue<? super NativeObject> referenceQueue) {
        super(nativeObject, referenceQueue);
        this.nativePtr = nativeObject.getNativePtr();
        this.nativeFinalizerPtr = nativeObject.getNativeFinalizerPtr();
        this.context = nativeContext;
        ReferencePool referencePool2 = referencePool;
        synchronized (referencePool2) {
            this.prev = null;
            this.next = referencePool2.head;
            if (referencePool2.head != null) {
                referencePool2.head.prev = this;
            }
            referencePool2.head = this;
        }
    }

    public static native void nativeCleanUp(long j, long j2);

    public void cleanup() {
        synchronized (this.context) {
            nativeCleanUp(this.nativeFinalizerPtr, this.nativePtr);
        }
        ReferencePool referencePool2 = referencePool;
        synchronized (referencePool2) {
            NativeObjectReference nativeObjectReference = this.next;
            NativeObjectReference nativeObjectReference2 = this.prev;
            this.next = null;
            this.prev = null;
            if (nativeObjectReference2 != null) {
                nativeObjectReference2.next = nativeObjectReference;
            } else {
                referencePool2.head = nativeObjectReference;
            }
            if (nativeObjectReference != null) {
                nativeObjectReference.prev = nativeObjectReference2;
            }
        }
    }
}
