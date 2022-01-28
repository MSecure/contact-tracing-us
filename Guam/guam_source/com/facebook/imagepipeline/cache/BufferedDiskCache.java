package com.facebook.imagepipeline.cache;

import androidx.appcompat.app.AppCompatDelegateImpl;
import bolts.Task;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache {
    public static final Class<?> TAG = BufferedDiskCache.class;
    public final FileCache mFileCache;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    public final PooledByteBufferFactory mPooledByteBufferFactory;
    public final PooledByteStreams mPooledByteStreams;
    public final Executor mReadExecutor;
    public final StagingArea mStagingArea = new StagingArea();
    public final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    /* JADX INFO: finally extract failed */
    public static PooledByteBuffer access$400(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) throws IOException {
        if (bufferedDiskCache != null) {
            try {
                FLog.v(TAG, "Disk cache read for %s", cacheKey.getUriString());
                FileBinaryResource resource = ((DiskStorageCache) bufferedDiskCache.mFileCache).getResource(cacheKey);
                if (resource == null) {
                    FLog.v(TAG, "Disk cache miss for %s", cacheKey.getUriString());
                    if (((NoOpImageCacheStatsTracker) bufferedDiskCache.mImageCacheStatsTracker) != null) {
                        return null;
                    }
                    throw null;
                }
                FLog.v(TAG, "Found entry in disk cache for %s", cacheKey.getUriString());
                if (((NoOpImageCacheStatsTracker) bufferedDiskCache.mImageCacheStatsTracker) != null) {
                    FileInputStream fileInputStream = new FileInputStream(resource.mFile);
                    try {
                        PooledByteBuffer newByteBuffer = bufferedDiskCache.mPooledByteBufferFactory.newByteBuffer(fileInputStream, (int) resource.size());
                        fileInputStream.close();
                        FLog.v(TAG, "Successful read from disk cache for %s", cacheKey.getUriString());
                        return newByteBuffer;
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                } else {
                    throw null;
                }
            } catch (IOException e) {
                FLog.w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
                if (((NoOpImageCacheStatsTracker) bufferedDiskCache.mImageCacheStatsTracker) != null) {
                    throw e;
                }
                throw null;
            }
        } else {
            throw null;
        }
    }

    public static void access$500(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, final EncodedImage encodedImage) {
        if (bufferedDiskCache != null) {
            FLog.v(TAG, "About to write to disk-cache for key %s", cacheKey.getUriString());
            try {
                ((DiskStorageCache) bufferedDiskCache.mFileCache).insert(cacheKey, new WriterCallback() {
                    /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass6 */
                });
                FLog.v(TAG, "Successful disk-cache write for key %s", cacheKey.getUriString());
            } catch (IOException e) {
                FLog.w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
            }
        } else {
            throw null;
        }
    }

    public Task<Void> clearAll() {
        this.mStagingArea.clearAll();
        try {
            return Task.call(new Callable<Void>() {
                /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    BufferedDiskCache.this.mStagingArea.clearAll();
                    DiskStorageCache diskStorageCache = (DiskStorageCache) BufferedDiskCache.this.mFileCache;
                    synchronized (diskStorageCache.mLock) {
                        try {
                            diskStorageCache.mStorage.clearAll();
                            diskStorageCache.mResourceIndex.clear();
                            if (((NoOpCacheEventListener) diskStorageCache.mCacheEventListener) != null) {
                                diskStorageCache.mCacheStats.reset();
                            } else {
                                throw null;
                            }
                        } catch (IOException | NullPointerException e) {
                            CacheErrorLogger cacheErrorLogger = diskStorageCache.mCacheErrorLogger;
                            e.getMessage();
                            if (((NoOpCacheErrorLogger) cacheErrorLogger) == null) {
                                throw null;
                            }
                        }
                    }
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e);
        }
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        boolean z;
        StagingArea stagingArea = this.mStagingArea;
        synchronized (stagingArea) {
            if (stagingArea.mMap.containsKey(cacheKey)) {
                EncodedImage encodedImage = stagingArea.mMap.get(cacheKey);
                synchronized (encodedImage) {
                    if (!EncodedImage.isValid(encodedImage)) {
                        stagingArea.mMap.remove(cacheKey);
                        FLog.w(StagingArea.TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    } else {
                        z = true;
                    }
                }
            }
            z = false;
        }
        if (z || ((DiskStorageCache) this.mFileCache).hasKeySync(cacheKey)) {
            return true;
        }
        EncodedImage encodedImage2 = this.mStagingArea.get(cacheKey);
        if (encodedImage2 != null) {
            CloseableReference.closeSafely(encodedImage2.mPooledByteBufferRef);
            FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
            if (((NoOpImageCacheStatsTracker) this.mImageCacheStatsTracker) != null) {
                return true;
            }
            throw null;
        }
        FLog.v(TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
        if (((NoOpImageCacheStatsTracker) this.mImageCacheStatsTracker) != null) {
            try {
                return ((DiskStorageCache) this.mFileCache).hasKey(cacheKey);
            } catch (Exception unused) {
                return false;
            }
        } else {
            throw null;
        }
    }

    /* JADX INFO: finally extract failed */
    public Task<EncodedImage> get(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        Task<EncodedImage> task;
        try {
            FrescoSystrace.isTracing();
            EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
            if (encodedImage != null) {
                FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
                if (((NoOpImageCacheStatsTracker) this.mImageCacheStatsTracker) != null) {
                    Task<EncodedImage> forResult = Task.forResult(encodedImage);
                    FrescoSystrace.isTracing();
                    return forResult;
                }
                throw null;
            }
            try {
                task = Task.call(new Callable<EncodedImage>() {
                    /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX INFO: finally extract failed */
                    @Override // java.util.concurrent.Callable
                    public EncodedImage call() throws Exception {
                        try {
                            FrescoSystrace.isTracing();
                            if (!atomicBoolean.get()) {
                                EncodedImage encodedImage = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                                if (encodedImage != null) {
                                    FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.getUriString());
                                    if (((NoOpImageCacheStatsTracker) BufferedDiskCache.this.mImageCacheStatsTracker) == null) {
                                        throw null;
                                    }
                                } else {
                                    FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
                                    if (((NoOpImageCacheStatsTracker) BufferedDiskCache.this.mImageCacheStatsTracker) != null) {
                                        try {
                                            PooledByteBuffer access$400 = BufferedDiskCache.access$400(BufferedDiskCache.this, cacheKey);
                                            if (access$400 == null) {
                                                FrescoSystrace.isTracing();
                                                return null;
                                            }
                                            CloseableReference of = CloseableReference.of(access$400);
                                            try {
                                                encodedImage = new EncodedImage(of);
                                            } finally {
                                                if (of != null) {
                                                    of.close();
                                                }
                                            }
                                        } catch (Exception unused) {
                                        }
                                    } else {
                                        throw null;
                                    }
                                }
                                if (!Thread.interrupted()) {
                                    FrescoSystrace.isTracing();
                                    return encodedImage;
                                }
                                FLog.v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                                CloseableReference.closeSafely(encodedImage.mPooledByteBufferRef);
                                throw new InterruptedException();
                            }
                            throw new CancellationException();
                        } catch (Throwable th) {
                            FrescoSystrace.isTracing();
                            throw th;
                        }
                    }
                }, this.mReadExecutor);
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
                task = Task.forError(e);
            }
            FrescoSystrace.isTracing();
            return task;
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        try {
            if (cacheKey != null) {
                AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(EncodedImage.isValid(encodedImage));
                StagingArea stagingArea = this.mStagingArea;
                synchronized (stagingArea) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(EncodedImage.isValid(encodedImage));
                    EncodedImage.closeSafely(stagingArea.mMap.put(cacheKey, EncodedImage.cloneOrNull(encodedImage)));
                    stagingArea.logStats();
                }
                final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
                try {
                    this.mWriteExecutor.execute(new Runnable() {
                        /* class com.facebook.imagepipeline.cache.BufferedDiskCache.AnonymousClass3 */

                        public void run() {
                            try {
                                FrescoSystrace.isTracing();
                                BufferedDiskCache.access$500(BufferedDiskCache.this, cacheKey, cloneOrNull);
                            } finally {
                                BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                                EncodedImage.closeSafely(cloneOrNull);
                                FrescoSystrace.isTracing();
                            }
                        }
                    });
                } catch (Exception e) {
                    FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
                    this.mStagingArea.remove(cacheKey, encodedImage);
                    EncodedImage.closeSafely(cloneOrNull);
                }
                FrescoSystrace.isTracing();
                return;
            }
            throw null;
        } finally {
            FrescoSystrace.isTracing();
        }
    }
}
