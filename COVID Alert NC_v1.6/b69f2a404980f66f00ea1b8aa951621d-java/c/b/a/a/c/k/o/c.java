package c.b.a.a.c.k.o;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final c f = new c();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f2319b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f2320c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<a> f2321d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f2322e = false;

    public interface a {
        void a(boolean z);
    }

    public final void a(boolean z) {
        synchronized (f) {
            ArrayList<a> arrayList = this.f2321d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                a aVar = arrayList.get(i);
                i++;
                aVar.a(z);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f2319b.compareAndSet(true, false);
        this.f2320c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f2319b.compareAndSet(true, false);
        this.f2320c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f2319b.compareAndSet(false, true)) {
            this.f2320c.set(true);
            a(true);
        }
    }
}
