package b.b0.y.s;

import android.content.ComponentName;
import android.content.Context;
import b.b0.m;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1264a = m.e("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z) {
        String str = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            m c2 = m.c();
            String str2 = f1264a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z ? str : "disabled";
            c2.a(str2, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e2) {
            m c3 = m.c();
            String str3 = f1264a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z) {
                str = "disabled";
            }
            objArr2[1] = str;
            c3.a(str3, String.format("%s could not be %s", objArr2), e2);
        }
    }
}
