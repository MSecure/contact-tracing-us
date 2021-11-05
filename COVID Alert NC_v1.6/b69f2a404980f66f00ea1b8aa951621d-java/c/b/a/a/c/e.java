package c.b.a.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import c.a.a.a.a;
import c.b.a.a.c.l.e0;
import c.b.a.a.c.n.c;
import c.b.a.a.c.o.b;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2293a = g.f2295a;

    /* renamed from: b  reason: collision with root package name */
    public static final e f2294b = new e();

    static {
        int i = g.f2295a;
    }

    public Intent a(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            if (context != null && c.w1(context)) {
                return e0.c();
            }
            StringBuilder g = a.g("gcore_");
            g.append(f2293a);
            g.append("-");
            if (!TextUtils.isEmpty(str)) {
                g.append(str);
            }
            g.append("-");
            if (context != null) {
                g.append(context.getPackageName());
            }
            g.append("-");
            if (context != null) {
                try {
                    c.b.a.a.c.o.a a2 = b.a(context);
                    g.append(a2.f2499a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return e0.a("com.google.android.gms", g.toString());
        } else if (i != 3) {
            return null;
        } else {
            return e0.b("com.google.android.gms");
        }
    }

    public int b(Context context, int i) {
        int b2 = g.b(context, i);
        boolean z = true;
        if (b2 != 18) {
            z = b2 == 1 ? g.c(context, "com.google.android.gms") : false;
        }
        if (z) {
            return 18;
        }
        return b2;
    }
}
