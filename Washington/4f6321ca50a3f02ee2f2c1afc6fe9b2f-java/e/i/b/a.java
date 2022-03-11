package e.i.b;

import android.content.Context;
import android.os.Build;

public class a {
    public static final Object a = new Object();

    public static int a(Context context, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i2) : context.getResources().getColor(i2);
    }
}
