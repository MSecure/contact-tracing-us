package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.nearby.zzks;
import com.google.android.gms.internal.nearby.zzkt;
import com.google.android.gms.internal.nearby.zzky;
import com.google.android.gms.internal.nearby.zzla;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzag extends GmsClient<zzt> {
    private final zzla<ListenerHolder.ListenerKey, IBinder> zzd = new zzla<>();
    private final ClientAppContext zze;
    private final int zzf;

    static int zza(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    zzag(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, MessagesOptions messagesOptions) {
        super(context, looper, 62, clientSettings, connectionCallbacks, onConnectionFailedListener);
        String realClientPackageName = clientSettings.getRealClientPackageName();
        int zza = zza(context);
        if (messagesOptions != null) {
            this.zze = new ClientAppContext(realClientPackageName, messagesOptions.zza, messagesOptions.zzb, messagesOptions.zzd, zza);
            this.zzf = messagesOptions.zzc;
        } else {
            this.zze = new ClientAppContext(realClientPackageName, null, false, null, zza);
            this.zzf = -1;
        }
        if (zza == 1 && PlatformVersion.isAtLeastIceCreamSandwich()) {
            Activity activity = (Activity) context;
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new zzai(activity, this));
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        getServiceRequestExtraArgs.putInt("NearbyPermissions", this.zzf);
        getServiceRequestExtraArgs.putParcelable("ClientAppContext", this.zze);
        return getServiceRequestExtraArgs;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        try {
            zza(2);
        } catch (RemoteException e) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
            }
        }
        this.zzd.zza();
        super.disconnect();
    }

    /* access modifiers changed from: package-private */
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, zzae zzae, zzu zzu, PublishOptions publishOptions, int i) throws RemoteException {
        ((zzt) getService()).zza(new zzby(zzae, publishOptions.getStrategy(), new zzkt(listenerHolder), zzu, i));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, zzae zzae, zzu zzu, PublishOptions publishOptions) throws RemoteException {
        zza(listenerHolder, zzae, zzu, publishOptions, this.zze.zza);
    }

    /* access modifiers changed from: package-private */
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, zzae zzae) throws RemoteException {
        ((zzt) getService()).zza(new zzcd(zzae, new zzkt(listenerHolder)));
    }

    /* access modifiers changed from: package-private */
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2, zzaa zzaa, SubscribeOptions subscribeOptions, byte[] bArr, int i) throws RemoteException {
        ListenerHolder.ListenerKey<MessageListener> listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey != null) {
            if (!this.zzd.zza(listenerKey)) {
                this.zzd.zza(listenerKey, new zzks(listenerHolder2));
            }
            ((zzt) getService()).zza(new SubscribeRequest(this.zzd.zzb(listenerKey), subscribeOptions.getStrategy(), new zzkt(listenerHolder), subscribeOptions.getFilter(), null, null, zzaa, subscribeOptions.zza, i));
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2, zzaa zzaa, SubscribeOptions subscribeOptions, byte[] bArr) throws RemoteException {
        zza(listenerHolder, listenerHolder2, zzaa, subscribeOptions, null, this.zze.zza);
    }

    /* access modifiers changed from: package-private */
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent, zzaa zzaa, SubscribeOptions subscribeOptions, int i) throws RemoteException {
        ((zzt) getService()).zza(new SubscribeRequest(null, subscribeOptions.getStrategy(), new zzkt(listenerHolder), subscribeOptions.getFilter(), pendingIntent, null, zzaa, subscribeOptions.zza, subscribeOptions.zzb, this.zze.zza));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent, zzaa zzaa, SubscribeOptions subscribeOptions) throws RemoteException {
        zza(listenerHolder, pendingIntent, zzaa, subscribeOptions, this.zze.zza);
    }

    /* access modifiers changed from: package-private */
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<MessageListener> listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey<MessageListener> listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey != null) {
            zzkt zzkt = new zzkt(listenerHolder);
            if (!this.zzd.zza(listenerKey)) {
                zzkt.zza(new Status(0));
                return;
            }
            ((zzt) getService()).zza(new zzcf(this.zzd.zzb(listenerKey), zzkt, null));
            this.zzd.zzc(listenerKey);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, PendingIntent pendingIntent) throws RemoteException {
        ((zzt) getService()).zza(new zzcf(null, new zzkt(listenerHolder), pendingIntent));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<StatusCallback> listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey<StatusCallback> listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey != null) {
            if (!this.zzd.zza(listenerKey)) {
                this.zzd.zza(listenerKey, new zzky(listenerHolder2));
            }
            zzca zzca = new zzca(new zzkt(listenerHolder), this.zzd.zzb(listenerKey));
            zzca.zza = true;
            ((zzt) getService()).zza(zzca);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(ListenerHolder<BaseImplementation.ResultHolder<Status>> listenerHolder, ListenerHolder<StatusCallback> listenerHolder2) throws RemoteException {
        ListenerHolder.ListenerKey<StatusCallback> listenerKey = listenerHolder2.getListenerKey();
        if (listenerKey != null) {
            zzkt zzkt = new zzkt(listenerHolder);
            if (!this.zzd.zza(listenerKey)) {
                zzkt.zza(new Status(0));
                return;
            }
            zzca zzca = new zzca(zzkt, this.zzd.zzb(listenerKey));
            zzca.zza = false;
            ((zzt) getService()).zza(zzca);
            this.zzd.zzc(listenerKey);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i) throws RemoteException {
        String str;
        if (i == 1) {
            str = "ACTIVITY_STOPPED";
        } else if (i == 2) {
            str = "CLIENT_DISCONNECTED";
        } else if (Log.isLoggable("NearbyMessagesClient", 5)) {
            Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", Integer.valueOf(i)));
            return;
        } else {
            return;
        }
        if (isConnected()) {
            zzi zzi = new zzi(i);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
            }
            ((zzt) getService()).zza(zzi);
        } else if (Log.isLoggable("NearbyMessagesClient", 3)) {
            Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (queryLocalInterface instanceof zzt) {
            return (zzt) queryLocalInterface;
        }
        return new zzs(iBinder);
    }
}
