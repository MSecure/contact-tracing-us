package f.b.a.e.k;

import android.app.Activity;
import android.app.Application;
import android.content.res.TypedArray;
import android.os.Bundle;
import com.google.android.material.R$attr;
import e.b.a.m;
import java.util.Objects;

public class a {
    public static final int[] a = {R$attr.dynamicColorThemeOverlay};
    public static final c b = new C0092a();

    /* renamed from: f.b.a.e.k.a$a  reason: collision with other inner class name */
    public static class C0092a implements c {
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        public final int b;
        public final c c;

        public b(int i2, c cVar) {
            this.b = i2;
            this.c = cVar;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            int i2 = this.b;
            c cVar = this.c;
            if (m.e.I0()) {
                if (i2 == 0) {
                    TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(a.a);
                    int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                    obtainStyledAttributes.recycle();
                    i2 = resourceId;
                }
                if (i2 != 0) {
                    Objects.requireNonNull(cVar);
                    activity.setTheme(i2);
                }
            }
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

    public interface c {
    }
}
