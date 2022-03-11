package f.b.a.c.b.l.l;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: f  reason: collision with root package name */
    public static final c f2675f = new c();
    public final AtomicBoolean b = new AtomicBoolean();
    public final AtomicBoolean c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<a> f2676d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f2677e = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(@RecentlyNonNull boolean z);
    }

    public static void a(@RecentlyNonNull Application application) {
        c cVar = f2675f;
        synchronized (cVar) {
            if (!cVar.f2677e) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f2677e = true;
            }
        }
    }

    public final void b(boolean z) {
        synchronized (f2675f) {
            ArrayList<a> arrayList = this.f2676d;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                a aVar = arrayList.get(i2);
                i2++;
                aVar.a(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@RecentlyNonNull Activity activity, Bundle bundle) {
        boolean compareAndSet = this.b.compareAndSet(true, false);
        this.c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@RecentlyNonNull Activity activity) {
        boolean compareAndSet = this.b.compareAndSet(true, false);
        this.c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@RecentlyNonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@RecentlyNonNull Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(@RecentlyNonNull int i2) {
        if (i2 == 20 && this.b.compareAndSet(false, true)) {
            this.c.set(true);
            b(true);
        }
    }
}
