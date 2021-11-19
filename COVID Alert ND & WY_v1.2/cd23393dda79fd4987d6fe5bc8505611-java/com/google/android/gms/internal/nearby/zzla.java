package com.google.android.gms.internal.nearby;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzla<K, V> {
    private final Map<K, WeakReference<V>> zza = new WeakHashMap();

    public final boolean zza(K k) {
        return zzb(k) != null;
    }

    public final void zza(K k, V v) {
        this.zza.put(k, new WeakReference<>(v));
    }

    public final V zzb(K k) {
        WeakReference<V> weakReference = this.zza.get(k);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void zzc(K k) {
        this.zza.remove(k);
    }

    public final void zza() {
        this.zza.clear();
    }
}
