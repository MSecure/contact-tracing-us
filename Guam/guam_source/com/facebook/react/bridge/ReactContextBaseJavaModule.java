package com.facebook.react.bridge;

import android.app.Activity;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;

public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    public final ReactApplicationContext mReactApplicationContext;

    public ReactContextBaseJavaModule() {
        this.mReactApplicationContext = null;
    }

    public final Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }

    public final ReactApplicationContext getReactApplicationContext() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactApplicationContext, "Tried to get ReactApplicationContext even though NativeModule wasn't instantiated with one");
        return reactApplicationContext;
    }

    public final ReactApplicationContext getReactApplicationContextIfActiveOrWarn() {
        if (this.mReactApplicationContext.hasActiveCatalystInstance() || this.mReactApplicationContext.isBridgeless()) {
            return this.mReactApplicationContext;
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Catalyst Instance has already disappeared: requested by ");
        outline15.append(getName());
        ReactSoftException.logSoftException("ReactContextBaseJavaModule", new RuntimeException(outline15.toString()));
        return null;
    }

    public ReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }
}
