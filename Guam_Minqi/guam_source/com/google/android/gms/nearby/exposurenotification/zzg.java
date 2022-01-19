package com.google.android.gms.nearby.exposurenotification;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public enum zzg {
    INFECTIOUSNESS_NONE(0),
    INFECTIOUSNESS_STANDARD(1),
    INFECTIOUSNESS_HIGH(2);
    
    public final int zze;

    /* access modifiers changed from: public */
    zzg(int i) {
        this.zze = i;
    }

    public static zzg zza(int i) {
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
        return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }
}
