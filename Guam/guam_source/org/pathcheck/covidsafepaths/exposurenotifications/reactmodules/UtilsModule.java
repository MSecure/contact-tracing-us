package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import android.content.Intent;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "UtilsModule")
public class UtilsModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "UtilsModule";
    public static final String TAG = "UtilsModule";

    public UtilsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "UtilsModule";
    }

    @ReactMethod
    public void openAppSettings() {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setFlags(268435456);
        if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) != null) {
            getReactApplicationContext().startActivity(intent);
        } else {
            Log.e("UtilsModule", "Cannot open settings screen");
        }
    }
}
