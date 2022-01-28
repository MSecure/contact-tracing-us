package com.facebook.react.modules.image;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

@ReactModule(name = ImageLoaderModule.NAME)
public class ImageLoaderModule extends NativeImageLoaderAndroidSpec implements LifecycleEventListener {
    public static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
    public static final String ERROR_INVALID_URI = "E_INVALID_URI";
    public static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
    public static final String NAME = "ImageLoader";
    public final Object mCallerContext;
    public final Object mEnqueuedRequestMonitor;
    public final SparseArray<DataSource<Void>> mEnqueuedRequests;

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray<>();
        this.mCallerContext = this;
    }

    private void registerRequest(int i, DataSource<Void> dataSource) {
        synchronized (this.mEnqueuedRequestMonitor) {
            this.mEnqueuedRequests.put(i, dataSource);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DataSource<Void> removeRequest(int i) {
        DataSource<Void> dataSource;
        synchronized (this.mEnqueuedRequestMonitor) {
            dataSource = this.mEnqueuedRequests.get(i);
            this.mEnqueuedRequests.remove(i);
        }
        return dataSource;
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void abortRequest(double d) {
        DataSource<Void> removeRequest = removeRequest((int) d);
        if (removeRequest != null) {
            removeRequest.close();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSize(String str, final Promise promise) {
        Uri uri;
        if (str == null || str.isEmpty()) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        try {
            uri = Uri.parse(str);
            if (uri.getScheme() == null) {
                uri = ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(reactApplicationContext, str);
            }
        } catch (Exception unused) {
            uri = ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(reactApplicationContext, str);
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(uri);
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), this.mCallerContext, ImageRequest.RequestLevel.FULL_FETCH, null).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>(this) {
            /* class com.facebook.react.modules.image.ImageLoaderModule.AnonymousClass1 */

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, dataSource.getFailureCause());
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                if (dataSource.isFinished()) {
                    CloseableReference<CloseableImage> result = dataSource.getResult();
                    if (result != null) {
                        try {
                            CloseableImage closeableImage = result.get();
                            WritableMap createMap = Arguments.createMap();
                            createMap.putInt(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, closeableImage.getWidth());
                            createMap.putInt(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, closeableImage.getHeight());
                            promise.resolve(createMap);
                        } catch (Exception e) {
                            promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, e);
                        } catch (Throwable th) {
                            result.close();
                            throw th;
                        }
                        result.close();
                        return;
                    }
                    promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE);
                }
            }
        }, CallerThreadExecutor.sInstance);
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSizeWithHeaders(String str, ReadableMap readableMap, final Promise promise) {
        Uri uri;
        if (str == null || str.isEmpty()) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        try {
            uri = Uri.parse(str);
            if (uri.getScheme() == null) {
                uri = ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(reactApplicationContext, str);
            }
        } catch (Exception unused) {
            uri = ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(reactApplicationContext, str);
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(uri);
        Fresco.getImagePipeline().fetchDecodedImage(new ReactNetworkImageRequest(ImageRequestBuilder.newBuilderWithSource(uri), readableMap), this.mCallerContext, ImageRequest.RequestLevel.FULL_FETCH, null).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>(this) {
            /* class com.facebook.react.modules.image.ImageLoaderModule.AnonymousClass2 */

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, dataSource.getFailureCause());
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                if (dataSource.isFinished()) {
                    CloseableReference<CloseableImage> result = dataSource.getResult();
                    if (result != null) {
                        try {
                            CloseableImage closeableImage = result.get();
                            WritableMap createMap = Arguments.createMap();
                            createMap.putInt(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, closeableImage.getWidth());
                            createMap.putInt(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, closeableImage.getHeight());
                            promise.resolve(createMap);
                        } catch (Exception e) {
                            promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, e);
                        } catch (Throwable th) {
                            result.close();
                            throw th;
                        }
                        result.close();
                        return;
                    }
                    promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE);
                }
            }
        }, CallerThreadExecutor.sInstance);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        synchronized (this.mEnqueuedRequestMonitor) {
            int size = this.mEnqueuedRequests.size();
            for (int i = 0; i < size; i++) {
                DataSource<Void> valueAt = this.mEnqueuedRequests.valueAt(i);
                if (valueAt != null) {
                    valueAt.close();
                }
            }
            this.mEnqueuedRequests.clear();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void prefetchImage(String str, double d, final Promise promise) {
        DataSource<Void> dataSource;
        final int i = (int) d;
        if (str == null || str.isEmpty()) {
            promise.reject(ERROR_INVALID_URI, "Cannot prefetch an image for an empty URI");
            return;
        }
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        Object obj = this.mCallerContext;
        Priority priority = Priority.MEDIUM;
        if (!imagePipeline.mIsPrefetchEnabledSupplier.get().booleanValue()) {
            dataSource = AppCompatDelegateImpl.ConfigurationImplApi17.immediateFailedDataSource(ImagePipeline.PREFETCH_EXCEPTION);
        } else {
            try {
                Producer<Void> encodedImagePrefetchProducerSequence = imagePipeline.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(build);
                ImageRequest.RequestLevel requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
                RequestListener requestListenerForRequest = imagePipeline.getRequestListenerForRequest(build, null);
                CallerContextVerifier callerContextVerifier = imagePipeline.mCallerContextVerifier;
                if (callerContextVerifier != null) {
                    callerContextVerifier.verifyCallerContext(obj);
                }
                try {
                    ImageRequest.RequestLevel requestLevel2 = build.mLowestPermittedRequestLevel;
                    dataSource = new ProducerToDataSourceAdapter<>(encodedImagePrefetchProducerSequence, new SettableProducerContext(build, String.valueOf(imagePipeline.mIdCounter.getAndIncrement()), requestListenerForRequest, obj, requestLevel2.mValue > requestLevel.mValue ? requestLevel2 : requestLevel, true, false, priority), requestListenerForRequest);
                } catch (Exception e) {
                    dataSource = AppCompatDelegateImpl.ConfigurationImplApi17.immediateFailedDataSource(e);
                }
            } catch (Exception e2) {
                dataSource = AppCompatDelegateImpl.ConfigurationImplApi17.immediateFailedDataSource(e2);
            }
        }
        AnonymousClass3 r14 = new BaseDataSubscriber<Void>() {
            /* class com.facebook.react.modules.image.ImageLoaderModule.AnonymousClass3 */

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<Void> dataSource) {
                try {
                    ImageLoaderModule.this.removeRequest(i);
                    promise.reject(ImageLoaderModule.ERROR_PREFETCH_FAILURE, dataSource.getFailureCause());
                } finally {
                    dataSource.close();
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onNewResultImpl(DataSource<Void> dataSource) {
                if (dataSource.isFinished()) {
                    try {
                        ImageLoaderModule.this.removeRequest(i);
                        promise.resolve(Boolean.TRUE);
                    } finally {
                        dataSource.close();
                    }
                }
            }
        };
        registerRequest(i, dataSource);
        dataSource.subscribe(r14, CallerThreadExecutor.sInstance);
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void queryCache(final ReadableArray readableArray, final Promise promise) {
        new GuardedAsyncTask<Void, Void>(this, getReactApplicationContext()) {
            /* class com.facebook.react.modules.image.ImageLoaderModule.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void[] voidArr) {
                WritableMap createMap = Arguments.createMap();
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                for (int i = 0; i < readableArray.size(); i++) {
                    String string = readableArray.getString(i);
                    Uri parse = Uri.parse(string);
                    if (imagePipeline != null) {
                        if (parse == null ? false : imagePipeline.mBitmapMemoryCache.contains(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: TERNARY(r5v0 boolean) = ((r4v0 'parse' android.net.Uri) == (null android.net.Uri)) ? false : (wrap: boolean : 0x002b: INVOKE  (r5v2 boolean) = 
                              (wrap: com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> : 0x0029: IGET  (r6v0 com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage>) = (r0v0 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline) com.facebook.imagepipeline.core.ImagePipeline.mBitmapMemoryCache com.facebook.imagepipeline.cache.MemoryCache)
                              (wrap: com.facebook.imagepipeline.core.ImagePipeline$7 : 0x0026: CONSTRUCTOR  (r5v1 com.facebook.imagepipeline.core.ImagePipeline$7) = (r0v0 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline), (r4v0 'parse' android.net.Uri) call: com.facebook.imagepipeline.core.ImagePipeline.7.<init>(com.facebook.imagepipeline.core.ImagePipeline, android.net.Uri):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.facebook.imagepipeline.cache.MemoryCache.contains(com.facebook.common.internal.Predicate):boolean) in method: com.facebook.react.modules.image.ImageLoaderModule.4.doInBackgroundGuarded(java.lang.Void[]):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:114)
                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:56)
                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:45)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:141)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:210)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: INVOKE  (r5v2 boolean) = 
                              (wrap: com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> : 0x0029: IGET  (r6v0 com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage>) = (r0v0 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline) com.facebook.imagepipeline.core.ImagePipeline.mBitmapMemoryCache com.facebook.imagepipeline.cache.MemoryCache)
                              (wrap: com.facebook.imagepipeline.core.ImagePipeline$7 : 0x0026: CONSTRUCTOR  (r5v1 com.facebook.imagepipeline.core.ImagePipeline$7) = (r0v0 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline), (r4v0 'parse' android.net.Uri) call: com.facebook.imagepipeline.core.ImagePipeline.7.<init>(com.facebook.imagepipeline.core.ImagePipeline, android.net.Uri):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.facebook.imagepipeline.cache.MemoryCache.contains(com.facebook.common.internal.Predicate):boolean in method: com.facebook.react.modules.image.ImageLoaderModule.4.doInBackgroundGuarded(java.lang.Void[]):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:854)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:477)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 28 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: CONSTRUCTOR  (r5v1 com.facebook.imagepipeline.core.ImagePipeline$7) = (r0v0 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline), (r4v0 'parse' android.net.Uri) call: com.facebook.imagepipeline.core.ImagePipeline.7.<init>(com.facebook.imagepipeline.core.ImagePipeline, android.net.Uri):void type: CONSTRUCTOR in method: com.facebook.react.modules.image.ImageLoaderModule.4.doInBackgroundGuarded(java.lang.Void[]):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 33 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.imagepipeline.core.ImagePipeline, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 39 more
                            */
                        /*
                            this = this;
                            java.lang.Void[] r8 = (java.lang.Void[]) r8
                            com.facebook.react.bridge.WritableMap r8 = com.facebook.react.bridge.Arguments.createMap()
                            com.facebook.imagepipeline.core.ImagePipeline r0 = com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline()
                            r1 = 0
                            r2 = r1
                        L_0x000c:
                            com.facebook.react.bridge.ReadableArray r3 = r3
                            int r3 = r3.size()
                            if (r2 >= r3) goto L_0x0047
                            com.facebook.react.bridge.ReadableArray r3 = r3
                            java.lang.String r3 = r3.getString(r2)
                            android.net.Uri r4 = android.net.Uri.parse(r3)
                            if (r0 == 0) goto L_0x0045
                            if (r4 != 0) goto L_0x0024
                            r5 = r1
                            goto L_0x002f
                        L_0x0024:
                            com.facebook.imagepipeline.core.ImagePipeline$7 r5 = new com.facebook.imagepipeline.core.ImagePipeline$7
                            r5.<init>(r0, r4)
                            com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r6 = r0.mBitmapMemoryCache
                            boolean r5 = r6.contains(r5)
                        L_0x002f:
                            if (r5 == 0) goto L_0x0037
                            java.lang.String r4 = "memory"
                            r8.putString(r3, r4)
                            goto L_0x0042
                        L_0x0037:
                            boolean r4 = r0.isInDiskCacheSync(r4)
                            if (r4 == 0) goto L_0x0042
                            java.lang.String r4 = "disk"
                            r8.putString(r3, r4)
                        L_0x0042:
                            int r2 = r2 + 1
                            goto L_0x000c
                        L_0x0045:
                            r8 = 0
                            throw r8
                        L_0x0047:
                            com.facebook.react.bridge.Promise r0 = r4
                            r0.resolve(r8)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.image.ImageLoaderModule.AnonymousClass4.doInBackgroundGuarded(java.lang.Object[]):void");
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }

            public ImageLoaderModule(ReactApplicationContext reactApplicationContext, Object obj) {
                super(reactApplicationContext);
                this.mEnqueuedRequestMonitor = new Object();
                this.mEnqueuedRequests = new SparseArray<>();
                this.mCallerContext = obj;
            }
        }
