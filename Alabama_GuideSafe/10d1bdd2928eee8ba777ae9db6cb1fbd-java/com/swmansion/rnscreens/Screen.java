package com.swmansion.rnscreens;

import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
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
    public ActivityState mActivityState;
    public ScreenContainer mContainer;
    public ScreenFragment mFragment;
    public boolean mGestureEnabled = true;
    public ReplaceAnimation mReplaceAnimation = ReplaceAnimation.POP;
    public StackAnimation mStackAnimation = StackAnimation.DEFAULT;
    public StackPresentation mStackPresentation = StackPresentation.PUSH;
    public boolean mTransitioning;

    public enum ActivityState {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP
    }

    public enum ReplaceAnimation {
        PUSH,
        POP
    }

    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT
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

    public ActivityState getActivityState() {
        return this.mActivityState;
    }

    public ScreenContainer getContainer() {
        return this.mContainer;
    }

    public ScreenFragment getFragment() {
        return this.mFragment;
    }

    public ReplaceAnimation getReplaceAnimation() {
        return this.mReplaceAnimation;
    }

    public StackAnimation getStackAnimation() {
        return this.mStackAnimation;
    }

    public StackPresentation getStackPresentation() {
        return this.mStackPresentation;
    }

    public final boolean hasWebView(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasWebView((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        ScreenFragment screenFragment = this.mFragment;
        if (screenFragment != null) {
            screenFragment.onViewAnimationEnd();
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        ScreenFragment screenFragment = this.mFragment;
        if (screenFragment == null) {
            return;
        }
        if (screenFragment.isResumed()) {
            screenFragment.dispatchOnWillAppear();
        } else {
            screenFragment.dispatchOnWillDisappear();
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

    public void setActivityState(ActivityState activityState) {
        if (activityState != this.mActivityState) {
            this.mActivityState = activityState;
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

    public void setReplaceAnimation(ReplaceAnimation replaceAnimation) {
        this.mReplaceAnimation = replaceAnimation;
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
            boolean hasWebView = hasWebView(this);
            int i = 2;
            if (!hasWebView || getLayerType() == 2) {
                if (!z || hasWebView) {
                    i = 0;
                }
                super.setLayerType(i, null);
            }
        }
    }
}
