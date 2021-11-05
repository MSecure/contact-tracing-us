package b.x;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

public class a0 extends z {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f2632g = true;

    @Override // b.x.c0
    @SuppressLint({"NewApi"})
    public void f(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i);
        } else if (f2632g) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f2632g = false;
            }
        }
    }
}
