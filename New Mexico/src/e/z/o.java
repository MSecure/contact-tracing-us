package e.z;

import android.os.Build;
/* loaded from: classes.dex */
public class o {
    public static final boolean a = true;
    public static final boolean b = true;
    public static final boolean c;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 28) {
            z = false;
        }
        c = z;
    }
}
