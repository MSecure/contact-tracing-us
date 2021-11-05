package c.b.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static h f2298a;

    public h(Context context) {
        context.getApplicationContext();
    }

    public static s a(PackageInfo packageInfo, s... sVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        u uVar = new u(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < sVarArr.length; i++) {
            if (sVarArr[i].equals(uVar)) {
                return sVarArr[i];
            }
        }
        return null;
    }

    public static boolean b(PackageInfo packageInfo, boolean z) {
        s sVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                sVar = a(packageInfo, w.f2507a);
            } else {
                sVar = a(packageInfo, w.f2507a[0]);
            }
            if (sVar != null) {
                return true;
            }
        }
        return false;
    }
}
