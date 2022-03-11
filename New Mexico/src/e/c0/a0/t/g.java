package e.c0.a0.t;

import android.content.ComponentName;
import android.content.Context;
import e.c0.n;
/* loaded from: classes.dex */
public class g {
    public static final String a = n.e("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z) {
        String str = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            n c = n.c();
            String str2 = a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z ? str : "disabled";
            c.a(str2, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e2) {
            n c2 = n.c();
            String str3 = a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z) {
                str = "disabled";
            }
            objArr2[1] = str;
            c2.a(str3, String.format("%s could not be %s", objArr2), e2);
        }
    }
}
