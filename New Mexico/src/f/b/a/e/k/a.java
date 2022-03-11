package f.b.a.e.k;

import android.app.Activity;
import android.app.Application;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.R$attr;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static final int[] a = {R$attr.dynamicColorThemeOverlay};
    public static final Set<String> b = new HashSet(Arrays.asList("oppo", "realme", "oneplus", "vivo", "xiaomi", "motorola", "itel", "tecno mobile limited", "infinix mobility limited", "hmd global", "sharp", "sony", "tcl", "lenovo", "google", "robolectric"));
    public static final c c = new C0094a();

    /* renamed from: f.b.a.e.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0094a implements c {
    }

    /* loaded from: classes.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public final int b;
        public final c c;

        public b(int i2, c cVar) {
            this.b = i2;
            this.c = cVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            int i2 = this.b;
            c cVar = this.c;
            if (Build.VERSION.SDK_INT >= 31 && a.b.contains(Build.MANUFACTURER.toLowerCase())) {
                if (i2 == 0) {
                    TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(a.a);
                    i2 = obtainStyledAttributes.getResourceId(0, 0);
                    obtainStyledAttributes.recycle();
                }
                if (i2 != 0) {
                    Objects.requireNonNull(cVar);
                    activity.setTheme(i2);
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
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: classes.dex */
    public interface c {
    }
}
