package com.google.android.gms.nearby.exposurenotification;

import c.b.a.a.g.e.qa;
import c.b.a.a.g.e.ta;
import java.util.Arrays;
import java.util.Set;

public enum ExposureNotificationStatus {
    ACTIVATED(1),
    INACTIVATED(2),
    BLUETOOTH_DISABLED(4),
    LOCATION_DISABLED(8),
    NO_CONSENT(16),
    NOT_IN_WHITELIST(32),
    BLUETOOTH_SUPPORT_UNKNOWN(64),
    HW_NOT_SUPPORT(128),
    FOCUS_LOST(256),
    LOW_STORAGE(512),
    UNKNOWN(1024),
    EN_NOT_SUPPORT(2048),
    USER_PROFILE_NOT_SUPPORT(4096);
    
    public final long zza;

    /* access modifiers changed from: public */
    ExposureNotificationStatus(long j) {
        this.zza = j;
    }

    public static qa<ExposureNotificationStatus> fromValue(long j) {
        Object[] objArr = new Object[4];
        ExposureNotificationStatus[] values = values();
        int i = 0;
        boolean z = false;
        for (ExposureNotificationStatus exposureNotificationStatus : values) {
            if ((exposureNotificationStatus.zza & j) != 0) {
                int i2 = i + 1;
                if (objArr.length < i2) {
                    int length = objArr.length;
                    if (i2 >= 0) {
                        int i3 = length + (length >> 1) + 1;
                        if (i3 < i2) {
                            i3 = Integer.highestOneBit(i2 - 1) << 1;
                        }
                        if (i3 < 0) {
                            i3 = Integer.MAX_VALUE;
                        }
                        objArr = Arrays.copyOf(objArr, i3);
                    } else {
                        throw new AssertionError("cannot store more than MAX_VALUE elements");
                    }
                } else {
                    if (z) {
                        objArr = (Object[]) objArr.clone();
                    }
                    objArr[i] = exposureNotificationStatus;
                    i++;
                }
                z = false;
                objArr[i] = exposureNotificationStatus;
                i++;
            }
        }
        if (i == 0) {
            return ta.i;
        }
        if (i == 1) {
            return qa.q(objArr[0]);
        }
        qa<ExposureNotificationStatus> p = qa.p(i, objArr);
        p.size();
        return p;
    }

    public static long getValues(Set<ExposureNotificationStatus> set) {
        long j = 0;
        for (ExposureNotificationStatus exposureNotificationStatus : set) {
            j |= exposureNotificationStatus.zza;
        }
        return j;
    }
}
