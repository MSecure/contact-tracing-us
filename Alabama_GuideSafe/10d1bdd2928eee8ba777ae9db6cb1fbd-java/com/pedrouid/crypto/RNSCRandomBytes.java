package com.pedrouid.crypto;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class RNSCRandomBytes extends ReactContextBaseJavaModule {
    public static final String SEED_KEY = "seed";

    public RNSCRandomBytes(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private String getRandomBytes(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 2);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(SEED_KEY, getRandomBytes(4096));
        return hashMap;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSCRandomBytes";
    }

    @ReactMethod
    public void randomBytes(int i, Promise promise) {
        try {
            promise.resolve(getRandomBytes(i));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }
}
