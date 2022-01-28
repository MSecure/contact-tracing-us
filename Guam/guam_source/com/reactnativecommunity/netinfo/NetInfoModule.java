package com.reactnativecommunity.netinfo;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPoller;

@ReactModule(name = NetInfoModule.NAME)
public class NetInfoModule extends ReactContextBaseJavaModule implements AmazonFireDeviceConnectivityPoller.ConnectivityChangedCallback {
    public static final String NAME = "RNCNetInfo";
    public final AmazonFireDeviceConnectivityPoller mAmazonConnectivityChecker;
    public final ConnectivityReceiver mConnectivityReceiver;

    public NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mConnectivityReceiver = new NetworkCallbackConnectivityReceiver(reactApplicationContext);
        } else {
            this.mConnectivityReceiver = new BroadcastReceiverConnectivityReceiver(reactApplicationContext);
        }
        this.mAmazonConnectivityChecker = new AmazonFireDeviceConnectivityPoller(reactApplicationContext, this);
    }

    @ReactMethod
    public void getCurrentState(String str, Promise promise) {
        promise.resolve(this.mConnectivityReceiver.createConnectivityEventMap(str));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        this.mConnectivityReceiver.register();
        AmazonFireDeviceConnectivityPoller amazonFireDeviceConnectivityPoller = this.mAmazonConnectivityChecker;
        if (amazonFireDeviceConnectivityPoller.isFireOsDevice()) {
            if (!amazonFireDeviceConnectivityPoller.receiver.registered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_DOWN");
                intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_UP");
                amazonFireDeviceConnectivityPoller.context.registerReceiver(amazonFireDeviceConnectivityPoller.receiver, intentFilter);
                amazonFireDeviceConnectivityPoller.receiver.registered = true;
            }
            if (!amazonFireDeviceConnectivityPoller.pollerRunning) {
                Handler handler = new Handler();
                amazonFireDeviceConnectivityPoller.handler = handler;
                amazonFireDeviceConnectivityPoller.pollerRunning = true;
                handler.post(amazonFireDeviceConnectivityPoller.checker);
            }
        }
    }

    @Override // com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPoller.ConnectivityChangedCallback
    public void onAmazonFireDeviceConnectivityChanged(boolean z) {
        ConnectivityReceiver connectivityReceiver = this.mConnectivityReceiver;
        connectivityReceiver.mIsInternetReachableOverride = Boolean.valueOf(z);
        connectivityReceiver.updateConnectivity(connectivityReceiver.mConnectionType, connectivityReceiver.mCellularGeneration, connectivityReceiver.mIsInternetReachable);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        AmazonFireDeviceConnectivityPoller amazonFireDeviceConnectivityPoller = this.mAmazonConnectivityChecker;
        if (amazonFireDeviceConnectivityPoller.isFireOsDevice()) {
            if (amazonFireDeviceConnectivityPoller.pollerRunning) {
                amazonFireDeviceConnectivityPoller.pollerRunning = false;
                amazonFireDeviceConnectivityPoller.handler.removeCallbacksAndMessages(null);
                amazonFireDeviceConnectivityPoller.handler = null;
            }
            AmazonFireDeviceConnectivityPoller.Receiver receiver = amazonFireDeviceConnectivityPoller.receiver;
            if (receiver.registered) {
                amazonFireDeviceConnectivityPoller.context.unregisterReceiver(receiver);
                amazonFireDeviceConnectivityPoller.receiver.registered = false;
            }
        }
        this.mConnectivityReceiver.unregister();
    }
}
