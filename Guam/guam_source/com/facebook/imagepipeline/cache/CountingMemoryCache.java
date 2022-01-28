package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public class CountingMemoryCache<K, V> implements MemoryCache<K, V>, MemoryTrimmable {
    public final CountingLruMap<K, Entry<K, V>> mCachedEntries;
    public final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
    public long mLastCacheParamsCheck = SystemClock.uptimeMillis();
    public MemoryCacheParams mMemoryCacheParams;
    public final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    public final ValueDescriptor<V> mValueDescriptor;

    public interface CacheTrimStrategy {
    }

    public static class Entry<K, V> {
        public int clientCount;
        public boolean isOrphan;
        public final K key;
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        public Entry(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
            if (k != null) {
                this.key = k;
                CloseableReference<V> cloneOrNull = CloseableReference.cloneOrNull(closeableReference);
                AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(cloneOrNull);
                this.valueRef = cloneOrNull;
                this.clientCount = 0;
                this.isOrphan = false;
                this.observer = entryStateObserver;
                return;
            }
            throw null;
        }
    }

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    public CountingMemoryCache(final ValueDescriptor<V> valueDescriptor, CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier) {
        new WeakHashMap();
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap<>(new ValueDescriptor<Entry<K, V>>(this) {
            /* class com.facebook.imagepipeline.cache.CountingMemoryCache.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(Object obj) {
                return valueDescriptor.getSizeInBytes(((Entry) obj).valueRef.get());
            }
        });
        this.mCachedEntries = new CountingLruMap<>(new ValueDescriptor<Entry<K, V>>(this) {
            /* class com.facebook.imagepipeline.cache.CountingMemoryCache.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(Object obj) {
                return valueDescriptor.getSizeInBytes(((Entry) obj).valueRef.get());
            }
        });
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = supplier.get();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        CloseableReference<V> closeableReference2;
        boolean z;
        CloseableReference<V> closeableReference3 = null;
        if (k == null) {
            throw null;
        } else if (closeableReference != null) {
            maybeUpdateCacheParams();
            synchronized (this) {
                Entry<K, V> remove = this.mExclusiveEntries.remove(k);
                Entry<K, V> remove2 = this.mCachedEntries.remove(k);
                if (remove2 != null) {
                    makeOrphan(remove2);
                    closeableReference2 = referenceToClose(remove2);
                } else {
                    closeableReference2 = null;
                }
                V v = closeableReference.get();
                synchronized (this) {
                    int sizeInBytes = this.mValueDescriptor.getSizeInBytes(v);
                    z = true;
                    if (sizeInBytes > this.mMemoryCacheParams.maxCacheEntrySize || getInUseCount() > this.mMemoryCacheParams.maxCacheEntries - 1 || getInUseSizeInBytes() > this.mMemoryCacheParams.maxCacheSize - sizeInBytes) {
                        z = false;
                    }
                }
                CloseableReference.closeSafely(closeableReference2);
                maybeNotifyExclusiveEntryRemoval(remove);
                maybeEvictEntries();
                return closeableReference3;
            }
            if (z) {
                Entry<K, V> entry = new Entry<>(k, closeableReference, null);
                this.mCachedEntries.put(k, entry);
                closeableReference3 = newClientReference(entry);
            }
            CloseableReference.closeSafely(closeableReference2);
            maybeNotifyExclusiveEntryRemoval(remove);
            maybeEvictEntries();
            return closeableReference3;
        } else {
            throw null;
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> get(K k) {
        Entry<K, V> remove;
        V v;
        CloseableReference<V> closeableReference = null;
        if (k != null) {
            synchronized (this) {
                remove = this.mExclusiveEntries.remove(k);
                CountingLruMap<K, Entry<K, V>> countingLruMap = this.mCachedEntries;
                synchronized (countingLruMap) {
                    v = countingLruMap.mMap.get(k);
                }
                V v2 = v;
                if (v2 != null) {
                    closeableReference = newClientReference(v2);
                }
            }
            maybeNotifyExclusiveEntryRemoval(remove);
            maybeUpdateCacheParams();
            maybeEvictEntries();
            return closeableReference;
        }
        throw null;
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }

    public final synchronized void makeOrphan(Entry<K, V> entry) {
        if (entry != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!entry.isOrphan);
            entry.isOrphan = true;
        } else {
            throw null;
        }
    }

    public final synchronized void makeOrphans(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan(it.next());
            }
        }
    }

    public final void maybeClose(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely(referenceToClose(it.next()));
            }
        }
    }

    public final void maybeEvictEntries() {
        ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries;
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
    }

    public final void maybeNotifyExclusiveEntryRemoval(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it.next());
            }
        }
    }

    public final synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs <= SystemClock.uptimeMillis()) {
            this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = this.mMemoryCacheParamsSupplier.get();
        }
    }

    public final synchronized CloseableReference<V> newClientReference(final Entry<K, V> entry) {
        synchronized (this) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!entry.isOrphan);
            entry.clientCount++;
        }
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() {
            /* class com.facebook.imagepipeline.cache.CountingMemoryCache.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:26:0x003a  */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(V v) {
                boolean z;
                EntryStateObserver<K> entryStateObserver;
                CountingMemoryCache countingMemoryCache = CountingMemoryCache.this;
                Entry<K, V> entry = entry;
                if (entry != null) {
                    synchronized (countingMemoryCache) {
                        synchronized (countingMemoryCache) {
                            z = false;
                            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(entry.clientCount > 0);
                            entry.clientCount--;
                        }
                        CloseableReference.closeSafely(countingMemoryCache.referenceToClose(entry));
                        if (!z) {
                            entry = null;
                        }
                        if (!(entry == null || (entryStateObserver = entry.observer) == null)) {
                            entryStateObserver.onExclusivityChanged(entry.key, true);
                        }
                        countingMemoryCache.maybeUpdateCacheParams();
                        countingMemoryCache.maybeEvictEntries();
                        return;
                    }
                    synchronized (countingMemoryCache) {
                        if (!entry.isOrphan && entry.clientCount == 0) {
                            countingMemoryCache.mExclusiveEntries.put(entry.key, entry);
                            z = true;
                        }
                    }
                    CloseableReference.closeSafely(countingMemoryCache.referenceToClose(entry));
                    if (!z) {
                    }
                    entryStateObserver.onExclusivityChanged(entry.key, true);
                    countingMemoryCache.maybeUpdateCacheParams();
                    countingMemoryCache.maybeEvictEntries();
                    return;
                }
                throw null;
            }
        });
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() {
            /* class com.facebook.imagepipeline.cache.CountingMemoryCache.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:26:0x003a  */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(V v) {
                boolean z;
                EntryStateObserver<K> entryStateObserver;
                CountingMemoryCache countingMemoryCache = CountingMemoryCache.this;
                Entry<K, V> entry = entry;
                if (entry != null) {
                    synchronized (countingMemoryCache) {
                        synchronized (countingMemoryCache) {
                            z = false;
                            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(entry.clientCount > 0);
                            entry.clientCount--;
                        }
                        CloseableReference.closeSafely(countingMemoryCache.referenceToClose(entry));
                        if (!z) {
                            entry = null;
                        }
                        if (!(entry == null || (entryStateObserver = entry.observer) == null)) {
                            entryStateObserver.onExclusivityChanged(entry.key, true);
                        }
                        countingMemoryCache.maybeUpdateCacheParams();
                        countingMemoryCache.maybeEvictEntries();
                        return;
                    }
                    synchronized (countingMemoryCache) {
                        if (!entry.isOrphan && entry.clientCount == 0) {
                            countingMemoryCache.mExclusiveEntries.put(entry.key, entry);
                            z = true;
                        }
                    }
                    CloseableReference.closeSafely(countingMemoryCache.referenceToClose(entry));
                    if (!z) {
                    }
                    entryStateObserver.onExclusivityChanged(entry.key, true);
                    countingMemoryCache.maybeUpdateCacheParams();
                    countingMemoryCache.maybeEvictEntries();
                    return;
                }
                throw null;
            }
        });
    }

    public final synchronized CloseableReference<V> referenceToClose(Entry<K, V> entry) {
        CloseableReference<V> closeableReference;
        closeableReference = null;
        if (entry == null) {
            throw null;
        } else if (entry.isOrphan && entry.clientCount == 0) {
            closeableReference = entry.valueRef;
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        ArrayList<Entry<K, V>> removeAll;
        ArrayList<Entry<K, V>> removeAll2;
        synchronized (this) {
            removeAll = this.mExclusiveEntries.removeAll(predicate);
            removeAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(removeAll2);
        }
        maybeClose(removeAll2);
        maybeNotifyExclusiveEntryRemoval(removeAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return removeAll2.size();
    }

    public final synchronized ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2) {
        K next;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
            return null;
        }
        ArrayList<Entry<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                return arrayList;
            }
            CountingLruMap<K, Entry<K, V>> countingLruMap = this.mExclusiveEntries;
            synchronized (countingLruMap) {
                next = countingLruMap.mMap.isEmpty() ? null : countingLruMap.mMap.keySet().iterator().next();
            }
            this.mExclusiveEntries.remove(next);
            arrayList.add(this.mCachedEntries.remove(next));
        }
    }

    public static <K, V> void maybeNotifyExclusiveEntryRemoval(Entry<K, V> entry) {
        EntryStateObserver<K> entryStateObserver;
        if (entry != null && (entryStateObserver = entry.observer) != null) {
            entryStateObserver.onExclusivityChanged(entry.key, false);
        }
    }
}
