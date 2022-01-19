package com.facebook.react.modules.fresco;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.soloader.SoLoader;
import java.io.IOException;
import java.util.HashSet;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

@ReactModule(name = FrescoModule.NAME, needsEagerInit = true)
public class FrescoModule extends ReactContextBaseJavaModule implements LifecycleEventListener, TurboModule {
    public static final String NAME = "FrescoModule";
    public static boolean sHasBeenInitialized = false;
    public final boolean mClearOnDestroy;
    public ImagePipelineConfig mConfig;

    public FrescoModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, true, null);
    }

    public static ImagePipelineConfig getDefaultConfig(ReactContext reactContext) {
        ImagePipelineConfig.Builder defaultConfigBuilder = getDefaultConfigBuilder(reactContext);
        if (defaultConfigBuilder != null) {
            return new ImagePipelineConfig(defaultConfigBuilder, null);
        }
        throw null;
    }

    public static ImagePipelineConfig.Builder getDefaultConfigBuilder(ReactContext reactContext) {
        HashSet hashSet = new HashSet();
        hashSet.add(new SystraceRequestListener());
        OkHttpClient build = AppCompatDelegateImpl.ConfigurationImplApi17.createClientBuilder().build();
        ((CookieJarContainer) build.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(reactContext)));
        ImagePipelineConfig.Builder builder = new ImagePipelineConfig.Builder(reactContext.getApplicationContext(), null);
        builder.mNetworkFetcher = new OkHttpNetworkFetcher(build);
        builder.mNetworkFetcher = new ReactOkHttpNetworkFetcher(build);
        builder.mDownsampleEnabled = false;
        builder.mRequestListeners = hashSet;
        return builder;
    }

    public static boolean hasBeenInitialized() {
        return sHasBeenInitialized;
    }

    public void clearSensitiveData() {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImagePipeline.AnonymousClass4 r1 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r1v0 'r1' com.facebook.imagepipeline.core.ImagePipeline$4) = (r0v0 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline) call: com.facebook.imagepipeline.core.ImagePipeline.4.<init>(com.facebook.imagepipeline.core.ImagePipeline):void type: CONSTRUCTOR in method: com.facebook.react.modules.fresco.FrescoModule.clearSensitiveData():void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.imagepipeline.core.ImagePipeline, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
            this = this;
            com.facebook.imagepipeline.core.ImagePipeline r0 = com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline()
            com.facebook.imagepipeline.core.ImagePipeline$4 r1 = new com.facebook.imagepipeline.core.ImagePipeline$4
            r1.<init>(r0)
            com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r2 = r0.mBitmapMemoryCache
            r2.removeAll(r1)
            com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> r2 = r0.mEncodedMemoryCache
            r2.removeAll(r1)
            com.facebook.imagepipeline.cache.BufferedDiskCache r1 = r0.mMainBufferedDiskCache
            r1.clearAll()
            com.facebook.imagepipeline.cache.BufferedDiskCache r0 = r0.mSmallImageBufferedDiskCache
            r0.clearAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.fresco.FrescoModule.clearSensitiveData():void");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
        getReactApplicationContext().addLifecycleEventListener(this);
        if (!hasBeenInitialized()) {
            if (this.mConfig == null) {
                this.mConfig = getDefaultConfig(getReactApplicationContext());
            }
            Context applicationContext = getReactApplicationContext().getApplicationContext();
            ImagePipelineConfig imagePipelineConfig = this.mConfig;
            FrescoSystrace.isTracing();
            if (Fresco.sIsInitialized) {
                FLog.w(Fresco.TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
            } else {
                Fresco.sIsInitialized = true;
            }
            try {
                FrescoSystrace.isTracing();
                SoLoader.init(applicationContext, 0);
                FrescoSystrace.isTracing();
                Context applicationContext2 = applicationContext.getApplicationContext();
                if (imagePipelineConfig == null) {
                    synchronized (ImagePipelineFactory.class) {
                        FrescoSystrace.isTracing();
                        ImagePipelineFactory.initialize(new ImagePipelineConfig(new ImagePipelineConfig.Builder(applicationContext2, null), null));
                        FrescoSystrace.isTracing();
                    }
                } else {
                    ImagePipelineFactory.initialize(imagePipelineConfig);
                }
                FrescoSystrace.isTracing();
                PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(applicationContext2);
                Fresco.sDraweeControllerBuilderSupplier = pipelineDraweeControllerBuilderSupplier;
                SimpleDraweeView.initialize(pipelineDraweeControllerBuilderSupplier);
                FrescoSystrace.isTracing();
                FrescoSystrace.isTracing();
                sHasBeenInitialized = true;
            } catch (IOException e) {
                FrescoSystrace.isTracing();
                throw new RuntimeException("Could not initialize SoLoader", e);
            }
        } else if (this.mConfig != null) {
            FLog.w("ReactNative", "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
        }
        this.mConfig = null;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        if (hasBeenInitialized() && this.mClearOnDestroy) {
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            ImagePipeline.AnonymousClass4 r1 = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r1v0 'r1' com.facebook.imagepipeline.core.ImagePipeline$4) = (r0v2 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline) call: com.facebook.imagepipeline.core.ImagePipeline.4.<init>(com.facebook.imagepipeline.core.ImagePipeline):void type: CONSTRUCTOR in method: com.facebook.react.modules.fresco.FrescoModule.onHostDestroy():void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.imagepipeline.core.ImagePipeline, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                */
            /*
                this = this;
                boolean r0 = hasBeenInitialized()
                if (r0 == 0) goto L_0x001d
                boolean r0 = r3.mClearOnDestroy
                if (r0 == 0) goto L_0x001d
                com.facebook.imagepipeline.core.ImagePipeline r0 = com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline()
                com.facebook.imagepipeline.core.ImagePipeline$4 r1 = new com.facebook.imagepipeline.core.ImagePipeline$4
                r1.<init>(r0)
                com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r2 = r0.mBitmapMemoryCache
                r2.removeAll(r1)
                com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> r0 = r0.mEncodedMemoryCache
                r0.removeAll(r1)
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.fresco.FrescoModule.onHostDestroy():void");
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostPause() {
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostResume() {
        }

        public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z) {
            this(reactApplicationContext, z, null);
        }

        public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z, ImagePipelineConfig imagePipelineConfig) {
            super(reactApplicationContext);
            this.mClearOnDestroy = z;
            this.mConfig = imagePipelineConfig;
        }
    }
