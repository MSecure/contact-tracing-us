package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzcf {
    private final zzcd zza = new zzcd();

    public final zzcf zza(IStatusCallback iStatusCallback) {
        this.zza.zzb = iStatusCallback;
        return this;
    }

    public final zzcf zza(List<ParcelFileDescriptor> list) {
        this.zza.zzc = list;
        return this;
    }

    public final zzcf zza(ExposureConfiguration exposureConfiguration) {
        this.zza.zzd = exposureConfiguration;
        return this;
    }

    public final zzcf zza(String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzcd zza() {
        return this.zza;
    }
}
