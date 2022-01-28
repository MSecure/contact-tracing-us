package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

public class DummyBitmapPool implements BitmapPool {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            return;
        }
        throw null;
    }
}
