package c.b.a.a.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.annotation.RecentlyNonNull;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static h f2935a;

    public h(Context context) {
        context.getApplicationContext();
    }

    public static t a(PackageInfo packageInfo, t... tVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        v vVar = new v(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < tVarArr.length; i++) {
            if (tVarArr[i].equals(vVar)) {
                return tVarArr[i];
            }
        }
        return null;
    }

    @RecentlyNonNull
    public static boolean b(@RecentlyNonNull PackageInfo packageInfo, @RecentlyNonNull boolean z) {
        t tVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                tVar = a(packageInfo, x.f3188a);
            } else {
                tVar = a(packageInfo, x.f3188a[0]);
            }
            if (tVar != null) {
                return true;
            }
        }
        return false;
    }
}
