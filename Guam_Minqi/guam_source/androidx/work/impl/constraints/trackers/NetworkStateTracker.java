package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkStateTracker extends ConstraintTracker<NetworkState> {
    public static final String TAG = Logger.tagWithPrefix("NetworkStateTracker");
    public NetworkStateBroadcastReceiver mBroadcastReceiver;
    public final ConnectivityManager mConnectivityManager = ((ConnectivityManager) this.mAppContext.getSystemService("connectivity"));
    public NetworkStateCallback mNetworkCallback;

    public class NetworkStateBroadcastReceiver extends BroadcastReceiver {
        public NetworkStateBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Logger.get().debug(NetworkStateTracker.TAG, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
                networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
            }
        }
    }

    public class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        public NetworkStateCallback() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Logger.get().debug(NetworkStateTracker.TAG, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }

        public void onLost(Network network) {
            Logger.get().debug(NetworkStateTracker.TAG, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }
    }

    public NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        if (isNetworkCallbackSupported()) {
            this.mNetworkCallback = new NetworkStateCallback();
        } else {
            this.mBroadcastReceiver = new NetworkStateBroadcastReceiver();
        }
    }

    public static boolean isNetworkCallbackSupported() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public NetworkState getActiveNetworkState() {
        boolean z;
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        boolean z2 = true;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            NetworkCapabilities networkCapabilities = this.mConnectivityManager.getNetworkCapabilities(this.mConnectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                z = true;
                boolean isActiveNetworkMetered = this.mConnectivityManager.isActiveNetworkMetered();
                if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
                    z2 = false;
                }
                return new NetworkState(z3, z, isActiveNetworkMetered, z2);
            }
        } catch (SecurityException e) {
            Logger.get().error(TAG, "Unable to validate active network", e);
        }
        z = false;
        boolean isActiveNetworkMetered2 = this.mConnectivityManager.isActiveNetworkMetered();
        z2 = false;
        return new NetworkState(z3, z, isActiveNetworkMetered2, z2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState getInitialState() {
        return getActiveNetworkState();
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(TAG, "Registering network callback", new Throwable[0]);
                this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException | SecurityException e) {
                Logger.get().error(TAG, "Received exception while registering network callback", e);
            }
        } else {
            Logger.get().debug(TAG, "Registering broadcast receiver", new Throwable[0]);
            this.mAppContext.registerReceiver(this.mBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(TAG, "Unregistering network callback", new Throwable[0]);
                this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException | SecurityException e) {
                Logger.get().error(TAG, "Received exception while unregistering network callback", e);
            }
        } else {
            Logger.get().debug(TAG, "Unregistering broadcast receiver", new Throwable[0]);
            this.mAppContext.unregisterReceiver(this.mBroadcastReceiver);
        }
    }
}
