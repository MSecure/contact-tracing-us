package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.api.internal.zabh;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.internal.common.zzi;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public abstract class BaseGmsClient<T extends IInterface> {
    public static final Feature[] zzd = new Feature[0];
    public final Handler zza;
    public ConnectionResult zzaa = null;
    public boolean zzab = false;
    public volatile zzc zzac = null;
    @RecentlyNonNull
    public ConnectionProgressReportCallbacks zzb;
    @RecentlyNonNull
    public AtomicInteger zzc = new AtomicInteger(0);
    public volatile String zzj = null;
    public zzl zzk;
    public final Context zzl;
    public final GmsClientSupervisor zzn;
    public final Object zzp = new Object();
    public final Object zzq = new Object();
    public IGmsServiceBroker zzr;
    public T zzs;
    public final ArrayList<zzc<?>> zzt = new ArrayList<>();
    public zzd zzu;
    public int zzv = 1;
    public final BaseConnectionCallbacks zzw;
    public final BaseOnConnectionFailedListener zzx;
    public final int zzy;
    public final String zzz;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface BaseConnectionCallbacks {
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface BaseOnConnectionFailedListener {
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(@RecentlyNonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, ((GmsClient) baseGmsClient).zab);
                return;
            }
            BaseOnConnectionFailedListener baseOnConnectionFailedListener = BaseGmsClient.this.zzx;
            if (baseOnConnectionFailedListener != null) {
                ((zai) baseOnConnectionFailedListener).zaa.onConnectionFailed(connectionResult);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface SignOutCallbacks {
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public abstract class zza extends zzc<Boolean> {
        public final int zza;
        public final Bundle zzb;

        public zza(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.zza = i;
            this.zzb = bundle;
        }

        public abstract void zza(ConnectionResult connectionResult);

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        public final /* synthetic */ void zza(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (this.zza != 0) {
                BaseGmsClient.this.zza(1, null);
                Bundle bundle = this.zzb;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                }
                zza(new ConnectionResult(this.zza, pendingIntent));
            } else if (!zza()) {
                BaseGmsClient.this.zza(1, null);
                zza(new ConnectionResult(8, null));
            }
        }

        public abstract boolean zza();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public final class zzb extends zzi {
        public zzb(Looper looper) {
            super(looper);
        }

        public static void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            if (((zza) zzc) != null) {
                zzc.zzd();
                return;
            }
            throw null;
        }

        public static boolean zzb(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            if (r0 == 5) goto L_0x002b;
         */
        public final void handleMessage(Message message) {
            TListener tlistener;
            if (BaseGmsClient.this.zzc.get() == message.arg1) {
                int i = message.what;
                if (!(i == 1 || i == 7)) {
                    if (i == 4) {
                        if (BaseGmsClient.this == null) {
                            throw null;
                        }
                    }
                }
                if (!BaseGmsClient.this.isConnecting()) {
                    zza(message);
                    return;
                }
                int i2 = message.what;
                if (i2 == 4) {
                    BaseGmsClient.this.zzaa = new ConnectionResult(message.arg2);
                    if (BaseGmsClient.zzb(BaseGmsClient.this)) {
                        BaseGmsClient baseGmsClient = BaseGmsClient.this;
                        if (!baseGmsClient.zzab) {
                            baseGmsClient.zza(3, null);
                            return;
                        }
                    }
                    ConnectionResult connectionResult = BaseGmsClient.this.zzaa;
                    if (connectionResult == null) {
                        connectionResult = new ConnectionResult(8);
                    }
                    BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                    if (BaseGmsClient.this != null) {
                        System.currentTimeMillis();
                        return;
                    }
                    throw null;
                } else if (i2 == 5) {
                    ConnectionResult connectionResult2 = BaseGmsClient.this.zzaa;
                    if (connectionResult2 == null) {
                        connectionResult2 = new ConnectionResult(8);
                    }
                    BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult2);
                    if (BaseGmsClient.this != null) {
                        System.currentTimeMillis();
                        return;
                    }
                    throw null;
                } else if (i2 == 3) {
                    Object obj = message.obj;
                    BaseGmsClient.this.zzb.onReportServiceBinding(new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
                    if (BaseGmsClient.this != null) {
                        System.currentTimeMillis();
                        return;
                    }
                    throw null;
                } else if (i2 == 6) {
                    BaseGmsClient.this.zza(5, null);
                    BaseConnectionCallbacks baseConnectionCallbacks = BaseGmsClient.this.zzw;
                    if (baseConnectionCallbacks != null) {
                        ((zag) baseConnectionCallbacks).zaa.onConnectionSuspended(message.arg2);
                    }
                    BaseGmsClient.this.onConnectionSuspended(message.arg2);
                    BaseGmsClient.zza(BaseGmsClient.this, 5, 1, null);
                } else if (i2 == 2 && !BaseGmsClient.this.isConnected()) {
                    zza(message);
                } else if (zzb(message)) {
                    zzc zzc = (zzc) message.obj;
                    synchronized (zzc) {
                        tlistener = zzc.zza;
                        if (zzc.zzb) {
                            String valueOf = String.valueOf(zzc);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                            sb.append("Callback proxy ");
                            sb.append(valueOf);
                            sb.append(" being reused. This is not safe.");
                            Log.w("GmsClient", sb.toString());
                        }
                    }
                    if (tlistener != null) {
                        try {
                            zzc.zza(tlistener);
                        } catch (RuntimeException e) {
                            throw e;
                        }
                    }
                    synchronized (zzc) {
                        zzc.zzb = true;
                    }
                    zzc.zzd();
                } else {
                    int i3 = message.what;
                    StringBuilder sb2 = new StringBuilder(45);
                    sb2.append("Don't know how to handle message: ");
                    sb2.append(i3);
                    Log.wtf("GmsClient", sb2.toString(), new Exception());
                }
            } else if (zzb(message)) {
                zza(message);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public abstract class zzc<TListener> {
        public TListener zza;
        public boolean zzb = false;

        public zzc(TListener tlistener) {
            this.zza = tlistener;
        }

        public abstract void zza(TListener tlistener);

        public final void zzd() {
            synchronized (this) {
                this.zza = null;
            }
            synchronized (BaseGmsClient.this.zzt) {
                BaseGmsClient.this.zzt.remove(this);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public final class zzd implements ServiceConnection {
        public final int zza;

        public zzd(int i) {
            this.zza = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker iGmsServiceBroker;
            if (iBinder == null) {
                BaseGmsClient.zza(BaseGmsClient.this);
                return;
            }
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                    iGmsServiceBroker = new IGmsServiceBroker$Stub$zza(iBinder);
                } else {
                    iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
                }
                baseGmsClient.zzr = iGmsServiceBroker;
            }
            BaseGmsClient baseGmsClient2 = BaseGmsClient.this;
            int i = this.zza;
            Handler handler = baseGmsClient2.zza;
            handler.sendMessage(handler.obtainMessage(7, i, -1, new zzg(0)));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient.this.zzr = null;
            }
            Handler handler = BaseGmsClient.this.zza;
            handler.sendMessage(handler.obtainMessage(6, this.zza, 1));
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public static final class zze extends IGmsCallbacks.zza {
        public BaseGmsClient zza;
        public final int zzb;

        public zze(BaseGmsClient baseGmsClient, int i) {
            this.zza = baseGmsClient;
            this.zzb = i;
        }

        public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
            ReactYogaConfigProvider.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            BaseGmsClient baseGmsClient = this.zza;
            int i2 = this.zzb;
            Handler handler = baseGmsClient.zza;
            handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
            this.zza = null;
        }
    }

    public BaseGmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull GmsClientSupervisor gmsClientSupervisor, @RecentlyNonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, @RecentlyNonNull int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        ReactYogaConfigProvider.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        ReactYogaConfigProvider.checkNotNull(looper, "Looper must not be null");
        ReactYogaConfigProvider.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        ReactYogaConfigProvider.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zza = new zzb(looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    public static boolean zzb(BaseGmsClient baseGmsClient) {
        if (baseGmsClient.zzab || TextUtils.isEmpty(baseGmsClient.getServiceDescriptor()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void connect(@RecentlyNonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        ReactYogaConfigProvider.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzb = connectionProgressReportCallbacks;
        zza(2, null);
    }

    @RecentlyNullable
    public abstract T createServiceInterface(@RecentlyNonNull IBinder iBinder);

    public void disconnect(@RecentlyNonNull String str) {
        this.zzj = str;
        disconnect();
    }

    @RecentlyNonNull
    public Feature[] getApiFeatures() {
        return zzd;
    }

    @RecentlyNullable
    public final Feature[] getAvailableFeatures() {
        zzc zzc2 = this.zzac;
        if (zzc2 == null) {
            return null;
        }
        return zzc2.zzb;
    }

    @RecentlyNonNull
    public String getEndpointPackageName() {
        zzl zzl2;
        if (isConnected() && (zzl2 = this.zzk) != null) {
            return zzl2.zzb;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @RecentlyNonNull
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @RecentlyNullable
    public String getLastDisconnectMessage() {
        return this.zzj;
    }

    @RecentlyNonNull
    public abstract int getMinApkVersion();

    public void getRemoteService(IAccountAccessor iAccountAccessor, @RecentlyNonNull Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy);
        getServiceRequest.zza = this.zzl.getPackageName();
        getServiceRequest.zzd = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzc = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            Account account = ((GmsClient) this).zac;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.zze = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzb = iAccountAccessor.asBinder();
            }
        }
        getServiceRequest.zzf = zzd;
        getServiceRequest.zzg = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzh = true;
        }
        try {
            synchronized (this.zzq) {
                if (this.zzr != null) {
                    this.zzr.getService(new zze(this, this.zzc.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            Handler handler = this.zza;
            handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), 3));
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            int i = this.zzc.get();
            Handler handler2 = this.zza;
            handler2.sendMessage(handler2.obtainMessage(1, i, -1, new zzf(8, null, null)));
        }
    }

    @RecentlyNonNull
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv == 5) {
                throw new DeadObjectException();
            } else if (isConnected()) {
                T t2 = this.zzs;
                ReactYogaConfigProvider.checkNotNull(t2, "Client is connected but service is null");
                t = t2;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t;
    }

    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    @RecentlyNonNull
    public boolean getUseDynamicLookup() {
        return false;
    }

    @RecentlyNonNull
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @RecentlyNonNull
    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            if (this.zzv != 2) {
                if (this.zzv != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void onConnectedLocked(@RecentlyNonNull T t) {
        System.currentTimeMillis();
    }

    public void onConnectionSuspended(@RecentlyNonNull int i) {
        System.currentTimeMillis();
    }

    public void onUserSignOut(@RecentlyNonNull SignOutCallbacks signOutCallbacks) {
        zabf zabf = (zabf) signOutCallbacks;
        GoogleApiManager.this.zaq.post(new zabh(zabf));
    }

    @RecentlyNonNull
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @RecentlyNonNull
    public boolean requiresSignIn() {
        return false;
    }

    @RecentlyNonNull
    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zza(int i, T t) {
        boolean z = false;
        if ((i == 4) == (t != null)) {
            z = true;
        }
        ReactYogaConfigProvider.checkArgument(z);
        synchronized (this.zzp) {
            this.zzv = i;
            this.zzs = t;
            if (i == 1) {
                zzd zzd2 = this.zzu;
                if (zzd2 != null) {
                    GmsClientSupervisor gmsClientSupervisor = this.zzn;
                    String str = this.zzk.zza;
                    ReactYogaConfigProvider.checkNotNull(str);
                    gmsClientSupervisor.zza(str, this.zzk.zzb, this.zzk.zzc, zzd2, zza(), this.zzk.zze);
                    this.zzu = null;
                }
            } else if (i == 2 || i == 3) {
                zzd zzd3 = this.zzu;
                if (!(zzd3 == null || this.zzk == null)) {
                    String str2 = this.zzk.zza;
                    String str3 = this.zzk.zzb;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 70 + String.valueOf(str3).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(str2);
                    sb.append(" on ");
                    sb.append(str3);
                    Log.e("GmsClient", sb.toString());
                    GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                    String str4 = this.zzk.zza;
                    ReactYogaConfigProvider.checkNotNull(str4);
                    gmsClientSupervisor2.zza(str4, this.zzk.zzb, this.zzk.zzc, zzd3, zza(), this.zzk.zze);
                    this.zzc.incrementAndGet();
                }
                zzd zzd4 = new zzd(this.zzc.get());
                this.zzu = zzd4;
                String startServiceAction = getStartServiceAction();
                GmsClientSupervisor.getDefaultBindFlags();
                zzl zzl2 = new zzl("com.google.android.gms", startServiceAction, false, 4225, getUseDynamicLookup());
                this.zzk = zzl2;
                if (!zzl2.zze || getMinApkVersion() >= 17895000) {
                    GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                    String str5 = this.zzk.zza;
                    ReactYogaConfigProvider.checkNotNull(str5);
                    if (!gmsClientSupervisor3.zza(new GmsClientSupervisor.zza(str5, this.zzk.zzb, this.zzk.zzc, this.zzk.zze), zzd4, zza())) {
                        String str6 = this.zzk.zza;
                        String str7 = this.zzk.zzb;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str6).length() + 34 + String.valueOf(str7).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str6);
                        sb2.append(" on ");
                        sb2.append(str7);
                        Log.e("GmsClient", sb2.toString());
                        int i2 = this.zzc.get();
                        Handler handler = this.zza;
                        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(16)));
                    }
                } else {
                    String valueOf = String.valueOf(this.zzk.zza);
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i == 4) {
                ReactYogaConfigProvider.checkNotNull(t);
                onConnectedLocked(t);
            }
        }
    }

    public void disconnect() {
        this.zzc.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i = 0; i < size; i++) {
                zzc<?> zzc2 = this.zzt.get(i);
                synchronized (zzc2) {
                    zzc2.zza = null;
                }
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zza(1, null);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public final class zzg extends zza {
        public zzg(int i) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(ConnectionResult connectionResult) {
            BaseGmsClient baseGmsClient = BaseGmsClient.this;
            if (baseGmsClient != null) {
                baseGmsClient.zzb.onReportServiceBinding(connectionResult);
                if (BaseGmsClient.this != null) {
                    System.currentTimeMillis();
                    return;
                }
                throw null;
            }
            throw null;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            BaseGmsClient.this.zzb.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public final class zzf extends zza {
        public final IBinder zza;

        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zza = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(ConnectionResult connectionResult) {
            BaseOnConnectionFailedListener baseOnConnectionFailedListener = BaseGmsClient.this.zzx;
            if (baseOnConnectionFailedListener != null) {
                ((zai) baseOnConnectionFailedListener).zaa.onConnectionFailed(connectionResult);
            }
            if (BaseGmsClient.this != null) {
                System.currentTimeMillis();
                return;
            }
            throw null;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            try {
                IBinder iBinder = this.zza;
                ReactYogaConfigProvider.checkNotNull(iBinder);
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(interfaceDescriptor).length() + String.valueOf(serviceDescriptor).length() + 34);
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.zza);
                if (createServiceInterface == null || (!BaseGmsClient.zza(BaseGmsClient.this, 2, 4, createServiceInterface) && !BaseGmsClient.zza(BaseGmsClient.this, 3, 4, createServiceInterface))) {
                    return false;
                }
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.zzaa = null;
                BaseConnectionCallbacks baseConnectionCallbacks = baseGmsClient.zzw;
                if (baseConnectionCallbacks == null) {
                    return true;
                }
                ((zag) baseConnectionCallbacks).zaa.onConnected(null);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public static boolean zza(BaseGmsClient baseGmsClient, int i, int i2, IInterface iInterface) {
        boolean z;
        synchronized (baseGmsClient.zzp) {
            if (baseGmsClient.zzv != i) {
                z = false;
            } else {
                baseGmsClient.zza(i2, iInterface);
                z = true;
            }
        }
        return z;
    }

    public static void zza(BaseGmsClient baseGmsClient) {
        boolean z;
        int i;
        synchronized (baseGmsClient.zzp) {
            z = baseGmsClient.zzv == 3;
        }
        if (z) {
            i = 5;
            baseGmsClient.zzab = true;
        } else {
            i = 4;
        }
        Handler handler = baseGmsClient.zza;
        handler.sendMessage(handler.obtainMessage(i, baseGmsClient.zzc.get(), 16));
    }
}
