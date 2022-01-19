package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;

public class BitmapCounter {
    public int mCount;
    public final int mMaxCount;
    public final int mMaxSize;
    public long mSize;
    public final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

    public BitmapCounter(int i, int i2) {
        boolean z = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i > 0);
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i2 <= 0 ? false : z);
        this.mMaxCount = i;
        this.mMaxSize = i2;
        this.mUnpooledBitmapsReleaser = new ResourceReleaser<Bitmap>() {
            /* class com.facebook.imagepipeline.memory.BitmapCounter.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                try {
                    BitmapCounter.this.decrease(bitmap2);
                } finally {
                    bitmap2.recycle();
                }
            }
        };
    }

    public synchronized void decrease(Bitmap bitmap) {
        int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument1(this.mCount > 0, "No bitmaps registered.");
        long j = (long) sizeInBytes;
        boolean z = j <= this.mSize;
        Object[] objArr = {Integer.valueOf(sizeInBytes), Long.valueOf(this.mSize)};
        if (z) {
            this.mSize -= j;
            this.mCount--;
        } else {
            throw new IllegalArgumentException(AppCompatDelegateImpl.ConfigurationImplApi17.format("Bitmap size bigger than the total registered size: %d, %d", objArr));
        }
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }
}
