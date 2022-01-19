package com.swmansion.gesturehandler.react;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> {

    public static class ButtonViewGroup extends ViewGroup {
        public static TypedValue sResolveOutValue = new TypedValue();
        public static ButtonViewGroup sResponder;
        public int mBackgroundColor = 0;
        public float mBorderRadius = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public boolean mNeedBackgroundUpdate = false;
        public Integer mRippleColor;
        public boolean mUseBorderless = false;
        public boolean mUseForeground = false;

        public ButtonViewGroup(Context context) {
            super(context);
            setClickable(true);
            setFocusable(true);
            this.mNeedBackgroundUpdate = true;
        }

        public final Drawable applyRippleEffectWhenNeeded(Drawable drawable) {
            Integer num = this.mRippleColor;
            if (!(num == null || drawable == null || !(drawable instanceof RippleDrawable))) {
                ((RippleDrawable) drawable).setColor(new ColorStateList(new int[][]{new int[]{16842910}}, new int[]{num.intValue()}));
            }
            return drawable;
        }

        public final Drawable createSelectableDrawable() {
            getContext().getTheme().resolveAttribute(getResources().getIdentifier(this.mUseBorderless ? "selectableItemBackgroundBorderless" : "selectableItemBackground", ColorPropConverter.ATTR, "android"), sResolveOutValue, true);
            return getResources().getDrawable(sResolveOutValue.resourceId, getContext().getTheme());
        }

        public void dispatchDrawableHotspotChanged(float f, float f2) {
        }

        public void drawableHotspotChanged(float f, float f2) {
            ButtonViewGroup buttonViewGroup = sResponder;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f, f2);
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            if (isPressed()) {
                return true;
            }
            return false;
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
            this.mNeedBackgroundUpdate = true;
        }

        public void setPressed(boolean z) {
            if (z && sResponder == null) {
                sResponder = this;
            }
            if (!z || sResponder == this) {
                super.setPressed(z);
            }
            if (!z && sResponder == this) {
                sResponder = null;
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return "RNGestureHandlerButton";
    }

    @ReactProp(name = "borderless")
    public void setBorderless(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.mUseBorderless = z;
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_ENABLED)
    public void setEnabled(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setEnabled(z);
    }

    @ReactProp(name = "foreground")
    @TargetApi(23)
    public void setForeground(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.mUseForeground = z;
        buttonViewGroup.mNeedBackgroundUpdate = true;
    }

    @ReactProp(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        buttonViewGroup.mRippleColor = num;
        buttonViewGroup.mNeedBackgroundUpdate = true;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ButtonViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ButtonViewGroup(themedReactContext);
    }

    public void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        if (buttonViewGroup.mNeedBackgroundUpdate) {
            buttonViewGroup.mNeedBackgroundUpdate = false;
            if (buttonViewGroup.mBackgroundColor == 0) {
                buttonViewGroup.setBackground(null);
            }
            buttonViewGroup.setForeground(null);
            if (buttonViewGroup.mUseForeground) {
                Drawable createSelectableDrawable = buttonViewGroup.createSelectableDrawable();
                buttonViewGroup.applyRippleEffectWhenNeeded(createSelectableDrawable);
                buttonViewGroup.setForeground(createSelectableDrawable);
                int i = buttonViewGroup.mBackgroundColor;
                if (i != 0) {
                    buttonViewGroup.setBackgroundColor(i);
                }
            } else if (buttonViewGroup.mBackgroundColor == 0 && buttonViewGroup.mRippleColor == null) {
                buttonViewGroup.setBackground(buttonViewGroup.createSelectableDrawable());
            } else {
                PaintDrawable paintDrawable = new PaintDrawable(buttonViewGroup.mBackgroundColor);
                Drawable createSelectableDrawable2 = buttonViewGroup.createSelectableDrawable();
                float f = buttonViewGroup.mBorderRadius;
                if (f != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    paintDrawable.setCornerRadius(f);
                    if (createSelectableDrawable2 instanceof RippleDrawable) {
                        PaintDrawable paintDrawable2 = new PaintDrawable(-1);
                        paintDrawable2.setCornerRadius(buttonViewGroup.mBorderRadius);
                        ((RippleDrawable) createSelectableDrawable2).setDrawableByLayerId(16908334, paintDrawable2);
                    }
                }
                buttonViewGroup.applyRippleEffectWhenNeeded(createSelectableDrawable2);
                buttonViewGroup.setBackground(new LayerDrawable(new Drawable[]{paintDrawable, createSelectableDrawable2}));
            }
        }
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f) {
        buttonViewGroup.mBorderRadius = f * buttonViewGroup.getResources().getDisplayMetrics().density;
        buttonViewGroup.mNeedBackgroundUpdate = true;
    }
}
