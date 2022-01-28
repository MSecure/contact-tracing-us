package com.facebook.common.references;

import java.util.IdentityHashMap;
import java.util.Map;

public class SharedReference<T> {
    public static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
    public int mRefCount;
    public final ResourceReleaser<T> mResourceReleaser;
    public T mValue;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        if (t != null) {
            this.mValue = t;
            if (resourceReleaser != null) {
                this.mResourceReleaser = resourceReleaser;
                this.mRefCount = 1;
                synchronized (sLiveObjects) {
                    Integer num = sLiveObjects.get(t);
                    if (num == null) {
                        sLiveObjects.put(t, 1);
                    } else {
                        sLiveObjects.put(t, Integer.valueOf(num.intValue() + 1));
                    }
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void ensureValid() {
        boolean z;
        boolean z2 = true;
        synchronized (this) {
            z = this.mRefCount > 0;
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            throw new NullReferenceException();
        }
    }

    public synchronized T get() {
        return this.mValue;
    }
}
