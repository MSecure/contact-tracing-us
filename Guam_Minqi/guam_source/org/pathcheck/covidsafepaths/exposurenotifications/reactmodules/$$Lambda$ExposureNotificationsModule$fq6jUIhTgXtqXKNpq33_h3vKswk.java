package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.-$$Lambda$ExposureNotificationsModule$fq6jUIhTgXtqXKNpq33_h3vKswk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExposureNotificationsModule$fq6jUIhTgXtqXKNpq33_h3vKswk implements OnFailureListener {
    public static final /* synthetic */ $$Lambda$ExposureNotificationsModule$fq6jUIhTgXtqXKNpq33_h3vKswk INSTANCE = new $$Lambda$ExposureNotificationsModule$fq6jUIhTgXtqXKNpq33_h3vKswk();

    private /* synthetic */ $$Lambda$ExposureNotificationsModule$fq6jUIhTgXtqXKNpq33_h3vKswk() {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.w(ExposureNotificationsModule.TAG, "Failed to stop EN", exc);
    }
}
