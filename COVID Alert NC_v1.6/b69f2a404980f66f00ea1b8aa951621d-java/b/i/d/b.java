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

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f963a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f964b;

    /* renamed from: c  reason: collision with root package name */
    public static final Field f965c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f966d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f967e;
    public static final Method f;
    public static final Handler g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f968b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f969c;

        public a(c cVar, Object obj) {
            this.f968b = cVar;
            this.f969c = obj;
        }

        public void run() {
            this.f968b.f972b = this.f969c;
        }
    }

    /* renamed from: b.i.d.b$b  reason: collision with other inner class name */
    public class RunnableC0019b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Application f970b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f971c;

        public RunnableC0019b(Application application, c cVar) {
            this.f970b = application;
            this.f971c = cVar;
        }

        public void run() {
            this.f970b.unregisterActivityLifecycleCallbacks(this.f971c);
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        public Object f972b;

        /* renamed from: c  reason: collision with root package name */
        public Activity f973c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f974d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f975e = false;
        public boolean f = false;

        public c(Activity activity) {
            this.f973c = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f973c == activity) {
                this.f973c = null;
                this.f975e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f975e && !this.f && !this.f974d) {
                Object obj = this.f972b;
                boolean z = false;
                try {
                    Object obj2 = b.f965c.get(activity);
                    if (obj2 == obj) {
                        b.g.postAtFrontOfQueue(new c(b.f964b.get(activity), obj2));
                        z = true;
                    }
                } catch (Throwable unused) {
                }
                if (z) {
                    this.f = true;
                    this.f972b = null;
                }
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f973c == activity) {
                this.f974d = true;
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
        f963a = cls;
        try {
            field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
        } catch (Throwable unused2) {
            field = null;
        }
        f964b = field;
        try {
            field2 = Activity.class.getDeclaredField("mToken");
            field2.setAccessible(true);
        } catch (Throwable unused3) {
            field2 = null;
        }
        f965c = field2;
        Class<?> cls4 = f963a;
        if (cls4 != null) {
            try {
                method = cls4.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                method.setAccessible(true);
            } catch (Throwable unused4) {
            }
            f966d = method;
            cls2 = f963a;
            if (cls2 != null) {
                try {
                    method2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                    method2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                f967e = method2;
                cls3 = f963a;
                if (a() && cls3 != null) {
                    Method declaredMethod = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    method3 = declaredMethod;
                }
                f = method3;
            }
            method2 = null;
            f967e = method2;
            cls3 = f963a;
            Method declaredMethod2 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            method3 = declaredMethod2;
            f = method3;
        }
        method = null;
        f966d = method;
        cls2 = f963a;
        if (cls2 != null) {
        }
        method2 = null;
        f967e = method2;
        cls3 = f963a;
        try {
            Method declaredMethod22 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod22.setAccessible(true);
            method3 = declaredMethod22;
        } catch (Throwable unused6) {
        }
        f = method3;
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
        } else if (a() && f == null) {
            return false;
        } else {
            if (f967e == null && f966d == null) {
                return false;
            }
            try {
                Object obj2 = f965c.get(activity);
                if (obj2 == null || (obj = f964b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                c cVar = new c(activity);
                application.registerActivityLifecycleCallbacks(cVar);
                g.post(new a(cVar, obj2));
                try {
                    if (a()) {
                        f.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                    } else {
                        activity.recreate();
                    }
                    return true;
                } finally {
                    g.post(new RunnableC0019b(application, cVar));
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
