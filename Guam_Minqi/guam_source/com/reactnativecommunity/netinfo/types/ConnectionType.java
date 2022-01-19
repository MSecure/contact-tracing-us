package com.reactnativecommunity.netinfo.types;

public enum ConnectionType {
    BLUETOOTH("bluetooth"),
    CELLULAR("cellular"),
    ETHERNET("ethernet"),
    NONE("none"),
    UNKNOWN("unknown"),
    WIFI("wifi"),
    WIMAX("wimax"),
    VPN("vpn");
    
    public final String label;

    /* access modifiers changed from: public */
    ConnectionType(String str) {
        this.label = str;
    }
}
