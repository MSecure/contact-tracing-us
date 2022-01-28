package f.b.a.c.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.annotation.RecentlyNonNull;

public class j {
    public static j a;

    public j(Context context) {
        context.getApplicationContext();
    }

    public static t a(PackageInfo packageInfo, t... tVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        v vVar = new v(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < tVarArr.length; i2++) {
            if (tVarArr[i2].equals(vVar)) {
                return tVarArr[i2];
            }
        }
        return null;
    }

    @RecentlyNonNull
    public static boolean b(@RecentlyNonNull PackageInfo packageInfo, @RecentlyNonNull boolean z) {
        t tVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                tVar = a(packageInfo, x.a);
            } else {
                tVar = a(packageInfo, x.a[0]);
            }
            if (tVar != null) {
                return true;
            }
        }
        return false;
    }
}
