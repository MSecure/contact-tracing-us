package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.R$animator;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements ExpandableWidget, Shapeable {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public boolean compatPadding;
    public int customSize;
    public PorterDuff.Mode imageMode;
    public int imagePadding;
    public ColorStateList imageTint;
    public FloatingActionButtonImpl impl;
    public ColorStateList rippleColor;
    public final Rect shadowPadding;
    public int size;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public boolean autoHideEnabled;
        public Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return getInsetDodgeRect((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) {
                    updateFabVisibilityForBottomSheet(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = dependencies.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior : false) && updateFabVisibilityForBottomSheet(view2, floatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            return true;
        }

        public final boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (this.autoHideEnabled && layoutParams.mAnchorId == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(null, false);
                return true;
            }
            floatingActionButton.show(null, false);
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.hide(null, false);
                return true;
            }
            floatingActionButton.show(null, false);
            return true;
        }

        public boolean getInsetDodgeRect(FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public void onHidden(FloatingActionButton floatingActionButton) {
        }

        public void onShown(FloatingActionButton floatingActionButton) {
        }
    }

    public class ShadowDelegateImpl implements ShadowViewDelegate {
        public ShadowDelegateImpl() {
        }
    }

    public class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
        public final TransformationCallback<T> listener;

        public TransformationCallbackWrapper(TransformationCallback<T> transformationCallback) {
            this.listener = transformationCallback;
        }

        public boolean equals(Object obj) {
            return (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).listener.equals(this.listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.animation.TransformationCallback<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onScaleChanged() {
            this.listener.onScaleChanged(FloatingActionButton.this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.animation.TransformationCallback<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onTranslationChanged() {
            this.listener.onTranslationChanged(FloatingActionButton.this);
        }
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
        }
        return this.impl;
    }

    public static int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size2);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size2;
        }
        throw new IllegalArgumentException();
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.hideListeners == null) {
            impl2.hideListeners = new ArrayList<>();
        }
        impl2.hideListeners.add(null);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.showListeners == null) {
            impl2.showListeners = new ArrayList<>();
        }
        impl2.showListeners.add(animatorListener);
    }

    public void addTransformationCallback(TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        FloatingActionButtonImpl impl2 = getImpl();
        TransformationCallbackWrapper transformationCallbackWrapper = new TransformationCallbackWrapper(null);
        if (impl2.transformationCallbacks == null) {
            impl2.transformationCallbacks = new ArrayList<>();
        }
        impl2.transformationCallbacks.add(transformationCallbackWrapper);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().hoveredFocusedTranslationZ;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().pressedTranslationZ;
    }

    public Drawable getContentBackground() {
        if (getImpl() != null) {
            return null;
        }
        throw null;
    }

    @Deprecated
    public boolean getContentRect(Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().hideMotionSpec;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        ShapeAppearanceModel shapeAppearanceModel = getImpl().shapeAppearance;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull(shapeAppearanceModel);
        return shapeAppearanceModel;
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().showMotionSpec;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide(final OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        AnonymousClass1 r4;
        FloatingActionButtonImpl impl2 = getImpl();
        if (onVisibilityChangedListener == null) {
            r4 = null;
        } else {
            r4 = new FloatingActionButtonImpl.InternalVisibilityChangedListener() {
                /* class com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1 */
            };
        }
        if (!impl2.isOrWillBeHidden()) {
            Animator animator = impl2.currentAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (impl2.shouldAnimateVisibilityChange()) {
                MotionSpec motionSpec = impl2.hideMotionSpec;
                if (motionSpec == null) {
                    if (impl2.defaultHideMotionSpec == null) {
                        impl2.defaultHideMotionSpec = MotionSpec.createFromResource(impl2.view.getContext(), R$animator.design_fab_hide_motion_spec);
                    }
                    motionSpec = impl2.defaultHideMotionSpec;
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull(motionSpec);
                }
                AnimatorSet createAnimator = impl2.createAnimator(motionSpec, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                createAnimator.addListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0048: INVOKE  
                      (r1v8 'createAnimator' android.animation.AnimatorSet)
                      (wrap: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1 : 0x0045: CONSTRUCTOR  (r2v1 com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1) = 
                      (r0v0 'impl2' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl)
                      (r5v0 'z' boolean)
                      (r4v1 'r4' com.google.android.material.floatingactionbutton.FloatingActionButton$1)
                     call: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1.<init>(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, boolean, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.animation.AnimatorSet.addListener(android.animation.Animator$AnimatorListener):void in method: com.google.android.material.floatingactionbutton.FloatingActionButton.hide(com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener, boolean):void, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: CONSTRUCTOR  (r2v1 com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1) = 
                      (r0v0 'impl2' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl)
                      (r5v0 'z' boolean)
                      (r4v1 'r4' com.google.android.material.floatingactionbutton.FloatingActionButton$1)
                     call: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1.<init>(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, boolean, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener):void type: CONSTRUCTOR in method: com.google.android.material.floatingactionbutton.FloatingActionButton.hide(com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener, boolean):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                // Method dump skipped, instructions count: 124
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.hide(com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener, boolean):void");
            }

            @Override // com.google.android.material.expandable.ExpandableWidget
            public boolean isExpanded() {
                throw null;
            }

            public boolean isOrWillBeHidden() {
                return getImpl().isOrWillBeHidden();
            }

            public boolean isOrWillBeShown() {
                return getImpl().isOrWillBeShown();
            }

            public void jumpDrawablesToCurrentState() {
                super.jumpDrawablesToCurrentState();
                getImpl().jumpDrawableToCurrentState();
            }

            public final void onApplySupportImageTint() {
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    ColorStateList colorStateList = this.imageTint;
                    if (colorStateList == null) {
                        drawable.clearColorFilter();
                        return;
                    }
                    int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
                    PorterDuff.Mode mode = this.imageMode;
                    if (mode == null) {
                        mode = PorterDuff.Mode.SRC_IN;
                    }
                    drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
                }
            }

            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                FloatingActionButtonImpl impl2 = getImpl();
                if (impl2.requirePreDrawListener()) {
                    ViewTreeObserver viewTreeObserver = impl2.view.getViewTreeObserver();
                    if (impl2.preDrawListener == null) {
                        impl2.preDrawListener = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: IPUT  
                              (wrap: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5 : 0x0019: CONSTRUCTOR  (r2v1 com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5) = (r0v0 'impl2' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl) call: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5.<init>(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl):void type: CONSTRUCTOR)
                              (r0v0 'impl2' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl)
                             com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.preDrawListener android.view.ViewTreeObserver$OnPreDrawListener in method: com.google.android.material.floatingactionbutton.FloatingActionButton.onAttachedToWindow():void, file: classes.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: CONSTRUCTOR  (r2v1 com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5) = (r0v0 'impl2' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl) call: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5.<init>(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl):void type: CONSTRUCTOR in method: com.google.android.material.floatingactionbutton.FloatingActionButton.onAttachedToWindow():void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 26 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 30 more
                            */
                        /*
                            this = this;
                            super.onAttachedToWindow()
                            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r0 = r3.getImpl()
                            boolean r1 = r0.requirePreDrawListener()
                            if (r1 == 0) goto L_0x0023
                            com.google.android.material.floatingactionbutton.FloatingActionButton r1 = r0.view
                            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                            android.view.ViewTreeObserver$OnPreDrawListener r2 = r0.preDrawListener
                            if (r2 != 0) goto L_0x001e
                            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5 r2 = new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5
                            r2.<init>()
                            r0.preDrawListener = r2
                        L_0x001e:
                            android.view.ViewTreeObserver$OnPreDrawListener r0 = r0.preDrawListener
                            r1.addOnPreDrawListener(r0)
                        L_0x0023:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.onAttachedToWindow():void");
                    }

                    public void onDetachedFromWindow() {
                        super.onDetachedFromWindow();
                        FloatingActionButtonImpl impl2 = getImpl();
                        ViewTreeObserver viewTreeObserver = impl2.view.getViewTreeObserver();
                        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl2.preDrawListener;
                        if (onPreDrawListener != null) {
                            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
                            impl2.preDrawListener = null;
                        }
                    }

                    public void onMeasure(int i, int i2) {
                        int sizeDimension = getSizeDimension();
                        this.imagePadding = (sizeDimension + 0) / 2;
                        getImpl().updatePadding();
                        Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
                        throw null;
                    }

                    public void onRestoreInstanceState(Parcelable parcelable) {
                        if (!(parcelable instanceof ExtendableSavedState)) {
                            super.onRestoreInstanceState(parcelable);
                            return;
                        }
                        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
                        super.onRestoreInstanceState(extendableSavedState.mSuperState);
                        AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull(extendableSavedState.extendableStates.getOrDefault("expandableWidgetHelper", null));
                        throw null;
                    }

                    public Parcelable onSaveInstanceState() {
                        if (super.onSaveInstanceState() == null) {
                            new Bundle();
                        }
                        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
                        throw null;
                    }

                    public boolean onTouchEvent(MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            getContentRect(null);
                        }
                        return super.onTouchEvent(motionEvent);
                    }

                    public void setBackgroundColor(int i) {
                        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
                    }

                    public void setBackgroundDrawable(Drawable drawable) {
                        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
                    }

                    public void setBackgroundResource(int i) {
                        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
                    }

                    public void setBackgroundTintList(ColorStateList colorStateList) {
                        if (this.backgroundTint != colorStateList) {
                            this.backgroundTint = colorStateList;
                            if (getImpl() == null) {
                                throw null;
                            }
                        }
                    }

                    public void setBackgroundTintMode(PorterDuff.Mode mode) {
                        if (this.backgroundTintMode != mode) {
                            this.backgroundTintMode = mode;
                            if (getImpl() == null) {
                                throw null;
                            }
                        }
                    }

                    public void setCompatElevation(float f) {
                        FloatingActionButtonImpl impl2 = getImpl();
                        if (impl2.elevation != f) {
                            impl2.elevation = f;
                            impl2.onElevationsChanged(f, impl2.hoveredFocusedTranslationZ, impl2.pressedTranslationZ);
                        }
                    }

                    public void setCompatElevationResource(int i) {
                        setCompatElevation(getResources().getDimension(i));
                    }

                    public void setCompatHoveredFocusedTranslationZ(float f) {
                        FloatingActionButtonImpl impl2 = getImpl();
                        if (impl2.hoveredFocusedTranslationZ != f) {
                            impl2.hoveredFocusedTranslationZ = f;
                            impl2.onElevationsChanged(impl2.elevation, f, impl2.pressedTranslationZ);
                        }
                    }

                    public void setCompatHoveredFocusedTranslationZResource(int i) {
                        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
                    }

                    public void setCompatPressedTranslationZ(float f) {
                        FloatingActionButtonImpl impl2 = getImpl();
                        if (impl2.pressedTranslationZ != f) {
                            impl2.pressedTranslationZ = f;
                            impl2.onElevationsChanged(impl2.elevation, impl2.hoveredFocusedTranslationZ, f);
                        }
                    }

                    public void setCompatPressedTranslationZResource(int i) {
                        setCompatPressedTranslationZ(getResources().getDimension(i));
                    }

                    public void setCustomSize(int i) {
                        if (i < 0) {
                            throw new IllegalArgumentException("Custom size must be non-negative");
                        } else if (i != this.customSize) {
                            this.customSize = i;
                            requestLayout();
                        }
                    }

                    public void setElevation(float f) {
                        super.setElevation(f);
                        if (getImpl() == null) {
                            throw null;
                        }
                    }

                    public void setEnsureMinTouchTargetSize(boolean z) {
                        if (z != getImpl().ensureMinTouchTargetSize) {
                            getImpl().ensureMinTouchTargetSize = z;
                            requestLayout();
                        }
                    }

                    public void setExpandedComponentIdHint(int i) {
                        throw null;
                    }

                    public void setHideMotionSpec(MotionSpec motionSpec) {
                        getImpl().hideMotionSpec = motionSpec;
                    }

                    public void setHideMotionSpecResource(int i) {
                        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
                    }

                    public void setImageDrawable(Drawable drawable) {
                        if (getDrawable() != drawable) {
                            super.setImageDrawable(drawable);
                            FloatingActionButtonImpl impl2 = getImpl();
                            impl2.setImageMatrixScale(impl2.imageMatrixScale);
                            if (this.imageTint != null) {
                                onApplySupportImageTint();
                            }
                        }
                    }

                    public void setImageResource(int i) {
                        throw null;
                    }

                    public void setRippleColor(int i) {
                        setRippleColor(ColorStateList.valueOf(i));
                    }

                    public void setScaleX(float f) {
                        super.setScaleX(f);
                        getImpl().onScaleChanged();
                    }

                    public void setScaleY(float f) {
                        super.setScaleY(f);
                        getImpl().onScaleChanged();
                    }

                    public void setShadowPaddingEnabled(boolean z) {
                        FloatingActionButtonImpl impl2 = getImpl();
                        impl2.shadowPaddingEnabled = z;
                        impl2.updatePadding();
                    }

                    @Override // com.google.android.material.shape.Shapeable
                    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
                        getImpl().shapeAppearance = shapeAppearanceModel;
                    }

                    public void setShowMotionSpec(MotionSpec motionSpec) {
                        getImpl().showMotionSpec = motionSpec;
                    }

                    public void setShowMotionSpecResource(int i) {
                        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
                    }

                    public void setSize(int i) {
                        this.customSize = 0;
                        if (i != this.size) {
                            this.size = i;
                            requestLayout();
                        }
                    }

                    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
                        setBackgroundTintList(colorStateList);
                    }

                    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
                        setBackgroundTintMode(mode);
                    }

                    public void setSupportImageTintList(ColorStateList colorStateList) {
                        if (this.imageTint != colorStateList) {
                            this.imageTint = colorStateList;
                            onApplySupportImageTint();
                        }
                    }

                    public void setSupportImageTintMode(PorterDuff.Mode mode) {
                        if (this.imageMode != mode) {
                            this.imageMode = mode;
                            onApplySupportImageTint();
                        }
                    }

                    public void setTranslationX(float f) {
                        super.setTranslationX(f);
                        getImpl().onTranslationChanged();
                    }

                    public void setTranslationY(float f) {
                        super.setTranslationY(f);
                        getImpl().onTranslationChanged();
                    }

                    public void setTranslationZ(float f) {
                        super.setTranslationZ(f);
                        getImpl().onTranslationChanged();
                    }

                    public void setUseCompatPadding(boolean z) {
                        if (this.compatPadding != z) {
                            this.compatPadding = z;
                            getImpl().onCompatShadowChanged();
                        }
                    }

                    @Override // com.google.android.material.internal.VisibilityAwareImageButton
                    public void setVisibility(int i) {
                        super.setVisibility(i);
                    }

                    public void show(final OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
                        AnonymousClass1 r5;
                        FloatingActionButtonImpl impl2 = getImpl();
                        if (onVisibilityChangedListener == null) {
                            r5 = null;
                        } else {
                            r5 = new FloatingActionButtonImpl.InternalVisibilityChangedListener() {
                                /* class com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1 */
                            };
                        }
                        if (!impl2.isOrWillBeShown()) {
                            Animator animator = impl2.currentAnimator;
                            if (animator != null) {
                                animator.cancel();
                            }
                            if (impl2.shouldAnimateVisibilityChange()) {
                                if (impl2.view.getVisibility() != 0) {
                                    impl2.view.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                    impl2.view.setScaleY(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                    impl2.view.setScaleX(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                    impl2.setImageMatrixScale(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                }
                                MotionSpec motionSpec = impl2.showMotionSpec;
                                if (motionSpec == null) {
                                    if (impl2.defaultShowMotionSpec == null) {
                                        impl2.defaultShowMotionSpec = MotionSpec.createFromResource(impl2.view.getContext(), R$animator.design_fab_show_motion_spec);
                                    }
                                    motionSpec = impl2.defaultShowMotionSpec;
                                    AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull(motionSpec);
                                }
                                AnimatorSet createAnimator = impl2.createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
                                createAnimator.addListener(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0065: INVOKE  
                                      (r1v8 'createAnimator' android.animation.AnimatorSet)
                                      (wrap: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$2 : 0x0062: CONSTRUCTOR  (r2v1 com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$2) = 
                                      (r0v0 'impl2' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl)
                                      (r6v0 'z' boolean)
                                      (r5v1 'r5' com.google.android.material.floatingactionbutton.FloatingActionButton$1)
                                     call: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2.<init>(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, boolean, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: android.animation.AnimatorSet.addListener(android.animation.Animator$AnimatorListener):void in method: com.google.android.material.floatingactionbutton.FloatingActionButton.show(com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener, boolean):void, file: classes.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: CONSTRUCTOR  (r2v1 com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$2) = 
                                      (r0v0 'impl2' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl)
                                      (r6v0 'z' boolean)
                                      (r5v1 'r5' com.google.android.material.floatingactionbutton.FloatingActionButton$1)
                                     call: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2.<init>(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, boolean, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener):void type: CONSTRUCTOR in method: com.google.android.material.floatingactionbutton.FloatingActionButton.show(com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener, boolean):void, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 28 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 34 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 166
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.show(com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener, boolean):void");
                            }

                            public final int getSizeDimension(int i) {
                                int i2 = this.customSize;
                                if (i2 != 0) {
                                    return i2;
                                }
                                Resources resources = getResources();
                                if (i != -1) {
                                    if (i != 1) {
                                        return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
                                    }
                                    return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
                                } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                                    return getSizeDimension(1);
                                } else {
                                    return getSizeDimension(0);
                                }
                            }

                            public void setRippleColor(ColorStateList colorStateList) {
                                if (this.rippleColor != colorStateList) {
                                    this.rippleColor = colorStateList;
                                    getImpl().setRippleColor(this.rippleColor);
                                }
                            }
                        }
