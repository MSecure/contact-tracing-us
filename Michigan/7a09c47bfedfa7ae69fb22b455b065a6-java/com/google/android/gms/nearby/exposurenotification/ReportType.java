package com.google.android.gms.nearby.exposurenotification;

public @interface ReportType {
    public static final int CONFIRMED_CLINICAL_DIAGNOSIS = 2;
    public static final int CONFIRMED_TEST = 1;
    public static final int RECURSIVE = 4;
    public static final int REVOKED = 5;
    public static final int SELF_REPORT = 3;
    public static final int UNKNOWN = 0;
}
