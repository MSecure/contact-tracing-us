package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzcr {
    private final Class<?> zza;
    private final Api.ApiOptions zzb = null;

    zzcr(GoogleApi<?> googleApi, Api.ApiOptions apiOptions) {
        this.zza = googleApi.getClass();
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcr) {
            zzcr zzcr = (zzcr) obj;
            if (!Objects.equal(this.zza, zzcr.zza) || !Objects.equal(this.zzb, zzcr.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
