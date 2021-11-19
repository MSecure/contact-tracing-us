package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.zza;
import java.io.IOException;
import java.util.Set;

public final class zzdd extends GmsClient<zzhk> {
    private final long zzd = ((long) hashCode());
    private final String zze;
    private final Set<zzdo> zzf = new ArraySet();
    private final Set<zzea> zzg = new ArraySet();
    private final Set<zzdf> zzh = new ArraySet();
    private zzja zzi;

    public zzdd(Context context, Looper looper, ClientSettings clientSettings, ConnectionsOptions connectionsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, clientSettings, connectionCallbacks, onConnectionFailedListener);
        String str;
        if (connectionsOptions == null) {
            str = null;
        } else {
            str = connectionsOptions.getZeroPartyIdentifier();
        }
        this.zze = str;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.zzd);
        String str = this.zze;
        if (str != null) {
            bundle.putString("zeroPartyIdentifier", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return new Feature[]{zza.zza};
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzhk) getService()).zza(new zzdb().zza());
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        zzd();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            zzd();
        }
        super.onConnectionSuspended(i);
    }

    private final void zzd() {
        for (zzdo zzdo : this.zzf) {
            zzdo.zza();
        }
        for (zzea zzea : this.zzg) {
            zzea.zza();
        }
        for (zzdf zzdf : this.zzh) {
            zzdf.zza();
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzh.clear();
        zzja zzja = this.zzi;
        if (zzja != null) {
            zzja.zza();
            this.zzi = null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, String str2, ListenerHolder<ConnectionLifecycleCallback> listenerHolder, ConnectionOptions connectionOptions) {
        zzdf zzdf = new zzdf(listenerHolder);
        this.zzh.add(zzdf);
        ((zzhk) getService()).zza(new zzjp().zza(new zzeh(resultHolder)).zza(str).zzb(str2).zza(zzdf).zza(connectionOptions).zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, byte[] bArr, String str, ListenerHolder<ConnectionLifecycleCallback> listenerHolder, ConnectionOptions connectionOptions) {
        zzdf zzdf = new zzdf(listenerHolder);
        this.zzh.add(zzdf);
        ((zzhk) getService()).zza(new zzjp().zza(new zzeh(resultHolder)).zzb(bArr).zzb(str).zza(zzdf).zza(connectionOptions).zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> resultHolder, byte[] bArr, String str, ListenerHolder<ConnectionLifecycleCallback> listenerHolder, AdvertisingOptions advertisingOptions) {
        zzdf zzdf = new zzdf(listenerHolder);
        this.zzh.add(zzdf);
        ((zzhk) getService()).zza(new zzjx().zza(new zzej(resultHolder)).zza(bArr).zzb(str).zza(advertisingOptions).zza(zzdf).zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, byte[] bArr, String str, ListenerHolder<ConnectionLifecycleCallback> listenerHolder) {
        zzdf zzdf = new zzdf(listenerHolder);
        this.zzh.add(zzdf);
        ((zzhk) getService()).zza(new zzjp().zza(new zzeh(resultHolder)).zzb(bArr).zzb(str).zza(zzdf).zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> resultHolder, String str, String str2, ListenerHolder<ConnectionLifecycleCallback> listenerHolder, AdvertisingOptions advertisingOptions) {
        zzdf zzdf = new zzdf(listenerHolder);
        this.zzh.add(zzdf);
        ((zzhk) getService()).zza(new zzjx().zza(new zzej(resultHolder)).zza(str).zzb(str2).zza(advertisingOptions).zza(zzdf).zza());
    }

    public final void zza() {
        ((zzhk) getService()).zza(new zzkc().zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, ListenerHolder<EndpointDiscoveryCallback> listenerHolder, DiscoveryOptions discoveryOptions) {
        zzdo zzdo = new zzdo(listenerHolder);
        this.zzf.add(zzdo);
        ((zzhk) getService()).zza(new zzkb().zza(new zzeh(resultHolder)).zza(str).zza(discoveryOptions).zza(zzdo).zza());
    }

    public final void zzb() {
        ((zzhk) getService()).zza(new zzki().zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, String str2, ListenerHolder<ConnectionLifecycleCallback> listenerHolder) {
        zzdf zzdf = new zzdf(listenerHolder);
        this.zzh.add(zzdf);
        ((zzhk) getService()).zza(new zzjp().zza(new zzeh(resultHolder)).zza(str).zzb(str2).zza(zzdf).zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, ListenerHolder<PayloadCallback> listenerHolder) {
        zzea zzea = new zzea(getContext(), listenerHolder);
        this.zzg.add(zzea);
        ((zzhk) getService()).zza(new zzcs().zza(new zzeh(resultHolder)).zza(str).zza(zzea).zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str) {
        ((zzhk) getService()).zza(new zzjl().zza(new zzeh(resultHolder)).zza(str).zza());
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String[] strArr, Payload payload, boolean z) {
        try {
            Pair<zzjc, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> zza = zzjg.zza(payload);
            ((zzhk) getService()).zza(new zzjt().zza(new zzeh(resultHolder)).zza(strArr).zza((zzjc) zza.first).zza());
            if (zza.second != null) {
                Pair pair = (Pair) zza.second;
                this.zzi.zza(payload.asStream().asInputStream(), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first), new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second), payload.getId());
            }
        } catch (IOException unused) {
            resultHolder.setResult(zzb((int) ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR));
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, long j) {
        ((zzhk) getService()).zza(new zzcw().zza(new zzeh(resultHolder)).zza(j).zza());
    }

    public final void zza(String str) {
        ((zzhk) getService()).zza(new zzgt().zza(str).zza());
    }

    public final void zzc() {
        ((zzhk) getService()).zza(new zzkh().zza());
    }

    public static Status zzb(int i) {
        return new Status(i, ConnectionsStatusCodes.getStatusCodeString(i));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        super.onConnectedLocked((zzhk) iInterface);
        this.zzi = new zzja();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (queryLocalInterface instanceof zzhk) {
            return (zzhk) queryLocalInterface;
        }
        return new zzhn(iBinder);
    }
}
