package f.b.a.f.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import f.b.a.f.a.e.a;
/* loaded from: classes.dex */
public final class o2 {
    public static final a c = new a("PackageStateCache");
    public final Context a;
    public int b = -1;

    public o2(Context context) {
        this.a = context;
    }

    public final synchronized int a() {
        if (this.b == -1) {
            try {
                this.b = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                c.b("The current version of the app could not be retrieved", new Object[0]);
            }
        }
        return this.b;
    }
}
