package com.google.android.gms.internal.nearby;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzcp {
    private static final Map<zzcr, zzcp> zza = new ArrayMap();
    private final Map<String, Set<ListenerHolder.ListenerKey<?>>> zzb = new ArrayMap();
    private final Set<ListenerHolder.ListenerKey<?>> zzc = new ArraySet();
    private final Map<String, Object> zzd = new ArrayMap();

    public static synchronized zzcp zza(GoogleApi<?> googleApi, Api.ApiOptions apiOptions) {
        zzcp zzcp;
        synchronized (zzcp.class) {
            zzcr zzcr = new zzcr(googleApi, null);
            Map<zzcr, zzcp> map = zza;
            if (!map.containsKey(zzcr)) {
                map.put(zzcr, new zzcp());
            }
            zzcp = map.get(zzcr);
        }
        return zzcp;
    }

    private zzcp() {
    }

    public final synchronized <T> ListenerHolder<T> zza(GoogleApi<?> googleApi, T t, String str) {
        ListenerHolder listenerHolder;
        listenerHolder = (ListenerHolder<L>) googleApi.registerListener(t, str);
        ListenerHolder.ListenerKey<?> listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(listenerHolder.getListenerKey(), "Key must not be null");
        Set<ListenerHolder.ListenerKey<?>> set = this.zzb.get(str);
        if (set == null) {
            set = new ArraySet<>();
            this.zzb.put(str, set);
        }
        set.add(listenerKey);
        return listenerHolder;
    }

    public final synchronized ListenerHolder<Object> zza(GoogleApi<?> googleApi, String str, String str2) {
        return zza(googleApi, zza(str), str2);
    }

    public final synchronized ListenerHolder.ListenerKey<Object> zza(String str, String str2) {
        return ListenerHolders.createListenerKey(zza(str), str2);
    }

    public final synchronized Task<Void> zza(GoogleApi<?> googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod) {
        ListenerHolder.ListenerKey<?> listenerKey;
        listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(registerListenerMethod.getListenerKey(), "Key must not be null");
        this.zzc.add(listenerKey);
        return googleApi.doRegisterEventListener(registerListenerMethod, unregisterListenerMethod).addOnFailureListener(new zzco(this, googleApi, listenerKey));
    }

    private final Object zza(String str) {
        if (!this.zzd.containsKey(str)) {
            this.zzd.put(str, new Object());
        }
        return this.zzd.get(str);
    }

    public final synchronized Task<Boolean> zza(GoogleApi<?> googleApi, ListenerHolder.ListenerKey<?> listenerKey) {
        String str;
        this.zzc.remove(listenerKey);
        Iterator<String> it = this.zzb.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            str = it.next();
            Set<ListenerHolder.ListenerKey<?>> set = this.zzb.get(str);
            if (set.contains(listenerKey)) {
                set.remove(listenerKey);
                break;
            }
        }
        if (str != null) {
            Iterator<Map.Entry<String, Object>> it2 = this.zzd.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it2.next();
                if (ListenerHolders.createListenerKey(next.getValue(), str).equals(listenerKey)) {
                    this.zzd.remove(next.getKey());
                    break;
                }
            }
        }
        return googleApi.doUnregisterEventListener(listenerKey);
    }

    public final synchronized Task<Void> zza(GoogleApi<?> googleApi, String str) {
        ArraySet arraySet = new ArraySet();
        Set<ListenerHolder.ListenerKey<?>> set = this.zzb.get(str);
        if (set == null) {
            return Tasks.whenAll(arraySet);
        }
        Iterator it = new ArraySet(set).iterator();
        while (it.hasNext()) {
            ListenerHolder.ListenerKey<?> listenerKey = (ListenerHolder.ListenerKey) it.next();
            if (this.zzc.contains(listenerKey)) {
                arraySet.add(zza(googleApi, listenerKey));
            }
        }
        this.zzb.remove(str);
        return Tasks.whenAll(arraySet);
    }
}
