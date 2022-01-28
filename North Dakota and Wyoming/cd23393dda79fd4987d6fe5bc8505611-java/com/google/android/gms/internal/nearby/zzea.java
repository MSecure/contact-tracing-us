package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzea extends zzhp {
    private final Context zza;
    private final ListenerHolder<PayloadCallback> zzb;
    private final Map<zzee, PayloadTransferUpdate> zzc = new ArrayMap();

    zzea(Context context, ListenerHolder<PayloadCallback> listenerHolder) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzhm
    public final synchronized void zza(zziq zziq) {
        Payload zza2 = zzjg.zza(this.zza, zziq.zzb());
        if (zza2 == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(zziq.zzb().zza())));
            return;
        }
        this.zzc.put(new zzee(zziq.zza(), zziq.zzb().zza()), new PayloadTransferUpdate.Builder().setPayloadId(zziq.zzb().zza()).build());
        this.zzb.notifyListener(new zzed(this, zziq, zza2));
    }

    @Override // com.google.android.gms.internal.nearby.zzhm
    public final synchronized void zza(zzis zzis) {
        if (zzis.zzb().getStatus() == 3) {
            this.zzc.put(new zzee(zzis.zza(), zzis.zzb().getPayloadId()), zzis.zzb());
        } else {
            this.zzc.remove(new zzee(zzis.zza(), zzis.zzb().getPayloadId()));
        }
        this.zzb.notifyListener(new zzec(this, zzis));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza() {
        for (Map.Entry<zzee, PayloadTransferUpdate> entry : this.zzc.entrySet()) {
            this.zzb.notifyListener(new zzef(this, entry.getKey().zza(), entry.getValue()));
        }
        this.zzc.clear();
    }
}
