package c.b.a.a.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.RecentlyNonNull;

public final class f extends g {
    @RecentlyNonNull
    public static Resources e(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
