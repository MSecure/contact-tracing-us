package f.b.a.a.a.b0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import f.b.a.a.a.n0.a1;
import gov.nm.covid19.exposurenotifications.R;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class f {
    public final e a;
    public final a1 b;
    public final ExecutorService c;

    public f(e eVar, a1 a1Var, ExecutorService executorService) {
        this.a = eVar;
        this.b = a1Var;
        this.c = executorService;
    }

    public static boolean a(Resources resources) {
        return resources.getBoolean(R.bool.enx_enableV1toENXMigration);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean b(Context context) {
        boolean z;
        boolean z2;
        PackageInfo packageInfo;
        if (a(context.getResources())) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                z2 = true;
                if (!z2) {
                    z = true;
                    if (z || this.b.a.getBoolean("ExposureNotificationSharedPreferences.HAS_DISPLAYED_ONBOARDING_FOR_MIGRATING_USERS", false)) {
                        return false;
                    }
                    return true;
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        z = false;
        if (z) {
        }
        return false;
    }
}
