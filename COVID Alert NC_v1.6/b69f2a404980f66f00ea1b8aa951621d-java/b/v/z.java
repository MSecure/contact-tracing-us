package b.v;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

public class z extends y {
    public static boolean g = true;

    @Override // b.v.b0
    @SuppressLint({"NewApi"})
    public void f(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i);
        } else if (g) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
