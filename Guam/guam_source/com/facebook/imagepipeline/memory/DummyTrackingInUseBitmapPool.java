package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class DummyTrackingInUseBitmapPool implements BitmapPool {
    public final Set<Bitmap> mInUseValues = Collections.newSetFromMap(new IdentityHashMap());

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int i) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
        this.mInUseValues.add(createBitmap);
        return createBitmap;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            this.mInUseValues.remove(bitmap2);
            bitmap2.recycle();
            return;
        }
        throw null;
    }
}
