package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    public final int mBlurRadius;
    public CacheKey mCacheKey;
    public final int mIterations;

    public IterativeBoxBlurPostProcessor(int i) {
        boolean z = false;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(true);
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i > 0 ? true : z);
        this.mIterations = 3;
        this.mBlurRadius = i;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor, com.facebook.imagepipeline.request.BasePostprocessor
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey(String.format(null, "i%dr%d", Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)));
        }
        return this.mCacheKey;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        NativeBlurFilter.iterativeBoxBlur(bitmap, this.mIterations, this.mBlurRadius);
    }
}
