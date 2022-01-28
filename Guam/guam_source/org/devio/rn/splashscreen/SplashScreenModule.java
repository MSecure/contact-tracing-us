package org.devio.rn.splashscreen;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.horcrux.svg.PathParser;
import java.lang.ref.WeakReference;

public class SplashScreenModule extends ReactContextBaseJavaModule {
    public SplashScreenModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "SplashScreen";
    }

    @ReactMethod
    public void hide() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            WeakReference<Activity> weakReference = PathParser.mActivity;
            if (weakReference != null) {
                currentActivity = weakReference.get();
            } else {
                return;
            }
        }
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new SplashScreen$2(currentActivity));
        }
    }

    @ReactMethod
    public void show() {
        Activity currentActivity = getCurrentActivity();
        int i = R$style.SplashScreen_SplashTheme;
        if (currentActivity != null) {
            PathParser.mActivity = new WeakReference<>(currentActivity);
            currentActivity.runOnUiThread(new SplashScreen$1(currentActivity, i));
        }
    }
}
