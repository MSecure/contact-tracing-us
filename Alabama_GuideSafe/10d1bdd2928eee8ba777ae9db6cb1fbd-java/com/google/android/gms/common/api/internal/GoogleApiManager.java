package com.google.android.gms.common.api.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class GoogleApiManager implements Handler.Callback {
    @RecentlyNonNull
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    public static final Object zaf = new Object();
    public static GoogleApiManager zag;
    public long zac = WebsocketJavaScriptExecutor.CONNECT_TIMEOUT_MS;
    public long zad = 120000;
    public long zae = 10000;
    public final Context zah;
    public final GoogleApiAvailability zai;
    public final zaj zaj;
    public final AtomicInteger zak;
    public final AtomicInteger zal;
    public final Map<ApiKey<?>, zaa<?>> zam;
    public zax zan;
    public final Set<ApiKey<?>> zao;
    public final Set<ApiKey<?>> zap;
    @NotOnlyInitialized
    public final Handler zaq;
    public volatile boolean zar;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class zab {
        public final ApiKey<?> zaa;
        public final Feature zab;

        public zab(ApiKey apiKey, Feature feature, zabc zabc) {
            this.zaa = apiKey;
            this.zab = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof zab)) {
                zab zab2 = (zab) obj;
                if (!ReactYogaConfigProvider.equal(this.zaa, zab2.zaa) || !ReactYogaConfigProvider.equal(this.zab, zab2.zab)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.zaa, this.zab});
        }

        public final String toString() {
            Objects$ToStringHelper stringHelper = ReactYogaConfigProvider.toStringHelper(this);
            stringHelper.add("key", this.zaa);
            stringHelper.add("feature", this.zab);
            return stringHelper.toString();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public class zac implements zace, BaseGmsClient.ConnectionProgressReportCallbacks {
        public final Api.Client zab;
        public final ApiKey<?> zac;
        public IAccountAccessor zad = null;
        public Set<Scope> zae = null;
        public boolean zaf = false;

        public zac(Api.Client client, ApiKey<?> apiKey) {
            this.zab = client;
            this.zac = apiKey;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            GoogleApiManager.this.zaq.post(new zabi(this, connectionResult));
        }

        public final void zaa(ConnectionResult connectionResult) {
            zaa<?> zaa2 = GoogleApiManager.this.zam.get(this.zac);
            if (zaa2 != null) {
                ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                Api.Client client = zaa2.zac;
                String name = client.getClass().getName();
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(valueOf.length() + name.length() + 25);
                sb.append("onSignInFailed for ");
                sb.append(name);
                sb.append(" with ");
                sb.append(valueOf);
                client.disconnect(sb.toString());
                zaa2.zaa(connectionResult, null);
            }
        }
    }

    public GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        boolean z = true;
        this.zak = new AtomicInteger(1);
        this.zal = new AtomicInteger(0);
        this.zam = new ConcurrentHashMap(5, 0.75f, 1);
        this.zan = null;
        this.zao = new ArraySet();
        this.zap = new ArraySet();
        this.zar = true;
        this.zah = context;
        this.zaq = new zap(looper, this);
        this.zai = googleApiAvailability;
        this.zaj = new zaj(googleApiAvailability);
        PackageManager packageManager = context.getPackageManager();
        if (ReactYogaConfigProvider.zzg == null) {
            ReactYogaConfigProvider.zzg = Boolean.valueOf((!ReactYogaConfigProvider.isAtLeastO() || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (ReactYogaConfigProvider.zzg.booleanValue()) {
            this.zar = false;
        }
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(6));
    }

    @RecentlyNonNull
    public static GoogleApiManager zaa(@RecentlyNonNull Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zaf) {
            if (zag == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zag = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.zab);
            }
            googleApiManager = zag;
        }
        return googleApiManager;
    }

    public static Status zab(ApiKey<?> apiKey, ConnectionResult connectionResult) {
        String str = apiKey.zac.zac;
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str).length() + 63);
        sb.append("API: ");
        sb.append(str);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(1, 17, sb.toString(), connectionResult.zzc, connectionResult);
    }

    @RecentlyNonNull
    public boolean handleMessage(@RecentlyNonNull Message message) {
        zaa<?> zaa2;
        Status status;
        Feature[] zaa3;
        int i = message.what;
        long j = 300000;
        int i2 = 0;
        switch (i) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.zae = j;
                this.zaq.removeMessages(12);
                for (ApiKey<?> apiKey : this.zam.keySet()) {
                    Handler handler = this.zaq;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey), this.zae);
                }
                break;
            case 2:
                if (((zaj) message.obj) != null) {
                    throw null;
                }
                throw null;
            case 3:
                for (zaa<?> zaa4 : this.zam.values()) {
                    zaa4.zad();
                    zaa4.zai();
                }
                break;
            case 4:
            case 8:
            case 13:
                zabr zabr = (zabr) message.obj;
                zaa<?> zaa5 = this.zam.get(zabr.zac.zae);
                if (zaa5 == null) {
                    zaa5 = zac(zabr.zac);
                }
                if (!zaa5.zak() || this.zal.get() == zabr.zab) {
                    zaa5.zaa(zabr.zaa);
                    break;
                } else {
                    zabr.zaa.zaa(zaa);
                    zaa5.zaa();
                    break;
                }
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zaa<?>> it = this.zam.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zaa2 = it.next();
                        if (zaa2.zah == i3) {
                        }
                    } else {
                        zaa2 = null;
                    }
                }
                if (zaa2 == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i3);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                    break;
                } else {
                    int i4 = connectionResult.zzb;
                    if (i4 != 13) {
                        Status zab2 = zab(zaa2.zad, connectionResult);
                        ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                        zaa2.zaa(zab2, null, false);
                        break;
                    } else if (this.zai != null) {
                        String errorString = GooglePlayServicesUtilLight.getErrorString(i4);
                        String str = connectionResult.zzd;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + String.valueOf(errorString).length() + 69);
                        sb2.append("Error resolution was canceled by the user, original error message: ");
                        sb2.append(errorString);
                        sb2.append(": ");
                        sb2.append(str);
                        Status status2 = new Status(17, sb2.toString());
                        ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                        zaa2.zaa(status2, null, false);
                        break;
                    } else {
                        throw null;
                    }
                }
            case 6:
                if (this.zah.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.zah.getApplicationContext();
                    synchronized (BackgroundDetector.zza) {
                        if (!BackgroundDetector.zza.zze) {
                            application.registerActivityLifecycleCallbacks(BackgroundDetector.zza);
                            application.registerComponentCallbacks(BackgroundDetector.zza);
                            BackgroundDetector.zza.zze = true;
                        }
                    }
                    BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                    zabc zabc = new zabc(this);
                    if (backgroundDetector != null) {
                        synchronized (BackgroundDetector.zza) {
                            backgroundDetector.zzd.add(zabc);
                        }
                        BackgroundDetector backgroundDetector2 = BackgroundDetector.zza;
                        if (!backgroundDetector2.zzc.get()) {
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState(runningAppProcessInfo);
                            if (!backgroundDetector2.zzc.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                                backgroundDetector2.zzb.set(true);
                            }
                        }
                        if (!backgroundDetector2.zzb.get()) {
                            this.zae = 300000;
                            break;
                        }
                    } else {
                        throw null;
                    }
                }
                break;
            case 7:
                zac((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zam.containsKey(message.obj)) {
                    zaa<?> zaa6 = this.zam.get(message.obj);
                    ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                    if (zaa6.zaj) {
                        zaa6.zai();
                        break;
                    }
                }
                break;
            case 10:
                for (ApiKey<?> apiKey2 : this.zap) {
                    zaa<?> remove = this.zam.remove(apiKey2);
                    if (remove != null) {
                        remove.zaa();
                    }
                }
                this.zap.clear();
                break;
            case 11:
                if (this.zam.containsKey(message.obj)) {
                    zaa<?> zaa7 = this.zam.get(message.obj);
                    ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                    if (zaa7.zaj) {
                        zaa7.zao();
                        GoogleApiManager googleApiManager = GoogleApiManager.this;
                        if (googleApiManager.zai.isGooglePlayServicesAvailable(googleApiManager.zah) == 18) {
                            status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
                        } else {
                            status = new Status(22, "API failed to connect while resuming due to an unknown error.");
                        }
                        ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                        zaa7.zaa(status, null, false);
                        zaa7.zac.disconnect("Timing out connection while resuming.");
                        break;
                    }
                }
                break;
            case 12:
                if (this.zam.containsKey(message.obj)) {
                    this.zam.get(message.obj).zaa(true);
                    break;
                }
                break;
            case 14:
                if (((zaaa) message.obj) == null) {
                    throw null;
                } else if (!this.zam.containsKey(null)) {
                    throw null;
                } else {
                    this.zam.get(null).zaa(false);
                    throw null;
                }
            case 15:
                zab zab3 = (zab) message.obj;
                if (this.zam.containsKey(zab3.zaa)) {
                    zaa<?> zaa8 = this.zam.get(zab3.zaa);
                    if (zaa8.zak.contains(zab3) && !zaa8.zaj) {
                        if (!zaa8.zac.isConnected()) {
                            zaa8.zai();
                            break;
                        } else {
                            zaa8.zan();
                            break;
                        }
                    }
                }
                break;
            case 16:
                zab zab4 = (zab) message.obj;
                if (this.zam.containsKey(zab4.zaa)) {
                    zaa<?> zaa9 = this.zam.get(zab4.zaa);
                    if (zaa9.zak.remove(zab4)) {
                        GoogleApiManager.this.zaq.removeMessages(15, zab4);
                        GoogleApiManager.this.zaq.removeMessages(16, zab4);
                        Feature feature = zab4.zab;
                        ArrayList arrayList = new ArrayList(zaa9.zab.size());
                        for (zac zac2 : zaa9.zab) {
                            if ((zac2 instanceof zab) && (zaa3 = ((zab) zac2).zaa(zaa9)) != null) {
                                int length = zaa3.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        i5 = -1;
                                    } else if (!ReactYogaConfigProvider.equal(zaa3[i5], feature)) {
                                        i5++;
                                    }
                                }
                                if (i5 >= 0) {
                                    arrayList.add(zac2);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            zac zac3 = (zac) obj;
                            zaa9.zab.remove(zac3);
                            zac3.zaa(new UnsupportedApiCallException(feature));
                        }
                        break;
                    }
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    public final zaa<?> zac(GoogleApi<?> googleApi) {
        ApiKey<O> apiKey = googleApi.zae;
        zaa<?> zaa2 = this.zam.get(apiKey);
        if (zaa2 == null) {
            zaa2 = new zaa<>(googleApi);
            this.zam.put(apiKey, zaa2);
        }
        if (zaa2.zak()) {
            this.zap.add(apiKey);
        }
        zaa2.zai();
        return zaa2;
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        public final Queue<zac> zab = new LinkedList();
        @NotOnlyInitialized
        public final Api.Client zac;
        public final ApiKey<O> zad;
        public final zaw zae;
        public final Set<zaj> zaf = new HashSet();
        public final Map<ListenerHolder$ListenerKey<?>, zabs> zag = new HashMap();
        public final int zah;
        public final zacb zai;
        public boolean zaj;
        public final List<zab> zak = new ArrayList();
        public ConnectionResult zal = null;

        public zaa(GoogleApi<O> googleApi) {
            Looper looper = GoogleApiManager.this.zaq.getLooper();
            ClientSettings build = googleApi.createClientSettingsBuilder().build();
            Api.AbstractClientBuilder<?, O> abstractClientBuilder = googleApi.zac.zaa;
            ReactYogaConfigProvider.checkNotNull(abstractClientBuilder);
            this.zac = abstractClientBuilder.buildClient(googleApi.zaa, looper, build, googleApi.zad, (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
            this.zad = googleApi.zae;
            this.zae = new zaw();
            this.zah = googleApi.zag;
            if (this.zac.requiresSignIn()) {
                this.zai = new zacb(GoogleApiManager.this.zah, GoogleApiManager.this.zaq, googleApi.createClientSettingsBuilder().build());
            } else {
                this.zai = null;
            }
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.zaq.getLooper()) {
                zam();
            } else {
                GoogleApiManager.this.zaq.post(new zabe(this));
            }
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            zaa(connectionResult, null);
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == GoogleApiManager.this.zaq.getLooper()) {
                zaa(i);
            } else {
                GoogleApiManager.this.zaq.post(new zabd(this, i));
            }
        }

        public final void zaa(int i) {
            zad();
            this.zaj = true;
            zaw zaw = this.zae;
            String lastDisconnectMessage = this.zac.getLastDisconnectMessage();
            if (zaw != null) {
                StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
                if (i == 1) {
                    sb.append(" due to service disconnection.");
                } else if (i == 3) {
                    sb.append(" due to dead object exception.");
                }
                if (lastDisconnectMessage != null) {
                    sb.append(" Last reason for disconnect: ");
                    sb.append(lastDisconnectMessage);
                }
                zaw.zaa(true, new Status(20, sb.toString()));
                Handler handler = GoogleApiManager.this.zaq;
                handler.sendMessageDelayed(Message.obtain(handler, 9, this.zad), GoogleApiManager.this.zac);
                Handler handler2 = GoogleApiManager.this.zaq;
                handler2.sendMessageDelayed(Message.obtain(handler2, 11, this.zad), GoogleApiManager.this.zad);
                GoogleApiManager.this.zaj.zaa.clear();
                for (zabs zabs : this.zag.values()) {
                    zabs.zac.run();
                }
                return;
            }
            throw null;
        }

        public final boolean zab(zac zac2) {
            if (!(zac2 instanceof zab)) {
                zac(zac2);
                return true;
            }
            zab zab2 = (zab) zac2;
            Feature zaa2 = zaa(zab2.zaa((zaa<?>) this));
            if (zaa2 == null) {
                zac(zac2);
                return true;
            }
            String name = this.zac.getClass().getName();
            String str = zaa2.zza;
            long version = zaa2.getVersion();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + name.length() + 77);
            sb.append(name);
            sb.append(" could not execute call because it requires feature (");
            sb.append(str);
            sb.append(", ");
            sb.append(version);
            sb.append(").");
            Log.w("GoogleApiManager", sb.toString());
            if (!GoogleApiManager.this.zar || !zab2.zab(this)) {
                zab2.zaa(new UnsupportedApiCallException(zaa2));
                return true;
            }
            PendingIntent pendingIntent = null;
            zab zab3 = new zab(this.zad, zaa2, null);
            int indexOf = this.zak.indexOf(zab3);
            if (indexOf >= 0) {
                zab zab4 = this.zak.get(indexOf);
                GoogleApiManager.this.zaq.removeMessages(15, zab4);
                Handler handler = GoogleApiManager.this.zaq;
                handler.sendMessageDelayed(Message.obtain(handler, 15, zab4), GoogleApiManager.this.zac);
            } else {
                this.zak.add(zab3);
                Handler handler2 = GoogleApiManager.this.zaq;
                handler2.sendMessageDelayed(Message.obtain(handler2, 15, zab3), GoogleApiManager.this.zac);
                Handler handler3 = GoogleApiManager.this.zaq;
                handler3.sendMessageDelayed(Message.obtain(handler3, 16, zab3), GoogleApiManager.this.zad);
                synchronized (GoogleApiManager.zaf) {
                }
                GoogleApiManager googleApiManager = GoogleApiManager.this;
                int i = this.zah;
                GoogleApiAvailability googleApiAvailability = googleApiManager.zai;
                Context context = googleApiManager.zah;
                if (googleApiAvailability != null) {
                    Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, 2, null);
                    if (errorResolutionIntent != null) {
                        pendingIntent = PendingIntent.getActivity(context, 0, errorResolutionIntent, 134217728);
                    }
                    if (pendingIntent != null) {
                        googleApiAvailability.zaa(context, 2, GoogleApiActivity.zaa(context, pendingIntent, i));
                    }
                } else {
                    throw null;
                }
            }
            return false;
        }

        public final void zac(zac zac2) {
            zac2.zaa(this.zae, zak());
            try {
                zac2.zac(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.zac.getClass().getName()), th);
            }
        }

        public final void zad() {
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            this.zal = null;
        }

        public final void zai() {
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            if (!this.zac.isConnected() && !this.zac.isConnecting()) {
                try {
                    int zaa2 = GoogleApiManager.this.zaj.zaa(GoogleApiManager.this.zah, this.zac);
                    if (zaa2 != 0) {
                        ConnectionResult connectionResult = new ConnectionResult(zaa2, null);
                        String name = this.zac.getClass().getName();
                        String valueOf = String.valueOf(connectionResult);
                        StringBuilder sb = new StringBuilder(name.length() + 35 + valueOf.length());
                        sb.append("The service for ");
                        sb.append(name);
                        sb.append(" is not available: ");
                        sb.append(valueOf);
                        Log.w("GoogleApiManager", sb.toString());
                        zaa(connectionResult, null);
                        return;
                    }
                    zac zac2 = new zac(this.zac, this.zad);
                    if (this.zac.requiresSignIn()) {
                        zacb zacb = this.zai;
                        ReactYogaConfigProvider.checkNotNull(zacb);
                        zacb zacb2 = zacb;
                        zad zad2 = zacb2.zag;
                        if (zad2 != null) {
                            zad2.disconnect();
                        }
                        zacb2.zaf.zak = Integer.valueOf(System.identityHashCode(zacb2));
                        Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = zacb2.zad;
                        Context context = zacb2.zab;
                        Looper looper = zacb2.zac.getLooper();
                        ClientSettings clientSettings = zacb2.zaf;
                        zacb2.zag = (zad) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.zai, (GoogleApiClient.ConnectionCallbacks) zacb2, (GoogleApiClient.OnConnectionFailedListener) zacb2);
                        zacb2.zah = zac2;
                        Set<Scope> set = zacb2.zae;
                        if (set == null || set.isEmpty()) {
                            zacb2.zac.post(new zacd(zacb2));
                        } else {
                            zacb2.zag.zab();
                        }
                    }
                    try {
                        this.zac.connect(zac2);
                    } catch (SecurityException e) {
                        zaa(new ConnectionResult(10), e);
                    }
                } catch (IllegalStateException e2) {
                    zaa(new ConnectionResult(10), e2);
                }
            }
        }

        public final boolean zak() {
            return this.zac.requiresSignIn();
        }

        public final void zam() {
            zad();
            zac(ConnectionResult.RESULT_SUCCESS);
            zao();
            Iterator<zabs> it = this.zag.values().iterator();
            if (!it.hasNext()) {
                zan();
                zap();
                return;
            }
            it.next();
            throw null;
        }

        public final void zan() {
            ArrayList arrayList = new ArrayList(this.zab);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zac zac2 = (zac) obj;
                if (!this.zac.isConnected()) {
                    return;
                }
                if (zab(zac2)) {
                    this.zab.remove(zac2);
                }
            }
        }

        public final void zao() {
            if (this.zaj) {
                GoogleApiManager.this.zaq.removeMessages(11, this.zad);
                GoogleApiManager.this.zaq.removeMessages(9, this.zad);
                this.zaj = false;
            }
        }

        public final void zap() {
            GoogleApiManager.this.zaq.removeMessages(12, this.zad);
            Handler handler = GoogleApiManager.this.zaq;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.zad), GoogleApiManager.this.zae);
        }

        public final void zac(ConnectionResult connectionResult) {
            Iterator<zaj> it = this.zaf.iterator();
            if (it.hasNext()) {
                zaj next = it.next();
                if (ReactYogaConfigProvider.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    this.zac.getEndpointPackageName();
                }
                if (next != null) {
                    throw null;
                }
                throw null;
            }
            this.zaf.clear();
        }

        public final void zaa(ConnectionResult connectionResult, Exception exc) {
            zad zad2;
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            zacb zacb = this.zai;
            if (!(zacb == null || (zad2 = zacb.zag) == null)) {
                zad2.disconnect();
            }
            zad();
            GoogleApiManager.this.zaj.zaa.clear();
            zac(connectionResult);
            if (connectionResult.zzb == 4) {
                Status status = GoogleApiManager.zab;
                ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                zaa(status, null, false);
            } else if (this.zab.isEmpty()) {
                this.zal = connectionResult;
            } else if (exc != null) {
                ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                zaa(null, exc, false);
            } else if (!GoogleApiManager.this.zar) {
                Status zab2 = GoogleApiManager.zab(this.zad, connectionResult);
                ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                zaa(zab2, null, false);
            } else {
                zaa(GoogleApiManager.zab(this.zad, connectionResult), null, true);
                if (!this.zab.isEmpty()) {
                    synchronized (GoogleApiManager.zaf) {
                    }
                    if (!GoogleApiManager.this.zaa(connectionResult, this.zah)) {
                        if (connectionResult.zzb == 18) {
                            this.zaj = true;
                        }
                        if (this.zaj) {
                            Handler handler = GoogleApiManager.this.zaq;
                            handler.sendMessageDelayed(Message.obtain(handler, 9, this.zad), GoogleApiManager.this.zac);
                            return;
                        }
                        Status zab3 = GoogleApiManager.zab(this.zad, connectionResult);
                        ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
                        zaa(zab3, null, false);
                    }
                }
            }
        }

        public final void zaa(zac zac2) {
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            if (!this.zac.isConnected()) {
                this.zab.add(zac2);
                ConnectionResult connectionResult = this.zal;
                if (connectionResult != null) {
                    if ((connectionResult.zzb == 0 || connectionResult.zzc == null) ? false : true) {
                        zaa(this.zal, null);
                        return;
                    }
                }
                zai();
            } else if (zab(zac2)) {
                zap();
            } else {
                this.zab.add(zac2);
            }
        }

        public final void zaa() {
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            Status status = GoogleApiManager.zaa;
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            zaa(status, null, false);
            zaw zaw = this.zae;
            if (zaw != null) {
                zaw.zaa(false, GoogleApiManager.zaa);
                for (ListenerHolder$ListenerKey listenerHolder$ListenerKey : (ListenerHolder$ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder$ListenerKey[0])) {
                    zaa(new zah(listenerHolder$ListenerKey, new TaskCompletionSource()));
                }
                zac(new ConnectionResult(4));
                if (this.zac.isConnected()) {
                    this.zac.onUserSignOut(new zabf(this));
                    return;
                }
                return;
            }
            throw null;
        }

        public final void zaa(Status status, Exception exc, boolean z) {
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            boolean z2 = true;
            boolean z3 = status == null;
            if (exc != null) {
                z2 = false;
            }
            if (z3 != z2) {
                Iterator<zac> it = this.zab.iterator();
                while (it.hasNext()) {
                    zac next = it.next();
                    if (!z || next.zaa == 2) {
                        if (status != null) {
                            next.zaa(status);
                        } else {
                            next.zaa(exc);
                        }
                        it.remove();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Status XOR exception should be null");
        }

        public final boolean zaa(boolean z) {
            ReactYogaConfigProvider.checkHandlerThread(GoogleApiManager.this.zaq);
            if (!this.zac.isConnected() || this.zag.size() != 0) {
                return false;
            }
            zaw zaw = this.zae;
            if (!zaw.zaa.isEmpty() || !zaw.zab.isEmpty()) {
                if (z) {
                    zap();
                }
                return false;
            }
            this.zac.disconnect("Timing out service connection.");
            return true;
        }

        public final Feature zaa(Feature[] featureArr) {
            if (featureArr == null || featureArr.length == 0) {
                return null;
            }
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.zza, Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.get(feature2.zza);
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
            return null;
        }
    }

    public final boolean zaa(ConnectionResult connectionResult, int i) {
        GoogleApiAvailability googleApiAvailability = this.zai;
        Context context = this.zah;
        PendingIntent pendingIntent = null;
        if (googleApiAvailability != null) {
            if ((connectionResult.zzb == 0 || connectionResult.zzc == null) ? false : true) {
                pendingIntent = connectionResult.zzc;
            } else {
                Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, connectionResult.zzb, null);
                if (errorResolutionIntent != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, errorResolutionIntent, 134217728);
                }
            }
            if (pendingIntent == null) {
                return false;
            }
            googleApiAvailability.zaa(context, connectionResult.zzb, GoogleApiActivity.zaa(context, pendingIntent, i));
            return true;
        }
        throw null;
    }
}
