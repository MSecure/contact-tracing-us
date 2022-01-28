package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbk extends zzbu {
    private final /* synthetic */ Message zza;
    private final /* synthetic */ zzbs zzb;
    private final /* synthetic */ PublishOptions zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbk(zzbj zzbj, GoogleApiClient googleApiClient, Message message, zzbs zzbs, PublishOptions publishOptions) {
        super(googleApiClient);
        this.zza = message;
        this.zzb = zzbs;
        this.zzc = publishOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzag zzag) throws RemoteException {
        zzag.zza(zza(), zzae.zza(this.zza), this.zzb, this.zzc);
    }
}
