package com.google.android.material.snackbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class BaseTransientBottomBar$SnackbarBaseLayout extends FrameLayout {
    public static final View.OnTouchListener consumeAllTouchListener = new View.OnTouchListener() {
        /* class com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout.AnonymousClass1 */

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    public final float actionTextColorAlpha;
    public int animationMode;
    public final float backgroundOverlayColorAlpha;
    public BaseTransientBottomBar$OnAttachStateChangeListener onAttachStateChangeListener;
    public BaseTransientBottomBar$OnLayoutChangeListener onLayoutChangeListener;

    public BaseTransientBottomBar$SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, 0, 0), attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
            ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
        }
        this.animationMode = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
        this.backgroundOverlayColorAlpha = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        this.actionTextColorAlpha = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(consumeAllTouchListener);
        setFocusable(true);
    }

    public float getActionTextColorAlpha() {
        return this.actionTextColorAlpha;
    }

    public int getAnimationMode() {
        return this.animationMode;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.backgroundOverlayColorAlpha;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BaseTransientBottomBar$OnAttachStateChangeListener baseTransientBottomBar$OnAttachStateChangeListener = this.onAttachStateChangeListener;
        if (baseTransientBottomBar$OnAttachStateChangeListener != null) {
            baseTransientBottomBar$OnAttachStateChangeListener.onViewAttachedToWindow(this);
        }
        ViewCompat.requestApplyInsets(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseTransientBottomBar$OnAttachStateChangeListener baseTransientBottomBar$OnAttachStateChangeListener = this.onAttachStateChangeListener;
        if (baseTransientBottomBar$OnAttachStateChangeListener != null) {
            baseTransientBottomBar$OnAttachStateChangeListener.onViewDetachedFromWindow(this);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        BaseTransientBottomBar$OnLayoutChangeListener baseTransientBottomBar$OnLayoutChangeListener = this.onLayoutChangeListener;
        if (baseTransientBottomBar$OnLayoutChangeListener != null) {
            baseTransientBottomBar$OnLayoutChangeListener.onLayoutChange(this, i, i2, i3, i4);
        }
    }

    public void setAnimationMode(int i) {
        this.animationMode = i;
    }

    public void setOnAttachStateChangeListener(BaseTransientBottomBar$OnAttachStateChangeListener baseTransientBottomBar$OnAttachStateChangeListener) {
        this.onAttachStateChangeListener = baseTransientBottomBar$OnAttachStateChangeListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(BaseTransientBottomBar$OnLayoutChangeListener baseTransientBottomBar$OnLayoutChangeListener) {
        this.onLayoutChangeListener = baseTransientBottomBar$OnLayoutChangeListener;
    }
}
