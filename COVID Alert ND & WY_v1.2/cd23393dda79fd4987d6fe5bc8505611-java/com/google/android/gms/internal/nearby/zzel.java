package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzel implements RemoteCall {
    private final zzei zza;
    private final String zzb;
    private final String zzc;
    private final ListenerHolder zzd;
    private final ConnectionOptions zze;

    zzel(zzei zzei, String str, String str2, ListenerHolder listenerHolder, ConnectionOptions connectionOptions) {
        this.zza = zzei;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = listenerHolder;
        this.zze = connectionOptions;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzei zzei = this.zza;
        ((zzdd) obj).zza(new zzfo(zzei, (TaskCompletionSource) obj2), this.zzb, this.zzc, this.zzd, this.zze);
    }
}
