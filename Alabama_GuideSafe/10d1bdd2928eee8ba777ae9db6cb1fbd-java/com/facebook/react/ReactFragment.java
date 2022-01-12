package com.facebook.react;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentHostCallback;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import okhttp3.internal.http2.Settings;

public class ReactFragment extends Fragment implements PermissionAwareActivity {
    public PermissionListener mPermissionListener;
    public ReactDelegate mReactDelegate;

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mReactDelegate.onActivityResult(i, i2, intent, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        Bundle bundle3 = this.mArguments;
        String str = null;
        if (bundle3 != null) {
            str = bundle3.getString("arg_component_name");
            bundle2 = this.mArguments.getBundle("arg_launch_options");
        } else {
            bundle2 = null;
        }
        if (str != null) {
            this.mReactDelegate = new ReactDelegate(getActivity(), ((ReactApplication) getActivity().getApplication()).getReactNativeHost(), str, bundle2);
            return;
        }
        throw new IllegalStateException("Cannot loadApp if component name is null");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        reactDelegate.loadApp(reactDelegate.mMainComponentName);
        return this.mReactDelegate.mReactRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mCalled = true;
        this.mReactDelegate.onHostDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mCalled = true;
        this.mReactDelegate.onHostPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionListener permissionListener = this.mPermissionListener;
        if (permissionListener != null && permissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
            this.mPermissionListener = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.mCalled = true;
        this.mReactDelegate.onHostResume();
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    @TargetApi(23)
    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            if (fragmentActivity == null) {
                throw null;
            } else if (i == -1) {
                ActivityCompat.requestPermissions(fragmentActivity, strArr, i);
            } else {
                FragmentActivity.checkForValidRequestCode(i);
                try {
                    fragmentActivity.mRequestedPermissionsFromFragment = true;
                    ActivityCompat.requestPermissions(fragmentActivity, strArr, ((fragmentActivity.allocateRequestIndex(this) + 1) << 16) + (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE));
                    fragmentActivity.mRequestedPermissionsFromFragment = false;
                } catch (Throwable th) {
                    fragmentActivity.mRequestedPermissionsFromFragment = false;
                    throw th;
                }
            }
        } else {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }
}
