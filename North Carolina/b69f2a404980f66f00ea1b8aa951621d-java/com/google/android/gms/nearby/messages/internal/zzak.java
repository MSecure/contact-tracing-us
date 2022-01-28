package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

@TargetApi(14)
public final class zzak implements Application.ActivityLifecycleCallbacks {
    public final Activity zza;
    public final zzai zzb;

    public zzak(Activity activity, zzai zzai) {
        this.zza = activity;
        this.zzb = zzai;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.zza) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName());
            }
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
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
            } catch (RemoteException e2) {
                if (Log.isLoggable("NearbyMessagesClient", 2)) {
                    String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", activity.getPackageName(), e2);
                }
            }
        }
    }
}
