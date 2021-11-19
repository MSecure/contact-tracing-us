package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.zza;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final class zzei extends ConnectionsClient {
    private static final Api.ClientKey<zzdd> zza;
    private static final Api.AbstractClientBuilder<zzdd, ConnectionsOptions> zzb;
    private static final Api<ConnectionsOptions> zzc;
    private final zzcp zzd;
    private final zzhx zze;

    public zzei(Context context, ConnectionsOptions connectionsOptions) {
        super(context, zzc, (ConnectionsOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzd = zzcp.zza(this, (Api.ApiOptions) null);
        this.zze = null;
    }

    public zzei(Activity activity, ConnectionsOptions connectionsOptions) {
        super(activity, zzc, (ConnectionsOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzd = zzcp.zza(this, (Api.ApiOptions) null);
        if (Build.VERSION.SDK_INT >= 19) {
            this.zze = zzhx.zza(activity);
        } else {
            this.zze = null;
        }
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions) {
        ListenerHolder registerListener = registerListener(new zzfp(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zza(str2);
        return doWrite(TaskApiCall.builder().setFeatures(zza.zza).run(new zzel(this, str, str2, registerListener, connectionOptions)).build()).addOnFailureListener(new zzfe(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions) {
        ListenerHolder registerListener = registerListener(new zzfp(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zza(str);
        return doWrite(TaskApiCall.builder().setFeatures(zza.zza).run(new zzek(this, bArr, str, registerListener, connectionOptions)).build()).addOnFailureListener(new zzfh(this, str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        ListenerHolder registerListener = registerListener(new zzfp(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        ListenerHolder zza2 = this.zzd.zza(this, new Object(), "advertising");
        return this.zzd.zza(this, new zzfg(this, zza2, new Feature[]{zza.zza}, false, bArr, str, registerListener, advertisingOptions), new zzfj(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(zza2.getListenerKey(), "Key must not be null")));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback) {
        ListenerHolder registerListener = registerListener(new zzfp(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zza(str);
        return doWrite(TaskApiCall.builder().setFeatures(zza.zza).run(new zzeq(this, bArr, str, registerListener)).build()).addOnFailureListener(new zzfi(this, str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        ListenerHolder registerListener = registerListener(new zzfp(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        ListenerHolder zza2 = this.zzd.zza(this, new Object(), "advertising");
        return this.zzd.zza(this, new zzfl(this, zza2, str, str2, registerListener, advertisingOptions), new zzfk(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(zza2.getListenerKey(), "Key must not be null")));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.zzd.zza(this, "advertising");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        ListenerHolder zza2 = this.zzd.zza(this, endpointDiscoveryCallback, "discovery");
        return this.zzd.zza(this, new zzfn(this, zza2, str, zza2, discoveryOptions), new zzey(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(zza2.getListenerKey(), "Key must not be null"))).addOnSuccessListener(new zzet(this, discoveryOptions));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        this.zzd.zza(this, "discovery").addOnSuccessListener(new zzes(this));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        ListenerHolder registerListener = registerListener(new zzfp(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        zza(str2);
        return doWrite(TaskApiCall.builder().run(new zzev(this, str, str2, registerListener)).build()).addOnFailureListener(new zzfb(this, str2));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> acceptConnection(String str, PayloadCallback payloadCallback) {
        return doWrite(TaskApiCall.builder().run(new zzeu(this, str, registerListener(payloadCallback, PayloadCallback.class.getName()))).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> rejectConnection(String str) {
        return zza(new zzex(str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(String str, Payload payload) {
        return doWrite(TaskApiCall.builder().run(new zzew(this, str, payload)).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> sendPayload(List<String> list, Payload payload) {
        return doWrite(TaskApiCall.builder().run(new zzen(this, list, payload)).build());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task<Void> cancelPayload(long j) {
        return zza(new zzem(j));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(String str) {
        zza(new zzep(str));
        zzb(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        stopAdvertising();
        stopDiscovery();
        zza(zzeo.zza).addOnCompleteListener(new zzer(this));
    }

    /* access modifiers changed from: public */
    private final void zza(String str) {
        ListenerHolder<Object> zza2 = this.zzd.zza((GoogleApi<?>) this, str, "connection");
        this.zzd.zza(this, new zzfa(this, zza2), new zzfd(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(zza2.getListenerKey(), "Key must not be null")));
    }

    /* access modifiers changed from: public */
    private final void zzb(String str) {
        zzcp zzcp = this.zzd;
        zzcp.zza(this, zzcp.zza(str, "connection"));
    }

    private final Task<Void> zza(zzfm zzfm) {
        return doWrite(new zzfc(this, zzfm));
    }

    private final Task<Void> zza(zzfr zzfr) {
        return doWrite(new zzff(this, zzfr));
    }

    public final /* synthetic */ void zza(Task task) {
        this.zzd.zza(this, "connection");
        disconnectService();
    }

    public final /* synthetic */ void zza(Void r1) {
        zzhx zzhx = this.zze;
        if (zzhx != null) {
            zzhx.zzb();
        }
    }

    public final /* synthetic */ void zza(DiscoveryOptions discoveryOptions, Void r2) {
        if (discoveryOptions.zza()) {
            zzhx zzhx = this.zze;
            if (zzhx == null) {
                Log.d("NearbyConnections", "Discovery started with NFC requested, but there is no NfcDispatcher available. Discovery will continue over other mediums instead. To use NFC discovery, pass in an Activity when calling Nearby.getConnectionsClient().");
            } else {
                zzhx.zza();
            }
        }
    }

    static {
        Api.ClientKey<zzdd> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzez zzez = new zzez();
        zzb = zzez;
        zzc = new Api<>("Nearby.CONNECTIONS_API", zzez, clientKey);
    }
}
