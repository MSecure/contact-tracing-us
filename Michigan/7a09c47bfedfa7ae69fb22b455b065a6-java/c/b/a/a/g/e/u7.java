package c.b.a.a.g.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public final class u7 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Activity> f3753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s7 f3754c;

    public u7(s7 s7Var, WeakReference<Activity> weakReference) {
        this.f3754c = s7Var;
        this.f3753b = weakReference;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (activity == this.f3753b.get()) {
            s7 s7Var = this.f3754c;
            s7Var.f3718d = true;
            s7Var.b();
        }
    }

    public final void onActivityStopped(Activity activity) {
        if (activity == this.f3753b.get()) {
            s7 s7Var = this.f3754c;
            s7Var.f3718d = false;
            s7Var.b();
        }
    }
}
