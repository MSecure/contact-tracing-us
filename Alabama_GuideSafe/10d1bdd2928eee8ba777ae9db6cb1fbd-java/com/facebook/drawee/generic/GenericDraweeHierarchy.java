package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;
import java.util.List;

public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    public final ForwardingDrawable mActualImageWrapper;
    public final Drawable mEmptyActualImageDrawable = new ColorDrawable(0);
    public final FadeDrawable mFadeDrawable;
    public final Resources mResources;
    public RoundingParams mRoundingParams;
    public final RootDrawable mTopLevelDrawable;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i;
        FrescoSystrace.isTracing();
        this.mResources = genericDraweeHierarchyBuilder.mResources;
        this.mRoundingParams = genericDraweeHierarchyBuilder.mRoundingParams;
        this.mActualImageWrapper = new ForwardingDrawable(this.mEmptyActualImageDrawable);
        List<Drawable> list = genericDraweeHierarchyBuilder.mOverlays;
        int size = (list != null ? list.size() : 1) + (genericDraweeHierarchyBuilder.mPressedStateOverlay != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[(size + 6)];
        drawableArr[0] = buildBranch(genericDraweeHierarchyBuilder.mBackground, null);
        drawableArr[1] = buildBranch(genericDraweeHierarchyBuilder.mPlaceholderImage, genericDraweeHierarchyBuilder.mPlaceholderImageScaleType);
        ForwardingDrawable forwardingDrawable = this.mActualImageWrapper;
        ScalingUtils$ScaleType scalingUtils$ScaleType = genericDraweeHierarchyBuilder.mActualImageScaleType;
        PointF pointF = genericDraweeHierarchyBuilder.mActualImageFocusPoint;
        forwardingDrawable.setColorFilter(genericDraweeHierarchyBuilder.mActualImageColorFilter);
        drawableArr[2] = WrappingUtils.maybeWrapWithScaleType(forwardingDrawable, scalingUtils$ScaleType, pointF);
        drawableArr[3] = buildBranch(genericDraweeHierarchyBuilder.mProgressBarImage, genericDraweeHierarchyBuilder.mProgressBarImageScaleType);
        drawableArr[4] = buildBranch(genericDraweeHierarchyBuilder.mRetryImage, genericDraweeHierarchyBuilder.mRetryImageScaleType);
        drawableArr[5] = buildBranch(genericDraweeHierarchyBuilder.mFailureImage, genericDraweeHierarchyBuilder.mFailureImageScaleType);
        if (size > 0) {
            List<Drawable> list2 = genericDraweeHierarchyBuilder.mOverlays;
            if (list2 != null) {
                i = 0;
                for (Drawable drawable : list2) {
                    drawableArr[i + 6] = buildBranch(drawable, null);
                    i++;
                }
            } else {
                i = 1;
            }
            Drawable drawable2 = genericDraweeHierarchyBuilder.mPressedStateOverlay;
            if (drawable2 != null) {
                drawableArr[i + 6] = buildBranch(drawable2, null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr);
        this.mFadeDrawable = fadeDrawable;
        fadeDrawable.mDurationMs = genericDraweeHierarchyBuilder.mFadeDuration;
        if (fadeDrawable.mTransitionState == 1) {
            fadeDrawable.mTransitionState = 0;
        }
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(this.mFadeDrawable, this.mRoundingParams));
        this.mTopLevelDrawable = rootDrawable;
        rootDrawable.mutate();
        resetFade();
        FrescoSystrace.isTracing();
    }

    public final Drawable buildBranch(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources), scalingUtils$ScaleType, null);
    }

    public final void fadeInLayer(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.mFadeDrawable;
            fadeDrawable.mTransitionState = 0;
            fadeDrawable.mIsLayerOn[i] = true;
            fadeDrawable.invalidateSelf();
        }
    }

    public final void fadeOutBranches() {
        fadeOutLayer(1);
        fadeOutLayer(2);
        fadeOutLayer(3);
        fadeOutLayer(4);
        fadeOutLayer(5);
    }

    public final void fadeOutLayer(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.mFadeDrawable;
            fadeDrawable.mTransitionState = 0;
            fadeDrawable.mIsLayerOn[i] = false;
            fadeDrawable.invalidateSelf();
        }
    }

    public final DrawableParent getParentDrawableAtIndex(int i) {
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (fadeDrawable != null) {
            boolean z = true;
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i >= 0);
            if (i >= fadeDrawable.mDrawableParents.length) {
                z = false;
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(z);
            DrawableParent[] drawableParentArr = fadeDrawable.mDrawableParents;
            if (drawableParentArr[i] == null) {
                drawableParentArr[i] = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: APUT  
                      (r1v2 'drawableParentArr' com.facebook.drawee.drawable.DrawableParent[])
                      (r5v0 'i' int)
                      (wrap: com.facebook.drawee.drawable.ArrayDrawable$1 : 0x0020: CONSTRUCTOR  (r2v2 com.facebook.drawee.drawable.ArrayDrawable$1) = (r0v0 'fadeDrawable' com.facebook.drawee.drawable.FadeDrawable), (r5v0 'i' int) call: com.facebook.drawee.drawable.ArrayDrawable.1.<init>(com.facebook.drawee.drawable.ArrayDrawable, int):void type: CONSTRUCTOR)
                     in method: com.facebook.drawee.generic.GenericDraweeHierarchy.getParentDrawableAtIndex(int):com.facebook.drawee.drawable.DrawableParent, file: classes.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: CONSTRUCTOR  (r2v2 com.facebook.drawee.drawable.ArrayDrawable$1) = (r0v0 'fadeDrawable' com.facebook.drawee.drawable.FadeDrawable), (r5v0 'i' int) call: com.facebook.drawee.drawable.ArrayDrawable.1.<init>(com.facebook.drawee.drawable.ArrayDrawable, int):void type: CONSTRUCTOR in method: com.facebook.drawee.generic.GenericDraweeHierarchy.getParentDrawableAtIndex(int):com.facebook.drawee.drawable.DrawableParent, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:416)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 26 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.drawee.drawable.ArrayDrawable, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 30 more
                    */
                /*
                    this = this;
                    com.facebook.drawee.drawable.FadeDrawable r0 = r4.mFadeDrawable
                    if (r0 == 0) goto L_0x0046
                    r1 = 1
                    r2 = 0
                    if (r5 < 0) goto L_0x000a
                    r3 = r1
                    goto L_0x000b
                L_0x000a:
                    r3 = r2
                L_0x000b:
                    androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(r3)
                    com.facebook.drawee.drawable.DrawableParent[] r3 = r0.mDrawableParents
                    int r3 = r3.length
                    if (r5 >= r3) goto L_0x0014
                    goto L_0x0015
                L_0x0014:
                    r1 = r2
                L_0x0015:
                    androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(r1)
                    com.facebook.drawee.drawable.DrawableParent[] r1 = r0.mDrawableParents
                    r2 = r1[r5]
                    if (r2 != 0) goto L_0x0025
                    com.facebook.drawee.drawable.ArrayDrawable$1 r2 = new com.facebook.drawee.drawable.ArrayDrawable$1
                    r2.<init>(r5)
                    r1[r5] = r2
                L_0x0025:
                    com.facebook.drawee.drawable.DrawableParent[] r0 = r0.mDrawableParents
                    r5 = r0[r5]
                    android.graphics.drawable.Drawable r0 = r5.getDrawable()
                    boolean r0 = r0 instanceof com.facebook.drawee.drawable.MatrixDrawable
                    if (r0 == 0) goto L_0x0037
                    android.graphics.drawable.Drawable r5 = r5.getDrawable()
                    com.facebook.drawee.drawable.MatrixDrawable r5 = (com.facebook.drawee.drawable.MatrixDrawable) r5
                L_0x0037:
                    android.graphics.drawable.Drawable r0 = r5.getDrawable()
                    boolean r0 = r0 instanceof com.facebook.drawee.drawable.ScaleTypeDrawable
                    if (r0 == 0) goto L_0x0045
                    android.graphics.drawable.Drawable r5 = r5.getDrawable()
                    com.facebook.drawee.drawable.ScaleTypeDrawable r5 = (com.facebook.drawee.drawable.ScaleTypeDrawable) r5
                L_0x0045:
                    return r5
                L_0x0046:
                    r5 = 0
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.GenericDraweeHierarchy.getParentDrawableAtIndex(int):com.facebook.drawee.drawable.DrawableParent");
            }

            public final ScaleTypeDrawable getScaleTypeDrawableAtIndex(int i) {
                DrawableParent parentDrawableAtIndex = getParentDrawableAtIndex(i);
                if (parentDrawableAtIndex instanceof ScaleTypeDrawable) {
                    return (ScaleTypeDrawable) parentDrawableAtIndex;
                }
                Drawable maybeWrapWithScaleType = WrappingUtils.maybeWrapWithScaleType(parentDrawableAtIndex.setDrawable(WrappingUtils.sEmptyDrawable), ScalingUtils$ScaleType.FIT_XY, null);
                parentDrawableAtIndex.setDrawable(maybeWrapWithScaleType);
                AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(maybeWrapWithScaleType, "Parent has no child drawable!");
                return (ScaleTypeDrawable) maybeWrapWithScaleType;
            }

            @Override // com.facebook.drawee.interfaces.DraweeHierarchy
            public Drawable getTopLevelDrawable() {
                return this.mTopLevelDrawable;
            }

            @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
            public void reset() {
                this.mActualImageWrapper.setCurrent(this.mEmptyActualImageDrawable);
                resetFade();
            }

            public final void resetFade() {
                FadeDrawable fadeDrawable = this.mFadeDrawable;
                if (fadeDrawable != null) {
                    fadeDrawable.beginBatchMode();
                    FadeDrawable fadeDrawable2 = this.mFadeDrawable;
                    fadeDrawable2.mTransitionState = 0;
                    Arrays.fill(fadeDrawable2.mIsLayerOn, true);
                    fadeDrawable2.invalidateSelf();
                    fadeOutBranches();
                    fadeInLayer(1);
                    this.mFadeDrawable.finishTransitionImmediately();
                    this.mFadeDrawable.endBatchMode();
                }
            }

            public final void setChildDrawableAtIndex(int i, Drawable drawable) {
                if (drawable == null) {
                    this.mFadeDrawable.setDrawable(i, null);
                    return;
                }
                getParentDrawableAtIndex(i).setDrawable(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources));
            }

            @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
            public void setControllerOverlay(Drawable drawable) {
                RootDrawable rootDrawable = this.mTopLevelDrawable;
                rootDrawable.mControllerOverlay = drawable;
                rootDrawable.invalidateSelf();
            }

            @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
            public void setFailure(Throwable th) {
                this.mFadeDrawable.beginBatchMode();
                fadeOutBranches();
                if (this.mFadeDrawable.getDrawable(5) != null) {
                    fadeInLayer(5);
                } else {
                    fadeInLayer(1);
                }
                this.mFadeDrawable.endBatchMode();
            }

            @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
            public void setImage(Drawable drawable, float f, boolean z) {
                Drawable maybeApplyLeafRounding = WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources);
                maybeApplyLeafRounding.mutate();
                this.mActualImageWrapper.setCurrent(maybeApplyLeafRounding);
                this.mFadeDrawable.beginBatchMode();
                fadeOutBranches();
                fadeInLayer(2);
                setProgress(f);
                if (z) {
                    this.mFadeDrawable.finishTransitionImmediately();
                }
                this.mFadeDrawable.endBatchMode();
            }

            public final void setProgress(float f) {
                Drawable drawable = this.mFadeDrawable.getDrawable(3);
                if (drawable != null) {
                    if (f >= 0.999f) {
                        if (drawable instanceof Animatable) {
                            ((Animatable) drawable).stop();
                        }
                        fadeOutLayer(3);
                    } else {
                        if (drawable instanceof Animatable) {
                            ((Animatable) drawable).start();
                        }
                        fadeInLayer(3);
                    }
                    drawable.setLevel(Math.round(f * 10000.0f));
                }
            }

            @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
            public void setRetry(Throwable th) {
                this.mFadeDrawable.beginBatchMode();
                fadeOutBranches();
                if (this.mFadeDrawable.getDrawable(4) != null) {
                    fadeInLayer(4);
                } else {
                    fadeInLayer(1);
                }
                this.mFadeDrawable.endBatchMode();
            }

            @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
            public void setProgress(float f, boolean z) {
                if (this.mFadeDrawable.getDrawable(3) != null) {
                    this.mFadeDrawable.beginBatchMode();
                    setProgress(f);
                    if (z) {
                        this.mFadeDrawable.finishTransitionImmediately();
                    }
                    this.mFadeDrawable.endBatchMode();
                }
            }
        }
