package c.b.a.a.e.c;

import android.content.Intent;
import android.os.Bundle;
import c.b.a.a.c.k.o.k;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import com.google.android.gms.nearby.messages.internal.zzag;
import com.google.android.gms.nearby.messages.internal.zzo;
import java.util.Collections;
import java.util.List;

public final class da extends zzo {

    /* renamed from: a  reason: collision with root package name */
    public final k<MessageListener> f2556a;

    public da(k<MessageListener> kVar) {
        this.f2556a = kVar;
    }

    public static void c(Intent intent, MessageListener messageListener) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.nearby.messages.UPDATES");
        d(bundleExtra == null ? Collections.emptyList() : bundleExtra.getParcelableArrayList("com.google.android.gms.nearby.messages.UPDATES"), messageListener);
    }

    public static void d(Iterable<Update> iterable, MessageListener messageListener) {
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
            update.zza(16);
        }
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzl
    public final void zza(zzag zzag) {
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzl
    public final void zza(List<Update> list) {
        this.f2556a.a(new ca(list));
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzl
    public final void zzb(zzag zzag) {
    }
}
