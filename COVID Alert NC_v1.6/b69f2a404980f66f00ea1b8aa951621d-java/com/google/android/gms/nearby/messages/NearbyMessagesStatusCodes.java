package com.google.android.gms.nearby.messages;

import c.b.a.a.c.k.c;

public class NearbyMessagesStatusCodes extends c {
    public static final int APP_NOT_OPTED_IN = 2802;
    public static final int APP_QUOTA_LIMIT_REACHED = 2804;
    public static final int BLE_ADVERTISING_UNSUPPORTED = 2821;
    public static final int BLE_SCANNING_UNSUPPORTED = 2822;
    public static final int BLUETOOTH_OFF = 2820;
    public static final int DISALLOWED_CALLING_CONTEXT = 2803;
    public static final int FORBIDDEN = 2806;
    public static final int MISSING_PERMISSIONS = 2807;
    public static final int NOT_AUTHORIZED = 2805;
    public static final int TOO_MANY_PENDING_INTENTS = 2801;

    public static String getStatusCodeString(int i) {
        switch (i) {
            case TOO_MANY_PENDING_INTENTS /*{ENCODED_INT: 2801}*/:
                return "TOO_MANY_PENDING_INTENTS";
            case APP_NOT_OPTED_IN /*{ENCODED_INT: 2802}*/:
                return "APP_NOT_OPTED_IN";
            case DISALLOWED_CALLING_CONTEXT /*{ENCODED_INT: 2803}*/:
                return "DISALLOWED_CALLING_CONTEXT";
            case APP_QUOTA_LIMIT_REACHED /*{ENCODED_INT: 2804}*/:
                return "APP_QUOTA_LIMIT_REACHED";
            case NOT_AUTHORIZED /*{ENCODED_INT: 2805}*/:
                return "NOT_AUTHORIZED";
            case FORBIDDEN /*{ENCODED_INT: 2806}*/:
                return "FORBIDDEN";
            case MISSING_PERMISSIONS /*{ENCODED_INT: 2807}*/:
                return "MISSING_PERMISSIONS";
            default:
                switch (i) {
                    case BLUETOOTH_OFF /*{ENCODED_INT: 2820}*/:
                        return "BLUETOOTH_OFF";
                    case BLE_ADVERTISING_UNSUPPORTED /*{ENCODED_INT: 2821}*/:
                        return "BLE_ADVERTISING_UNSUPPORTED";
                    case BLE_SCANNING_UNSUPPORTED /*{ENCODED_INT: 2822}*/:
                        return "BLE_SCANNING_UNSUPPORTED";
                    default:
                        return c.getStatusCodeString(i);
                }
        }
    }
}
