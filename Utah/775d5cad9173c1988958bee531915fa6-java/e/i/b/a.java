package e.i.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import java.io.File;

public class a {
    public static final Object a = new Object();

    /* renamed from: e.i.b.a$a  reason: collision with other inner class name */
    public static class C0033a {
        public static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        public static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    public static class b {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }

        public static Drawable b(Context context, int i2) {
            return context.getDrawable(i2);
        }

        public static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    public static class c {
        public static int a(Context context, int i2) {
            return context.getColor(i2);
        }

        public static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        public static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    public static class d {
        public static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    public static int a(Context context, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? c.a(context, i2) : context.getResources().getColor(i2);
    }
}
