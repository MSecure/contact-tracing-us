package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzai implements Application.ActivityLifecycleCallbacks {
    private final Activity zza;
    private final zzag zzb;

    private zzai(Activity activity, zzag zzag) {
        this.zza = activity;
        this.zzb = zzag;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        if (activity == this.zza) {
            try {
                this.zzb.zza(1);
            } catch (RemoteException e) {
                if (Log.isLoggable("NearbyMessagesClient", 2)) {
                    Log.v("NearbyMessagesClient", String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", activity.getPackageName(), e));
                }
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.zza) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            }
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }
}
