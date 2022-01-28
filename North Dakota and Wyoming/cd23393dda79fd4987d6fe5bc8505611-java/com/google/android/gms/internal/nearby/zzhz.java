package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzhz implements Application.ActivityLifecycleCallbacks {
    private final WeakReference<Activity> zza;
    private final /* synthetic */ zzhx zzb;

    zzhz(zzhx zzhx, WeakReference<Activity> weakReference) {
        this.zzb = zzhx;
        this.zza = weakReference;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (activity == this.zza.get()) {
            this.zzb.zze = true;
            Log.d("NearbyConnections", "Activity is visible.");
            this.zzb.zzc();
        }
    }

    public final void onActivityStopped(Activity activity) {
        if (activity == this.zza.get()) {
            this.zzb.zze = false;
            Log.d("NearbyConnections", "Activity is hidden.");
            this.zzb.zzc();
        }
    }
}
