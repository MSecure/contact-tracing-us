package org.pathcheck.covidsafepaths;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzu;
import com.google.common.util.concurrent.MoreExecutors;
import com.horcrux.svg.R;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.devio.rn.splashscreen.SplashScreen$1;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.helpers.BluetoothHelper;
import org.pathcheck.covidsafepaths.helpers.LocationHelper;

public class MainActivity extends ReactActivity {
    public BluetoothHelper bluetoothHelper;
    public LocationHelper locationHelper;

    public final ReactContext getReactContext() {
        return ((ReactActivity) this).mDelegate.getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
    }

    public /* synthetic */ void lambda$checkIfExposureNotificationsEnabled$0$MainActivity(ExposureNotificationClientWrapper exposureNotificationClientWrapper, Boolean bool) {
        exposureNotificationClientWrapper.onExposureNotificationStateChanged(getReactContext(), bool.booleanValue());
    }

    @Override // androidx.fragment.app.FragmentActivity, com.facebook.react.ReactActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        ((ReactActivity) this).mDelegate.mReactDelegate.onActivityResult(i, i2, intent, true);
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(this);
        ReactContext reactContext = getReactContext();
        if (i2 != -1) {
            z = false;
        }
        if (exposureNotificationClientWrapper == null) {
            throw null;
        } else if (i == 1111) {
            if (z) {
                exposureNotificationClientWrapper.requestPermissionToStartTracing(reactContext);
                return;
            }
            exposureNotificationClientWrapper.onExposureNotificationStateChanged(reactContext, false);
            CallbackToFutureAdapter$Completer<Void> callbackToFutureAdapter$Completer = exposureNotificationClientWrapper.startTracingCompleter;
            if (callbackToFutureAdapter$Completer != null) {
                callbackToFutureAdapter$Completer.setException(new Exception("Cancelled by user"));
                exposureNotificationClientWrapper.startTracingCompleter = null;
            }
        } else if (i != 2222) {
        } else {
            if (z) {
                exposureNotificationClientWrapper.requestPermissionToGetExposureKeys(reactContext);
                return;
            }
            CallbackToFutureAdapter$Completer<List<TemporaryExposureKey>> callbackToFutureAdapter$Completer2 = exposureNotificationClientWrapper.getKeysCompleter;
            if (callbackToFutureAdapter$Completer2 != null) {
                callbackToFutureAdapter$Completer2.setException(new Exception("Cancelled by user"));
                exposureNotificationClientWrapper.getKeysCompleter = null;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.facebook.react.ReactActivity
    public void onCreate(Bundle bundle) {
        MoreExecutors.mActivity = new WeakReference<>(this);
        runOnUiThread(new SplashScreen$1(this, R.style.SplashTheme));
        super.onCreate(bundle);
        this.bluetoothHelper = new BluetoothHelper(new BluetoothHelper.BluetoothCallback() {
            /* class org.pathcheck.covidsafepaths.MainActivity.AnonymousClass1 */

            public void onBluetoothAvailable() {
                DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
                ReactContext reactContext = MainActivity.this.getReactContext();
                if (reactContext != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
                    rCTDeviceEventEmitter.emit("onBluetoothStatusUpdated", true);
                }
            }

            public void onBluetoothUnavailable() {
                DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
                ReactContext reactContext = MainActivity.this.getReactContext();
                if (reactContext != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
                    rCTDeviceEventEmitter.emit("onBluetoothStatusUpdated", false);
                }
            }
        });
        this.locationHelper = new LocationHelper(new LocationHelper.LocationCallback() {
            /* class org.pathcheck.covidsafepaths.MainActivity.AnonymousClass2 */

            public void onLocationAvailable() {
                DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
                ReactContext reactContext = MainActivity.this.getReactContext();
                if (reactContext != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
                    rCTDeviceEventEmitter.emit("onLocationStatusUpdated", true);
                }
            }

            public void onLocationUnavailable() {
                DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
                ReactContext reactContext = MainActivity.this.getReactContext();
                if (reactContext != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
                    rCTDeviceEventEmitter.emit("onLocationStatusUpdated", false);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, com.facebook.react.ReactActivity
    public void onPause() {
        super.onPause();
        BluetoothHelper bluetoothHelper2 = this.bluetoothHelper;
        if (bluetoothHelper2 != null) {
            Intrinsics.checkNotNullParameter(this, "context");
            unregisterReceiver(bluetoothHelper2.receiver);
            LocationHelper locationHelper2 = this.locationHelper;
            if (locationHelper2 != null) {
                Intrinsics.checkNotNullParameter(this, "context");
                unregisterReceiver(locationHelper2.receiver);
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // androidx.fragment.app.FragmentActivity, com.facebook.react.ReactActivity
    public void onResume() {
        boolean z;
        super.onResume();
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = ExposureNotificationClientWrapper.get(this);
        Task<Boolean> isEnabled = exposureNotificationClientWrapper.isEnabled();
        $$Lambda$MainActivity$vDsfGjdrkHULg2sNzJrqPPE7JA r2 = new OnSuccessListener(exposureNotificationClientWrapper) {
            /* class org.pathcheck.covidsafepaths.$$Lambda$MainActivity$vDsfGjdrkHULg2sNzJrqPPE7JA */
            public final /* synthetic */ ExposureNotificationClientWrapper f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                MainActivity.this.lambda$checkIfExposureNotificationsEnabled$0$MainActivity(this.f$1, (Boolean) obj);
            }
        };
        zzu zzu = (zzu) isEnabled;
        if (zzu != null) {
            zzu.addOnSuccessListener(TaskExecutors.MAIN_THREAD, r2);
            BluetoothHelper bluetoothHelper2 = this.bluetoothHelper;
            if (bluetoothHelper2 != null) {
                Intrinsics.checkNotNullParameter(this, "context");
                registerReceiver(bluetoothHelper2.receiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                boolean z2 = false;
                if (defaultAdapter == null) {
                    z = false;
                } else {
                    z = defaultAdapter.isEnabled();
                }
                if (z) {
                    ((AnonymousClass1) bluetoothHelper2.callback).onBluetoothAvailable();
                } else {
                    ((AnonymousClass1) bluetoothHelper2.callback).onBluetoothUnavailable();
                }
                LocationHelper locationHelper2 = this.locationHelper;
                if (locationHelper2 != null) {
                    Intrinsics.checkNotNullParameter(this, "context");
                    registerReceiver(locationHelper2.receiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
                    Intrinsics.checkNotNullParameter(this, "context");
                    Object systemService = getSystemService("location");
                    if (systemService != null) {
                        LocationManager locationManager = (LocationManager) systemService;
                        if (Build.VERSION.SDK_INT >= 28) {
                            z2 = locationManager.isLocationEnabled();
                        } else if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
                            z2 = true;
                        }
                        if (z2) {
                            ((AnonymousClass2) locationHelper2.callback).onLocationAvailable();
                        } else {
                            ((AnonymousClass2) locationHelper2.callback).onLocationUnavailable();
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }
}
