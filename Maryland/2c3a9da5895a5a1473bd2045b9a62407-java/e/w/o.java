package e.w;

import android.os.Build;

public class o {
    public static final boolean a = true;
    public static final boolean b = true;
    public static final boolean c;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i2 < 28) {
            z = false;
        }
        c = z;
    }
}
