package com.facebook.react.bridge;

import com.android.tools.r8.GeneratedOutlineSupport;

public class JSCJavaScriptExecutorFactory implements JavaScriptExecutorFactory {
    public final String mAppName;
    public final String mDeviceName;

    public JSCJavaScriptExecutorFactory(String str, String str2) {
        this.mAppName = str;
        this.mDeviceName = str2;
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public JavaScriptExecutor create() throws Exception {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("OwnerIdentity", "ReactNative");
        writableNativeMap.putString("AppIdentity", this.mAppName);
        writableNativeMap.putString("DeviceIdentity", this.mDeviceName);
        return new JSCJavaScriptExecutor(writableNativeMap);
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public void startSamplingProfiler() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Starting sampling profiler not supported on ");
        outline17.append(toString());
        throw new UnsupportedOperationException(outline17.toString());
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public void stopSamplingProfiler(String str) {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Stopping sampling profiler not supported on ");
        outline17.append(toString());
        throw new UnsupportedOperationException(outline17.toString());
    }

    public String toString() {
        return "JSCExecutor";
    }
}
