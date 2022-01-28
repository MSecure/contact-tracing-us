package e.y;

import android.os.Build;
import android.view.View;

public class w extends v {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f2062i = true;

    @Override // e.y.y
    public void f(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i2);
        } else if (f2062i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f2062i = false;
            }
        }
    }
}
