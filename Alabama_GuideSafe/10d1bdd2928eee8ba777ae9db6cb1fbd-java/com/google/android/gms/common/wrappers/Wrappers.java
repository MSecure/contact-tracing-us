package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class Wrappers {
    public static Wrappers zzb = new Wrappers();
    public PackageManagerWrapper zza = null;

    @RecentlyNonNull
    public static PackageManagerWrapper packageManager(@RecentlyNonNull Context context) {
        PackageManagerWrapper packageManagerWrapper;
        Wrappers wrappers = zzb;
        synchronized (wrappers) {
            if (wrappers.zza == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                wrappers.zza = new PackageManagerWrapper(context);
            }
            packageManagerWrapper = wrappers.zza;
        }
        return packageManagerWrapper;
    }
}
