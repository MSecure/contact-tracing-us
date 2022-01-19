package com.google.android.gms.nearby;

import android.content.Context;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.nearby.zznj;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class Nearby {
    public static boolean zza(Context context) {
        if (Wrappers.packageManager(context).zza.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            return zznj.zza(context.getContentResolver(), "gms:nearby:requires_gms_check");
        }
        return true;
    }
}
