package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper$MultiSourceResult;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReactImageView extends GenericDraweeView {
    public static float[] sComputedCornerRadii = new float[4];
    public static final Matrix sInverse = new Matrix();
    public static final Matrix sMatrix = new Matrix();
    public static final Matrix sTileMatrix = new Matrix();
    public int mBackgroundColor;
    public RoundedColorDrawable mBackgroundImageDrawable;
    public int mBorderColor;
    public float[] mBorderCornerRadii;
    public float mBorderRadius;
    public float mBorderWidth;
    public ImageSource mCachedImageSource;
    public Object mCallerContext;
    public ControllerListener mControllerForTesting;
    public ControllerListener mControllerListener;
    public Drawable mDefaultImageDrawable;
    public final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    public int mFadeDurationMs;
    public GlobalImageLoadListener mGlobalImageLoadListener;
    public ReadableMap mHeaders;
    public ImageSource mImageSource;
    public boolean mIsDirty;
    public IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;
    public Drawable mLoadingImageDrawable;
    public int mOverlayColor;
    public boolean mProgressiveRenderingEnabled;
    public ImageResizeMethod mResizeMethod;
    public final RoundedCornerPostprocessor mRoundedCornerPostprocessor;
    public ScalingUtils$ScaleType mScaleType;
    public final List<ImageSource> mSources;
    public Shader.TileMode mTileMode;
    public final TilePostprocessor mTilePostprocessor;

    public class RoundedCornerPostprocessor extends BasePostprocessor {
        public RoundedCornerPostprocessor(AnonymousClass1 r2) {
        }

        @Override // com.facebook.imagepipeline.request.BasePostprocessor
        public void process(Bitmap bitmap, Bitmap bitmap2) {
            ReactImageView.this.cornerRadii(ReactImageView.sComputedCornerRadii);
            bitmap.setHasAlpha(true);
            if (!AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(ReactImageView.sComputedCornerRadii[0], BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) || !AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(ReactImageView.sComputedCornerRadii[1], BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) || !AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(ReactImageView.sComputedCornerRadii[2], BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) || !AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(ReactImageView.sComputedCornerRadii[3], BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                Canvas canvas = new Canvas(bitmap);
                float[] fArr = new float[8];
                float[] fArr2 = ReactImageView.sComputedCornerRadii;
                ((ScalingUtils$AbstractScaleType) ReactImageView.this.mScaleType).getTransform(ReactImageView.sMatrix, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), bitmap2.getWidth(), bitmap2.getHeight(), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                ReactImageView.sMatrix.invert(ReactImageView.sInverse);
                fArr[0] = ReactImageView.sInverse.mapRadius(fArr2[0]);
                fArr[1] = fArr[0];
                fArr[2] = ReactImageView.sInverse.mapRadius(fArr2[1]);
                fArr[3] = fArr[2];
                fArr[4] = ReactImageView.sInverse.mapRadius(fArr2[2]);
                fArr[5] = fArr[4];
                fArr[6] = ReactImageView.sInverse.mapRadius(fArr2[3]);
                fArr[7] = fArr[6];
                Path path = new Path();
                path.addRoundRect(new RectF(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) bitmap2.getWidth(), (float) bitmap2.getHeight()), fArr, Path.Direction.CW);
                canvas.drawPath(path, paint);
                return;
            }
            super.process(bitmap, bitmap2);
        }
    }

    public class TilePostprocessor extends BasePostprocessor {
        public TilePostprocessor(AnonymousClass1 r2) {
        }

        @Override // com.facebook.imagepipeline.request.Postprocessor, com.facebook.imagepipeline.request.BasePostprocessor
        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ((ScalingUtils$AbstractScaleType) ReactImageView.this.mScaleType).getTransform(ReactImageView.sTileMatrix, rect, bitmap.getWidth(), bitmap.getHeight(), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = ReactImageView.this.mTileMode;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(ReactImageView.sTileMatrix);
            paint.setShader(bitmapShader);
            int width = ReactImageView.this.getWidth();
            int height = ReactImageView.this.getHeight();
            if (platformBitmapFactory != null) {
                CloseableReference<Bitmap> createBitmapInternal = platformBitmapFactory.createBitmapInternal(width, height, Bitmap.Config.ARGB_8888);
                try {
                    new Canvas(createBitmapInternal.get()).drawRect(rect, paint);
                    CloseableReference<Bitmap> clone = createBitmapInternal.clone();
                    createBitmapInternal.close();
                    return clone;
                } catch (Throwable th) {
                    CloseableReference.closeSafely(createBitmapInternal);
                    throw th;
                }
            } else {
                throw null;
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        super(context, r0.build());
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        RoundingParams roundingParams = new RoundingParams();
        if (roundingParams.mCornersRadii == null) {
            roundingParams.mCornersRadii = new float[8];
        }
        Arrays.fill(roundingParams.mCornersRadii, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        genericDraweeHierarchyBuilder.mRoundingParams = roundingParams;
        this.mResizeMethod = ImageResizeMethod.AUTO;
        this.mBackgroundColor = 0;
        this.mBorderRadius = Float.NaN;
        this.mTileMode = Shader.TileMode.CLAMP;
        this.mFadeDurationMs = -1;
        this.mScaleType = ScalingUtils$ScaleType.CENTER_CROP;
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mRoundedCornerPostprocessor = new RoundedCornerPostprocessor(null);
        this.mTilePostprocessor = new TilePostprocessor(null);
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
        this.mSources = new LinkedList();
    }

    public final void cornerRadii(float[] fArr) {
        float f = !ReactYogaConfigProvider.isUndefined(this.mBorderRadius) ? this.mBorderRadius : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        float[] fArr2 = this.mBorderCornerRadii;
        fArr[0] = (fArr2 == null || ReactYogaConfigProvider.isUndefined(fArr2[0])) ? f : this.mBorderCornerRadii[0];
        float[] fArr3 = this.mBorderCornerRadii;
        fArr[1] = (fArr3 == null || ReactYogaConfigProvider.isUndefined(fArr3[1])) ? f : this.mBorderCornerRadii[1];
        float[] fArr4 = this.mBorderCornerRadii;
        fArr[2] = (fArr4 == null || ReactYogaConfigProvider.isUndefined(fArr4[2])) ? f : this.mBorderCornerRadii[2];
        float[] fArr5 = this.mBorderCornerRadii;
        if (fArr5 != null && !ReactYogaConfigProvider.isUndefined(fArr5[3])) {
            f = this.mBorderCornerRadii[3];
        }
        fArr[3] = f;
    }

    public final boolean hasMultipleSources() {
        return this.mSources.size() > 1;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public final boolean isTiled() {
        return this.mTileMode != Shader.TileMode.CLAMP;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0109 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010a  */
    public void maybeUpdateView() {
        ImageSource imageSource;
        boolean z;
        int i;
        Postprocessor postprocessor;
        MultiSourceHelper$MultiSourceResult multiSourceHelper$MultiSourceResult;
        RoundingParams.RoundingMethod roundingMethod = RoundingParams.RoundingMethod.BITMAP_ONLY;
        if (this.mIsDirty) {
            if (!hasMultipleSources() || (getWidth() > 0 && getHeight() > 0)) {
                this.mImageSource = null;
                if (this.mSources.isEmpty()) {
                    this.mSources.add(new ImageSource(getContext(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII="));
                } else if (hasMultipleSources()) {
                    int width = getWidth();
                    int height = getHeight();
                    List<ImageSource> list = this.mSources;
                    if (list.isEmpty()) {
                        multiSourceHelper$MultiSourceResult = new MultiSourceHelper$MultiSourceResult(null, null, null);
                    } else if (list.size() == 1) {
                        multiSourceHelper$MultiSourceResult = new MultiSourceHelper$MultiSourceResult(list.get(0), null, null);
                    } else if (width <= 0 || height <= 0) {
                        multiSourceHelper$MultiSourceResult = new MultiSourceHelper$MultiSourceResult(null, null, null);
                    } else {
                        ImagePipeline imagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
                        double d = 1.0d;
                        double d2 = ((double) (width * height)) * 1.0d;
                        Iterator<ImageSource> it = list.iterator();
                        double d3 = Double.MAX_VALUE;
                        ImageSource imageSource2 = null;
                        ImageSource imageSource3 = null;
                        double d4 = Double.MAX_VALUE;
                        while (it.hasNext()) {
                            ImageSource next = it.next();
                            double abs = Math.abs(d - (next.mSize / d2));
                            if (abs < d3) {
                                d3 = abs;
                                imageSource2 = next;
                            }
                            if (abs < d4) {
                                Uri uri = next.getUri();
                                if (imagePipeline == null) {
                                    throw null;
                                } else if (imagePipeline.mBitmapMemoryCache.contains(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ba: INVOKE  (r11v10 boolean) = 
                                      (wrap: com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> : 0x00b8: IGET  (r11v9 com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage>) = (r8v11 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline) com.facebook.imagepipeline.core.ImagePipeline.mBitmapMemoryCache com.facebook.imagepipeline.cache.MemoryCache)
                                      (wrap: com.facebook.imagepipeline.core.ImagePipeline$7 : 0x00b5: CONSTRUCTOR  (r12v3 com.facebook.imagepipeline.core.ImagePipeline$7) = (r8v11 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline), (r11v8 'uri' android.net.Uri) call: com.facebook.imagepipeline.core.ImagePipeline.7.<init>(com.facebook.imagepipeline.core.ImagePipeline, android.net.Uri):void type: CONSTRUCTOR)
                                     type: INTERFACE call: com.facebook.imagepipeline.cache.MemoryCache.contains(com.facebook.common.internal.Predicate):boolean in method: com.facebook.react.views.image.ReactImageView.maybeUpdateView():void, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:94)
                                    	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:116)
                                    	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:56)
                                    	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:83)
                                    	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:150)
                                    	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:69)
                                    	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:45)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:141)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b5: CONSTRUCTOR  (r12v3 com.facebook.imagepipeline.core.ImagePipeline$7) = (r8v11 'imagePipeline' com.facebook.imagepipeline.core.ImagePipeline), (r11v8 'uri' android.net.Uri) call: com.facebook.imagepipeline.core.ImagePipeline.7.<init>(com.facebook.imagepipeline.core.ImagePipeline, android.net.Uri):void type: CONSTRUCTOR in method: com.facebook.react.views.image.ReactImageView.maybeUpdateView():void, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 60 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.imagepipeline.core.ImagePipeline, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 66 more
                                    */
                                /* JADX WARNING: Removed duplicated region for block: B:51:0x0109 A[RETURN] */
                                /* JADX WARNING: Removed duplicated region for block: B:52:0x010a  */
                                /*
                                // Method dump skipped, instructions count: 893
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ReactImageView.maybeUpdateView():void");
                            }

                            public void onSizeChanged(int i, int i2, int i3, int i4) {
                                super.onSizeChanged(i, i2, i3, i4);
                                if (i > 0 && i2 > 0) {
                                    this.mIsDirty = this.mIsDirty || hasMultipleSources() || isTiled();
                                    maybeUpdateView();
                                }
                            }

                            public void setBackgroundColor(int i) {
                                if (this.mBackgroundColor != i) {
                                    this.mBackgroundColor = i;
                                    this.mBackgroundImageDrawable = new RoundedColorDrawable(i);
                                    this.mIsDirty = true;
                                }
                            }

                            public void setBlurRadius(float f) {
                                int pixelFromDIP = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f);
                                if (pixelFromDIP == 0) {
                                    this.mIterativeBoxBlurPostProcessor = null;
                                } else {
                                    this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor(pixelFromDIP);
                                }
                                this.mIsDirty = true;
                            }

                            public void setBorderColor(int i) {
                                this.mBorderColor = i;
                                this.mIsDirty = true;
                            }

                            public void setBorderRadius(float f) {
                                if (!AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(this.mBorderRadius, f)) {
                                    this.mBorderRadius = f;
                                    this.mIsDirty = true;
                                }
                            }

                            public void setBorderWidth(float f) {
                                this.mBorderWidth = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f);
                                this.mIsDirty = true;
                            }

                            public void setControllerListener(ControllerListener controllerListener) {
                                this.mControllerForTesting = controllerListener;
                                this.mIsDirty = true;
                                maybeUpdateView();
                            }

                            public void setDefaultSource(String str) {
                                ResourceDrawableIdHelper instance = ResourceDrawableIdHelper.getInstance();
                                Context context = getContext();
                                int resourceDrawableId = instance.getResourceDrawableId(context, str);
                                this.mDefaultImageDrawable = resourceDrawableId > 0 ? context.getResources().getDrawable(resourceDrawableId) : null;
                                this.mIsDirty = true;
                            }

                            public void setFadeDuration(int i) {
                                this.mFadeDurationMs = i;
                            }

                            public void setHeaders(ReadableMap readableMap) {
                                this.mHeaders = readableMap;
                            }

                            public void setLoadingIndicatorSource(String str) {
                                ResourceDrawableIdHelper instance = ResourceDrawableIdHelper.getInstance();
                                Context context = getContext();
                                int resourceDrawableId = instance.getResourceDrawableId(context, str);
                                AutoRotateDrawable autoRotateDrawable = null;
                                Drawable drawable = resourceDrawableId > 0 ? context.getResources().getDrawable(resourceDrawableId) : null;
                                if (drawable != null) {
                                    autoRotateDrawable = new AutoRotateDrawable(drawable, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
                                }
                                this.mLoadingImageDrawable = autoRotateDrawable;
                                this.mIsDirty = true;
                            }

                            public void setOverlayColor(int i) {
                                this.mOverlayColor = i;
                                this.mIsDirty = true;
                            }

                            public void setProgressiveRenderingEnabled(boolean z) {
                                this.mProgressiveRenderingEnabled = z;
                            }

                            public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
                                this.mResizeMethod = imageResizeMethod;
                                this.mIsDirty = true;
                            }

                            public void setScaleType(ScalingUtils$ScaleType scalingUtils$ScaleType) {
                                this.mScaleType = scalingUtils$ScaleType;
                                this.mIsDirty = true;
                            }

                            public void setShouldNotifyLoadEvents(boolean z) {
                                if (!z) {
                                    this.mControllerListener = null;
                                } else {
                                    final EventDispatcher eventDispatcherForReactTag = ReactYogaConfigProvider.getEventDispatcherForReactTag((ReactContext) getContext(), getId());
                                    this.mControllerListener = new BaseControllerListener<ImageInfo>() {
                                        /* class com.facebook.react.views.image.ReactImageView.AnonymousClass1 */

                                        @Override // com.facebook.drawee.controller.ControllerListener, com.facebook.drawee.controller.BaseControllerListener
                                        public void onFailure(String str, Throwable th) {
                                            eventDispatcherForReactTag.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 1, true, th.getMessage()));
                                        }

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.Object, android.graphics.drawable.Animatable] */
                                        @Override // com.facebook.drawee.controller.ControllerListener, com.facebook.drawee.controller.BaseControllerListener
                                        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                                            ImageInfo imageInfo2 = imageInfo;
                                            if (imageInfo2 != null) {
                                                eventDispatcherForReactTag.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 2, ReactImageView.this.mImageSource.mSource, imageInfo2.getWidth(), imageInfo2.getHeight()));
                                                eventDispatcherForReactTag.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
                                            }
                                        }

                                        @Override // com.facebook.drawee.controller.ControllerListener, com.facebook.drawee.controller.BaseControllerListener
                                        public void onSubmit(String str, Object obj) {
                                            eventDispatcherForReactTag.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 4));
                                        }
                                    };
                                }
                                this.mIsDirty = true;
                            }

                            public void setSource(ReadableArray readableArray) {
                                this.mSources.clear();
                                if (readableArray == null || readableArray.size() == 0) {
                                    this.mSources.add(new ImageSource(getContext(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII="));
                                } else {
                                    if (readableArray.size() == 1) {
                                        ImageSource imageSource = new ImageSource(getContext(), readableArray.getMap(0).getString(NetworkingModule.REQUEST_BODY_KEY_URI));
                                        this.mSources.add(imageSource);
                                        if (Uri.EMPTY.equals(imageSource.getUri())) {
                                            warnImageSource();
                                        }
                                    } else {
                                        for (int i = 0; i < readableArray.size(); i++) {
                                            ReadableMap map = readableArray.getMap(i);
                                            ImageSource imageSource2 = new ImageSource(getContext(), map.getString(NetworkingModule.REQUEST_BODY_KEY_URI), map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH), map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT));
                                            this.mSources.add(imageSource2);
                                            if (Uri.EMPTY.equals(imageSource2.getUri())) {
                                                warnImageSource();
                                            }
                                        }
                                    }
                                }
                                this.mIsDirty = true;
                            }

                            public void setTileMode(Shader.TileMode tileMode) {
                                this.mTileMode = tileMode;
                                this.mIsDirty = true;
                            }

                            public final void warnImageSource() {
                            }
                        }
