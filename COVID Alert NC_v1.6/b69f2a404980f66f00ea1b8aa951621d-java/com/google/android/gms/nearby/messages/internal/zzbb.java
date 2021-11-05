package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public final class zzbb implements Application.ActivityLifecycleCallbacks {
    public final Activity zza;
    public final zzaj zzb;

    public zzbb(Activity activity, zzaj zzaj) {
        this.zza = activity;
        this.zzb = zzaj;
    }

    public /* synthetic */ zzbb(Activity activity, zzaj zzaj, zzat zzat) {
        this(activity, zzaj);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.zza) {
            String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName());
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
            this.zzb.zza((zzaj) 1);
        }
    }
}
