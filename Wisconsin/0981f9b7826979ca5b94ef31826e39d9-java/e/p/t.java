package e.p;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import e.p.g;

public class t extends Fragment {

    public static class a implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            t.a(activity, g.a.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            t.a(activity, g.a.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            t.a(activity, g.a.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            t.a(activity, g.a.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            t.a(activity, g.a.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            t.a(activity, g.a.ON_STOP);
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

    public static void a(Activity activity, g.a aVar) {
        if (activity instanceof l) {
            k a2 = ((l) activity).a();
            a2.d("handleLifecycleEvent");
            a2.g(aVar.a());
        } else if (activity instanceof j) {
            g a3 = ((j) activity).a();
            if (a3 instanceof k) {
                k kVar = (k) a3;
                kVar.d("handleLifecycleEvent");
                kVar.g(aVar.a());
            }
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new t(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void b(g.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), aVar);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(g.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(g.a.ON_DESTROY);
    }

    public void onPause() {
        super.onPause();
        b(g.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        b(g.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        b(g.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(g.a.ON_STOP);
    }
}
