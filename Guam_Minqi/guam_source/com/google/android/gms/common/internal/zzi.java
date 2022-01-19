package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzi implements ServiceConnection {
    public final Map<ServiceConnection, ServiceConnection> zza = new HashMap();
    public int zzb = 2;
    public boolean zzc;
    public IBinder zzd;
    public final GmsClientSupervisor.zza zze;
    public ComponentName zzf;
    public final /* synthetic */ zzg zzg;

    public zzi(zzg zzg2, GmsClientSupervisor.zza zza2) {
        this.zzg = zzg2;
        this.zze = zza2;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzg.zza) {
            this.zzg.zzc.removeMessages(1, this.zze);
            this.zzd = iBinder;
            this.zzf = componentName;
            for (ServiceConnection serviceConnection : this.zza.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.zzb = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzg.zza) {
            this.zzg.zzc.removeMessages(1, this.zze);
            this.zzd = null;
            this.zzf = componentName;
            for (ServiceConnection serviceConnection : this.zza.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.zzb = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ec  */
    public final void zza(String str) {
        Intent intent;
        boolean z;
        Bundle bundle;
        this.zzb = 3;
        zzg zzg2 = this.zzg;
        ConnectionTracker connectionTracker = zzg2.zzd;
        Context context = zzg2.zzb;
        GmsClientSupervisor.zza zza2 = this.zze;
        if (zza2.zza != null) {
            if (zza2.zze) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", zza2.zza);
                try {
                    bundle = context.getContentResolver().call(GmsClientSupervisor.zza.zzf, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 34);
                    sb.append("Dynamic intent resolution failed: ");
                    sb.append(valueOf);
                    Log.w("ConnectionStatusConfig", sb.toString());
                    bundle = null;
                }
                if (bundle == null) {
                    intent = null;
                } else {
                    intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    String valueOf2 = String.valueOf(zza2.zza);
                    Log.w("ConnectionStatusConfig", valueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf2) : new String("Dynamic lookup for intent failed for action: "));
                }
            } else {
                intent = null;
            }
            if (intent == null) {
                intent = new Intent(zza2.zza).setPackage(zza2.zzb);
            }
        } else {
            intent = new Intent().setComponent(zza2.zzc);
        }
        int i = this.zze.zzd;
        if (connectionTracker != null) {
            ComponentName component = intent.getComponent();
            boolean z2 = false;
            if (component != null) {
                String packageName = component.getPackageName();
                "com.google.android.gms".equals(packageName);
                try {
                    if ((Wrappers.packageManager(context).zza.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                        z = true;
                        if (!z) {
                            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                        } else {
                            z2 = context.bindService(intent, this, i);
                        }
                        this.zzc = z2;
                        if (!z2) {
                            Message obtainMessage = this.zzg.zzc.obtainMessage(1, this.zze);
                            zzg zzg3 = this.zzg;
                            zzg3.zzc.sendMessageDelayed(obtainMessage, zzg3.zzf);
                            return;
                        }
                        this.zzb = 2;
                        try {
                            this.zzg.zzd.unbindService(this.zzg.zzb, this);
                            return;
                        } catch (IllegalArgumentException unused) {
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                }
            }
            z = false;
            if (!z) {
            }
            this.zzc = z2;
            if (!z2) {
            }
        } else {
            throw null;
        }
    }
}
