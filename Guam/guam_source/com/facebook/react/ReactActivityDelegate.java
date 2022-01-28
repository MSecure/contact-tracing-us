package com.facebook.react;

import android.app.Activity;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.PermissionListener;

public class ReactActivityDelegate {
    public final Activity mActivity;
    public final String mMainComponentName;
    public PermissionListener mPermissionListener;
    public Callback mPermissionsCallback;
    public ReactDelegate mReactDelegate;

    public ReactActivityDelegate(ReactActivity reactActivity, String str) {
        this.mActivity = reactActivity;
        this.mMainComponentName = str;
    }

    public abstract ReactRootView createRootView();

    public ReactNativeHost getReactNativeHost() {
        Activity activity = this.mActivity;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(activity);
        return ((ReactApplication) activity.getApplication()).getReactNativeHost();
    }
}
