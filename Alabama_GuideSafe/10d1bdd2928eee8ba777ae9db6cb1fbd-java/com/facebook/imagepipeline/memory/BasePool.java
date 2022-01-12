package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public abstract class BasePool<V> implements Pool<V> {
    public final Class<?> TAG = getClass();
    public boolean mAllowNewBuckets;
    public final SparseArray<Bucket<V>> mBuckets;
    public final Counter mFree;
    public final Set<V> mInUseValues;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final PoolParams mPoolParams;
    public final PoolStatsTracker mPoolStatsTracker;
    public final Counter mUsed;

    public static class Counter {
        public int mCount;
        public int mNumBytes;

        public void decrement(int i) {
            int i2;
            int i3 = this.mNumBytes;
            if (i3 < i || (i2 = this.mCount) <= 0) {
                FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
                return;
            }
            this.mCount = i2 - 1;
            this.mNumBytes = i3 - i;
        }

        public void increment(int i) {
            this.mCount++;
            this.mNumBytes += i;
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        public InvalidSizeException(Object obj) {
            super(r0.toString());
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Invalid size: ");
            outline17.append(obj.toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        if (memoryTrimmableRegistry != null) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            if (poolParams != null) {
                this.mPoolParams = poolParams;
                if (poolStatsTracker != null) {
                    this.mPoolStatsTracker = poolStatsTracker;
                    this.mBuckets = new SparseArray<>();
                    if (this.mPoolParams.fixBucketsReinitialization) {
                        synchronized (this) {
                            SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
                            if (sparseIntArray != null) {
                                this.mBuckets.clear();
                                for (int i = 0; i < sparseIntArray.size(); i++) {
                                    int keyAt = sparseIntArray.keyAt(i);
                                    this.mBuckets.put(keyAt, new Bucket<>(getSizeInBytes(keyAt), sparseIntArray.valueAt(i), 0, this.mPoolParams.fixBucketsReinitialization));
                                }
                                this.mAllowNewBuckets = false;
                            } else {
                                this.mAllowNewBuckets = true;
                            }
                        }
                    } else {
                        SparseIntArray sparseIntArray2 = new SparseIntArray(0);
                        synchronized (this) {
                            this.mBuckets.clear();
                            SparseIntArray sparseIntArray3 = this.mPoolParams.bucketSizes;
                            if (sparseIntArray3 != null) {
                                for (int i2 = 0; i2 < sparseIntArray3.size(); i2++) {
                                    int keyAt2 = sparseIntArray3.keyAt(i2);
                                    this.mBuckets.put(keyAt2, new Bucket<>(getSizeInBytes(keyAt2), sparseIntArray3.valueAt(i2), sparseIntArray2.get(keyAt2, 0), this.mPoolParams.fixBucketsReinitialization));
                                }
                                this.mAllowNewBuckets = false;
                            } else {
                                this.mAllowNewBuckets = true;
                            }
                        }
                    }
                    this.mInUseValues = Collections.newSetFromMap(new IdentityHashMap());
                    this.mFree = new Counter();
                    this.mUsed = new Counter();
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public abstract V alloc(int i);

    public synchronized boolean canAllocate(int i) {
        int i2 = this.mPoolParams.maxSizeHardCap;
        if (i > i2 - this.mUsed.mNumBytes) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i3 = this.mPoolParams.maxSizeSoftCap;
        if (i > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            trimToSize(i3 - i);
        }
        if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    public abstract void free(V v);

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0 = alloc(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0084, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5.mUsed.decrement(r3);
        r4 = getBucket(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (r4 != null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        r4.decrementInUseCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.propagateIfPossible(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0097, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.checkState(r5.mInUseValues.add(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a1, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a6, code lost:
        if (isMaxSizeSoftCapExceeded() == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a8, code lost:
        trimToSize(r5.mPoolParams.maxSizeSoftCap);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b0, code lost:
        r5.mPoolStatsTracker.onAlloc(r3);
        logStats();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bc, code lost:
        if (com.facebook.common.logging.FLog.isLoggable(2) != false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00be, code lost:
        com.facebook.common.logging.FLog.v(r5.TAG, "get (alloc) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(r0)), java.lang.Integer.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d1, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d2, code lost:
        return r0;
     */
    @Override // com.facebook.common.memory.Pool
    public V get(int i) {
        boolean z;
        V value;
        synchronized (this) {
            if (isMaxSizeSoftCapExceeded()) {
                if (this.mFree.mNumBytes != 0) {
                    z = false;
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkState(z);
                }
            }
            z = true;
            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(z);
        }
        int bucketedSize = getBucketedSize(i);
        synchronized (this) {
            Bucket<V> bucket = getBucket(bucketedSize);
            if (bucket == null || (value = getValue(bucket)) == null) {
                int sizeInBytes = getSizeInBytes(bucketedSize);
                if (canAllocate(sizeInBytes)) {
                    this.mUsed.increment(sizeInBytes);
                    if (bucket != null) {
                        bucket.mInUseLength++;
                    }
                } else {
                    throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, sizeInBytes);
                }
            } else {
                AppCompatDelegateImpl.ConfigurationImplApi17.checkState(this.mInUseValues.add(value));
                int bucketedSizeForValue = getBucketedSizeForValue(value);
                int sizeInBytes2 = getSizeInBytes(bucketedSizeForValue);
                this.mUsed.increment(sizeInBytes2);
                this.mFree.decrement(sizeInBytes2);
                this.mPoolStatsTracker.onValueReuse(sizeInBytes2);
                logStats();
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                }
                return value;
            }
        }
    }

    public synchronized Bucket<V> getBucket(int i) {
        Bucket<V> bucket = this.mBuckets.get(i);
        if (bucket == null) {
            if (this.mAllowNewBuckets) {
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(i));
                }
                Bucket<V> newBucket = newBucket(i);
                this.mBuckets.put(i, newBucket);
                return newBucket;
            }
        }
        return bucket;
    }

    public abstract int getBucketedSize(int i);

    public abstract int getBucketedSizeForValue(V v);

    public abstract int getSizeInBytes(int i);

    public synchronized V getValue(Bucket<V> bucket) {
        V pop;
        pop = bucket.pop();
        if (pop != null) {
            bucket.mInUseLength++;
        }
        return pop;
    }

    public void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    public synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z;
        z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
        if (z) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z;
    }

    public boolean isReusable(V v) {
        return true;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    public final void logStats() {
        if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    public Bucket<V> newBucket(int i) {
        return new Bucket<>(getSizeInBytes(i), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(V v) {
        Bucket<V> bucket;
        if (v != null) {
            int bucketedSizeForValue = getBucketedSizeForValue(v);
            int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
            synchronized (this) {
                synchronized (this) {
                    bucket = this.mBuckets.get(bucketedSizeForValue);
                }
                return;
            }
            boolean z = true;
            if (!this.mInUseValues.remove(v)) {
                FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                free(v);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            } else {
                if (bucket != null) {
                    if (bucket.mInUseLength + bucket.mFreeList.size() <= bucket.mMaxLength) {
                        z = false;
                    }
                    if (!z && !isMaxSizeSoftCapExceeded() && isReusable(v)) {
                        bucket.release(v);
                        this.mFree.increment(sizeInBytes);
                        this.mUsed.decrement(sizeInBytes);
                        this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                        if (FLog.isLoggable(2)) {
                            FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                        }
                    }
                }
                if (bucket != null) {
                    bucket.decrementInUseCount();
                }
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                }
                free(v);
                this.mUsed.decrement(sizeInBytes);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            }
            logStats();
            return;
        }
        throw null;
    }

    public synchronized void trimToSize(int i) {
        int min = Math.min((this.mUsed.mNumBytes + this.mFree.mNumBytes) - i, this.mFree.mNumBytes);
        if (min > 0) {
            if (FLog.isLoggable(2)) {
                FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(min));
            }
            logStats();
            for (int i2 = 0; i2 < this.mBuckets.size() && min > 0; i2++) {
                Bucket<V> valueAt = this.mBuckets.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    free(pop);
                    min -= valueAt.mItemSize;
                    this.mFree.decrement(valueAt.mItemSize);
                }
            }
            logStats();
            if (FLog.isLoggable(2)) {
                FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
            }
        }
    }
}
