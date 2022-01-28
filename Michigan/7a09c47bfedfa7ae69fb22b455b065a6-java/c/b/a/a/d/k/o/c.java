package c.b.a.a.d.k.o;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: f  reason: collision with root package name */
    public static final c f2959f = new c();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f2960b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f2961c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<a> f2962d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f2963e = false;

    public interface a {
        void a(@RecentlyNonNull boolean z);
    }

    public final void a(boolean z) {
        synchronized (f2959f) {
            ArrayList<a> arrayList = this.f2962d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                a aVar = arrayList.get(i);
                i++;
                aVar.a(z);
            }
        }
    }

    public final void onActivityCreated(@RecentlyNonNull Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f2960b.compareAndSet(true, false);
        this.f2961c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    public final void onActivityDestroyed(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityPaused(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityResumed(@RecentlyNonNull Activity activity) {
        boolean compareAndSet = this.f2960b.compareAndSet(true, false);
        this.f2961c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    public final void onActivitySaveInstanceState(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle) {
    }

    public final void onActivityStarted(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityStopped(@RecentlyNonNull Activity activity) {
    }

    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(@RecentlyNonNull int i) {
        if (i == 20 && this.f2960b.compareAndSet(false, true)) {
            this.f2961c.set(true);
            a(true);
        }
    }
}
