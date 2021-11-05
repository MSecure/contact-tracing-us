package b.v;

import android.os.Build;
import android.view.ViewGroup;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1830a = true;

    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (f1830a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f1830a = false;
            }
        }
    }
}
