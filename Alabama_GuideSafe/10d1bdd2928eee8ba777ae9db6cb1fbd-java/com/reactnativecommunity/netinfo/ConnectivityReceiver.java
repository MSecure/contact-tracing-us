package com.reactnativecommunity.netinfo;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.common.util.concurrent.MoreExecutors;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Locale;

public abstract class ConnectivityReceiver {
    public CellularGeneration mCellularGeneration = null;
    public ConnectionType mConnectionType = ConnectionType.UNKNOWN;
    public final ConnectivityManager mConnectivityManager;
    public boolean mIsInternetReachable = false;
    public Boolean mIsInternetReachableOverride;
    public final ReactApplicationContext mReactContext;
    public final TelephonyManager mTelephonyManager;
    public final WifiManager mWifiManager;

    public ConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        this.mConnectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.mWifiManager = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.mTelephonyManager = (TelephonyManager) reactApplicationContext.getSystemService("phone");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:45|46|(1:50)|51|52|(1:54)|55|56|57|58|59|60|61|62) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00ea */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0107 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cd A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0184  */
    public final WritableMap createConnectivityEventMap(String str) {
        String str2;
        boolean z;
        WifiInfo connectionInfo;
        WritableMap createMap = Arguments.createMap();
        if (ContextCompat.checkSelfPermission(this.mReactContext, "android.permission.ACCESS_WIFI_STATE") == 0) {
            createMap.putBoolean("isWifiEnabled", this.mWifiManager.isWifiEnabled());
        }
        if (str != null) {
            str2 = str;
        } else {
            str2 = this.mConnectionType.label;
        }
        createMap.putString("type", str2);
        boolean z2 = !this.mConnectionType.equals(ConnectionType.NONE) && !this.mConnectionType.equals(ConnectionType.UNKNOWN);
        createMap.putBoolean("isConnected", z2);
        createMap.putBoolean("isInternetReachable", this.mIsInternetReachable && (str == null || str.equals(this.mConnectionType.label)));
        if (str == null) {
            str = this.mConnectionType.label;
        }
        WritableMap createMap2 = Arguments.createMap();
        int hashCode = str.hashCode();
        if (hashCode != -916596374) {
            if (hashCode == 3649301 && str.equals("wifi")) {
                z = true;
                if (!z) {
                    CellularGeneration cellularGeneration = this.mCellularGeneration;
                    if (cellularGeneration != null) {
                        createMap2.putString("cellularGeneration", cellularGeneration.label);
                    }
                    String networkOperatorName = this.mTelephonyManager.getNetworkOperatorName();
                    if (networkOperatorName != null) {
                        createMap2.putString("carrier", networkOperatorName);
                    }
                } else if (z) {
                    if ((ContextCompat.checkSelfPermission(this.mReactContext, "android.permission.ACCESS_WIFI_STATE") == 0) && (connectionInfo = this.mWifiManager.getConnectionInfo()) != null) {
                        String ssid = connectionInfo.getSSID();
                        if (ssid != null && !ssid.contains("<unknown ssid>")) {
                            createMap2.putString("ssid", ssid.replace("\"", ""));
                        }
                        String bssid = connectionInfo.getBSSID();
                        if (bssid != null) {
                            createMap2.putString("bssid", bssid);
                        }
                        createMap2.putInt("strength", WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100));
                        createMap2.putInt("frequency", connectionInfo.getFrequency());
                        byte[] byteArray = BigInteger.valueOf((long) connectionInfo.getIpAddress()).toByteArray();
                        MoreExecutors.reverseByteArray(byteArray);
                        createMap2.putString("ipAddress", InetAddress.getByAddress(byteArray).getHostAddress());
                        byte[] byteArray2 = BigInteger.valueOf((long) connectionInfo.getIpAddress()).toByteArray();
                        MoreExecutors.reverseByteArray(byteArray2);
                        int networkPrefixLength = -1 << (32 - NetworkInterface.getByInetAddress(InetAddress.getByAddress(byteArray2)).getInterfaceAddresses().get(1).getNetworkPrefixLength());
                        createMap2.putString("subnet", String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((networkPrefixLength >> 24) & 255), Integer.valueOf((networkPrefixLength >> 16) & 255), Integer.valueOf((networkPrefixLength >> 8) & 255), Integer.valueOf(networkPrefixLength & 255)));
                    }
                }
                if (z2) {
                    createMap2.putBoolean("isConnectionExpensive", this.mConnectivityManager.isActiveNetworkMetered());
                }
                createMap.putMap("details", createMap2);
                return createMap;
            }
        } else if (str.equals("cellular")) {
            z = false;
            if (!z) {
            }
            if (z2) {
            }
            createMap.putMap("details", createMap2);
            return createMap;
        }
        z = true;
        if (!z) {
        }
        if (z2) {
        }
        createMap.putMap("details", createMap2);
        return createMap;
    }

    public abstract void register();

    public abstract void unregister();

    public void updateConnectivity(ConnectionType connectionType, CellularGeneration cellularGeneration, boolean z) {
        Boolean bool = this.mIsInternetReachableOverride;
        if (bool != null) {
            z = bool.booleanValue();
        }
        boolean z2 = true;
        boolean z3 = connectionType != this.mConnectionType;
        boolean z4 = cellularGeneration != this.mCellularGeneration;
        if (z == this.mIsInternetReachable) {
            z2 = false;
        }
        if (z3 || z4 || z2) {
            this.mConnectionType = connectionType;
            this.mCellularGeneration = cellularGeneration;
            this.mIsInternetReachable = z;
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("netInfo.networkStatusDidChange", createConnectivityEventMap(null));
        }
    }
}
