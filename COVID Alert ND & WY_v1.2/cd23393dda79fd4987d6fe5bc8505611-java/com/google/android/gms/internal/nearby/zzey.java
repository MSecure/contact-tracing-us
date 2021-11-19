package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzey extends UnregisterListenerMethod<zzdd, EndpointDiscoveryCallback> {
    zzey(zzei zzei, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void unregisterListener(zzdd zzdd, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdd.zzb();
        taskCompletionSource.setResult(true);
    }
}
