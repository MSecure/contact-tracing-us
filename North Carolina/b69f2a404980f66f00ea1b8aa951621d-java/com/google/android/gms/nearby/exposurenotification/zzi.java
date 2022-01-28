package com.google.android.gms.nearby.exposurenotification;

import c.b.a.a.e.c.ya;

public enum zzi {
    INFECTIOUSNESS_NONE(0),
    INFECTIOUSNESS_STANDARD(1),
    INFECTIOUSNESS_HIGH(2);
    
    public static final ya<zzi> zzd = new zzh();
    public final int zze;

    /* access modifiers changed from: public */
    zzi(int i) {
        this.zze = i;
    }

    public static zzi zza(int i) {
        if (i == 0) {
            return INFECTIOUSNESS_NONE;
        }
        if (i == 1) {
            return INFECTIOUSNESS_STANDARD;
        }
        if (i != 2) {
            return null;
        }
        return INFECTIOUSNESS_HIGH;
    }

    public final String toString() {
        return "<" + zzi.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }
}
