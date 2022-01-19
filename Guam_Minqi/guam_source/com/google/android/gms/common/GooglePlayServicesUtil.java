package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    @RecentlyNonNull
    public static Resources getRemoteResource(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
