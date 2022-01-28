package com.google.android.gms.nearby.exposurenotification;

import c.b.a.a.g.e.ya;

public enum zzg {
    LOWEST_CONFIDENCE(0),
    LOW_CONFIDENCE(1),
    MEDIUM_CONFIDENCE(2),
    HIGH_CONFIDENCE(3);
    
    public static final ya<zzg> zze = new zzf();
    public final int zzf;

    /* access modifiers changed from: public */
    zzg(int i) {
        this.zzf = i;
    }

    public static zzg zza(int i) {
        if (i == 0) {
            return LOWEST_CONFIDENCE;
        }
        if (i == 1) {
            return LOW_CONFIDENCE;
        }
        if (i == 2) {
            return MEDIUM_CONFIDENCE;
        }
        if (i != 3) {
            return null;
        }
        return HIGH_CONFIDENCE;
    }

    public final String toString() {
        return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }
}
