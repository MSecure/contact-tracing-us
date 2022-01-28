package com.facebook.imagepipeline.memory;

import com.facebook.imagepipeline.memory.BucketMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public abstract class LruBucketsPoolBackend<T> {
    public final Set<T> mCurrentItems = new HashSet();
    public final BucketMap<T> mMap = new BucketMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    public T get(int i) {
        T t;
        BucketMap<T> bucketMap = this.mMap;
        synchronized (bucketMap) {
            BucketMap.LinkedEntry<T> linkedEntry = bucketMap.mMap.get(i);
            if (linkedEntry == null) {
                t = null;
            } else {
                I pollFirst = linkedEntry.value.pollFirst();
                bucketMap.moveToFront(linkedEntry);
                t = pollFirst;
            }
        }
        if (t != null) {
            synchronized (this) {
                this.mCurrentItems.remove(t);
            }
        }
        return t;
    }

    public abstract int getSize(T t);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public T pop() {
        T t;
        BucketMap<T> bucketMap = this.mMap;
        synchronized (bucketMap) {
            BucketMap.LinkedEntry<T> linkedEntry = bucketMap.mTail;
            if (linkedEntry == null) {
                t = null;
            } else {
                I pollLast = linkedEntry.value.pollLast();
                if (linkedEntry.value.isEmpty()) {
                    bucketMap.prune(linkedEntry);
                    bucketMap.mMap.remove(linkedEntry.key);
                }
                t = pollLast;
            }
        }
        if (t != null) {
            synchronized (this) {
                this.mCurrentItems.remove(t);
            }
        }
        return t;
    }

    public void put(T t) {
        boolean add;
        synchronized (this) {
            add = this.mCurrentItems.add(t);
        }
        if (add) {
            BucketMap<T> bucketMap = this.mMap;
            int size = getSize(t);
            synchronized (bucketMap) {
                BucketMap.LinkedEntry<T> linkedEntry = bucketMap.mMap.get(size);
                if (linkedEntry == null) {
                    BucketMap.LinkedEntry<T> linkedEntry2 = new BucketMap.LinkedEntry<>(null, size, new LinkedList(), null, null);
                    bucketMap.mMap.put(size, linkedEntry2);
                    linkedEntry = linkedEntry2;
                }
                linkedEntry.value.addLast(t);
                bucketMap.moveToFront(linkedEntry);
            }
        }
    }
}
