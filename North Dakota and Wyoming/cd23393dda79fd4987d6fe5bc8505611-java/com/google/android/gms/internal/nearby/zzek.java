package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzek implements RemoteCall {
    private final zzei zza;
    private final byte[] zzb;
    private final String zzc;
    private final ListenerHolder zzd;
    private final ConnectionOptions zze;

    zzek(zzei zzei, byte[] bArr, String str, ListenerHolder listenerHolder, ConnectionOptions connectionOptions) {
        this.zza = zzei;
        this.zzb = bArr;
        this.zzc = str;
        this.zzd = listenerHolder;
        this.zze = connectionOptions;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzei zzei = this.zza;
        ((zzdd) obj).zza(new zzfo(zzei, (TaskCompletionSource) obj2), this.zzb, this.zzc, this.zzd, this.zze);
    }
}
