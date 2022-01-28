package com.facebook.imagepipeline.core;

import com.facebook.common.internal.Supplier;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class ImagePipelineExperiments {
    public boolean mBitmapPrepareToDrawForPrefetch;
    public final int mBitmapPrepareToDrawMaxSizeBytes;
    public final int mBitmapPrepareToDrawMinSizeBytes;
    public final boolean mDecodeCancellationEnabled;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public final boolean mGingerbreadDecoderEnabled;
    public final Supplier<Boolean> mLazyDataSource;
    public final int mMaxBitmapSize;
    public final boolean mNativeCodeDisabled;
    public final boolean mPartialImageCachingEnabled;
    public final ProducerFactoryMethod mProducerFactoryMethod;
    public final boolean mUseBitmapPrepareToDraw;
    public final boolean mUseDownsamplingRatioForResizing;
    public final WebpBitmapFactory mWebpBitmapFactory;
    public final WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger = null;
    public final boolean mWebpSupportEnabled;

    public static class Builder {
        public boolean mBitmapPrepareToDrawForPrefetch = false;
        public int mBitmapPrepareToDrawMaxSizeBytes = 0;
        public int mBitmapPrepareToDrawMinSizeBytes = 0;
        public boolean mDecodeCancellationEnabled = false;
        public int mMaxBitmapSize = 2048;
        public boolean mNativeCodeDisabled = false;
        public boolean mPartialImageCachingEnabled = false;
        public boolean mUseBitmapPrepareToDraw = false;
        public boolean mUseDownsamplingRatioForResizing = false;
        public boolean mWebpSupportEnabled = false;

        public Builder(ImagePipelineConfig.Builder builder) {
        }
    }

    public static class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
    }

    public interface ProducerFactoryMethod {
    }

    public ImagePipelineExperiments(Builder builder, AnonymousClass1 r3) {
        this.mWebpSupportEnabled = builder.mWebpSupportEnabled;
        this.mDecodeCancellationEnabled = builder.mDecodeCancellationEnabled;
        this.mWebpBitmapFactory = null;
        this.mUseDownsamplingRatioForResizing = builder.mUseDownsamplingRatioForResizing;
        this.mUseBitmapPrepareToDraw = builder.mUseBitmapPrepareToDraw;
        this.mBitmapPrepareToDrawMinSizeBytes = builder.mBitmapPrepareToDrawMinSizeBytes;
        this.mBitmapPrepareToDrawMaxSizeBytes = builder.mBitmapPrepareToDrawMaxSizeBytes;
        this.mBitmapPrepareToDrawForPrefetch = builder.mBitmapPrepareToDrawForPrefetch;
        this.mMaxBitmapSize = builder.mMaxBitmapSize;
        this.mNativeCodeDisabled = builder.mNativeCodeDisabled;
        this.mPartialImageCachingEnabled = builder.mPartialImageCachingEnabled;
        this.mProducerFactoryMethod = new DefaultProducerFactoryMethod();
        this.mLazyDataSource = null;
        this.mGingerbreadDecoderEnabled = false;
        this.mDownscaleFrameToDrawableDimensions = false;
    }
}
