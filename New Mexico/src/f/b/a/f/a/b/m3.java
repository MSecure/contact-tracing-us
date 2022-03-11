package f.b.a.f.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
/* loaded from: classes.dex */
public final class m3 {
    public final Context a;

    public m3(Context context) {
        this.a = context;
    }

    public static String a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("local_testing_dir");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
