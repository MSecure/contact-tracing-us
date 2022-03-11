package e.c0.x.t;

import android.content.ComponentName;
import android.content.Context;
import e.c0.l;

public class f {
    public static final String a = l.e("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z) {
        String str = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            l c = l.c();
            String str2 = a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z ? str : "disabled";
            c.a(str2, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e2) {
            l c2 = l.c();
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
