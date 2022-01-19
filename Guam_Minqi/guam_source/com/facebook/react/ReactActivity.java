package com.facebook.react;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;
import org.pathcheck.covidsafepaths.MainActivity;
import org.pathcheck.covidsafepaths.MainApplication;

public abstract class ReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {
    public final ReactActivityDelegate mDelegate;

    public ReactActivity() {
        MainActivity mainActivity = (MainActivity) this;
        this.mDelegate = new ReactActivityDelegate(mainActivity, "COVIDSafePaths") {
            /* class org.pathcheck.covidsafepaths.MainActivity.AnonymousClass3 */

            @Override // com.facebook.react.ReactActivityDelegate
            public ReactRootView createRootView() {
                return new RNGestureHandlerEnabledRootView(MainActivity.this);
            }
        };
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mDelegate.mReactDelegate.onActivityResult(i, i2, intent, true);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        boolean z;
        ReactDelegate reactDelegate = this.mDelegate.mReactDelegate;
        if (reactDelegate.mReactNativeHost.hasInstance()) {
            ReactInstanceManager reactInstanceManager = reactDelegate.mReactNativeHost.getReactInstanceManager();
            if (reactInstanceManager != null) {
                UiThreadUtil.assertOnUiThread();
                ReactContext reactContext = reactInstanceManager.mCurrentReactContext;
                if (reactContext == null) {
                    FLog.w("ReactInstanceManager", "Instance detached from instance manager");
                    UiThreadUtil.assertOnUiThread();
                    DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = reactInstanceManager.mDefaultBackButtonImpl;
                    if (defaultHardwareBackBtnHandler != null) {
                        defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
                    }
                } else {
                    ((DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class)).emitHardwareBackPressed();
                }
                z = true;
            } else {
                throw null;
            }
        } else {
            z = false;
        }
        if (!z) {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        String str = reactActivityDelegate.mMainComponentName;
        Activity activity = reactActivityDelegate.mActivity;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(activity);
        ReactActivityDelegate.AnonymousClass1 r7 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: CONSTRUCTOR  (r7v0 'r7' com.facebook.react.ReactActivityDelegate$1) = 
              (r9v1 'reactActivityDelegate' com.facebook.react.ReactActivityDelegate)
              (r2v0 'activity' android.app.Activity)
              (wrap: com.facebook.react.ReactNativeHost : 0x000e: INVOKE  (r3v0 com.facebook.react.ReactNativeHost) = (r9v1 'reactActivityDelegate' com.facebook.react.ReactActivityDelegate) type: VIRTUAL call: com.facebook.react.ReactActivityDelegate.getReactNativeHost():com.facebook.react.ReactNativeHost)
              (r6v0 'str' java.lang.String)
              (null android.os.Bundle)
             call: com.facebook.react.ReactActivityDelegate.1.<init>(com.facebook.react.ReactActivityDelegate, android.app.Activity, com.facebook.react.ReactNativeHost, java.lang.String, android.os.Bundle):void type: CONSTRUCTOR in method: com.facebook.react.ReactActivity.onCreate(android.os.Bundle):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.ReactActivityDelegate, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
            this = this;
            super.onCreate(r9)
            com.facebook.react.ReactActivityDelegate r9 = r8.mDelegate
            java.lang.String r6 = r9.mMainComponentName
            com.facebook.react.ReactActivityDelegate$1 r7 = new com.facebook.react.ReactActivityDelegate$1
            android.app.Activity r2 = r9.mActivity
            androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(r2)
            com.facebook.react.ReactNativeHost r3 = r9.getReactNativeHost()
            r5 = 0
            r0 = r7
            r1 = r9
            r4 = r6
            r0.<init>(r2, r3, r4, r5)
            r9.mReactDelegate = r7
            java.lang.String r0 = r9.mMainComponentName
            if (r0 == 0) goto L_0x002e
            r7.loadApp(r6)
            android.app.Activity r0 = r9.mActivity
            androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(r0)
            com.facebook.react.ReactDelegate r9 = r9.mReactDelegate
            com.facebook.react.ReactRootView r9 = r9.mReactRootView
            r0.setContentView(r9)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.mDelegate.mReactDelegate.onHostDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        if (!reactActivityDelegate.getReactNativeHost().hasInstance() || ((MainApplication.AnonymousClass1) reactActivityDelegate.getReactNativeHost()) != null) {
            return super.onKeyDown(i, keyEvent);
        }
        throw null;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        if (!reactActivityDelegate.getReactNativeHost().hasInstance() || ((MainApplication.AnonymousClass1) reactActivityDelegate.getReactNativeHost()) != null) {
            return super.onKeyLongPress(i, keyEvent);
        }
        throw null;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ReactDelegate reactDelegate = this.mDelegate.mReactDelegate;
        if (!reactDelegate.mReactNativeHost.hasInstance() || ((MainApplication.AnonymousClass1) reactDelegate.mReactNativeHost) != null) {
            return super.onKeyUp(i, keyEvent);
        }
        throw null;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        boolean z;
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        if (reactActivityDelegate.getReactNativeHost().hasInstance()) {
            ReactInstanceManager reactInstanceManager = reactActivityDelegate.getReactNativeHost().getReactInstanceManager();
            if (reactInstanceManager != null) {
                UiThreadUtil.assertOnUiThread();
                ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                if (currentReactContext == null) {
                    FLog.w("ReactInstanceManager", "Instance detached from instance manager");
                } else {
                    String action = intent.getAction();
                    Uri data = intent.getData();
                    if (data != null && ("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action))) {
                        ((DeviceEventManagerModule) currentReactContext.getNativeModule(DeviceEventManagerModule.class)).emitNewIntentReceived(data);
                    }
                    currentReactContext.onNewIntent(reactInstanceManager.mCurrentActivity, intent);
                }
                z = true;
            } else {
                throw null;
            }
        } else {
            z = false;
        }
        if (!z) {
            super.onNewIntent(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.mDelegate.mReactDelegate.onHostPause();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        reactActivityDelegate.mPermissionsCallback = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: IPUT  
              (wrap: com.facebook.react.ReactActivityDelegate$2 : 0x0004: CONSTRUCTOR  (r1v0 com.facebook.react.ReactActivityDelegate$2) = 
              (r0v0 'reactActivityDelegate' com.facebook.react.ReactActivityDelegate)
              (r3v0 'i' int)
              (r4v0 'strArr' java.lang.String[])
              (r5v0 'iArr' int[])
             call: com.facebook.react.ReactActivityDelegate.2.<init>(com.facebook.react.ReactActivityDelegate, int, java.lang.String[], int[]):void type: CONSTRUCTOR)
              (r0v0 'reactActivityDelegate' com.facebook.react.ReactActivityDelegate)
             com.facebook.react.ReactActivityDelegate.mPermissionsCallback com.facebook.react.bridge.Callback in method: com.facebook.react.ReactActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r1v0 com.facebook.react.ReactActivityDelegate$2) = 
              (r0v0 'reactActivityDelegate' com.facebook.react.ReactActivityDelegate)
              (r3v0 'i' int)
              (r4v0 'strArr' java.lang.String[])
              (r5v0 'iArr' int[])
             call: com.facebook.react.ReactActivityDelegate.2.<init>(com.facebook.react.ReactActivityDelegate, int, java.lang.String[], int[]):void type: CONSTRUCTOR in method: com.facebook.react.ReactActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.ReactActivityDelegate, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 18 more
            */
        /*
            this = this;
            com.facebook.react.ReactActivityDelegate r0 = r2.mDelegate
            com.facebook.react.ReactActivityDelegate$2 r1 = new com.facebook.react.ReactActivityDelegate$2
            r1.<init>(r3, r4, r5)
            r0.mPermissionsCallback = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        reactActivityDelegate.mReactDelegate.onHostResume();
        Callback callback = reactActivityDelegate.mPermissionsCallback;
        if (callback != null) {
            callback.invoke(new Object[0]);
            reactActivityDelegate.mPermissionsCallback = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        if (reactActivityDelegate.getReactNativeHost().hasInstance()) {
            ReactInstanceManager reactInstanceManager = reactActivityDelegate.getReactNativeHost().getReactInstanceManager();
            if (reactInstanceManager != null) {
                UiThreadUtil.assertOnUiThread();
                ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                if (currentReactContext != null) {
                    currentReactContext.onWindowFocusChange(z);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        reactActivityDelegate.mPermissionListener = permissionListener;
        Activity activity = reactActivityDelegate.mActivity;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(activity);
        activity.requestPermissions(strArr, i);
    }
}
