package c.b.a.a.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import c.a.a.a.a;
import c.b.a.a.d.m.i0;
import c.b.a.a.d.p.b;

public class e {
    @RecentlyNonNull

    /* renamed from: a  reason: collision with root package name */
    public static final int f2930a = g.f2932a;

    /* renamed from: b  reason: collision with root package name */
    public static final e f2931b = new e();

    static {
        int i = g.f2932a;
    }

    @RecentlyNullable
    public Intent a(Context context, @RecentlyNonNull int i, String str) {
        if (i == 1 || i == 2) {
            if (context != null && t.Z1(context)) {
                return i0.a();
            }
            StringBuilder h = a.h("gcore_");
            h.append(f2930a);
            h.append("-");
            if (!TextUtils.isEmpty(str)) {
                h.append(str);
            }
            h.append("-");
            if (context != null) {
                h.append(context.getPackageName());
            }
            h.append("-");
            if (context != null) {
                try {
                    c.b.a.a.d.p.a a2 = b.a(context);
                    h.append(a2.f3180a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return i0.c("com.google.android.gms", h.toString());
        } else if (i != 3) {
            return null;
        } else {
            return i0.b("com.google.android.gms");
        }
    }

    @RecentlyNonNull
    public int b(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        int b2 = g.b(context, i);
        boolean z = true;
        if (b2 != 18) {
            z = b2 == 1 ? g.d(context, "com.google.android.gms") : false;
        }
        if (z) {
            return 18;
        }
        return b2;
    }
}
