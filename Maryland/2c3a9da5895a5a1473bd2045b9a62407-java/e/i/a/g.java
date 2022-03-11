package e.i.a;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class g {
    public static final Class<?> a;
    public static final Field b;
    public static final Field c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f1398d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f1399e;

    /* renamed from: f  reason: collision with root package name */
    public static final Method f1400f;

    /* renamed from: g  reason: collision with root package name */
    public static final Handler f1401g = new Handler(Looper.getMainLooper());

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public Object b;
        public Activity c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1402d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1403e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1404f = false;

        public a(Activity activity) {
            this.c = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.c == activity) {
                this.c = null;
                this.f1403e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1403e && !this.f1404f && !this.f1402d) {
                Object obj = this.b;
                boolean z = false;
                try {
                    Object obj2 = g.c.get(activity);
                    if (obj2 == obj) {
                        g.f1401g.postAtFrontOfQueue(new f(g.b.get(activity), obj2));
                        z = true;
                    }
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while fetching field values", th);
                }
                if (z) {
                    this.f1404f = true;
                    this.b = null;
                }
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.c == activity) {
                this.f1402d = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d A[SYNTHETIC, Splitter:B:25:0x005d] */
    static {
        Class<?> cls;
        Field field;
        Field field2;
        Method method;
        Class<?> cls2;
        Method method2;
        Class<?> cls3;
        Class<?> cls4 = Boolean.TYPE;
        Method method3 = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
        } catch (Throwable unused2) {
            field = null;
        }
        b = field;
        try {
            field2 = Activity.class.getDeclaredField("mToken");
            field2.setAccessible(true);
        } catch (Throwable unused3) {
            field2 = null;
        }
        c = field2;
        Class<?> cls5 = a;
        if (cls5 != null) {
            try {
                method = cls5.getDeclaredMethod("performStopActivity", IBinder.class, cls4, String.class);
                method.setAccessible(true);
            } catch (Throwable unused4) {
            }
            f1398d = method;
            cls2 = a;
            if (cls2 != null) {
                try {
                    method2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, cls4);
                    method2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                f1399e = method2;
                cls3 = a;
                if (a() && cls3 != null) {
                    Method declaredMethod = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls4, Configuration.class, Configuration.class, cls4, cls4);
                    declaredMethod.setAccessible(true);
                    method3 = declaredMethod;
                }
                f1400f = method3;
            }
            method2 = null;
            f1399e = method2;
            cls3 = a;
            Method declaredMethod2 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls4, Configuration.class, Configuration.class, cls4, cls4);
            declaredMethod2.setAccessible(true);
            method3 = declaredMethod2;
            f1400f = method3;
        }
        method = null;
        f1398d = method;
        cls2 = a;
        if (cls2 != null) {
        }
        method2 = null;
        f1399e = method2;
        cls3 = a;
        try {
            Method declaredMethod22 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls4, Configuration.class, Configuration.class, cls4, cls4);
            declaredMethod22.setAccessible(true);
            method3 = declaredMethod22;
        } catch (Throwable unused6) {
        }
        f1400f = method3;
    }

    public static boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }
}
