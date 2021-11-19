package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.internal.Objects;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzee {
    private final String zza;
    private final long zzb;

    zzee(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final String zza() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzee) {
            zzee zzee = (zzee) obj;
            return Objects.equal(this.zza, zzee.zza) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzee.zzb));
        }
    }
}
