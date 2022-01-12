package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import android.content.pm.PackageInfo;
import android.location.LocationManager;
import android.os.Build;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;

@ReactModule(name = "DeviceInfoModule")
public class DeviceInfoModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "DeviceInfoModule";
    public static final String TAG = "DeviceInfoModule";

    public DeviceInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private PackageInfo getPackageInfo() throws Exception {
        return getReactApplicationContext().getPackageManager().getPackageInfo(getReactApplicationContext().getPackageName(), 0);
    }

    @ReactMethod
    public void deviceSupportsLocationlessScanning(Promise promise) {
        promise.resolve(Boolean.valueOf(ExposureNotificationClientWrapper.get(getReactApplicationContext()).deviceSupportsLocationlessScanning()));
    }

    @ReactMethod
    public void getApplicationName(Promise promise) {
        promise.resolve(getReactApplicationContext().getApplicationInfo().loadLabel(getReactApplicationContext().getPackageManager()).toString());
    }

    @ReactMethod
    public void getBuildNumber(Promise promise) {
        try {
            promise.resolve(Integer.toString(getPackageInfo().versionCode));
        } catch (Exception unused) {
            promise.resolve("unknown");
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "DeviceInfoModule";
    }

    @ReactMethod
    public void getVersion(Promise promise) {
        try {
            promise.resolve(getPackageInfo().versionName);
        } catch (Exception unused) {
            promise.resolve("unknown");
        }
    }

    @ReactMethod
    public void isLocationEnabled(Promise promise) {
        boolean z;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        Object systemService = reactApplicationContext.getSystemService("location");
        if (systemService != null) {
            LocationManager locationManager = (LocationManager) systemService;
            if (Build.VERSION.SDK_INT >= 28) {
                z = locationManager.isLocationEnabled();
            } else {
                z = locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
            }
            promise.resolve(Boolean.valueOf(z));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }
}
