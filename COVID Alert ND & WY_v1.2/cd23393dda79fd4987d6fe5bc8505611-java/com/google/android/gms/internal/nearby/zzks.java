package com.google.android.gms.internal.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import com.google.android.gms.nearby.messages.internal.zzae;
import com.google.android.gms.nearby.messages.internal.zzm;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzks extends zzm {
    private final ListenerHolder<MessageListener> zza;

    public zzks(ListenerHolder<MessageListener> listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzn
    public final void zza(zzae zzae) {
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzn
    public final void zzb(zzae zzae) {
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzn
    public final void zza(List<Update> list) throws RemoteException {
        this.zza.notifyListener(new zzku(this, list));
    }

    public static void zza(Iterable<Update> iterable, MessageListener messageListener) {
        for (Update update : iterable) {
            if (update.zza(1)) {
                messageListener.onFound(update.zza);
            }
            if (update.zza(2)) {
                messageListener.onLost(update.zza);
            }
            if (update.zza(4)) {
                messageListener.onDistanceChanged(update.zza, update.zzb);
            }
            if (update.zza(8)) {
                messageListener.onBleSignalChanged(update.zza, update.zzc);
            }
            if (update.zza(16)) {
                Message message = update.zza;
                zzkn zzkn = update.zzd;
            }
        }
    }

    public static void zza(Intent intent, MessageListener messageListener) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.nearby.messages.UPDATES");
        zza(bundleExtra == null ? Collections.emptyList() : bundleExtra.getParcelableArrayList("com.google.android.gms.nearby.messages.UPDATES"), messageListener);
    }
}
