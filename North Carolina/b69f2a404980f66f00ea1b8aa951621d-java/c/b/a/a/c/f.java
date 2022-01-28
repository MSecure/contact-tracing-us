package c.b.a.a.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;

public final class f extends g {
    public static Resources e(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
