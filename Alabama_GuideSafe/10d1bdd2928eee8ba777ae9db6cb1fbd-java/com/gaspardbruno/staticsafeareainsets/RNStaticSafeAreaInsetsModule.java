package com.gaspardbruno.staticsafeareainsets;

import android.view.WindowInsets;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.HashMap;
import java.util.Map;

public class RNStaticSafeAreaInsetsModule extends ReactContextBaseJavaModule {
    public final ReactApplicationContext reactContext;

    public RNStaticSafeAreaInsetsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private Map<String, Object> _getSafeAreaInsets() {
        HashMap hashMap = new HashMap();
        if (getCurrentActivity() != null) {
            WindowInsets rootWindowInsets = getCurrentActivity().getWindow().getDecorView().getRootWindowInsets();
            hashMap.put("safeAreaInsetsTop", Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) rootWindowInsets.getSystemWindowInsetTop())));
            hashMap.put("safeAreaInsetsBottom", Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) rootWindowInsets.getSystemWindowInsetBottom())));
            hashMap.put("safeAreaInsetsLeft", Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) rootWindowInsets.getSystemWindowInsetLeft())));
            hashMap.put("safeAreaInsetsRight", Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) rootWindowInsets.getSystemWindowInsetRight())));
        } else {
            hashMap.put("safeAreaInsetsTop", 0);
            hashMap.put("safeAreaInsetsBottom", 0);
            hashMap.put("safeAreaInsetsLeft", 0);
            hashMap.put("safeAreaInsetsRight", 0);
        }
        return hashMap;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return _getSafeAreaInsets();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNStaticSafeAreaInsets";
    }

    @ReactMethod
    public void getSafeAreaInsets(Callback callback) {
        Map<String, Object> _getSafeAreaInsets = _getSafeAreaInsets();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("safeAreaInsetsTop", ((Float) _getSafeAreaInsets.get("safeAreaInsetsTop")).intValue());
        writableNativeMap.putInt("safeAreaInsetsBottom", ((Float) _getSafeAreaInsets.get("safeAreaInsetsBottom")).intValue());
        writableNativeMap.putInt("safeAreaInsetsLeft", ((Float) _getSafeAreaInsets.get("safeAreaInsetsLeft")).intValue());
        writableNativeMap.putInt("safeAreaInsetsRight", ((Float) _getSafeAreaInsets.get("safeAreaInsetsRight")).intValue());
        callback.invoke(writableNativeMap);
    }
}
