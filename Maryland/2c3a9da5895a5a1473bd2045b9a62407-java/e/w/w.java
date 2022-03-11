package e.w;

import android.os.Build;
import android.view.View;

public class w extends v {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f1969i = true;

    @Override // e.w.y
    public void f(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i2);
        } else if (f1969i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f1969i = false;
            }
        }
    }
}
