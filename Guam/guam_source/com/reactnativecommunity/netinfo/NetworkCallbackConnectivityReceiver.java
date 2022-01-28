package com.reactnativecommunity.netinfo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

@TargetApi(24)
public class NetworkCallbackConnectivityReceiver extends ConnectivityReceiver {
    public Network mNetwork = null;
    public final ConnectivityNetworkCallback mNetworkCallback = new ConnectivityNetworkCallback(null);
    public NetworkCapabilities mNetworkCapabilities = null;

    public class ConnectivityNetworkCallback extends ConnectivityManager.NetworkCallback {
        public ConnectivityNetworkCallback(AnonymousClass1 r2) {
        }

        public void onAvailable(Network network) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = network;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.mConnectivityManager.getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = network;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCapabilities;
            networkCallbackConnectivityReceiver.updateAndSend();
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            if (networkCallbackConnectivityReceiver.mNetwork != null) {
                networkCallbackConnectivityReceiver.mNetwork = network;
                networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.mConnectivityManager.getNetworkCapabilities(network);
            }
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLosing(Network network, int i) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = network;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.mConnectivityManager.getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLost(Network network) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = null;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = null;
            networkCallbackConnectivityReceiver.updateAndSend();
        }

        public void onUnavailable() {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.mNetwork = null;
            networkCallbackConnectivityReceiver.mNetworkCapabilities = null;
            networkCallbackConnectivityReceiver.updateAndSend();
        }
    }

    public NetworkCallbackConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    @SuppressLint({"MissingPermission"})
    public void register() {
        try {
            this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
        } catch (SecurityException unused) {
        }
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    public void unregister() {
        try {
            this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException unused) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public void updateAndSend() {
        boolean z;
        ConnectionType connectionType = ConnectionType.CELLULAR;
        ConnectionType connectionType2 = ConnectionType.UNKNOWN;
        NetworkCapabilities networkCapabilities = this.mNetworkCapabilities;
        CellularGeneration cellularGeneration = null;
        boolean z2 = false;
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(2)) {
                connectionType2 = ConnectionType.BLUETOOTH;
            } else if (this.mNetworkCapabilities.hasTransport(0)) {
                connectionType2 = connectionType;
            } else if (this.mNetworkCapabilities.hasTransport(3)) {
                connectionType2 = ConnectionType.ETHERNET;
            } else if (this.mNetworkCapabilities.hasTransport(1)) {
                connectionType2 = ConnectionType.WIFI;
            } else if (this.mNetworkCapabilities.hasTransport(4)) {
                connectionType2 = ConnectionType.VPN;
            }
            Network network = this.mNetwork;
            NetworkInfo networkInfo = network != null ? this.mConnectivityManager.getNetworkInfo(network) : null;
            if (Build.VERSION.SDK_INT >= 28) {
                z = !this.mNetworkCapabilities.hasCapability(21);
            } else {
                z = (this.mNetwork == null || networkInfo == null || networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) ? false : true;
            }
            if (this.mNetworkCapabilities.hasCapability(12) && this.mNetworkCapabilities.hasCapability(16) && !z) {
                z2 = true;
            }
            if (this.mNetwork != null && connectionType2 == connectionType && z2) {
                cellularGeneration = CellularGeneration.fromNetworkInfo(networkInfo);
            }
        } else {
            connectionType2 = ConnectionType.NONE;
        }
        updateConnectivity(connectionType2, cellularGeneration, z2);
    }
}
