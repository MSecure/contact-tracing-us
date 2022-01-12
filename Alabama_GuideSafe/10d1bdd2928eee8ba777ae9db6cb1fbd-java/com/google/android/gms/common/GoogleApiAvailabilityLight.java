package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class GoogleApiAvailabilityLight {
    @RecentlyNonNull
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    static {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @RecentlyNullable
    public Intent getErrorResolutionIntent(Context context, @RecentlyNonNull int i, String str) {
        if (i == 1 || i == 2) {
            if (context != null && ReactYogaConfigProvider.isWearableWithoutPlayStore(context)) {
                return zzj.zza();
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("gcore_");
            outline17.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
            outline17.append("-");
            if (!TextUtils.isEmpty(str)) {
                outline17.append(str);
            }
            outline17.append("-");
            if (context != null) {
                outline17.append(context.getPackageName());
            }
            outline17.append("-");
            if (context != null) {
                try {
                    PackageManagerWrapper packageManager = Wrappers.packageManager(context);
                    outline17.append(packageManager.zza.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return zzj.zza("com.google.android.gms", outline17.toString());
        } else if (i != 3) {
            return null;
        } else {
            return zzj.zza("com.google.android.gms");
        }
    }

    @RecentlyNonNull
    public int isGooglePlayServicesAvailable(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        boolean z = true;
        if (isGooglePlayServicesAvailable != 18) {
            if (isGooglePlayServicesAvailable == 1) {
                try {
                    Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                                break;
                            }
                        } else {
                            z = context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
                            break;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            z = false;
        }
        if (z) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }
}
