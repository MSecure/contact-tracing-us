package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.views.view.ReactViewGroup;

public class RNGestureHandlerRootView extends ReactViewGroup {
    public boolean mEnabled;
    public RNGestureHandlerRootHelper mRootHelper;

    public RNGestureHandlerRootView(Context context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mEnabled) {
            RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.mRootHelper;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(rNGestureHandlerRootHelper);
            if (rNGestureHandlerRootHelper.dispatchTouchEvent(motionEvent)) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        UiThreadUtil.assertOnUiThread();
        ViewParent parent = getParent();
        while (true) {
            if (parent == null) {
                z = false;
                break;
            } else if ((parent instanceof RNGestureHandlerEnabledRootView) || (parent instanceof RNGestureHandlerRootView)) {
                z = true;
            } else {
                parent = parent.getParent();
            }
        }
        z = true;
        boolean z2 = !z;
        this.mEnabled = z2;
        if (!z2) {
            Log.i("ReactNative", "[GESTURE HANDLER] Gesture handler is already enabled for a parent view");
        }
        if (this.mEnabled && this.mRootHelper == null) {
            this.mRootHelper = new RNGestureHandlerRootHelper((ReactContext) getContext(), this);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.mEnabled) {
            RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.mRootHelper;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(rNGestureHandlerRootHelper);
            rNGestureHandlerRootHelper.requestDisallowInterceptTouchEvent();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }
}
