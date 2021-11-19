package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Payload;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdz extends zzeb<Connections.MessageListener> {
    private final /* synthetic */ zziq zza;
    private final /* synthetic */ zzdw zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdz(zzdw zzdw, zziq zziq) {
        super();
        this.zzb = zzdw;
        this.zza = zziq;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        Connections.MessageListener messageListener = (Connections.MessageListener) obj;
        Payload zza2 = zzjg.zza(zzdw.zza(this.zzb), this.zza.zzb());
        if (zza2 == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(this.zza.zzb().zza())));
        } else if (zza2.getType() == 1) {
            messageListener.onMessageReceived(this.zza.zza(), zza2.asBytes(), this.zza.zzc());
        }
    }
}
