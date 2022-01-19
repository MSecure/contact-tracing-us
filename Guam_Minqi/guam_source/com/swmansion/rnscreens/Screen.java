package com.swmansion.rnscreens;

import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;

public class Screen extends ViewGroup {
    public static View.OnAttachStateChangeListener sShowSoftKeyboardOnAttach = new View.OnAttachStateChangeListener() {
        /* class com.swmansion.rnscreens.Screen.AnonymousClass1 */

        public void onViewAttachedToWindow(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
            view.removeOnAttachStateChangeListener(Screen.sShowSoftKeyboardOnAttach);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    };
    public boolean mActive;
    public ScreenContainer mContainer;
    public ScreenFragment mFragment;
    public boolean mGestureEnabled = true;
    public StackAnimation mStackAnimation = StackAnimation.DEFAULT;
    public StackPresentation mStackPresentation = StackPresentation.PUSH;
    public boolean mTransitioning;

    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE
    }

    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
        setLayoutParams(new WindowManager.LayoutParams(2));
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    public ScreenContainer getContainer() {
        return this.mContainer;
    }

    public ScreenFragment getFragment() {
        return this.mFragment;
    }

    public StackAnimation getStackAnimation() {
        return this.mStackAnimation;
    }

    public StackPresentation getStackPresentation() {
        return this.mStackPresentation;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        ScreenFragment screenFragment = this.mFragment;
        if (screenFragment != null) {
            screenFragment.onViewAnimationEnd();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            while (focusedChild instanceof ViewGroup) {
                focusedChild = ((ViewGroup) focusedChild).getFocusedChild();
            }
            if (focusedChild instanceof TextView) {
                TextView textView = (TextView) focusedChild;
                if (textView.getShowSoftInputOnFocus()) {
                    textView.addOnAttachStateChangeListener(sShowSoftKeyboardOnAttach);
                }
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            final int i5 = i3 - i;
            final int i6 = i4 - i2;
            final ReactContext reactContext = (ReactContext) getContext();
            reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                /* class com.swmansion.rnscreens.Screen.AnonymousClass2 */

                @Override // com.facebook.react.bridge.GuardedRunnable
                public void runGuarded() {
                    ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).updateNodeSize(Screen.this.getId(), i5, i6);
                }
            });
        }
    }

    public void setActive(boolean z) {
        if (z != this.mActive) {
            this.mActive = z;
            ScreenContainer screenContainer = this.mContainer;
            if (screenContainer != null) {
                screenContainer.markUpdated();
            }
        }
    }

    public void setContainer(ScreenContainer screenContainer) {
        this.mContainer = screenContainer;
    }

    public void setFragment(ScreenFragment screenFragment) {
        this.mFragment = screenFragment;
    }

    public void setGestureEnabled(boolean z) {
        this.mGestureEnabled = z;
    }

    public void setLayerType(int i, Paint paint) {
    }

    public void setStackAnimation(StackAnimation stackAnimation) {
        this.mStackAnimation = stackAnimation;
    }

    public void setStackPresentation(StackPresentation stackPresentation) {
        this.mStackPresentation = stackPresentation;
    }

    public void setTransitioning(boolean z) {
        if (this.mTransitioning != z) {
            this.mTransitioning = z;
            super.setLayerType(z ? 2 : 0, null);
        }
    }
}
