package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import com.facebook.cache.disk.FileCache;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiskStorageCacheFactory implements FileCacheFactory {
    public DynamicDefaultDiskStorageFactory mDiskStorageFactory;

    public DiskStorageCacheFactory(DynamicDefaultDiskStorageFactory dynamicDefaultDiskStorageFactory) {
        this.mDiskStorageFactory = dynamicDefaultDiskStorageFactory;
    }

    public FileCache get(DiskCacheConfig diskCacheConfig) {
        if (this.mDiskStorageFactory != null) {
            DynamicDefaultDiskStorage dynamicDefaultDiskStorage = new DynamicDefaultDiskStorage(diskCacheConfig.mVersion, diskCacheConfig.mBaseDirectoryPathSupplier, diskCacheConfig.mBaseDirectoryName, diskCacheConfig.mCacheErrorLogger);
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            return new DiskStorageCache(dynamicDefaultDiskStorage, diskCacheConfig.mEntryEvictionComparatorSupplier, new DiskStorageCache.Params(diskCacheConfig.mMinimumSizeLimit, diskCacheConfig.mLowDiskSpaceSizeLimit, diskCacheConfig.mDefaultSizeLimit), diskCacheConfig.mCacheEventListener, diskCacheConfig.mCacheErrorLogger, diskCacheConfig.mDiskTrimmableRegistry, newSingleThreadExecutor, diskCacheConfig.mIndexPopulateAtStartupEnabled);
        }
        throw null;
    }
}
