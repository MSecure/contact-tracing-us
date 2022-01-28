package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers$1;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.OreoDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;
import java.util.Collections;
import java.util.Set;

public class ImagePipelineFactory {
    public static final Class<?> TAG = ImagePipelineFactory.class;
    public static ImagePipelineFactory sInstance;
    public AnimatedFactory mAnimatedFactory;
    public CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
    public InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public final ImagePipelineConfig mConfig;
    public CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public ImageDecoder mImageDecoder;
    public ImagePipeline mImagePipeline;
    public ImageTranscoderFactory mImageTranscoderFactory;
    public BufferedDiskCache mMainBufferedDiskCache;
    public FileCache mMainFileCache;
    public PlatformBitmapFactory mPlatformBitmapFactory;
    public PlatformDecoder mPlatformDecoder;
    public ProducerFactory mProducerFactory;
    public ProducerSequenceFactory mProducerSequenceFactory;
    public BufferedDiskCache mSmallImageBufferedDiskCache;
    public FileCache mSmallImageFileCache;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        FrescoSystrace.isTracing();
        if (imagePipelineConfig != null) {
            this.mConfig = imagePipelineConfig;
            this.mThreadHandoffProducerQueue = new ThreadHandoffProducerQueue(imagePipelineConfig.mExecutorSupplier.forLightweightBackgroundTasks());
            this.mCloseableReferenceFactory = new CloseableReferenceFactory(imagePipelineConfig.mCloseableReferenceLeakTracker);
            FrescoSystrace.isTracing();
            return;
        }
        throw null;
    }

    public static ImagePipelineFactory getInstance() {
        ImagePipelineFactory imagePipelineFactory = sInstance;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        return imagePipelineFactory;
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig) {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                FLog.w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            sInstance = new ImagePipelineFactory(imagePipelineConfig);
        }
    }

    public final AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            PlatformBitmapFactory platformBitmapFactory = getPlatformBitmapFactory();
            ExecutorSupplier executorSupplier = this.mConfig.mExecutorSupplier;
            CountingMemoryCache<CacheKey, CloseableImage> bitmapCountingMemoryCache = getBitmapCountingMemoryCache();
            boolean z = this.mConfig.mImagePipelineExperiments.mDownscaleFrameToDrawableDimensions;
            if (!AnimatedFactoryProvider.sImplLoaded) {
                try {
                    AnimatedFactoryProvider.sImpl = (AnimatedFactory) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE).newInstance(platformBitmapFactory, executorSupplier, bitmapCountingMemoryCache, Boolean.valueOf(z));
                } catch (Throwable unused) {
                }
                if (AnimatedFactoryProvider.sImpl != null) {
                    AnimatedFactoryProvider.sImplLoaded = true;
                }
            }
            this.mAnimatedFactory = AnimatedFactoryProvider.sImpl;
        }
        return this.mAnimatedFactory;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            ImagePipelineConfig imagePipelineConfig = this.mConfig;
            Supplier<MemoryCacheParams> supplier = imagePipelineConfig.mBitmapMemoryCacheParamsSupplier;
            MemoryTrimmableRegistry memoryTrimmableRegistry = imagePipelineConfig.mMemoryTrimmableRegistry;
            CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache = new CountingMemoryCache<>(new BitmapCountingMemoryCacheFactory$1(), imagePipelineConfig.mBitmapMemoryCacheTrimStrategy, supplier);
            memoryTrimmableRegistry.registerMemoryTrimmable(countingMemoryCache);
            this.mBitmapCountingMemoryCache = countingMemoryCache;
        }
        return this.mBitmapCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        if (this.mBitmapMemoryCache == null) {
            CountingMemoryCache<CacheKey, CloseableImage> bitmapCountingMemoryCache = getBitmapCountingMemoryCache();
            ImageCacheStatsTracker imageCacheStatsTracker = this.mConfig.mImageCacheStatsTracker;
            if (((NoOpImageCacheStatsTracker) imageCacheStatsTracker) != null) {
                this.mBitmapMemoryCache = new InstrumentedMemoryCache<>(bitmapCountingMemoryCache, new BitmapMemoryCacheFactory$1(imageCacheStatsTracker));
            } else {
                throw null;
            }
        }
        return this.mBitmapMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        if (this.mEncodedMemoryCache == null) {
            if (this.mEncodedCountingMemoryCache == null) {
                ImagePipelineConfig imagePipelineConfig = this.mConfig;
                Supplier<MemoryCacheParams> supplier = imagePipelineConfig.mEncodedMemoryCacheParamsSupplier;
                MemoryTrimmableRegistry memoryTrimmableRegistry = imagePipelineConfig.mMemoryTrimmableRegistry;
                CountingMemoryCache<CacheKey, PooledByteBuffer> countingMemoryCache = new CountingMemoryCache<>(new EncodedCountingMemoryCacheFactory$1(), new NativeMemoryCacheTrimStrategy(), supplier);
                memoryTrimmableRegistry.registerMemoryTrimmable(countingMemoryCache);
                this.mEncodedCountingMemoryCache = countingMemoryCache;
            }
            CountingMemoryCache<CacheKey, PooledByteBuffer> countingMemoryCache2 = this.mEncodedCountingMemoryCache;
            ImageCacheStatsTracker imageCacheStatsTracker = this.mConfig.mImageCacheStatsTracker;
            if (((NoOpImageCacheStatsTracker) imageCacheStatsTracker) != null) {
                this.mEncodedMemoryCache = new InstrumentedMemoryCache<>(countingMemoryCache2, new EncodedMemoryCacheFactory$1(imageCacheStatsTracker));
            } else {
                throw null;
            }
        }
        return this.mEncodedMemoryCache;
    }

    public ImagePipeline getImagePipeline() {
        ImagePipeline imagePipeline;
        ImagePipeline imagePipeline2;
        ProducerSequenceFactory producerSequenceFactory;
        ProducerSequenceFactory producerSequenceFactory2;
        ContentResolver contentResolver;
        boolean z;
        ImageDecoder imageDecoder;
        ImageDecoder imageDecoder2;
        if (this.mImagePipeline == null) {
            boolean z2 = Build.VERSION.SDK_INT >= 24 && this.mConfig.mImagePipelineExperiments.mUseBitmapPrepareToDraw;
            if (this.mProducerSequenceFactory == null) {
                ContentResolver contentResolver2 = this.mConfig.mContext.getApplicationContext().getContentResolver();
                if (this.mProducerFactory == null) {
                    ImagePipelineConfig imagePipelineConfig = this.mConfig;
                    ImagePipelineExperiments.ProducerFactoryMethod producerFactoryMethod = imagePipelineConfig.mImagePipelineExperiments.mProducerFactoryMethod;
                    Context context = imagePipelineConfig.mContext;
                    ByteArrayPool smallByteArrayPool = imagePipelineConfig.mPoolFactory.getSmallByteArrayPool();
                    if (this.mImageDecoder == null) {
                        ImageDecoder imageDecoder3 = this.mConfig.mImageDecoder;
                        if (imageDecoder3 != null) {
                            this.mImageDecoder = imageDecoder3;
                        } else {
                            AnimatedFactory animatedFactory = getAnimatedFactory();
                            if (animatedFactory != null) {
                                imageDecoder = animatedFactory.getGifDecoder(this.mConfig.mBitmapConfig);
                                imageDecoder2 = animatedFactory.getWebPDecoder(this.mConfig.mBitmapConfig);
                            } else {
                                imageDecoder2 = null;
                                imageDecoder = null;
                            }
                            if (this.mConfig != null) {
                                this.mImageDecoder = new DefaultImageDecoder(imageDecoder, imageDecoder2, getPlatformDecoder());
                            } else {
                                throw null;
                            }
                        }
                    }
                    ImageDecoder imageDecoder4 = this.mImageDecoder;
                    ImagePipelineConfig imagePipelineConfig2 = this.mConfig;
                    ProgressiveJpegConfig progressiveJpegConfig = imagePipelineConfig2.mProgressiveJpegConfig;
                    boolean z3 = imagePipelineConfig2.mDownsampleEnabled;
                    boolean z4 = imagePipelineConfig2.mResizeAndRotateEnabledForNetwork;
                    boolean z5 = imagePipelineConfig2.mImagePipelineExperiments.mDecodeCancellationEnabled;
                    ExecutorSupplier executorSupplier = imagePipelineConfig2.mExecutorSupplier;
                    PooledByteBufferFactory pooledByteBufferFactory = imagePipelineConfig2.mPoolFactory.getPooledByteBufferFactory(imagePipelineConfig2.mMemoryChunkType);
                    InstrumentedMemoryCache<CacheKey, CloseableImage> bitmapMemoryCache = getBitmapMemoryCache();
                    InstrumentedMemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache = getEncodedMemoryCache();
                    BufferedDiskCache mainBufferedDiskCache = getMainBufferedDiskCache();
                    BufferedDiskCache smallImageBufferedDiskCache = getSmallImageBufferedDiskCache();
                    CacheKeyFactory cacheKeyFactory = this.mConfig.mCacheKeyFactory;
                    PlatformBitmapFactory platformBitmapFactory = getPlatformBitmapFactory();
                    ImagePipelineExperiments imagePipelineExperiments = this.mConfig.mImagePipelineExperiments;
                    imagePipeline2 = imagePipeline;
                    int i = imagePipelineExperiments.mBitmapPrepareToDrawMinSizeBytes;
                    z = z2;
                    int i2 = imagePipelineExperiments.mBitmapPrepareToDrawMaxSizeBytes;
                    contentResolver = contentResolver2;
                    boolean z6 = imagePipelineExperiments.mBitmapPrepareToDrawForPrefetch;
                    int i3 = imagePipelineExperiments.mMaxBitmapSize;
                    producerSequenceFactory2 = producerSequenceFactory;
                    CloseableReferenceFactory closeableReferenceFactory = this.mCloseableReferenceFactory;
                    if (((ImagePipelineExperiments.DefaultProducerFactoryMethod) producerFactoryMethod) != null) {
                        this.mProducerFactory = new ProducerFactory(context, smallByteArrayPool, imageDecoder4, progressiveJpegConfig, z3, z4, z5, executorSupplier, pooledByteBufferFactory, bitmapMemoryCache, encodedMemoryCache, mainBufferedDiskCache, smallImageBufferedDiskCache, cacheKeyFactory, platformBitmapFactory, i, i2, z6, i3, closeableReferenceFactory);
                    } else {
                        throw null;
                    }
                } else {
                    imagePipeline2 = imagePipeline;
                    producerSequenceFactory2 = producerSequenceFactory;
                    contentResolver = contentResolver2;
                    z = z2;
                }
                ProducerFactory producerFactory = this.mProducerFactory;
                ImagePipelineConfig imagePipelineConfig3 = this.mConfig;
                NetworkFetcher networkFetcher = imagePipelineConfig3.mNetworkFetcher;
                boolean z7 = imagePipelineConfig3.mResizeAndRotateEnabledForNetwork;
                ImagePipelineExperiments imagePipelineExperiments2 = imagePipelineConfig3.mImagePipelineExperiments;
                boolean z8 = imagePipelineExperiments2.mWebpSupportEnabled;
                ThreadHandoffProducerQueue threadHandoffProducerQueue = this.mThreadHandoffProducerQueue;
                boolean z9 = imagePipelineConfig3.mDownsampleEnabled;
                boolean z10 = imagePipelineExperiments2.mPartialImageCachingEnabled;
                boolean z11 = imagePipelineConfig3.mDiskCacheEnabled;
                if (this.mImageTranscoderFactory == null) {
                    if (imagePipelineConfig3.mImageTranscoderFactory == null && imagePipelineConfig3.mImageTranscoderType == null && imagePipelineExperiments2.mNativeCodeDisabled) {
                        this.mImageTranscoderFactory = new SimpleImageTranscoderFactory(imagePipelineExperiments2.mMaxBitmapSize);
                    } else {
                        ImagePipelineConfig imagePipelineConfig4 = this.mConfig;
                        ImagePipelineExperiments imagePipelineExperiments3 = imagePipelineConfig4.mImagePipelineExperiments;
                        this.mImageTranscoderFactory = new MultiImageTranscoderFactory(imagePipelineExperiments3.mMaxBitmapSize, imagePipelineExperiments3.mUseDownsamplingRatioForResizing, imagePipelineConfig4.mImageTranscoderFactory, imagePipelineConfig4.mImageTranscoderType);
                    }
                }
                this.mProducerSequenceFactory = new ProducerSequenceFactory(contentResolver, producerFactory, networkFetcher, z7, z8, threadHandoffProducerQueue, z9, z, z10, z11, this.mImageTranscoderFactory);
            } else {
                imagePipeline2 = imagePipeline;
            }
            ProducerSequenceFactory producerSequenceFactory3 = this.mProducerSequenceFactory;
            Set unmodifiableSet = Collections.unmodifiableSet(this.mConfig.mRequestListeners);
            Supplier<Boolean> supplier = this.mConfig.mIsPrefetchEnabledSupplier;
            InstrumentedMemoryCache<CacheKey, CloseableImage> bitmapMemoryCache2 = getBitmapMemoryCache();
            InstrumentedMemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache2 = getEncodedMemoryCache();
            BufferedDiskCache mainBufferedDiskCache2 = getMainBufferedDiskCache();
            BufferedDiskCache smallImageBufferedDiskCache2 = getSmallImageBufferedDiskCache();
            CacheKeyFactory cacheKeyFactory2 = this.mConfig.mCacheKeyFactory;
            ThreadHandoffProducerQueue threadHandoffProducerQueue2 = this.mThreadHandoffProducerQueue;
            Suppliers$1 suppliers$1 = new Suppliers$1(Boolean.FALSE);
            ImagePipelineConfig imagePipelineConfig5 = this.mConfig;
            this.mImagePipeline = new ImagePipeline(producerSequenceFactory3, unmodifiableSet, supplier, bitmapMemoryCache2, encodedMemoryCache2, mainBufferedDiskCache2, smallImageBufferedDiskCache2, cacheKeyFactory2, threadHandoffProducerQueue2, suppliers$1, imagePipelineConfig5.mImagePipelineExperiments.mLazyDataSource, imagePipelineConfig5.mCallerContextVerifier);
        }
        return this.mImagePipeline;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        if (this.mMainBufferedDiskCache == null) {
            if (this.mMainFileCache == null) {
                ImagePipelineConfig imagePipelineConfig = this.mConfig;
                this.mMainFileCache = ((DiskStorageCacheFactory) imagePipelineConfig.mFileCacheFactory).get(imagePipelineConfig.mMainDiskCacheConfig);
            }
            FileCache fileCache = this.mMainFileCache;
            ImagePipelineConfig imagePipelineConfig2 = this.mConfig;
            this.mMainBufferedDiskCache = new BufferedDiskCache(fileCache, imagePipelineConfig2.mPoolFactory.getPooledByteBufferFactory(imagePipelineConfig2.mMemoryChunkType), this.mConfig.mPoolFactory.getPooledByteStreams(), this.mConfig.mExecutorSupplier.forLocalStorageRead(), this.mConfig.mExecutorSupplier.forLocalStorageWrite(), this.mConfig.mImageCacheStatsTracker);
        }
        return this.mMainBufferedDiskCache;
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            PoolFactory poolFactory = this.mConfig.mPoolFactory;
            getPlatformDecoder();
            this.mPlatformBitmapFactory = new ArtBitmapFactory(poolFactory.getBitmapPool(), this.mCloseableReferenceFactory);
        }
        return this.mPlatformBitmapFactory;
    }

    public PlatformDecoder getPlatformDecoder() {
        PlatformDecoder platformDecoder;
        if (this.mPlatformDecoder == null) {
            ImagePipelineConfig imagePipelineConfig = this.mConfig;
            PoolFactory poolFactory = imagePipelineConfig.mPoolFactory;
            boolean z = imagePipelineConfig.mImagePipelineExperiments.mGingerbreadDecoderEnabled;
            if (Build.VERSION.SDK_INT >= 26) {
                int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
                platformDecoder = new OreoDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools$SynchronizedPool(flexByteArrayPoolMaxNumThreads));
            } else {
                int flexByteArrayPoolMaxNumThreads2 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
                platformDecoder = new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads2, new Pools$SynchronizedPool(flexByteArrayPoolMaxNumThreads2));
            }
            this.mPlatformDecoder = platformDecoder;
        }
        return this.mPlatformDecoder;
    }

    public final BufferedDiskCache getSmallImageBufferedDiskCache() {
        if (this.mSmallImageBufferedDiskCache == null) {
            if (this.mSmallImageFileCache == null) {
                ImagePipelineConfig imagePipelineConfig = this.mConfig;
                this.mSmallImageFileCache = ((DiskStorageCacheFactory) imagePipelineConfig.mFileCacheFactory).get(imagePipelineConfig.mSmallImageDiskCacheConfig);
            }
            FileCache fileCache = this.mSmallImageFileCache;
            ImagePipelineConfig imagePipelineConfig2 = this.mConfig;
            this.mSmallImageBufferedDiskCache = new BufferedDiskCache(fileCache, imagePipelineConfig2.mPoolFactory.getPooledByteBufferFactory(imagePipelineConfig2.mMemoryChunkType), this.mConfig.mPoolFactory.getPooledByteStreams(), this.mConfig.mExecutorSupplier.forLocalStorageRead(), this.mConfig.mExecutorSupplier.forLocalStorageWrite(), this.mConfig.mImageCacheStatsTracker);
        }
        return this.mSmallImageBufferedDiskCache;
    }
}
