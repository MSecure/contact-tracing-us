package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

public final class BitmapMemoryCacheFactory$1 implements MemoryCacheTracker<CacheKey> {
    public final /* synthetic */ ImageCacheStatsTracker val$imageCacheStatsTracker;

    public BitmapMemoryCacheFactory$1(ImageCacheStatsTracker imageCacheStatsTracker) {
        this.val$imageCacheStatsTracker = imageCacheStatsTracker;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
    public void onCacheHit(CacheKey cacheKey) {
        if (((NoOpImageCacheStatsTracker) this.val$imageCacheStatsTracker) == null) {
            throw null;
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
    public void onCacheMiss() {
        if (((NoOpImageCacheStatsTracker) this.val$imageCacheStatsTracker) == null) {
            throw null;
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
    public void onCachePut() {
        if (((NoOpImageCacheStatsTracker) this.val$imageCacheStatsTracker) == null) {
            throw null;
        }
    }
}
