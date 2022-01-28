package com.bugfender.sdk.a.a.f.e;

import androidx.exifinterface.media.ExifInterface;

public enum b {
    VERBOSE(ExifInterface.GPS_MEASUREMENT_INTERRUPTED),
    DEBUG("D"),
    INFO("I"),
    WARNING(ExifInterface.LONGITUDE_WEST),
    ERROR(ExifInterface.LONGITUDE_EAST),
    ASSERT(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS),
    WTF("F");
    
    private final String a;

    private b(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public static b a(char c) {
        if (c == 'A') {
            return ASSERT;
        }
        if (c == 'I') {
            return INFO;
        }
        if (c == 'E') {
            return ERROR;
        }
        if (c == 'F') {
            return WTF;
        }
        if (c == 'V') {
            return VERBOSE;
        }
        if (c != 'W') {
            return DEBUG;
        }
        return WARNING;
    }
}
