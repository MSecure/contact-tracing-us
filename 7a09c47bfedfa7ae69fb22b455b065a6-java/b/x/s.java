package b.x;

import android.os.Build;
import android.view.ViewGroup;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2719a = true;

    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (f2719a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f2719a = false;
            }
        }
    }
}
