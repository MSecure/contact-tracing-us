package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzu implements RemoteCall {
    public final zzt zza;

    public zzu(zzt zzt) {
        this.zza = zzt;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzak zzak = new zzak((TaskCompletionSource) obj2);
        zzci zzci = new zzci((zzcl) null);
        zzci.zza = zzak;
        ((zzdv) ((zzr) obj).getService()).zza(zzci);
    }
}
