package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import b.x.t;
import c.b.a.a.d.p.a;
import c.b.a.a.d.p.b;
import c.b.a.a.g.h.b4;
import c.b.a.a.g.h.h;
import c.b.a.a.g.h.t1;

@Keep
public class LogUtils {
    public static h zza(Context context) {
        h.a aVar = (h.a) ((t1.a) h.zzof.g(5, null, null));
        String packageName = context.getPackageName();
        if (aVar.f4035d) {
            aVar.i();
            aVar.f4035d = false;
        }
        h.k((h) aVar.f4034c, packageName);
        String zzb = zzb(context);
        if (zzb != null) {
            if (aVar.f4035d) {
                aVar.i();
                aVar.f4035d = false;
            }
            h.l((h) aVar.f4034c, zzb);
        }
        t1 t1Var = (t1) aVar.j();
        if (t1Var.isInitialized()) {
            return (h) t1Var;
        }
        throw new b4();
    }

    public static String zzb(Context context) {
        try {
            a a2 = b.a(context);
            return a2.f3180a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            t.g1(e2, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }
}
