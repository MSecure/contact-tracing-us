package com.bugsnag.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionLifecycleCallback.kt */
public final class SessionLifecycleCallback implements Application.ActivityLifecycleCallbacks {
    public final SessionTracker sessionTracker;

    public SessionLifecycleCallback(SessionTracker sessionTracker2) {
        Intrinsics.checkParameterIsNotNull(sessionTracker2, "sessionTracker");
        this.sessionTracker = sessionTracker2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        SessionTracker sessionTracker2 = this.sessionTracker;
        String simpleName = activity.getClass().getSimpleName();
        if (sessionTracker2 != null) {
            sessionTracker2.updateForegroundTracker(simpleName, true, System.currentTimeMillis());
            return;
        }
        throw null;
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        SessionTracker sessionTracker2 = this.sessionTracker;
        String simpleName = activity.getClass().getSimpleName();
        if (sessionTracker2 != null) {
            sessionTracker2.updateForegroundTracker(simpleName, false, System.currentTimeMillis());
            return;
        }
        throw null;
    }
}
