package com.reactnativecommunity.webview;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RNCWebViewPackage.kt */
public final class RNCWebViewPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<RNCWebViewModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        return MoreExecutors.listOf(new RNCWebViewModule(reactApplicationContext));
    }

    @Override // com.facebook.react.ReactPackage
    public List<RNCWebViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        return MoreExecutors.listOf(new RNCWebViewManager());
    }
}
