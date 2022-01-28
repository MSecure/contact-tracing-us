package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources$1;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {
    public static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    public static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener<Object>() {
        /* class com.facebook.drawee.controller.AbstractDraweeControllerBuilder.AnonymousClass1 */

        @Override // com.facebook.drawee.controller.ControllerListener, com.facebook.drawee.controller.BaseControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    public static final AtomicLong sIdCounter = new AtomicLong();
    public boolean mAutoPlayAnimations;
    public final Set<ControllerListener> mBoundControllerListeners;
    public Object mCallerContext;
    public String mContentDescription;
    public final Context mContext;
    public ControllerListener<? super INFO> mControllerListener;
    public ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    public REQUEST mImageRequest;
    public REQUEST mLowResImageRequest;
    public REQUEST[] mMultiImageRequests;
    public DraweeController mOldController;
    public boolean mTapToRetryEnabled;
    public boolean mTryCacheOnlyFirst;

    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        init();
    }

    /* JADX INFO: finally extract failed */
    public AbstractDraweeController build() {
        PipelineDraweeController pipelineDraweeController;
        REQUEST request;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(this.mMultiImageRequests == null || this.mImageRequest == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(true, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        CacheKey cacheKey = null;
        if (this.mImageRequest == null && this.mMultiImageRequests == null && (request = this.mLowResImageRequest) != null) {
            this.mImageRequest = request;
            this.mLowResImageRequest = null;
        }
        FrescoSystrace.isTracing();
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) this;
        FrescoSystrace.isTracing();
        try {
            DraweeController draweeController = pipelineDraweeControllerBuilder.mOldController;
            String valueOf = String.valueOf(sIdCounter.getAndIncrement());
            if (draweeController instanceof PipelineDraweeController) {
                pipelineDraweeController = (PipelineDraweeController) draweeController;
            } else {
                PipelineDraweeControllerFactory pipelineDraweeControllerFactory = pipelineDraweeControllerBuilder.mPipelineDraweeControllerFactory;
                PipelineDraweeController pipelineDraweeController2 = new PipelineDraweeController(pipelineDraweeControllerFactory.mResources, pipelineDraweeControllerFactory.mDeferredReleaser, pipelineDraweeControllerFactory.mAnimatedDrawableFactory, pipelineDraweeControllerFactory.mUiThreadExecutor, pipelineDraweeControllerFactory.mMemoryCache, pipelineDraweeControllerFactory.mDrawableFactories);
                Supplier<Boolean> supplier = pipelineDraweeControllerFactory.mDebugOverlayEnabledSupplier;
                if (supplier != null) {
                    pipelineDraweeController2.mDrawDebugOverlay = supplier.get().booleanValue();
                }
                pipelineDraweeController = pipelineDraweeController2;
            }
            Supplier<DataSource<IMAGE>> obtainDataSourceSupplier = pipelineDraweeControllerBuilder.obtainDataSourceSupplier(pipelineDraweeController, valueOf);
            REQUEST request2 = pipelineDraweeControllerBuilder.mImageRequest;
            CacheKeyFactory cacheKeyFactory = pipelineDraweeControllerBuilder.mImagePipeline.mCacheKeyFactory;
            if (!(cacheKeyFactory == null || request2 == null)) {
                cacheKey = request2.mPostprocessor != null ? ((DefaultCacheKeyFactory) cacheKeyFactory).getPostprocessedBitmapCacheKey(request2, pipelineDraweeControllerBuilder.mCallerContext) : ((DefaultCacheKeyFactory) cacheKeyFactory).getBitmapCacheKey(request2, pipelineDraweeControllerBuilder.mCallerContext);
            }
            pipelineDraweeController.initialize(obtainDataSourceSupplier, valueOf, cacheKey, pipelineDraweeControllerBuilder.mCallerContext, null, null);
            pipelineDraweeController.initializePerformanceMonitoring(pipelineDraweeControllerBuilder.mImagePerfDataListener);
            FrescoSystrace.isTracing();
            pipelineDraweeController.mRetainImageOnFailure = false;
            pipelineDraweeController.mContentDescription = this.mContentDescription;
            if (this.mTapToRetryEnabled) {
                if (pipelineDraweeController.mRetryManager == null) {
                    pipelineDraweeController.mRetryManager = new RetryManager();
                }
                pipelineDraweeController.mRetryManager.mTapToRetryEnabled = this.mTapToRetryEnabled;
                if (pipelineDraweeController.mGestureDetector == null) {
                    GestureDetector gestureDetector = new GestureDetector(this.mContext);
                    pipelineDraweeController.mGestureDetector = gestureDetector;
                    gestureDetector.mClickListener = pipelineDraweeController;
                }
            }
            Set<ControllerListener> set = this.mBoundControllerListeners;
            if (set != null) {
                for (ControllerListener controllerListener : set) {
                    pipelineDraweeController.addControllerListener(controllerListener);
                }
            }
            ControllerListener<? super INFO> controllerListener2 = this.mControllerListener;
            if (controllerListener2 != null) {
                pipelineDraweeController.addControllerListener(controllerListener2);
            }
            if (this.mAutoPlayAnimations) {
                pipelineDraweeController.addControllerListener(sAutoPlayAnimationsListener);
            }
            FrescoSystrace.isTracing();
            return pipelineDraweeController;
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final DraweeController draweeController, final String str, final REQUEST request) {
        final CacheLevel cacheLevel = CacheLevel.FULL_FETCH;
        final Object obj = this.mCallerContext;
        return new Supplier<DataSource<IMAGE>>() {
            /* class com.facebook.drawee.controller.AbstractDraweeControllerBuilder.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: com.facebook.imagepipeline.listener.ForwardingRequestListener */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.Supplier
            public Object get() {
                ImageRequest.RequestLevel requestLevel;
                AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = AbstractDraweeControllerBuilder.this;
                DraweeController draweeController = r14;
                Object obj = r10;
                Object obj2 = r11;
                CacheLevel cacheLevel = r12;
                PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) abstractDraweeControllerBuilder;
                ImageOriginRequestListener imageOriginRequestListener = null;
                if (pipelineDraweeControllerBuilder != null) {
                    ImageRequest imageRequest = (ImageRequest) obj;
                    ImagePipeline imagePipeline = pipelineDraweeControllerBuilder.mImagePipeline;
                    int ordinal = cacheLevel.ordinal();
                    if (ordinal == 0) {
                        requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
                    } else if (ordinal == 1) {
                        requestLevel = ImageRequest.RequestLevel.DISK_CACHE;
                    } else if (ordinal == 2) {
                        requestLevel = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
                    } else {
                        throw new RuntimeException("Cache level" + cacheLevel + "is not supported. ");
                    }
                    if (draweeController instanceof PipelineDraweeController) {
                        PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) draweeController;
                        synchronized (pipelineDraweeController) {
                            if (pipelineDraweeController.mImageOriginListener != null) {
                                imageOriginRequestListener = new ImageOriginRequestListener(pipelineDraweeController.mId, pipelineDraweeController.mImageOriginListener);
                            }
                            if (pipelineDraweeController.mRequestListeners != null) {
                                ForwardingRequestListener forwardingRequestListener = new ForwardingRequestListener(pipelineDraweeController.mRequestListeners);
                                if (imageOriginRequestListener != null) {
                                    forwardingRequestListener.mRequestListeners.add(imageOriginRequestListener);
                                }
                                imageOriginRequestListener = forwardingRequestListener;
                            }
                        }
                    }
                    return imagePipeline.fetchDecodedImage(imageRequest, obj2, requestLevel, imageOriginRequestListener);
                }
                throw null;
            }

            public String toString() {
                Objects$ToStringHelper stringHelper = AppCompatDelegateImpl.ConfigurationImplApi17.toStringHelper(this);
                stringHelper.addHolder("request", r10.toString());
                return stringHelper.toString();
            }
        };
    }

    public final void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(final DraweeController draweeController, final String str) {
        Supplier<DataSource<IMAGE>> supplier;
        REQUEST request = this.mImageRequest;
        if (request != null) {
            supplier = getDataSourceSupplierForRequest(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.mMultiImageRequests;
            if (requestArr != null) {
                boolean z = this.mTryCacheOnlyFirst;
                ArrayList arrayList = new ArrayList(requestArr.length * 2);
                if (z) {
                    for (final REQUEST request2 : requestArr) {
                        final CacheLevel cacheLevel = CacheLevel.BITMAP_MEMORY_CACHE;
                        final Object obj = this.mCallerContext;
                        arrayList.add(new Supplier<DataSource<IMAGE>>() {
                            /* class com.facebook.drawee.controller.AbstractDraweeControllerBuilder.AnonymousClass2 */

                            /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: com.facebook.imagepipeline.listener.ForwardingRequestListener */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.facebook.common.internal.Supplier
                            public Object get() {
                                ImageRequest.RequestLevel requestLevel;
                                AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = AbstractDraweeControllerBuilder.this;
                                DraweeController draweeController = draweeController;
                                Object obj = request2;
                                Object obj2 = obj;
                                CacheLevel cacheLevel = cacheLevel;
                                PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) abstractDraweeControllerBuilder;
                                ImageOriginRequestListener imageOriginRequestListener = null;
                                if (pipelineDraweeControllerBuilder != null) {
                                    ImageRequest imageRequest = (ImageRequest) obj;
                                    ImagePipeline imagePipeline = pipelineDraweeControllerBuilder.mImagePipeline;
                                    int ordinal = cacheLevel.ordinal();
                                    if (ordinal == 0) {
                                        requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
                                    } else if (ordinal == 1) {
                                        requestLevel = ImageRequest.RequestLevel.DISK_CACHE;
                                    } else if (ordinal == 2) {
                                        requestLevel = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
                                    } else {
                                        throw new RuntimeException("Cache level" + cacheLevel + "is not supported. ");
                                    }
                                    if (draweeController instanceof PipelineDraweeController) {
                                        PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) draweeController;
                                        synchronized (pipelineDraweeController) {
                                            if (pipelineDraweeController.mImageOriginListener != null) {
                                                imageOriginRequestListener = new ImageOriginRequestListener(pipelineDraweeController.mId, pipelineDraweeController.mImageOriginListener);
                                            }
                                            if (pipelineDraweeController.mRequestListeners != null) {
                                                ForwardingRequestListener forwardingRequestListener = new ForwardingRequestListener(pipelineDraweeController.mRequestListeners);
                                                if (imageOriginRequestListener != null) {
                                                    forwardingRequestListener.mRequestListeners.add(imageOriginRequestListener);
                                                }
                                                imageOriginRequestListener = forwardingRequestListener;
                                            }
                                        }
                                    }
                                    return imagePipeline.fetchDecodedImage(imageRequest, obj2, requestLevel, imageOriginRequestListener);
                                }
                                throw null;
                            }

                            public String toString() {
                                Objects$ToStringHelper stringHelper = AppCompatDelegateImpl.ConfigurationImplApi17.toStringHelper(this);
                                stringHelper.addHolder("request", request2.toString());
                                return stringHelper.toString();
                            }
                        });
                    }
                }
                for (REQUEST request3 : requestArr) {
                    arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request3));
                }
                supplier = new FirstAvailableDataSourceSupplier<>(arrayList);
            } else {
                supplier = null;
            }
        }
        if (!(supplier == null || this.mLowResImageRequest == null)) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(supplier);
            arrayList2.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            supplier = new IncreasingQualityDataSourceSupplier<>(arrayList2, false);
        }
        return supplier == null ? new DataSources$1(NO_REQUEST_EXCEPTION) : supplier;
    }
}
