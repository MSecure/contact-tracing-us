package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbd implements Application.ActivityLifecycleCallbacks {
    private final Activity zza;
    private final zzal zzb;

    private zzbd(Activity activity, zzal zzal) {
        this.zza = activity;
        this.zzb = zzal;
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
            this.zzb.zza((zzal) 1);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.zza) {
            Log.v("NearbyMessages", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    /* synthetic */ zzbd(Activity activity, zzal zzal, zzav zzav) {
        this(activity, zzal);
    }
}
