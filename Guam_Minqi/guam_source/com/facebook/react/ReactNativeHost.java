package com.facebook.react;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bugsnag.android.BugsnagPackage;
import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.jscexecutor.JSCExecutorFactory;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.soloader.SoLoader;
import com.horcrux.svg.SvgPackage;
import com.lugg.ReactNativeConfig.ReactNativeConfigPackage;
import com.pedrouid.crypto.RCTCryptoPackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.rnpermissions.RNPermissionsPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.terveystalo.react_native.matomo_sdk.RNMatomoSdkPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.devio.rn.splashscreen.SplashScreenReactPackage;
import org.pathcheck.covidsafepaths.bridge.ExposureNotificationsPackage;
import org.reactnative.maskedview.RNCMaskedViewPackage;

public abstract class ReactNativeHost {
    public final Application mApplication;
    public ReactInstanceManager mReactInstanceManager;

    public ReactNativeHost(Application application) {
        this.mApplication = application;
    }

    public ReactInstanceManager getReactInstanceManager() {
        JavaScriptExecutorFactory javaScriptExecutorFactory;
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
            ArrayList arrayList = new ArrayList();
            Application application = this.mApplication;
            UIImplementationProvider uIImplementationProvider = new UIImplementationProvider();
            LifecycleState lifecycleState = LifecycleState.BEFORE_CREATE;
            ArrayList arrayList2 = new ArrayList(Arrays.asList(new MainReactPackage(), new BugsnagPackage(), new AsyncStoragePackage(), new RNDateTimePickerPackage(), new RNCMaskedViewPackage(), new NetInfoPackage(), new ReactNativeConfigPackage(), new RNGestureHandlerPackage(), new RNMatomoSdkPackage(), new RNPermissionsPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RCTCryptoPackage(), new SplashScreenReactPackage(), new SvgPackage()));
            arrayList2.add(new ExposureNotificationsPackage());
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add((ReactPackage) it.next());
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull("index.android.bundle");
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(application, "Application property has not been set with this builder");
            AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(true, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
            AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(true, "Either MainModulePath or JS Bundle File needs to be provided");
            String packageName = application.getPackageName();
            String friendlyDeviceName = AndroidInfoHelpers.getFriendlyDeviceName();
            try {
                SoLoader.init(application.getApplicationContext(), false);
                SoLoader.loadLibrary("jscexecutor");
                javaScriptExecutorFactory = new JSCExecutorFactory(packageName, friendlyDeviceName);
            } catch (UnsatisfiedLinkError e) {
                if (!e.getMessage().contains("__cxa_bad_typeid")) {
                    try {
                        javaScriptExecutorFactory = new HermesExecutorFactory();
                    } catch (UnsatisfiedLinkError e2) {
                        e2.printStackTrace();
                        throw e;
                    }
                } else {
                    throw e;
                }
            }
            JSBundleLoader createAssetLoader = JSBundleLoader.createAssetLoader(application, "assets://index.android.bundle", false);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(lifecycleState, "Initial lifecycle state was not set");
            ReactInstanceManager reactInstanceManager = new ReactInstanceManager(application, null, null, javaScriptExecutorFactory, createAssetLoader, "index", arrayList, false, null, lifecycleState, uIImplementationProvider, null, null, false, null, 1, -1, null, null);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
            this.mReactInstanceManager = reactInstanceManager;
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
        }
        return this.mReactInstanceManager;
    }

    public boolean hasInstance() {
        return this.mReactInstanceManager != null;
    }
}
