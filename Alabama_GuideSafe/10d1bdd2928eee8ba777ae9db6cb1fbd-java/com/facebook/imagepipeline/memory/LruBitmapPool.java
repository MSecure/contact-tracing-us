package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.memory.MemoryTrimmableRegistry;

public class LruBitmapPool implements BitmapPool {
    public int mCurrentSize;
    public int mMaxBitmapSize;
    public final int mMaxPoolSize;
    public final PoolStatsTracker mPoolStatsTracker;
    public final LruBucketsPoolBackend<Bitmap> mStrategy = new BitmapPoolBackend();

    public LruBitmapPool(int i, int i2, PoolStatsTracker poolStatsTracker, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.mMaxPoolSize = i;
        this.mMaxBitmapSize = i2;
        this.mPoolStatsTracker = poolStatsTracker;
        if (memoryTrimmableRegistry != null) {
            memoryTrimmableRegistry.registerMemoryTrimmable(this);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int i) {
        Bitmap bitmap;
        synchronized (this) {
            if (this.mCurrentSize > this.mMaxPoolSize) {
                int i2 = this.mMaxPoolSize;
                synchronized (this) {
                    while (true) {
                        if (this.mCurrentSize <= i2) {
                            break;
                        }
                        Bitmap pop = this.mStrategy.pop();
                        if (pop == null) {
                            break;
                        }
                        int size = this.mStrategy.getSize(pop);
                        this.mCurrentSize -= size;
                        this.mPoolStatsTracker.onFree(size);
                    }
                }
            }
            bitmap = this.mStrategy.get(i);
            if (bitmap != null) {
                int size2 = this.mStrategy.getSize(bitmap);
                this.mCurrentSize -= size2;
                this.mPoolStatsTracker.onValueReuse(size2);
            } else {
                this.mPoolStatsTracker.onAlloc(i);
                bitmap = Bitmap.createBitmap(1, i, Bitmap.Config.ALPHA_8);
            }
        }
        return bitmap;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        int size = this.mStrategy.getSize(bitmap2);
        if (size <= this.mMaxBitmapSize) {
            this.mPoolStatsTracker.onValueRelease(size);
            this.mStrategy.put(bitmap2);
            synchronized (this) {
                this.mCurrentSize += size;
            }
        }
    }
}
