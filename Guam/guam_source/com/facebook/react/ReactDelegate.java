package com.facebook.react;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

public class ReactDelegate {
    public final Activity mActivity;
    public DoubleTapReloadRecognizer mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
    public Bundle mLaunchOptions;
    public final String mMainComponentName;
    public ReactNativeHost mReactNativeHost;
    public ReactRootView mReactRootView;

    public ReactDelegate(Activity activity, ReactNativeHost reactNativeHost, String str, Bundle bundle) {
        this.mActivity = activity;
        this.mMainComponentName = str;
        this.mLaunchOptions = bundle;
        this.mReactNativeHost = reactNativeHost;
    }

    public ReactRootView createRootView() {
        return new ReactRootView(this.mActivity);
    }

    public void loadApp(String str) {
        if (this.mReactRootView == null) {
            ReactRootView createRootView = createRootView();
            this.mReactRootView = createRootView;
            createRootView.startReactApplication(this.mReactNativeHost.getReactInstanceManager(), str, this.mLaunchOptions);
            return;
        }
        throw new IllegalStateException("Cannot loadApp while app is already running.");
    }

    public void onActivityResult(int i, int i2, Intent intent, boolean z) {
        if (this.mReactNativeHost.hasInstance() && z) {
            ReactInstanceManager reactInstanceManager = this.mReactNativeHost.getReactInstanceManager();
            Activity activity = this.mActivity;
            ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
            if (currentReactContext != null) {
                currentReactContext.onActivityResult(activity, i, i2, intent);
            }
        }
    }

    public void onHostDestroy() {
        ReactRootView reactRootView = this.mReactRootView;
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
            this.mReactRootView = null;
        }
        if (this.mReactNativeHost.hasInstance()) {
            ReactInstanceManager reactInstanceManager = this.mReactNativeHost.getReactInstanceManager();
            if (this.mActivity == reactInstanceManager.mCurrentActivity) {
                UiThreadUtil.assertOnUiThread();
                if (reactInstanceManager.mUseDeveloperSupport) {
                    reactInstanceManager.mDevSupportManager.setDevSupportEnabled(false);
                }
                LifecycleState lifecycleState = LifecycleState.BEFORE_RESUME;
                synchronized (reactInstanceManager) {
                    ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                    if (currentReactContext != null) {
                        if (reactInstanceManager.mLifecycleState == LifecycleState.RESUMED) {
                            currentReactContext.onHostPause();
                            reactInstanceManager.mLifecycleState = lifecycleState;
                        }
                        if (reactInstanceManager.mLifecycleState == lifecycleState) {
                            currentReactContext.onHostDestroy();
                        }
                    }
                    reactInstanceManager.mLifecycleState = LifecycleState.BEFORE_CREATE;
                }
                reactInstanceManager.mCurrentActivity = null;
            }
        }
    }

    public void onHostPause() {
        if (this.mReactNativeHost.hasInstance()) {
            ReactInstanceManager reactInstanceManager = this.mReactNativeHost.getReactInstanceManager();
            Activity activity = this.mActivity;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactInstanceManager.mCurrentActivity);
            boolean z = activity == reactInstanceManager.mCurrentActivity;
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Pausing an activity that is not the current activity, this is incorrect! Current activity: ");
            outline15.append(reactInstanceManager.mCurrentActivity.getClass().getSimpleName());
            outline15.append(" Paused activity: ");
            outline15.append(activity.getClass().getSimpleName());
            AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(z, outline15.toString());
            UiThreadUtil.assertOnUiThread();
            reactInstanceManager.mDefaultBackButtonImpl = null;
            if (reactInstanceManager.mUseDeveloperSupport) {
                reactInstanceManager.mDevSupportManager.setDevSupportEnabled(false);
            }
            synchronized (reactInstanceManager) {
                ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                if (currentReactContext != null) {
                    if (reactInstanceManager.mLifecycleState == LifecycleState.BEFORE_CREATE) {
                        currentReactContext.onHostResume(reactInstanceManager.mCurrentActivity);
                        currentReactContext.onHostPause();
                    } else if (reactInstanceManager.mLifecycleState == LifecycleState.RESUMED) {
                        currentReactContext.onHostPause();
                    }
                }
                reactInstanceManager.mLifecycleState = LifecycleState.BEFORE_RESUME;
            }
        }
    }

    public void onHostResume() {
        if (!this.mReactNativeHost.hasInstance()) {
            return;
        }
        if (this.mActivity instanceof DefaultHardwareBackBtnHandler) {
            ReactInstanceManager reactInstanceManager = this.mReactNativeHost.getReactInstanceManager();
            Activity activity = this.mActivity;
            DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = (DefaultHardwareBackBtnHandler) activity;
            if (reactInstanceManager != null) {
                UiThreadUtil.assertOnUiThread();
                reactInstanceManager.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
                UiThreadUtil.assertOnUiThread();
                reactInstanceManager.mCurrentActivity = activity;
                if (reactInstanceManager.mUseDeveloperSupport) {
                    View decorView = activity.getWindow().getDecorView();
                    if (!ViewCompat.isAttachedToWindow(decorView)) {
                        decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(decorView) {
                            /* class com.facebook.react.ReactInstanceManager.AnonymousClass4 */
                            public final /* synthetic */ View val$decorView;

                            {
                                this.val$decorView = r2;
                            }

                            public void onViewAttachedToWindow(View view) {
                                this.val$decorView.removeOnAttachStateChangeListener(this);
                                ReactInstanceManager.this.mDevSupportManager.setDevSupportEnabled(true);
                            }

                            public void onViewDetachedFromWindow(View view) {
                            }
                        });
                    } else {
                        reactInstanceManager.mDevSupportManager.setDevSupportEnabled(true);
                    }
                }
                reactInstanceManager.moveToResumedLifecycleState(false);
                return;
            }
            throw null;
        }
        throw new ClassCastException("Host Activity does not implement DefaultHardwareBackBtnHandler");
    }
}
