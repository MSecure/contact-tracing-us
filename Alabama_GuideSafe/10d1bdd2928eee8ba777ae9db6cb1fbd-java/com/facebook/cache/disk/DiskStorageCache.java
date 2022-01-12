package com.facebook.cache.disk;

import android.os.StatFs;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class DiskStorageCache implements FileCache {
    public static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
    public static final long FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
    public static final Class<?> TAG = DiskStorageCache.class;
    public final CacheErrorLogger mCacheErrorLogger;
    public final CacheEventListener mCacheEventListener;
    public long mCacheSizeLastUpdateTime;
    public long mCacheSizeLimit;
    public final CacheStats mCacheStats;
    public final Clock mClock;
    public final CountDownLatch mCountDownLatch;
    public final long mDefaultCacheSizeLimit;
    public final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    public final boolean mIndexPopulateAtStartupEnabled;
    public boolean mIndexReady;
    public final Object mLock = new Object();
    public final long mLowDiskSpaceCacheSizeLimit;
    public final Set<String> mResourceIndex;
    public final StatFsHelper mStatFsHelper;
    public final DiskStorage mStorage;

    public static class CacheStats {
        public long mCount = -1;
        public boolean mInitialized = false;
        public long mSize = -1;

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized void increment(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.mCount += j2;
            }
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.mCount = -1;
            this.mSize = -1;
        }
    }

    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, DiskTrimmableRegistry diskTrimmableRegistry, Executor executor, boolean z) {
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        long j = params.mDefaultCacheSizeLimit;
        this.mDefaultCacheSizeLimit = j;
        this.mCacheSizeLimit = j;
        this.mStatFsHelper = StatFsHelper.getInstance();
        this.mStorage = diskStorage;
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.mCacheSizeLastUpdateTime = -1;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mCacheStats = new CacheStats();
        this.mClock = SystemClock.INSTANCE;
        this.mIndexPopulateAtStartupEnabled = z;
        this.mResourceIndex = new HashSet();
        if (this.mIndexPopulateAtStartupEnabled) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() {
                /* class com.facebook.cache.disk.DiskStorageCache.AnonymousClass1 */

                public void run() {
                    synchronized (DiskStorageCache.this.mLock) {
                        DiskStorageCache.this.maybeUpdateFileCacheSize();
                    }
                    DiskStorageCache diskStorageCache = DiskStorageCache.this;
                    diskStorageCache.mIndexReady = true;
                    diskStorageCache.mCountDownLatch.countDown();
                }
            });
            return;
        }
        this.mCountDownLatch = new CountDownLatch(0);
    }

    public final void evictAboveSize(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        try {
            Collection<DiskStorage.Entry> sortedEntries = getSortedEntries(this.mStorage.getEntries());
            long size = this.mCacheStats.getSize() - j;
            int i = 0;
            Iterator it = ((ArrayList) sortedEntries).iterator();
            long j2 = 0;
            while (it.hasNext()) {
                DiskStorage.Entry entry = (DiskStorage.Entry) it.next();
                if (j2 > size) {
                    break;
                }
                long remove = this.mStorage.remove(entry);
                this.mResourceIndex.remove(entry.getId());
                if (remove > 0) {
                    i++;
                    j2 += remove;
                    SettableCacheEvent obtain = SettableCacheEvent.obtain();
                    entry.getId();
                    if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                        obtain.recycle();
                    } else {
                        throw null;
                    }
                }
            }
            this.mCacheStats.increment(-j2, (long) (-i));
            this.mStorage.purgeUnexpectedResources();
        } catch (IOException e) {
            CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
            e.getMessage();
            if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                throw e;
            }
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        if (((com.facebook.cache.common.NoOpCacheErrorLogger) r8.mCacheErrorLogger) != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
        if (((com.facebook.cache.common.NoOpCacheEventListener) r8.mCacheEventListener) != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005c, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005e, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0061, code lost:
        throw r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x004c */
    public FileBinaryResource getResource(CacheKey cacheKey) {
        FileBinaryResource fileBinaryResource;
        SettableCacheEvent obtain = SettableCacheEvent.obtain();
        synchronized (this.mLock) {
            List<String> resourceIds = AppCompatDelegateImpl.ConfigurationImplApi17.getResourceIds(cacheKey);
            int i = 0;
            String str = null;
            fileBinaryResource = null;
            while (true) {
                if (i >= resourceIds.size()) {
                    break;
                }
                str = resourceIds.get(i);
                fileBinaryResource = this.mStorage.getResource(str, cacheKey);
                if (fileBinaryResource != null) {
                    break;
                }
                i++;
            }
            if (fileBinaryResource == null) {
                if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                    this.mResourceIndex.remove(str);
                } else {
                    throw null;
                }
            } else if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                this.mResourceIndex.add(str);
            } else {
                throw null;
            }
        }
        obtain.recycle();
        return fileBinaryResource;
    }

    public final Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> collection) {
        if (((SystemClock) this.mClock) != null) {
            long currentTimeMillis = System.currentTimeMillis() + FUTURE_TIMESTAMP_THRESHOLD_MS;
            ArrayList arrayList = new ArrayList(collection.size());
            ArrayList arrayList2 = new ArrayList(collection.size());
            for (DiskStorage.Entry entry : collection) {
                if (entry.getTimestamp() > currentTimeMillis) {
                    arrayList.add(entry);
                } else {
                    arrayList2.add(entry);
                }
            }
            Collections.sort(arrayList2, this.mEntryEvictionComparatorSupplier.get());
            arrayList.addAll(arrayList2);
            return arrayList;
        }
        throw null;
    }

    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.mLock) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> resourceIds = AppCompatDelegateImpl.ConfigurationImplApi17.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    if (this.mStorage.contains(str, cacheKey)) {
                        this.mResourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.mLock) {
            List<String> resourceIds = AppCompatDelegateImpl.ConfigurationImplApi17.getResourceIds(cacheKey);
            for (int i = 0; i < resourceIds.size(); i++) {
                if (this.mResourceIndex.contains(resourceIds.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public FileBinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String str;
        FileBinaryResource commit;
        SettableCacheEvent obtain = SettableCacheEvent.obtain();
        if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
            synchronized (this.mLock) {
                try {
                    if (cacheKey instanceof MultiCacheKey) {
                        str = AppCompatDelegateImpl.ConfigurationImplApi17.secureHashKey(((MultiCacheKey) cacheKey).mCacheKeys.get(0));
                    } else {
                        str = AppCompatDelegateImpl.ConfigurationImplApi17.secureHashKey(cacheKey);
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                DefaultDiskStorage.InserterImpl inserterImpl = (DefaultDiskStorage.InserterImpl) startInsert(str, cacheKey);
                try {
                    inserterImpl.writeData(writerCallback, cacheKey);
                    synchronized (this.mLock) {
                        commit = inserterImpl.commit(cacheKey);
                        this.mResourceIndex.add(str);
                        this.mCacheStats.increment(commit.size(), 1);
                    }
                    commit.size();
                    this.mCacheStats.getSize();
                    if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                        obtain.recycle();
                        return commit;
                    }
                    throw null;
                } finally {
                    if (!inserterImpl.cleanUp()) {
                        FLog.e(TAG, "Failed to delete temp file");
                    }
                }
            } catch (IOException e2) {
                if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                    FLog.e(TAG, "Failed inserting a file into the cache", e2);
                    throw e2;
                }
                throw null;
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        } else {
            throw null;
        }
    }

    public final boolean maybeUpdateFileCacheSize() {
        boolean z;
        Set<String> set;
        long j;
        long j2;
        if (((SystemClock) this.mClock) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            CacheStats cacheStats = this.mCacheStats;
            synchronized (cacheStats) {
                z = cacheStats.mInitialized;
            }
            long j3 = -1;
            if (z) {
                long j4 = this.mCacheSizeLastUpdateTime;
                if (j4 != -1 && currentTimeMillis - j4 <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                    return false;
                }
            }
            if (((SystemClock) this.mClock) != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j5 = FUTURE_TIMESTAMP_THRESHOLD_MS + currentTimeMillis2;
                if (!this.mIndexPopulateAtStartupEnabled || !this.mResourceIndex.isEmpty()) {
                    set = this.mIndexPopulateAtStartupEnabled ? new HashSet<>() : null;
                } else {
                    set = this.mResourceIndex;
                }
                try {
                    long j6 = 0;
                    boolean z2 = false;
                    int i = 0;
                    for (DiskStorage.Entry entry : this.mStorage.getEntries()) {
                        i++;
                        j6 += entry.getSize();
                        if (entry.getTimestamp() > j5) {
                            entry.getSize();
                            j2 = j5;
                            j3 = Math.max(entry.getTimestamp() - currentTimeMillis2, j3);
                            z2 = true;
                        } else {
                            j2 = j5;
                            if (this.mIndexPopulateAtStartupEnabled) {
                                set.add(entry.getId());
                            }
                        }
                        j5 = j2;
                    }
                    if (z2) {
                        if (((NoOpCacheErrorLogger) this.mCacheErrorLogger) == null) {
                            throw null;
                        }
                    }
                    CacheStats cacheStats2 = this.mCacheStats;
                    synchronized (cacheStats2) {
                        j = cacheStats2.mCount;
                    }
                    long j7 = (long) i;
                    if (!(j == j7 && this.mCacheStats.getSize() == j6)) {
                        if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex != set) {
                            this.mResourceIndex.clear();
                            this.mResourceIndex.addAll(set);
                        }
                        CacheStats cacheStats3 = this.mCacheStats;
                        synchronized (cacheStats3) {
                            cacheStats3.mCount = j7;
                            cacheStats3.mSize = j6;
                            cacheStats3.mInitialized = true;
                        }
                    }
                    this.mCacheSizeLastUpdateTime = currentTimeMillis2;
                    return true;
                } catch (IOException e) {
                    CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                    e.getMessage();
                    if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                        return false;
                    }
                    throw null;
                }
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }

    public void remove(CacheKey cacheKey) {
        synchronized (this.mLock) {
            try {
                List<String> resourceIds = AppCompatDelegateImpl.ConfigurationImplApi17.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    this.mStorage.remove(str);
                    this.mResourceIndex.remove(str);
                }
            } catch (IOException e) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                e.getMessage();
                if (((NoOpCacheErrorLogger) cacheErrorLogger) == null) {
                    throw null;
                }
            }
        }
    }

    public final DiskStorage.Inserter startInsert(String str, CacheKey cacheKey) throws IOException {
        synchronized (this.mLock) {
            boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            if (size > this.mCacheSizeLimit) {
                evictAboveSize((this.mCacheSizeLimit * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
        return this.mStorage.insert(str, cacheKey);
    }

    public final void updateFileCacheSizeLimit() {
        StatFsHelper.StorageType storageType = StatFsHelper.StorageType.INTERNAL;
        StatFsHelper.StorageType storageType2 = this.mStorage.isExternal() ? StatFsHelper.StorageType.EXTERNAL : storageType;
        StatFsHelper statFsHelper = this.mStatFsHelper;
        long size = this.mDefaultCacheSizeLimit - this.mCacheStats.getSize();
        statFsHelper.ensureInitialized();
        statFsHelper.ensureInitialized();
        if (statFsHelper.lock.tryLock()) {
            try {
                if (android.os.SystemClock.uptimeMillis() - statFsHelper.mLastRestatTime > StatFsHelper.RESTAT_INTERVAL_MS) {
                    statFsHelper.updateStats();
                }
            } finally {
                statFsHelper.lock.unlock();
            }
        }
        StatFs statFs = storageType2 == storageType ? statFsHelper.mInternalStatFs : statFsHelper.mExternalStatFs;
        long availableBlocksLong = statFs != null ? statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() : 0;
        boolean z = true;
        if (availableBlocksLong > 0 && availableBlocksLong >= size) {
            z = false;
        }
        if (z) {
            this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        } else {
            this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        }
    }
}
