package org.pathcheck.covidsafepaths.helpers;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationHelper.kt */
public final class LocationHelper {
    public final LocationCallback callback;
    public final LocationHelper$receiver$1 receiver = new LocationHelper$receiver$1(this);

    /* compiled from: LocationHelper.kt */
    public interface LocationCallback {
    }

    public LocationHelper(LocationCallback locationCallback) {
        Intrinsics.checkNotNullParameter(locationCallback, "callback");
        this.callback = locationCallback;
    }
}
