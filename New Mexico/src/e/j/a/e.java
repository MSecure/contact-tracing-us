package e.j.a;

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
/* loaded from: classes.dex */
public final class e {
    public static final Class<?> a;
    public static final Field b;
    public static final Field c;

    /* renamed from: d */
    public static final Method f1531d;

    /* renamed from: e */
    public static final Method f1532e;

    /* renamed from: f */
    public static final Method f1533f;

    /* renamed from: g */
    public static final Handler f1534g = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ c b;
        public final /* synthetic */ Object c;

        public a(c cVar, Object obj) {
            this.b = cVar;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b = this.c;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Application b;
        public final /* synthetic */ c c;

        public b(Application application, c cVar) {
            this.b = application;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.unregisterActivityLifecycleCallbacks(this.c);
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public Object b;
        public Activity c;

        /* renamed from: d */
        public final int f1535d;

        /* renamed from: e */
        public boolean f1536e = false;

        /* renamed from: f */
        public boolean f1537f = false;

        /* renamed from: g */
        public boolean f1538g = false;

        public c(Activity activity) {
            this.c = activity;
            this.f1535d = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.c == activity) {
                this.c = null;
                this.f1537f = true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
            r5.f1538g = true;
            r5.b = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
            return;
         */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void onActivityPaused(Activity activity) {
            if (this.f1537f && !this.f1538g && !this.f1536e) {
                Object obj = this.b;
                int i2 = this.f1535d;
                boolean z = false;
                try {
                    Object obj2 = e.c.get(activity);
                    if (obj2 == obj && activity.hashCode() == i2) {
                        e.f1534g.postAtFrontOfQueue(new f(e.b.get(activity), obj2));
                        z = true;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.c == activity) {
                this.f1536e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Class<?> cls;
        Field field;
        Field field2;
        Method declaredMethod;
        Class<?> cls2;
        Method declaredMethod2;
        Class<?> cls3;
        Method method = null;
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
                declaredMethod = cls4.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
            }
            f1531d = declaredMethod;
            cls2 = a;
            if (cls2 != null) {
                try {
                    declaredMethod2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                    declaredMethod2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                f1532e = declaredMethod2;
                cls3 = a;
                if (a() && cls3 != null) {
                    try {
                        Class<?> cls5 = Boolean.TYPE;
                        Method declaredMethod3 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
                        declaredMethod3.setAccessible(true);
                        method = declaredMethod3;
                    } catch (Throwable unused6) {
                    }
                }
                f1533f = method;
            }
            declaredMethod2 = null;
            f1532e = declaredMethod2;
            cls3 = a;
            if (a()) {
                Class<?> cls52 = Boolean.TYPE;
                Method declaredMethod32 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls52, Configuration.class, Configuration.class, cls52, cls52);
                declaredMethod32.setAccessible(true);
                method = declaredMethod32;
            }
            f1533f = method;
        }
        declaredMethod = null;
        f1531d = declaredMethod;
        cls2 = a;
        if (cls2 != null) {
        }
        declaredMethod2 = null;
        f1532e = declaredMethod2;
        cls3 = a;
        if (a()) {
        }
        f1533f = method;
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
        } else if (a() && f1533f == null) {
            return false;
        } else {
            if (f1532e == null && f1531d == null) {
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
                Handler handler = f1534g;
                handler.post(new a(cVar, obj2));
                if (a()) {
                    Method method = f1533f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, cVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
