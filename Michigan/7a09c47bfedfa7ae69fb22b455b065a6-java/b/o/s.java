package b.o;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import b.o.f;

public class s extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public a f2236b;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            s.a(activity, f.a.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            s.a(activity, f.a.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            s.a(activity, f.a.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            s.a(activity, f.a.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            s.a(activity, f.a.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            s.a(activity, f.a.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void a(Activity activity, f.a aVar) {
        if (activity instanceof k) {
            j lifecycle = ((k) activity).getLifecycle();
            lifecycle.d("handleLifecycleEvent");
            lifecycle.g(aVar.b());
        } else if (activity instanceof i) {
            f lifecycle2 = ((i) activity).getLifecycle();
            if (lifecycle2 instanceof j) {
                j jVar = (j) lifecycle2;
                jVar.d("handleLifecycleEvent");
                jVar.g(aVar.b());
            }
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new s(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void b(f.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), aVar);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a aVar = this.f2236b;
        if (aVar != null) {
            aVar.a();
        }
        b(f.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(f.a.ON_DESTROY);
        this.f2236b = null;
    }

    public void onPause() {
        super.onPause();
        b(f.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f2236b;
        if (aVar != null) {
            aVar.b();
        }
        b(f.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        a aVar = this.f2236b;
        if (aVar != null) {
            aVar.c();
        }
        b(f.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(f.a.ON_STOP);
    }
}
