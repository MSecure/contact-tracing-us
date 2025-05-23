package b.i.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1025a = new Object();

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static int b(Context context, int i) {
        return context.getColor(i);
    }

    public static Drawable c(Context context, int i) {
        return context.getDrawable(i);
    }

    public static boolean d(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void e(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
