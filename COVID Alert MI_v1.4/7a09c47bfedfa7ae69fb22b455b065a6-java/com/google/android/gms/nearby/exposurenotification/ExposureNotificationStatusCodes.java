package com.google.android.gms.nearby.exposurenotification;

import c.b.a.a.d.k.c;

public final class ExposureNotificationStatusCodes extends c {
    public static final int FAILED = 13;
    public static final int FAILED_ALREADY_STARTED = 39500;
    public static final int FAILED_BLUETOOTH_DISABLED = 39504;
    public static final int FAILED_DISK_IO = 39506;
    public static final int FAILED_NOT_SUPPORTED = 39501;
    public static final int FAILED_RATE_LIMITED = 39508;
    public static final int FAILED_REJECTED_OPT_IN = 39502;
    public static final int FAILED_SERVICE_DISABLED = 39503;
    public static final int FAILED_TEMPORARILY_DISABLED = 39505;
    public static final int FAILED_UNAUTHORIZED = 39507;

    public static String getStatusCodeString(int i) {
        switch (i) {
            case FAILED_ALREADY_STARTED /*{ENCODED_INT: 39500}*/:
                return "FAILED_ALREADY_STARTED";
            case FAILED_NOT_SUPPORTED /*{ENCODED_INT: 39501}*/:
                return "FAILED_NOT_SUPPORTED";
            case FAILED_REJECTED_OPT_IN /*{ENCODED_INT: 39502}*/:
                return "FAILED_REJECTED_OPT_IN";
            case FAILED_SERVICE_DISABLED /*{ENCODED_INT: 39503}*/:
                return "FAILED_SERVICE_DISABLED";
            case FAILED_BLUETOOTH_DISABLED /*{ENCODED_INT: 39504}*/:
                return "FAILED_BLUETOOTH_DISABLED";
            case FAILED_TEMPORARILY_DISABLED /*{ENCODED_INT: 39505}*/:
                return "FAILED_TEMPORARILY_DISABLED";
            case FAILED_DISK_IO /*{ENCODED_INT: 39506}*/:
                return "FAILED_DISK_IO";
            case FAILED_UNAUTHORIZED /*{ENCODED_INT: 39507}*/:
                return "FAILED_UNAUTHORIZED";
            case FAILED_RATE_LIMITED /*{ENCODED_INT: 39508}*/:
                return "FAILED_RATE_LIMITED";
            default:
                return c.getStatusCodeString(i);
        }
    }
}
