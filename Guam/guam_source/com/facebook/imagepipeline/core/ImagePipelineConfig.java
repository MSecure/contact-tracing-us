package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Set;

public class ImagePipelineConfig {
    public static DefaultImageRequestConfig sDefaultImageRequestConfig = new DefaultImageRequestConfig(null);
    public final Bitmap.Config mBitmapConfig;
    public final Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
    public final CountingMemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
    public final CacheKeyFactory mCacheKeyFactory;
    public final CallerContextVerifier mCallerContextVerifier;
    public final NoOpCloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
    public final Context mContext;
    public final boolean mDiskCacheEnabled;
    public final boolean mDownsampleEnabled;
    public final Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
    public final ExecutorSupplier mExecutorSupplier;
    public final FileCacheFactory mFileCacheFactory;
    public final int mHttpNetworkTimeout;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    public final ImageDecoder mImageDecoder;
    public final ImageDecoderConfig mImageDecoderConfig;
    public final ImagePipelineExperiments mImagePipelineExperiments;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public final Integer mImageTranscoderType;
    public final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    public final DiskCacheConfig mMainDiskCacheConfig;
    public final int mMemoryChunkType;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final NetworkFetcher mNetworkFetcher;
    public final PoolFactory mPoolFactory;
    public final ProgressiveJpegConfig mProgressiveJpegConfig;
    public final Set<RequestListener> mRequestListeners;
    public final boolean mResizeAndRotateEnabledForNetwork;
    public final DiskCacheConfig mSmallImageDiskCacheConfig;

    public static class Builder {
        public NoOpCloseableReferenceLeakTracker mCloseableReferenceLeakTracker = new NoOpCloseableReferenceLeakTracker();
        public final Context mContext;
        public boolean mDiskCacheEnabled = true;
        public boolean mDownsampleEnabled = false;
        public final ImagePipelineExperiments.Builder mExperimentsBuilder = new ImagePipelineExperiments.Builder(this);
        public int mHttpConnectionTimeout = -1;
        public Integer mImageTranscoderType = null;
        public Integer mMemoryChunkType = null;
        public NetworkFetcher mNetworkFetcher;
        public Set<RequestListener> mRequestListeners;
        public boolean mResizeAndRotateEnabledForNetwork = true;

        public Builder(Context context, AnonymousClass1 r4) {
            if (context != null) {
                this.mContext = context;
                return;
            }
            throw null;
        }
    }

    public static class DefaultImageRequestConfig {
        public boolean mProgressiveRenderingEnabled = false;

        public DefaultImageRequestConfig(AnonymousClass1 r1) {
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
    public ImagePipelineConfig(Builder builder, AnonymousClass1 r7) {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        boolean z;
        Integer num;
        WebpBitmapFactory webpBitmapFactory;
        FrescoSystrace.isTracing();
        ImagePipelineExperiments.Builder builder2 = builder.mExperimentsBuilder;
        if (builder2 != null) {
            this.mImagePipelineExperiments = new ImagePipelineExperiments(builder2, null);
            this.mBitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity"));
            this.mBitmapMemoryCacheTrimStrategy = new BitmapMemoryCacheTrimStrategy();
            this.mBitmapConfig = Bitmap.Config.ARGB_8888;
            synchronized (DefaultCacheKeyFactory.class) {
                if (DefaultCacheKeyFactory.sInstance == null) {
                    DefaultCacheKeyFactory.sInstance = new DefaultCacheKeyFactory();
                }
                defaultCacheKeyFactory = DefaultCacheKeyFactory.sInstance;
            }
            this.mCacheKeyFactory = defaultCacheKeyFactory;
            Context context = builder.mContext;
            AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(context);
            this.mContext = context;
            this.mFileCacheFactory = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
            this.mDownsampleEnabled = builder.mDownsampleEnabled;
            this.mEncodedMemoryCacheParamsSupplier = new DefaultEncodedMemoryCacheParamsSupplier();
            synchronized (NoOpImageCacheStatsTracker.class) {
                if (NoOpImageCacheStatsTracker.sInstance == null) {
                    NoOpImageCacheStatsTracker.sInstance = new NoOpImageCacheStatsTracker();
                }
                noOpImageCacheStatsTracker = NoOpImageCacheStatsTracker.sInstance;
            }
            this.mImageCacheStatsTracker = noOpImageCacheStatsTracker;
            this.mImageDecoder = null;
            this.mImageTranscoderFactory = null;
            this.mImageTranscoderType = builder.mImageTranscoderType;
            this.mIsPrefetchEnabledSupplier = new Supplier<Boolean>(this) {
                /* class com.facebook.imagepipeline.core.ImagePipelineConfig.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.facebook.common.internal.Supplier
                public Boolean get() {
                    return Boolean.TRUE;
                }
            };
            int i = 0;
            Context context2 = builder.mContext;
            try {
                FrescoSystrace.isTracing();
                DiskCacheConfig.Builder builder3 = new DiskCacheConfig.Builder(context2, null);
                if (builder3.mBaseDirectoryPathSupplier == null) {
                    if (builder3.mContext == null) {
                        z = false;
                        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(z, "Either a non-null context or a base directory path or supplier must be provided.");
                        if (builder3.mBaseDirectoryPathSupplier == null && builder3.mContext != null) {
                            builder3.mBaseDirectoryPathSupplier = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ab: IPUT  
                                  (wrap: com.facebook.cache.disk.DiskCacheConfig$Builder$1 : 0x00a8: CONSTRUCTOR  (r2v11 com.facebook.cache.disk.DiskCacheConfig$Builder$1) = (r3v0 'builder3' com.facebook.cache.disk.DiskCacheConfig$Builder) call: com.facebook.cache.disk.DiskCacheConfig.Builder.1.<init>(com.facebook.cache.disk.DiskCacheConfig$Builder):void type: CONSTRUCTOR)
                                  (r3v0 'builder3' com.facebook.cache.disk.DiskCacheConfig$Builder)
                                 com.facebook.cache.disk.DiskCacheConfig.Builder.mBaseDirectoryPathSupplier com.facebook.common.internal.Supplier in method: com.facebook.imagepipeline.core.ImagePipelineConfig.<init>(com.facebook.imagepipeline.core.ImagePipelineConfig$Builder, com.facebook.imagepipeline.core.ImagePipelineConfig$1):void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a8: CONSTRUCTOR  (r2v11 com.facebook.cache.disk.DiskCacheConfig$Builder$1) = (r3v0 'builder3' com.facebook.cache.disk.DiskCacheConfig$Builder) call: com.facebook.cache.disk.DiskCacheConfig.Builder.1.<init>(com.facebook.cache.disk.DiskCacheConfig$Builder):void type: CONSTRUCTOR in method: com.facebook.imagepipeline.core.ImagePipelineConfig.<init>(com.facebook.imagepipeline.core.ImagePipelineConfig$Builder, com.facebook.imagepipeline.core.ImagePipelineConfig$1):void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 41 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.cache.disk.DiskCacheConfig, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 45 more
                                */
                            /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
                            /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8  */
                            /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
                            /* JADX WARNING: Removed duplicated region for block: B:44:0x00de  */
                            /* JADX WARNING: Removed duplicated region for block: B:47:0x0106  */
                            /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
                            /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
                            /*
                            // Method dump skipped, instructions count: 352
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipelineConfig.<init>(com.facebook.imagepipeline.core.ImagePipelineConfig$Builder, com.facebook.imagepipeline.core.ImagePipelineConfig$1):void");
                        }
                    }
