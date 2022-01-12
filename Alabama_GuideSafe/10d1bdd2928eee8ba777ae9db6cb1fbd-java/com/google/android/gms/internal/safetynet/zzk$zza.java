package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNetApi$zza;
import com.google.android.gms.safetynet.zza;

public final class zzk$zza implements SafetyNetApi$zza {
    public final Status zzad;
    public final zza zzae;

    public zzk$zza(Status status, zza zza) {
        this.zzad = status;
        this.zzae = zza;
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi$zza
    public final String getJwsResult() {
        zza zza = this.zzae;
        if (zza == null) {
            return null;
        }
        return zza.zze;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzad;
    }
}
