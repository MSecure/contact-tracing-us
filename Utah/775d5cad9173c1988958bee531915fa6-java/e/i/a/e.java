package e.i.a;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class e {
    public static final Class<?> a;
    public static final Field b;
    public static final Field c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f1447d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f1448e;

    /* renamed from: f  reason: collision with root package name */
    public static final Method f1449f;

    /* renamed from: g  reason: collision with root package name */
    public static final Handler f1450g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public final /* synthetic */ c b;
        public final /* synthetic */ Object c;

        public a(c cVar, Object obj) {
            this.b = cVar;
            this.c = obj;
        }

        public void run() {
            this.b.b = this.c;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Application b;
        public final /* synthetic */ c c;

        public b(Application application, c cVar) {
            this.b = application;
            this.c = cVar;
        }

        public void run() {
            this.b.unregisterActivityLifecycleCallbacks(this.c);
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public Object b;
        public Activity c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1451d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1452e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1453f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f1454g = false;

        public c(Activity activity) {
            this.c = activity;
            this.f1451d = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.c == activity) {
                this.c = null;
                this.f1453f = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1453f && !this.f1454g && !this.f1452e) {
                Object obj = this.b;
                int i2 = this.f1451d;
                boolean z = false;
                try {
                    Object obj2 = e.c.get(activity);
                    if (obj2 == obj) {
                        if (activity.hashCode() == i2) {
                            e.f1450g.postAtFrontOfQueue(new f(e.b.get(activity), obj2));
                            z = true;
                        }
                    }
                } catch (Throwable unused) {
                }
                if (z) {
                    this.f1454g = true;
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
                this.f1452e = true;
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
        Class<?> cls4 = a;
        if (cls4 != null) {
            try {
                method = cls4.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                method.setAccessible(true);
            } catch (Throwable unused4) {
            }
            f1447d = method;
            cls2 = a;
            if (cls2 != null) {
                try {
                    method2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                    method2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                f1448e = method2;
                cls3 = a;
                if (a() && cls3 != null) {
                    Class<?> cls5 = Boolean.TYPE;
                    Method declaredMethod = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
                    declaredMethod.setAccessible(true);
                    method3 = declaredMethod;
                }
                f1449f = method3;
            }
            method2 = null;
            f1448e = method2;
            cls3 = a;
            Class<?> cls52 = Boolean.TYPE;
            Method declaredMethod2 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls52, Configuration.class, Configuration.class, cls52, cls52);
            declaredMethod2.setAccessible(true);
            method3 = declaredMethod2;
            f1449f = method3;
        }
        method = null;
        f1447d = method;
        cls2 = a;
        if (cls2 != null) {
        }
        method2 = null;
        f1448e = method2;
        cls3 = a;
        try {
            Class<?> cls522 = Boolean.TYPE;
            Method declaredMethod22 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls522, Configuration.class, Configuration.class, cls522, cls522);
            declaredMethod22.setAccessible(true);
            method3 = declaredMethod22;
        } catch (Throwable unused6) {
        }
        f1449f = method3;
    }

    public static boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    public static boolean b(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f1449f == null) {
            return false;
        } else {
            if (f1448e == null && f1447d == null) {
                return false;
            }
            try {
                Object obj2 = c.get(activity);
                if (obj2 == null || (obj = b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                c cVar = new c(activity);
                application.registerActivityLifecycleCallbacks(cVar);
                Handler handler = f1450g;
                handler.post(new a(cVar, obj2));
                try {
                    if (a()) {
                        Method method = f1449f;
                        Boolean bool = Boolean.FALSE;
                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                    } else {
                        activity.recreate();
                    }
                    handler.post(new b(application, cVar));
                    return true;
                } catch (Throwable th) {
                    f1450g.post(new b(application, cVar));
                    throw th;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
