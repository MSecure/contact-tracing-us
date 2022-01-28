package androidx.core.app;

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

public final class ActivityRecreator {
    public static final Class<?> activityThreadClass;
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());
    public static final Field mainThreadField;
    public static final Method performStopActivity2ParamsMethod;
    public static final Method performStopActivity3ParamsMethod;
    public static final Method requestRelaunchActivityMethod;
    public static final Field tokenField;

    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        public Object currentlyRecreatingToken;
        public Activity mActivity;
        public boolean mDestroyed = false;
        public final int mRecreatingHashCode;
        public boolean mStarted = false;
        public boolean mStopQueued = false;

        public LifecycleCheckCallbacks(Activity activity) {
            this.mActivity = activity;
            this.mRecreatingHashCode = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.mDestroyed && !this.mStopQueued && !this.mStarted) {
                Object obj = this.currentlyRecreatingToken;
                int i = this.mRecreatingHashCode;
                boolean z = false;
                try {
                    Object obj2 = ActivityRecreator.tokenField.get(activity);
                    if (obj2 == obj) {
                        if (activity.hashCode() == i) {
                            ActivityRecreator.mainHandler.postAtFrontOfQueue(new Runnable(ActivityRecreator.mainThreadField.get(activity), obj2) {
                                /* class androidx.core.app.ActivityRecreator.AnonymousClass3 */
                                public final /* synthetic */ Object val$activityThread;
                                public final /* synthetic */ Object val$token;

                                {
                                    this.val$activityThread = r1;
                                    this.val$token = r2;
                                }

                                public void run() {
                                    try {
                                        if (ActivityRecreator.performStopActivity3ParamsMethod != null) {
                                            ActivityRecreator.performStopActivity3ParamsMethod.invoke(this.val$activityThread, this.val$token, Boolean.FALSE, "AppCompat recreation");
                                            return;
                                        }
                                        ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, Boolean.FALSE);
                                    } catch (RuntimeException e) {
                                        if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                                            throw e;
                                        }
                                    } catch (Throwable th) {
                                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                                    }
                                }
                            });
                            z = true;
                        }
                    }
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while fetching field values", th);
                }
                if (z) {
                    this.mStopQueued = true;
                    this.currentlyRecreatingToken = null;
                }
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
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
        activityThreadClass = cls;
        try {
            field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
        } catch (Throwable unused2) {
            field = null;
        }
        mainThreadField = field;
        try {
            field2 = Activity.class.getDeclaredField("mToken");
            field2.setAccessible(true);
        } catch (Throwable unused3) {
            field2 = null;
        }
        tokenField = field2;
        Class<?> cls4 = activityThreadClass;
        if (cls4 != null) {
            try {
                method = cls4.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                method.setAccessible(true);
            } catch (Throwable unused4) {
            }
            performStopActivity3ParamsMethod = method;
            cls2 = activityThreadClass;
            if (cls2 != null) {
                try {
                    method2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                    method2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                performStopActivity2ParamsMethod = method2;
                cls3 = activityThreadClass;
                if (needsRelaunchCall() && cls3 != null) {
                    Method declaredMethod = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    method3 = declaredMethod;
                }
                requestRelaunchActivityMethod = method3;
            }
            method2 = null;
            performStopActivity2ParamsMethod = method2;
            cls3 = activityThreadClass;
            Method declaredMethod2 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            method3 = declaredMethod2;
            requestRelaunchActivityMethod = method3;
        }
        method = null;
        performStopActivity3ParamsMethod = method;
        cls2 = activityThreadClass;
        if (cls2 != null) {
        }
        method2 = null;
        performStopActivity2ParamsMethod = method2;
        cls3 = activityThreadClass;
        try {
            Method declaredMethod22 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod22.setAccessible(true);
            method3 = declaredMethod22;
        } catch (Throwable unused6) {
        }
        requestRelaunchActivityMethod = method3;
    }

    public static boolean needsRelaunchCall() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static boolean recreate(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (needsRelaunchCall() && requestRelaunchActivityMethod == null) {
            return false;
        } else {
            if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
                return false;
            }
            try {
                final Object obj2 = tokenField.get(activity);
                if (obj2 == null || (obj = mainThreadField.get(activity)) == null) {
                    return false;
                }
                final Application application = activity.getApplication();
                final LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                mainHandler.post(new Runnable() {
                    /* class androidx.core.app.ActivityRecreator.AnonymousClass1 */

                    public void run() {
                        LifecycleCheckCallbacks.this.currentlyRecreatingToken = obj2;
                    }
                });
                try {
                    if (needsRelaunchCall()) {
                        requestRelaunchActivityMethod.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                    } else {
                        activity.recreate();
                    }
                    return true;
                } finally {
                    mainHandler.post(new Runnable() {
                        /* class androidx.core.app.ActivityRecreator.AnonymousClass2 */

                        public void run() {
                            application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                        }
                    });
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
