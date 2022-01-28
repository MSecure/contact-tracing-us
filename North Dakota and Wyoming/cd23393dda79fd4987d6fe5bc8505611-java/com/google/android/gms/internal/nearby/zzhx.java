package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzhx {
    private static final WeakHashMap<Activity, zzhx> zza = new WeakHashMap<>();
    private final Context zzb;
    private final WeakReference<Activity> zzc;
    private final NfcAdapter zzd;
    private boolean zze = true;
    private boolean zzf;
    private boolean zzg;

    public static synchronized zzhx zza(Activity activity) {
        zzhx zzhx;
        synchronized (zzhx.class) {
            WeakHashMap<Activity, zzhx> weakHashMap = zza;
            if (!weakHashMap.containsKey(activity)) {
                weakHashMap.put(activity, new zzhx(activity));
            }
            zzhx = weakHashMap.get(activity);
        }
        return zzhx;
    }

    private zzhx(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        this.zzb = applicationContext;
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.zzc = weakReference;
        this.zzd = NfcAdapter.getDefaultAdapter(applicationContext);
        activity.getApplication().registerActivityLifecycleCallbacks(new zzhz(this, weakReference));
        Log.d("NearbyConnections", "NfcDispatcher created.");
    }

    public final void zza() {
        this.zzf = true;
        Log.d("NearbyConnections", "NFC discovery started.");
        zzc();
    }

    public final void zzb() {
        this.zzf = false;
        Log.d("NearbyConnections", "NFC discovery stopped.");
        zzc();
    }

    /* access modifiers changed from: private */
    public final void zzc() {
        NfcAdapter nfcAdapter;
        Log.d("NearbyConnections", "Invalidating dispatch state.");
        boolean z = false;
        if (!this.zze || !this.zzf) {
            Log.d("NearbyConnections", "Stopping NFC dispatching.");
            if (!this.zzg) {
                Log.d("NearbyConnections", "Can't stop NFC dispatching. Not dispatching.");
                return;
            }
            Activity activity = this.zzc.get();
            if (activity != null) {
                this.zzd.disableReaderMode(activity);
            }
            this.zzg = false;
            Log.d("NearbyConnections", "No longer dispatching NFC events");
            return;
        }
        Log.d("NearbyConnections", "Starting NFC dispatching.");
        if (this.zzg) {
            Log.d("NearbyConnections", "Can't start NFC dispatching. Already dispatching.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 19 && this.zzb.getPackageManager().hasSystemFeature("android.hardware.nfc") && ContextCompat.checkSelfPermission(this.zzb, "android.permission.NFC") == 0 && (nfcAdapter = this.zzd) != null && nfcAdapter.isEnabled()) {
            z = true;
        }
        if (!z) {
            Log.d("NearbyConnections", "Cannot dispatch NFC events. NFC is not supported.");
            return;
        }
        Activity activity2 = this.zzc.get();
        if (activity2 == null) {
            Log.d("NearbyConnections", "Cannot dispatch NFC events. Activity is gone.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("presence", 100);
        this.zzd.enableReaderMode(activity2, new zzhw(this), 385, bundle);
        this.zzg = true;
        Log.d("NearbyConnections", "Dispatching NFC events");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Tag tag) {
        Intent intent = new Intent("android.nfc.action.TAG_DISCOVERED");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("android.nfc.extra.TAG", tag);
        this.zzb.sendBroadcast(intent);
        Log.d("NearbyConnections", "Dispatching discovered NFC tag");
    }
}
