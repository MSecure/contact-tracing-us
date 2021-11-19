package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.MessageListener;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzku extends zzkv<MessageListener> {
    private final /* synthetic */ List zza;

    zzku(zzks zzks, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        zzks.zza(this.zza, (MessageListener) obj);
    }
}
