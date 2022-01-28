package b.i.d;

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

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f1647a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f1648b;

    /* renamed from: c  reason: collision with root package name */
    public static final Field f1649c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f1650d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f1651e;

    /* renamed from: f  reason: collision with root package name */
    public static final Method f1652f;

    /* renamed from: g  reason: collision with root package name */
    public static final Handler f1653g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C0029c f1654b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f1655c;

        public a(C0029c cVar, Object obj) {
            this.f1654b = cVar;
            this.f1655c = obj;
        }

        public void run() {
            this.f1654b.f1658b = this.f1655c;
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Application f1656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ C0029c f1657c;

        public b(Application application, C0029c cVar) {
            this.f1656b = application;
            this.f1657c = cVar;
        }

        public void run() {
            this.f1656b.unregisterActivityLifecycleCallbacks(this.f1657c);
        }
    }

    /* renamed from: b.i.d.c$c  reason: collision with other inner class name */
    public static final class C0029c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        public Object f1658b;

        /* renamed from: c  reason: collision with root package name */
        public Activity f1659c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1660d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1661e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1662f = false;

        public C0029c(Activity activity) {
            this.f1659c = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f1659c == activity) {
                this.f1659c = null;
                this.f1661e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f1661e && !this.f1662f && !this.f1660d) {
                Object obj = this.f1658b;
                boolean z = false;
                try {
                    Object obj2 = c.f1649c.get(activity);
                    if (obj2 == obj) {
                        c.f1653g.postAtFrontOfQueue(new d(c.f1648b.get(activity), obj2));
                        z = true;
                    }
                } catch (Throwable unused) {
                }
                if (z) {
                    this.f1662f = true;
                    this.f1658b = null;
                }
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f1659c == activity) {
                this.f1660d = true;
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
        f1647a = cls;
        try {
            field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
        } catch (Throwable unused2) {
            field = null;
        }
        f1648b = field;
        try {
            field2 = Activity.class.getDeclaredField("mToken");
            field2.setAccessible(true);
        } catch (Throwable unused3) {
            field2 = null;
        }
        f1649c = field2;
        Class<?> cls4 = f1647a;
        if (cls4 != null) {
            try {
                method = cls4.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                method.setAccessible(true);
            } catch (Throwable unused4) {
            }
            f1650d = method;
            cls2 = f1647a;
            if (cls2 != null) {
                try {
                    method2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                    method2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                f1651e = method2;
                cls3 = f1647a;
                if (a() && cls3 != null) {
                    Method declaredMethod = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    method3 = declaredMethod;
                }
                f1652f = method3;
            }
            method2 = null;
            f1651e = method2;
            cls3 = f1647a;
            Method declaredMethod2 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            method3 = declaredMethod2;
            f1652f = method3;
        }
        method = null;
        f1650d = method;
        cls2 = f1647a;
        if (cls2 != null) {
        }
        method2 = null;
        f1651e = method2;
        cls3 = f1647a;
        try {
            Method declaredMethod22 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod22.setAccessible(true);
            method3 = declaredMethod22;
        } catch (Throwable unused6) {
        }
        f1652f = method3;
    }

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static boolean b(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f1652f == null) {
            return false;
        } else {
            if (f1651e == null && f1650d == null) {
                return false;
            }
            try {
                Object obj2 = f1649c.get(activity);
                if (obj2 == null || (obj = f1648b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                C0029c cVar = new C0029c(activity);
                application.registerActivityLifecycleCallbacks(cVar);
                f1653g.post(new a(cVar, obj2));
                try {
                    if (a()) {
                        f1652f.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                    } else {
                        activity.recreate();
                    }
                    return true;
                } finally {
                    f1653g.post(new b(application, cVar));
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
