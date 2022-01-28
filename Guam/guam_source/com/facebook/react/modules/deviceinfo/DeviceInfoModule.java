package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = DeviceInfoModule.NAME)
public class DeviceInfoModule extends NativeDeviceInfoSpec implements LifecycleEventListener {
    public static final String NAME = "DeviceInfo";
    public float mFontScale;
    public ReadableMap mPreviousDisplayMetrics;
    public ReactApplicationContext mReactApplicationContext;

    public DeviceInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        AppCompatDelegateImpl.ConfigurationImplApi17.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        this.mFontScale = reactApplicationContext.getResources().getConfiguration().fontScale;
        this.mReactApplicationContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext != null) {
            if (reactApplicationContext.hasActiveCatalystInstance()) {
                double d = (double) this.mFontScale;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(Boolean.valueOf((AppCompatDelegateImpl.ConfigurationImplApi17.sWindowDisplayMetrics == null && AppCompatDelegateImpl.ConfigurationImplApi17.sScreenDisplayMetrics == null) ? false : true), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putMap("windowPhysicalPixels", AppCompatDelegateImpl.ConfigurationImplApi17.getPhysicalPixelsNativeMap(AppCompatDelegateImpl.ConfigurationImplApi17.sWindowDisplayMetrics, d));
                writableNativeMap.putMap("screenPhysicalPixels", AppCompatDelegateImpl.ConfigurationImplApi17.getPhysicalPixelsNativeMap(AppCompatDelegateImpl.ConfigurationImplApi17.sScreenDisplayMetrics, d));
                ReadableMap readableMap = this.mPreviousDisplayMetrics;
                if (readableMap == null) {
                    this.mPreviousDisplayMetrics = writableNativeMap.copy();
                } else if (!writableNativeMap.equals(readableMap)) {
                    this.mPreviousDisplayMetrics = writableNativeMap.copy();
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didUpdateDimensions", writableNativeMap);
                }
            } else {
                ReactSoftException.logSoftException(NAME, new ReactNoCrashSoftException("No active CatalystInstance, cannot emitUpdateDimensionsEvent"));
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceInfoSpec
    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        double d = (double) this.mFontScale;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(Boolean.valueOf((AppCompatDelegateImpl.ConfigurationImplApi17.sWindowDisplayMetrics == null && AppCompatDelegateImpl.ConfigurationImplApi17.sScreenDisplayMetrics == null) ? false : true), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("windowPhysicalPixels", AppCompatDelegateImpl.ConfigurationImplApi17.getPhysicalPixelsMap(AppCompatDelegateImpl.ConfigurationImplApi17.sWindowDisplayMetrics, d));
        hashMap2.put("screenPhysicalPixels", AppCompatDelegateImpl.ConfigurationImplApi17.getPhysicalPixelsMap(AppCompatDelegateImpl.ConfigurationImplApi17.sScreenDisplayMetrics, d));
        hashMap.put("Dimensions", hashMap2);
        return hashMap;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public void invalidate() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext != null) {
            float f = reactApplicationContext.getResources().getConfiguration().fontScale;
            if (this.mFontScale != f) {
                this.mFontScale = f;
                emitUpdateDimensionsEvent();
            }
        }
    }

    public DeviceInfoModule(Context context) {
        super(null);
        this.mReactApplicationContext = null;
        AppCompatDelegateImpl.ConfigurationImplApi17.initDisplayMetricsIfNotInitialized(context);
        this.mFontScale = context.getResources().getConfiguration().fontScale;
    }
}
