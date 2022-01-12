package com.facebook.imagepipeline.cache;

import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imageutils.BitmapUtil;

public final class BitmapCountingMemoryCacheFactory$1 implements ValueDescriptor<CloseableImage> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.imagepipeline.cache.ValueDescriptor
    public int getSizeInBytes(CloseableImage closeableImage) {
        return BitmapUtil.getSizeInBytes(((CloseableStaticBitmap) closeableImage).mBitmap);
    }
}
