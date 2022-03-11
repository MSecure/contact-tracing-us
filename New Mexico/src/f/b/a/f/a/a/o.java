package f.b.a.f.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import f.b.a.f.a.c.c;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.a0;
import f.b.a.f.a.e.l;
import f.b.a.f.a.e.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: e */
    public static final a f3172e = new a("AppUpdateService");

    /* renamed from: f */
    public static final Intent f3173f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    public l<a0> a;
    public final String b;
    public final Context c;

    /* renamed from: d */
    public final q f3174d;

    public o(Context context, q qVar) {
        this.b = context.getPackageName();
        this.c = context;
        this.f3174d = qVar;
        if (n.b(context)) {
            Context applicationContext = context.getApplicationContext();
            this.a = new l<>(applicationContext != null ? applicationContext : context, f3172e, "AppUpdateService", f3173f, l.a, null);
        }
    }

    public static Bundle a(o oVar, String str) {
        Map<String, Integer> map;
        Integer num;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Map<String, Map<String, Integer>> map2 = c.a;
        Bundle bundle3 = new Bundle();
        synchronized (c.class) {
            Map<String, Map<String, Integer>> map3 = c.a;
            if (!map3.containsKey("app_update")) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 11002);
                map3.put("app_update", hashMap);
            }
            map = map3.get("app_update");
        }
        bundle3.putInt("playcore_version_code", map.get("java").intValue());
        if (map.containsKey("native")) {
            bundle3.putInt("playcore_native_version", map.get("native").intValue());
        }
        if (map.containsKey("unity")) {
            bundle3.putInt("playcore_unity_version", map.get("unity").intValue());
        }
        bundle2.putAll(bundle3);
        bundle2.putInt("playcore.version.code", 11002);
        bundle.putAll(bundle2);
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(oVar.c.getPackageManager().getPackageInfo(oVar.c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f3172e.b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }
}
